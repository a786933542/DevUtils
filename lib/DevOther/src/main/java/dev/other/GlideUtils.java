package dev.other;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import dev.utils.LogPrintUtils;

/**
 * detail: Glide 工具类
 * @author Ttt
 * <pre>
 *     init: GlideUtils.init(getApplicationContext());
 *     use modify: 修改 defaultOptions() 配置、以及加载默认图片资源
 *     <p></p>
 *     Glide 详细使用
 *     @see <a href="https://www.jianshu.com/p/7cfe2653a1fb"/>
 *     Glide 文档
 *     @see <a href="https://muyangmin.github.io/glide-docs-cn"/>
 *     解决 Glide 加载图片闪烁的问题 ( 圆角处理 ) - transform(new RoundedCorners(xx));
 *     @see <a href="https://blog.csdn.net/andcisco/article/details/96487800"/>
 * </pre>
 */
public final class GlideUtils {

    private GlideUtils() {
    }

    // 日志 TAG
    private static final String TAG = GlideUtils.class.getSimpleName();
    // GlideLoader
    private static GlideLoader sGlideLoader;
    // 图片默认加载配置
    private static RequestOptions DF_OPTIONS = defaultOptions();
    // 全局 Context
    private static Context sContext;
    // 图片加载中
    private static int sImageLoadingRes = 0;
    // 图片地址异常
    private static int sImageUriErrorRes = 0;
    // 图片 ( 加载 / 解码 ) 失败
    private static int sImageFailRes = 0;

    // ================================
    // =  GlideLoader(RequestManager) =
    // ================================

    @NonNull
    public static GlideLoader with(@NonNull Context context) {
        return new GlideLoader(Glide.with(context));
    }

    @NonNull
    public static GlideLoader with(@NonNull Activity activity) {
        return new GlideLoader(Glide.with(activity));
    }

    @NonNull
    public static GlideLoader with(@NonNull FragmentActivity activity) {
        return new GlideLoader(Glide.with(activity));
    }

    @NonNull
    public static GlideLoader with(@NonNull android.app.Fragment fragment) {
        return new GlideLoader(Glide.with(fragment));
    }

    @NonNull
    public static GlideLoader with(@NonNull Fragment fragment) {
        return new GlideLoader(Glide.with(fragment));
    }

    @NonNull
    public static GlideLoader with(@NonNull View view) {
        return new GlideLoader(Glide.with(view));
    }

    /**
     * 获取全局 Context Glide
     * @return {@link GlideLoader}
     */
    public static GlideLoader with() {
        if (sGlideLoader == null) {
            try {
                sGlideLoader = new GlideLoader(Glide.with(sContext));
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "with");
            }
        }
        return sGlideLoader;
    }

    // ==========
    // = 初始化 =
    // ==========

    /**
     * 初始化方法
     * @param context {@link Context}
     */
    public static void init(final Context context) {
        if (sContext == null && context != null) {
            // 设置全局 Context
            sContext = context.getApplicationContext();
            // 默认进行初始化
            with();
        }
    }

    // ==================
    // = RequestOptions =
    // ==================

    /**
     * 克隆图片加载配置
     * @param options 待克隆加载配置
     * @return {@link RequestOptions}
     */
    public static RequestOptions cloneImageOptions(final RequestOptions options) {
        return (options != null) ? options.clone() : null;
    }

    /**
     * 获取默认加载配置
     * <pre>
     *     优先级:
     *     Priority.LOW 低
     *     Priority.NORMAL 默认正常
     *     Priority.HIGH 高 / 优先
     *     Priority.IMMEDIATE 立即加载
     *     缓存:
     *     DiskCacheStrategy.NONE 不做磁盘缓存
     *     DiskCacheStrategy.SOURCE 只缓存图像原图
     *     DiskCacheStrategy.RESULT 只缓存加载后的图像, 即处理后最终显示时的图像
     *     DiskCacheStrategy.ALL 缓存所有版本的图像 ( 默认行为 )
     * </pre>
     * @return {@link RequestOptions}
     */
    public static RequestOptions defaultOptions() {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL) // 设置全缓存
                .placeholder(sImageLoadingRes) // 设置图片在下载期间显示的图片
                .fallback(sImageUriErrorRes) // 设置图片 Uri 为空或是错误的时候显示的图片
                .error(sImageFailRes) // 设置图片 ( 加载 / 解码 ) 过程中错误时候显示的图片
