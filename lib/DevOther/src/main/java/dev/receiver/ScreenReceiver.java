package dev.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: 屏幕监听广播 ( 锁屏 / 解锁 / 亮屏 )
 * @author Ttt
 */
public final class ScreenReceiver extends BroadcastReceiver {

    private ScreenReceiver() {
        super();
    }

    // 日志 TAG
    private static final String TAG = ScreenReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            // 打印当前触发的广播
            LogPrintUtils.dTag(TAG, "ScreenReceiver onReceive Action: " + action);
            // 判断类型
            switch (action) {
                case Intent.ACTION_SCREEN_ON: // 开屏
                    if (screenListener != null) {
                        screenListener.screenOn();
                    }
                    break;
                case Intent.ACTION_SCREEN_OFF: // 锁屏
                    if (screenListener != null) {
                        screenListener.screenOff();
                    }
                    break;
                case Intent.ACTION_USER_PRESENT: // 解锁
                    if (screenListener != null) {
                        screenListener.userPresent();
                    }
                    break;
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "onReceive");
        }
    }

    // ================
    // = 对外公开方法 =
    // ================

    // 屏幕广播监听
    private static final ScreenReceiver screenReceiver = new ScreenReceiver();

    /**
     * 注册屏幕监听广播
     */
    public static void registerReceiver() {
        try {
            IntentFilter filter = new IntentFilter();
            // 屏幕状态改变通知
            filter.addAction(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            filter.addAction(Intent.ACTION_USER_PRESENT);
            filter.setPriority(Integer.MAX_VALUE);
            // 注册广播
            DevUtils.getContext().registerReceiver(screenReceiver, filter);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "registerReceiver");
        }
    }

    /**
     * 取消注册屏幕监听广播
     */
    public static void unregisterReceiver() {
        try {
            DevUtils.getContext().unregisterReceiver(screenReceiver);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "unregisterReceiver");
        }
    }

    // =

    // 屏幕监听事件
    private static ScreenListener screenListener;

    /**
     * 设置屏幕监听事件
     * @param listener {@link ScreenListener}
     */
    public static void setScreenListener(final ScreenListener listener) {
        ScreenReceiver.screenListener = listener;
    }

    /**
     * detail: 屏幕监听事件
     * @author Ttt
     */
    public interface ScreenListener {

        /**
         * 用户打开屏幕 ( 屏幕变亮 )
         */
        void screenOn();

        /**
         * 锁屏触发
         */
        void screenOff();

        /**
         * 用户解锁触发
         */
        void userPresent();
    }
}