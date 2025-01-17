package dev.service;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationManagerCompat;

import java.util.Set;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: 通知栏监听服务
 * @author Ttt
 * <pre>
 *     @see <a href="https://www.jianshu.com/p/981e7de2c7be"/>
 *     所需权限
 *     <uses-permission android:name="android.permission.BIND_NOTIFICATION_LISTENER_SERVICE" />
 * </pre>
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public final class NotificationService extends NotificationListenerService {

    // 日志 TAG
    private static final String TAG = NotificationService.class.getSimpleName();
    // 当前服务所持对象
    private static NotificationService self;

    // ============
    // = 通知回调 =
    // ============

    /**
     * 当系统收到新的通知后触发回调
     * @param sbn {@link StatusBarNotification}
     */
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (self != null && notificationListener != null) {
            notificationListener.onNotificationPosted(sbn);
        }
    }

    /**
     * 当系统通知被删掉后触发回调
     * @param sbn {@link StatusBarNotification}
     */
    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        if (self != null && notificationListener != null) {
            notificationListener.onNotificationRemoved(sbn);
        }
    }

    // ============
    // = 生命周期 =
    // ============

    @Override
    public void onCreate() {
        super.onCreate();
        LogPrintUtils.dTag(TAG, "onCreate");

        if (notificationListener != null) {
            notificationListener.onServiceCreated(this);
        }
        self = this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogPrintUtils.dTag(TAG, "onDestroy");

        if (notificationListener != null) {
            notificationListener.onServiceDestroy();
            notificationListener = null;
        }
        self = null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogPrintUtils.dTag(TAG, "onStartCommand");

        return notificationListener == null ? START_STICKY : notificationListener.onStartCommand(this, intent, flags, startId);
    }

    // ================
    // = 对外公开方法 =
    // ================

    /**
     * 获取当前服务所持对象
     * @return {@link NotificationService}
     */
    public static NotificationService getSelf() {
        return self;
    }

    /**
     * 启动服务
     */
    public static void startService() {
        try {
            DevUtils.getContext().startService(new Intent(DevUtils.getContext(), NotificationService.class));
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, "startService");
        }
    }

    /**
     * 停止服务
     */
    public static void stopService() {
        try {
            DevUtils.getContext().stopService(new Intent(DevUtils.getContext(), NotificationService.class));
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, "stopService");
        }
    }

    // =

    /**
     * 检查是否有获取通知栏信息权限并跳转设置页面
     * @return {@code true} yes, {@code false} no
     */
    public static boolean checkAndIntentSetting() {
        if (!isNotificationListenerEnabled()) {
            startNotificationListenSettings();
            return false;
        }
        return true;
    }

    /**
     * 判断是否有获取通知栏信息权限
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isNotificationListenerEnabled() {
        return isNotificationListenerEnabled(DevUtils.getContext().getPackageName());
    }

    /**
     * 判断是否有获取通知栏信息权限
     * @param packageName 应用包名
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isNotificationListenerEnabled(final String packageName) {
        Set<String> packageNames = NotificationManagerCompat.getEnabledListenerPackages(DevUtils.getContext());
        return packageNames.contains(packageName);
    }

    /**
     * 跳转到设置页面, 开启获取通知栏信息权限
     */
    public static void startNotificationListenSettings() {
        try {
            Intent intent;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                intent = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            } else {
                intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            }
            if (!(DevUtils.getContext() instanceof Activity)) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            DevUtils.getContext().startActivity(intent);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "startNotificationListenSettings");
        }
    }

    // =

//    cancelAllNotifications() 删除系统中所有可被清除的通知
//    getActiveNotifications() 返回当前系统所有通知到 StatusBarNotification[]

    /**
     * 取消通知方法
     * <pre>
     *     cancelNotification(String key) 是 API >= 21 才可以使用的, 利用 StatusBarNotification 的 getKey() 方法来获取 key 并取消通知
     *     cancelNotification(String pkg, String tag, int id) 在 API < 21 时可以使用, 在 API >= 21 时使用此方法来取消通知将无效 ( 被废弃 )
     * </pre>
     * @param sbn {@link StatusBarNotification}
     */
    public void cancelNotification(final StatusBarNotification sbn) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cancelNotification(sbn.getKey());
        } else {
            cancelNotification(sbn.getPackageName(), sbn.getTag(), sbn.getId());
        }
    }

    // =

    // 通知栏监听事件
    private static NotificationListener notificationListener;

    /**
     * 设置通知栏监听事件
     * @param listener {@link NotificationListener}
     */
    public static void setNotificationListener(final NotificationListener listener) {
        NotificationService.notificationListener = listener;
    }

    /**
     * detail: 通知栏监听事件
     * @author Ttt
     */
    public interface NotificationListener {

        /**
         * 服务创建通知
         * @param service {@link NotificationService}
         */
        void onServiceCreated(NotificationService service);

        /**
         * 服务销毁通知
         */
        void onServiceDestroy();

        /**
         * 触发服务指令
         * @param service {@link NotificationService}
         * @param intent  {@link Intent}
         * @param flags   Additional data about this start request.
         * @param startId A unique integer representing this specific request to start.  Use with {@link #stopSelfResult(int)}.
         * @return The return value indicates what semantics the system should
         * use for the service's current started state.  It may be one of the
         * constants associated with the {@link #START_CONTINUATION_MASK} bits.
         */
        int onStartCommand(NotificationService service, Intent intent, int flags, int startId);

        /**
         * 当系统收到新的通知后触发回调
         * <pre>
         *     当 API > 18 时, 利用 Notification.extras 来获取通知内容, extras 是在 API 19 时被加入的
         *     当 API = 18 时, 利用反射获取 Notification 中的内容
         * </pre>
         * @param sbn {@link StatusBarNotification}
         */
        void onNotificationPosted(StatusBarNotification sbn);

        /**
         * 当系统通知被删掉后触发回调
         * @param sbn {@link StatusBarNotification}
         */
        void onNotificationRemoved(StatusBarNotification sbn);
    }
}