//                .format(DecodeFormat.PREFER_ARGB_8888) // 设置图片解码格式, 默认 8888
                .priority(Priority.HIGH);
        return requestOptions;
    }

    /**
     * 获取空白加载配置
     * @return {@link RequestOptions}
     */
    public static RequestOptions emptyOptions() {
        return new RequestOptions();
    }

    /**
     * 获取跳过缓存 ( 每次都从服务端获取最新 ) 加载配置
     * @return {@link RequestOptions}
     */
    public static RequestOptions skipCacheOptions() {
        return skipCacheOptions(cloneImageOptions(DF_OPTIONS));
    }

    /**
     * 获取跳过缓存 ( 每次都从服务端获取最新 ) 加载配置
     * @param options {@link RequestOptions}
     * @return {@link RequestOptions}
     */
    public static RequestOptions skipCacheOptions(final RequestOptions options) {
        if (options != null) {
            return options.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
        }
        return options;
    }

    /**
     * 获取自定义图片加载配置
     * @param loadingRes 设置加载中显示的图片
     * @return {@link RequestOptions}
     */
    public static RequestOptions getLoadResOptions(@DrawableRes final int loadingRes) {
        return getLoadResOptions(cloneImageOptions(DF_OPTIONS), loadingRes);
    }

    /**
     * 获取自定义图片加载配置
     * @param options    {@link RequestOptions}
     * @param loadingRes 设置加载中显示的图片
     * @return {@link RequestOptions}
     */
    public static RequestOptions getLoadResOptions(final RequestOptions options, @DrawableRes final int loadingRes) {
        if (options != null && loadingRes != 0) {
            options.placeholder(loadingRes) // 设置图片在下载期间显示的图片
                    .fallback(loadingRes) // 设置图片 Uri 为空或是错误的时候显示的图片
                    .error(loadingRes); // 设置图片 ( 加载 / 解码 ) 过程中错误时候显示的图片
        }
        return options;
    }

    /**
     * 获取图片处理效果加载配置
     * @param transformation {@link Transformation} 图形效果
     * @return {@link RequestOptions}
     */
    public static RequestOptions transformationOptions(final Transformation transformation) {
        return transformationOptions(cloneImageOptions(DF_OPTIONS), transformation);
    }

    /**
     * 获取图片处理效果加载配置
     * @param options        {@link RequestOptions}
     * @param transformation {@link Transformation} 图形效果
     * @return {@link RequestOptions}
     */
    public static RequestOptions transformationOptions(final RequestOptions options, final Transformation transformation) {
        if (options != null) {
            try {
                options.transform(transformation);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "transformationOptions");
            }
        }
        return options;
    }

    // ==============
    // = 内部方法类 =
    // ==============

    /**
     * detail: Glide Loader 封装内部类
     * @author Ttt
     */
    public final static class GlideLoader {

        // RequestManager
        private RequestManager mRequestManager;

        /**
         * 构造函数
         * @param requestManager {@link RequestManager}
         */
        public GlideLoader(RequestManager requestManager) {
            this.mRequestManager = requestManager;
            // 设置加载配置
            if (requestManager != null) requestManager.setDefaultRequestOptions(DF_OPTIONS);
        }

        // ==============
        // = 预加载处理 =
        // ==============

        /**
         * 预加载图片
         * @param uri Image Uri
         */
        public void preload(final String uri) {
            preload(uri, null);
        }

        /**
         * 预加载图片
         * <pre>
         *     先加载图片, 不显示, 等到需要显示的时候, 直接拿缓存用
         * </pre>
         * @param uri     Image Uri
         * @param options {@link RequestOptions}
         */
        public void preload(final String uri, final RequestOptions options) {
            if (mRequestManager != null) {
                if (options != null) {
                    mRequestManager.asBitmap().load(uri).apply(options).preload();
                } else {
                    mRequestManager.asBitmap().load(uri).preload();
                }
            }
        }

        // ============
        // = 图片显示 =
        // ============

        /**
         * 图片显示
         * @param uri       Image Uri
         * @param imageView ImageView
         */
        public void displayImage(final String uri, final ImageView imageView) {
            displayImage(uri, imageView, null);
        }

        /**
         * 图片显示
         * <pre>
         *     支持显示 Gif 图片第一帧
         * </pre>
         * @param uri       Image Uri
         * @param imageView ImageView
         * @param options   {@link RequestOptions}
         */
        public void displayImage(final String uri, final ImageView imageView, final RequestOptions options) {
            if (mRequestManager != null && imageView != null) {
                if (options != null) {
                    mRequestManager.asBitmap().load(uri).apply(options).into(imageView);
                } else {
                    mRequestManager.asBitmap().load(uri).into(imageView);
                }
            }
        }

        // =

        /**
         * 图片显示
         * @param uri       Image Uri
         * @param imageView ImageView
         */
        public void displayImageToGif(final String uri, final ImageView imageView) {
            displayImageToGif(uri, imageView, null);
        }

        /**
         * 图片显示
         * @param uri       Image Uri
         * @param imageView ImageView
         * @param options   {@link RequestOptions}
         */
        public void displayImageToGif(final String uri, final ImageView imageView, final RequestOptions options) {
            if (mRequestManager != null && imageView != null) {
                if (options != null) {
                    mRequestManager.asGif().load(uri).apply(options).into(imageView);
                } else {
                    mRequestManager.asGif().load(uri).into(imageView);
                }
            }
        }

        // ============
        // = 图片加载 =
        // ============

        /**
         * 图片加载
         * @param uri    Image Uri
         * @param target {@link Target}
         */
        public void loadImageBitmap(final String uri, final Target<Bitmap> target) {
            loadImageBitmap(uri, target, null);
        }

        /**
         * 图片加载
         * @param uri     Image Uri
         * @param target  {@link Target}
         * @param options {@link RequestOptions}
         */
        public void loadImageBitmap(final String uri, final Target<Bitmap> target, final RequestOptions options) {
            if (mRequestManager != null) {
                if (options != null) {
                    mRequestManager.asBitmap().load(uri).apply(options).into(target);
                } else {
                    mRequestManager.asBitmap().load(uri).into(target);
                }
            }
        }

        // =

        /**
         * 图片加载
         * @param uri    Image Uri
         * @param target {@link Target}
         */
        public void loadImageDrawable(final String uri, final Target<Drawable> target) {
            loadImageDrawable(uri, target, null);
        }

        /**
         * 图片加载
         * @param uri     Image Uri
         * @param target  {@link Target}
         * @param options {@link RequestOptions}
         */
        public void loadImageDrawable(final String uri, final Target<Drawable> target, final RequestOptions options) {
            if (mRequestManager != null) {
                if (options != null) {
                    mRequestManager.asDrawable().load(uri).apply(options).into(target);
                } else {
                    mRequestManager.asDrawable().load(uri).into(target);
                }
            }
        }

        // =

        /**
         * 图片加载
         * @param uri    Image Uri
         * @param target {@link Target}
         */
        public void loadImageFile(final String uri, final Target<File> target) {
            loadImageFile(uri, target, null);
        }

        /**
         * 图片加载
         * @param uri     Image Uri
         * @param target  {@link Target}
         * @param options {@link RequestOptions}
         */
        public void loadImageFile(final String uri, final Target<File> target, final RequestOptions options) {
            if (mRequestManager != null) {
                if (options != null) {
                    mRequestManager.asFile().load(uri).apply(options).into(target);
                } else {
                    mRequestManager.asFile().load(uri).into(target);
                }
            }
        }

        /**
         * 图片加载
         * @param uri    Image Uri
         * @param target {@link Target}
         */
        public void loadImageGif(final String uri, final Target<GifDrawable> target) {
            loadImageGif(uri, target, null);
        }

        /**
         * 图片加载
         * @param uri     Image Uri
         * @param target  {@link Target}
         * @param options {@link RequestOptions}
         */
        public void loadImageGif(final String uri, final Target<GifDrawable> target, final RequestOptions options) {
            if (mRequestManager != null) {
                if (options != null) {
                    mRequestManager.asGif().load(uri).apply(options).into(target);
                } else {
                    mRequestManager.asGif().load(uri).into(target);
                }
            }
        }

        // ============
        // = 其他操作 =
        // ============

        /**
         * 取消图片显示任务
         * @param view {@link View}
         */
        public void cancelDisplayTask(final View view) {
            if (mRequestManager != null && view != null) {
                mRequestManager.clear(view);
            }
        }

        /**
         * 取消图片显示任务
         * @param target {@link Target}
         */
        public void cancelDisplayTask(final Target target) {
            if (mRequestManager != null && target != null) {
                mRequestManager.clear(target);
            }
        }

        // =

        /**
         * 销毁操作
         */
        public void destroy() {
            if (mRequestManager != null) {
                mRequestManager.onDestroy();
            }
        }

        /**
         * 暂停图片加载
         */
        public void pause() {
            if (mRequestManager != null) {
                mRequestManager.pauseAllRequests();
            }
        }

        /**
         * 恢复图片加载
         */
        public void resume() {
            if (mRequestManager != null) {
                mRequestManager.resumeRequests();
            }
        }

        /**
         * 停止图片加载
         */
        public void stop() {
            if (mRequestManager != null) {
                mRequestManager.onStop();
            }
        }

        /**
         * 开始图片加载
         */
        public void start() {
            if (mRequestManager != null) {
                mRequestManager.onStart();
            }
        }
    }

    // ============
    // = 其他操作 =
    // ============

    /**
     * 清除磁盘缓存
     */
    public static void clearDiskCache() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // This method must be called on a background thread.
                    Glide.get(sContext).clearDiskCache();
                } catch (Exception e) {
                    LogPrintUtils.eTag(TAG, e, "clearDiskCache");
                }
            }
        }).start();
    }

    /**
     * 清除内存缓存
     */
    public static void clearMemoryCache() {
        try {
            // This method must be called on the main thread.
            Glide.get(sContext).clearMemory(); // 必须在主线程上调用该方法
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "clearMemoryCache");
        }
    }

    /**
     * 低内存通知
     */
    public static void onLowMemory() {
        try {
            Glide.get(sContext).onLowMemory();
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "onLowMemory");
        }
    }

    /**
     * 获取 SDCard 缓存空间
     * @return SDCard 缓存空间 File
     */
    public static File getDiskCache() {
        try {
            return Glide.getPhotoCacheDir(sContext);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getDiskCache");
        }
        return null;
    }
}