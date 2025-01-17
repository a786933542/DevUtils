

## 目录结构

```
- dev                                                 | 根目录
   - other                                            | 第三方库封装工具类
   - receiver                                         | BroadcastReceiver 监听相关
   - service                                          | Service 相关
   - temp                                             | 临时快捷调用工具类
```


## Use

> 直接 copy 所需要的类到项目中使用


## API


- dev                                                 | 根目录
   - [other](#devother)                               | 第三方库封装工具类
   - [receiver](#devreceiver)                         | BroadcastReceiver 监听相关
   - [service](#devservice)                           | Service 相关
   - [temp](#devtemp)                                 | 临时快捷调用工具类




## <span id="dev">**`dev`**</span>


## <span id="devother">**`dev.other`**</span>


* **EventBus 工具类 ->** [EventBusUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/other/EventBusUtils.java)

| 方法 | 注释 |
| :- | :- |
| register | 注册 EventBus |
| unregister | 解绑 EventBus |
| post | 发送事件消息 |
| cancelEventDelivery | 取消事件传送 |
| postSticky | 发送粘性事件消息 |
| removeStickyEvent | 移除指定的粘性订阅事件 |
| removeAllStickyEvents | 移除所有的粘性订阅事件 |


* **Glide 图形处理工具类 ->** [GlideTransformUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/other/GlideTransformUtils.java)

| 方法 | 注释 |
| :- | :- |
| transform | transform |
| updateDiskCacheKey | updateDiskCacheKey |
| blurBitmap | 模糊图片处理 |


* **Glide 工具类 ->** [GlideUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/other/GlideUtils.java)

| 方法 | 注释 |
| :- | :- |
| with | with |
| init | 初始化方法 |
| cloneImageOptions | 克隆图片加载配置 |
| defaultOptions | 获取默认加载配置 |
| emptyOptions | 获取空白加载配置 |
| skipCacheOptions | 获取跳过缓存 ( 每次都从服务端获取最新 ) 加载配置 |
| getLoadResOptions | 获取自定义图片加载配置 |
| transformationOptions | 获取图片处理效果加载配置 |
| clearDiskCache | 清除磁盘缓存 |
| clearMemoryCache | 清除内存缓存 |
| onLowMemory | 低内存通知 |
| getDiskCache | 获取 SDCard 缓存空间 |
| preload | 预加载图片 |
| displayImage | 图片显示 |
| displayImageToGif | 图片显示 |
| loadImageBitmap | 图片加载 |
| loadImageDrawable | 图片加载 |
| loadImageFile | 图片加载 |
| loadImageGif | 图片加载 |
| cancelDisplayTask | 取消图片显示任务 |
| destroy | 销毁操作 |
| pause | 暂停图片加载 |
| resume | 恢复图片加载 |
| stop | 停止图片加载 |
| start | 开始图片加载 |


* **Gson 工具类 ->** [GsonUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/other/GsonUtils.java)

| 方法 | 注释 |
| :- | :- |
| toJson | 将对象转换为 JSON String |
| fromJson | 将 JSON String 映射为指定类型对象 |
| isJSON | 判断字符串是否 JSON 格式 |
| toJsonIndent | JSON String 缩进处理 |
| createGson | 创建 GsonBuilder |
| createGsonExcludeFields | 创建过滤指定修饰符字段 GsonBuilder |
| getArrayType | 获取 Array Type |
| getListType | 获取 List Type |
| getSetType | 获取 Set Type |
| getMapType | 获取 Map Type |
| getType | 获取 Type |


* **ImageLoader 工具类 ->** [ImageLoaderUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/other/ImageLoaderUtils.java)

| 方法 | 注释 |
| :- | :- |
| init | 初始化 ImageLoader 加载配置 |
| defaultOptions | 获取 DisplayImageOptions 图片加载配置 |
| getDefaultImageOptions | 获取图片默认加载配置 |
| getNoCacheImageOptions | 获取不使用缓存的图片加载配置 |
| getCacheImageOptions | 获取 ImageLoader 图片缓存加载配置 |
| cloneImageOptions | 克隆图片加载配置 |
| getFadeInBitmapDisplayer | 获取图片渐变动画加载配置 |
| getRoundedBitmapDisplayer | 获取圆角图片加载配置 |
| getBitmapDisplayerOptions | 获取图片效果加载配置 |
| displayImage | 图片显示 |
| loadImage | 图片加载 |
| loadImageSync | 图片同步加载 |
| clearDiskCache | 清除磁盘缓存 |
| clearMemoryCache | 清除内存缓存 |
| getDiskCache | 获取 SDCard 缓存空间 |
| getMemoryCache | 获取 Memory 缓存空间 |
| handleSlowNetwork | 设置是否处理弱网情况 |
| denyNetworkDownloads | 设置是否禁止网络下载 |
| cancelDisplayTask | 取消图片显示任务 |
| getLoadingUriForView | 通过 ImageView 获取图片加载地址 |
| setDefaultLoadingListener | 设置全局加载监听事件 |
| destroy | 销毁操作 |
| pause | 暂停图片加载 |
| resume | 恢复图片加载 |
| stop | 停止图片加载 |


## <span id="devreceiver">**`dev.receiver`**</span>


* **网络监听广播 ->** [NetWorkReceiver.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/receiver/NetWorkReceiver.java)

| 方法 | 注释 |
| :- | :- |
| onReceive | onReceive |
| isConnectNetWork | 是否连接网络 |
| getConnectType | 获取连接的网络类型 |
| registerReceiver | 注册网络广播监听 |
| unregisterReceiver | 取消注册网络广播监听 |
| setNetListener | 设置监听通知事件 |
| onNetworkState | 网络连接状态改变时通知 |


* **手机监听广播 ->** [PhoneReceiver.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/receiver/PhoneReceiver.java)

| 方法 | 注释 |
| :- | :- |
| onReceive | onReceive |
| registerReceiver | 注册电话监听广播 |
| unregisterReceiver | 取消注册电话监听广播 |
| setPhoneListener | 设置电话状态监听事件 |
| onPhoneStateChanged | 电话状态改变通知 |


* **屏幕监听广播 ( 锁屏 / 解锁 / 亮屏 ) ->** [ScreenReceiver.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/receiver/ScreenReceiver.java)

| 方法 | 注释 |
| :- | :- |
| onReceive | onReceive |
| registerReceiver | 注册屏幕监听广播 |
| unregisterReceiver | 取消注册屏幕监听广播 |
| setScreenListener | 设置屏幕监听事件 |
| screenOn | 用户打开屏幕 ( 屏幕变亮 ) |
| screenOff | 锁屏触发 |
| userPresent | 用户解锁触发 |


* **短信监听广播 ->** [SmsReceiver.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/receiver/SmsReceiver.java)

| 方法 | 注释 |
| :- | :- |
| onReceive | onReceive |
| getMessageData | 获取消息数据 |
| registerReceiver | 注册短信监听广播 |
| unregisterReceiver | 取消注册短信监听广播 |
| setSmsListener | 设置短信监听事件 |
| onMessage | 最终触发通知 ( 超过长度的短信消息, 最终合并成一条内容体 ) |


* **时间监听广播 ->** [TimeReceiver.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/receiver/TimeReceiver.java)

| 方法 | 注释 |
| :- | :- |
| onReceive | onReceive |
| registerReceiver | 注册时间监听广播 |
| unregisterReceiver | 取消注册时间监听广播 |
| setTimeListener | 设置时间监听事件 |
| onTimeZoneChanged | 时区改变 |
| onTimeChanged | 设置时间 |
| onTimeTick | 每分钟调用 |


* **Wifi 监听广播 ->** [WifiReceiver.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/receiver/WifiReceiver.java)

| 方法 | 注释 |
| :- | :- |
| onReceive | onReceive |
| registerReceiver | 注册 Wifi 监听广播 |
| unregisterReceiver | 取消注册 Wifi 监听广播 |
| setWifiListener | 设置 Wifi 监听事件 |
| onIntoTrigger | 触发回调通知 ( 每次进入都通知 ) |
| onTrigger | 触发回调通知 |
| onWifiSwitch | Wifi 开关状态 |


## <span id="devservice">**`dev.service`**</span>


* **无障碍功能监听服务 ->** [AccessibilityListenerService.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/service/AccessibilityListenerService.java)

| 方法 | 注释 |
| :- | :- |
| onAccessibilityEvent | 通过这个函数可以接收系统发送来的 AccessibilityEvent |
| onInterrupt | 系统想要中断 AccessibilityService 返给的响应时会调用 |
| onServiceConnected | 系统成功绑定该服务时被触发, 也就是当你在设置中开启相应的服务, 系统成功的绑定了该服务时会触发, 通常我们可以在这里做一些初始化操作 |
| onCreate | onCreate |
| onDestroy | onDestroy |
| getSelf | 获取当前服务所持对象 |
| startService | 启动服务 |
| stopService | 停止服务 |
| checkAccessibility | 检查是否开启无障碍功能 |
| isAccessibilitySettingsOn | 判断是否开启无障碍功能 |
| setAccessibilityListener | 设置监听事件 |
| onServiceCreated | 服务创建通知 |
| onServiceDestroy | 服务销毁通知 |


* **通知栏监听服务 ->** [NotificationService.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/service/NotificationService.java)

| 方法 | 注释 |
| :- | :- |
| onNotificationPosted | 当系统收到新的通知后触发回调 |
| onNotificationRemoved | 当系统通知被删掉后触发回调 |
| onCreate | onCreate |
| onDestroy | onDestroy |
| onStartCommand | onStartCommand |
| getSelf | 获取当前服务所持对象 |
| startService | 启动服务 |
| stopService | 停止服务 |
| checkAndIntentSetting | 检查是否有获取通知栏信息权限并跳转设置页面 |
| isNotificationListenerEnabled | 判断是否有获取通知栏信息权限 |
| startNotificationListenSettings | 跳转到设置页面, 开启获取通知栏信息权限 |
| cancelNotification | 取消通知方法 |
| setNotificationListener | 设置通知栏监听事件 |
| onServiceCreated | 服务创建通知 |
| onServiceDestroy | 服务销毁通知 |


## <span id="devtemp">**`dev.temp`**</span>


* **随机生成汉字工具类 ->** [ChineseUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevOther/src/main/java/dev/temp/ChineseUtils.java)

| 方法 | 注释 |
| :- | :- |
| getRandomWord | 获取随机汉字 |