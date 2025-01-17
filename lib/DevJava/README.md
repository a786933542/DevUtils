
## Gradle

```java
implementation 'com.afkt:DevJava:1.0.5'
```

## 目录结构

```
- dev.utils                                           | 根目录
   - common                                           | Java 工具类, 不依赖 android api
      - assist                                        | 各种快捷辅助类
         - search                                     | 搜索相关 ( 文件搜索等 )
      - cipher                                        | 编 / 解码工具类
      - encrypt                                       | 加密工具类
      - random                                        | 随机概率算法工具类
      - thread                                        | 线程相关
      - validator                                     | 数据校验工具类
```


## 事项

- 该工具类不依赖 android api，属于 Java 工具类库

- 开启日志
```java
// 打开 lib 内部日志 - 线上 (release) 环境，不调用方法就行
JCLogUtils.setPrintLog(true);
// 控制台打印日志
JCLogUtils.setControlPrintLog(true);
// 设置 Java 模块日志信息监听
JCLogUtils.setPrint(new JCLogUtils.Print() {});
```

- 部分 API 更新不及时或有遗漏等，`具体以对应的工具类为准`

- [检测代码规范、注释内容排版，API 文档生成](https://github.com/afkT/JavaDoc)

## API


- dev.utils                                           | 根目录
   - [common](#devutilscommon)                        | Java 工具类, 不依赖 android api
      - [assist](#devutilscommonassist)               | 各种快捷辅助类
         - [search](#devutilscommonassistsearch)      | 搜索相关 ( 文件搜索等 )
      - [cipher](#devutilscommoncipher)               | 编 / 解码工具类
      - [encrypt](#devutilscommonencrypt)             | 加密工具类
      - [random](#devutilscommonrandom)               | 随机概率算法工具类
      - [thread](#devutilscommonthread)               | 线程相关
      - [validator](#devutilscommonvalidator)         | 数据校验工具类




## <span id="devutilscommon">**`dev.utils.common`**</span>


* **Array 数组工具类 ->** [ArrayUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ArrayUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断数组是否为 null |
| isNotEmpty | 判断数组是否不为 null |
| length | 获取数组长度 |
| isLength | 判断数组长度是否等于期望长度 |
| get | 获取数组对应索引数据 |
| getFirst | 获取数组第一条数据 |
| getLast | 获取数组最后一条数据 |
| getPosition | 根据指定值获取 value 所在位置 + 偏移量的索引 |
| getNotNull | 根据指定 value 获取 value 所在位置 + 偏移量的值, 不允许值为 null |
| getPositionNotNull | 根据指定 value 获取索引, 不允许值为 null |
| intsToIntegers | int[] 转换 Integer[] |
| bytesToBytes | byte[] 转换 Byte[] |
| charsToCharacters | char[] 转换 Character[] |
| shortsToShorts | short[] 转换 Short[] |
| longsToLongs | long[] 转换 Long[] |
| floatsToFloats | float[] 转换 Float[] |
| doublesToDoubles | double[] 转换 Double[] |
| booleansToBooleans | boolean[] 转换 Boolean[] |
| integersToInts | Integer[] 转换 int[] |
| charactersToChars | Character[] 转换 char[] |
| asList | 转换数组为集合 |
| equals | 判断两个值是否一样 |
| arraycopy | 拼接数组 |
| newarray | 创建指定长度数组 |
| subarray | 从数组上截取一段 |
| appendToString | 追加数组内容字符串 |
| getMinimumIndex | 获取数组中最小值索引 |
| getMaximumIndex | 获取数组中最大值索引 |
| getMinimum | 获取数组中最小值 |
| getMaximum | 获取数组中最大值 |
| sumarray | 计算数组总和 |


* **资金运算工具类 ->** [BigDecimalUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/BigDecimalUtils.java)

| 方法 | 注释 |
| :- | :- |
| add | 提供精确的加法运算 |
| substract | 提供精确的减法运算 |
| multiply | 提供精确的乘法运算 |
| divide | 提供 ( 相对 ) 精确的除法运算 |
| round | 提供精确的小数位四舍五入处理 |
| remainder | 取余数 |
| compare | 比较大小 |
| formatMoney | 金额分割, 四舍五入金额 |
| adjustDouble | 获取自己想要的数据格式 |


* **类 (Class) 工具类 ->** [ClassUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ClassUtils.java)

| 方法 | 注释 |
| :- | :- |
| isBaseDataType | 判断类是否是基础数据类型 - 目前支持 11 种 |
| newInstance | 根据类获取对象, 不再必须一个无参构造 |
| getDefaultPrimiticeValue | 判断 Class 是否为原始类型 (boolean、char、byte、short、int、long、float、double) |
| isCollection | 判断是否集合类型 |
| isArray | 判断是否数组类型 |
| getGenericSuperclass | 获取父类泛型类型 |
| getGenericInterfaces | 获取接口泛型类型 |


* **克隆工具类 ->** [CloneUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/CloneUtils.java)

| 方法 | 注释 |
| :- | :- |
| deepClone | 进行克隆 |
| serializableToBytes | 通过序列化实体类, 获取对应的 byte[] 数据 |


* **关闭 (IO 流 ) 工具类 ->** [CloseUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/CloseUtils.java)

| 方法 | 注释 |
| :- | :- |
| closeIO | 关闭 IO |
| closeIOQuietly | 安静关闭 IO |


* **集合工具类 (Collection - List、Set、Queue) 等 ->** [CollectionUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/CollectionUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断 Collection 是否为 null |
| isNotEmpty | 判断 Collection 是否不为 null |
| length | 获取 Collection 长度 |
| isLength | 获取长度 to Collection 是否等于期望长度 |
| greaterThan | 判断 Collection 长度是否大于指定长度 |
| greaterThanOrEqual | 判断 Collection 长度是否大于等于指定长度 |
| lessThan | 判断 Collection 长度是否小于指定长度 |
| lessThanOrEqual | 判断 Collection 长度是否小于等于指定长度 |
| get | 获取数据 |
| getFirst | 获取第一条数据 |
| getLast | 获取最后一条数据 |
| getPosition | 根据指定 value 获取 value 所在位置 + 偏移量的索引 |
| getPositionNotNull | 根据指定 value 获取索引, 不允许值为 null |
| getNext | 根据指定 value 获取 value 所在位置的下一个值 |
| getNextNotNull | 根据指定 value 获取 value 所在位置的下一个值, 不允许值为 null |
| getPrevious | 根据指定 value 获取 value 所在位置的上一个值 |
| getPreviousNotNull | 根据指定 value 获取 value 所在位置的上一个值, 不允许值为 null |
| add | 添加一条数据 |
| addNotNull | 添加一条数据 - value 不允许为 null |
| addAll | 添加集合数据 |
| addAllNotNull | 添加集合数据 - values 内的值不允许为 null |
| remove | 移除一条数据 |
| removeAll | 移除集合数据 |
| clear | 清空集合中符合指定 value 的全部数据 |
| clearNotBelong | 保留集合中符合指定 value 的全部数据 |
| clearAll | 清空集合全部数据 |
| clearNull | 清空集合中为 null 的值 |
| isEqualCollection | 判断两个集合是否相同 |
| isEqualCollections | 判断多个集合是否相同 |
| union | 两个集合并集处理 |
| unions | 多个集合并集处理 |
| intersection | 两个集合交集处理 |
| disjunction | 两个集合交集的补集处理 |
| subtract | 两个集合差集 ( 扣除 ) 处理 |
| equals | 判断两个值是否一样 |
| toArray | 转换数组 to Object |
| reverse | 集合翻转处理 |
| getMinimumIndexI | 获取集合中最小值索引 |
| getMinimumIndexL | 获取集合中最小值索引 |
| getMinimumIndexF | 获取集合中最小值索引 |
| getMinimumIndexD | 获取集合中最小值索引 |
| getMaximumIndexI | 获取集合中最大值索引 |
| getMaximumIndexL | 获取集合中最大值索引 |
| getMaximumIndexF | 获取集合中最大值索引 |
| getMaximumIndexD | 获取集合中最大值索引 |
| getMinimumI | 获取集合中最小值 |
| getMinimumL | 获取集合中最小值 |
| getMinimumF | 获取集合中最小值 |
| getMinimumD | 获取集合中最小值 |
| getMaximumI | 获取集合中最大值 |
| getMaximumL | 获取集合中最大值 |
| getMaximumF | 获取集合中最大值 |
| getMaximumD | 获取集合中最大值 |
| sumlistI | 计算集合总和 |
| sumlistL | 计算集合总和 |
| sumlistF | 计算集合总和 |
| sumlistD | 计算集合总和 |


* **颜色工具类 ( 包括常用的色值 ) ->** [ColorUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ColorUtils.java)

| 方法 | 注释 |
| :- | :- |
| toHexAlpha | 获取十六进制透明度字符串 |
| alpha | 返回一个颜色中的透明度值 ( 返回十进制 ) |
| alphaPercent | 返回一个颜色中的透明度百分比值 |
| red | 返回一个颜色中红色的色值 ( 返回十进制 ) |
| redPercent | 返回一个颜色中红色的百分比值 |
| green | 返回一个颜色中绿色的色值 ( 返回十进制 ) |
| greenPercent | 返回一个颜色中绿色的百分比值 |
| blue | 返回一个颜色中蓝色的色值 ( 返回十进制 ) |
| bluePercent | 返回一个颜色中蓝色的百分比值 |
| rgb | 根据对应的 red、green、blue 生成一个颜色值 |
| argb | 根据对应的 alpha、red、green、blue 生成一个颜色值 ( 含透明度 ) |
| isRGB | 判断颜色 RGB 是否有效 |
| isARGB | 判断颜色 ARGB 是否有效 |
| setAlpha | 设置透明度 |
| setRed | 改变颜色值中的红色色值 |
| setGreen | 改变颜色值中的绿色色值 |
| setBlue | 改变颜色值中的蓝色色值 |
| parseColor | 解析颜色字符串, 返回对应的颜色值 |
| intToRgbString | 颜色值 转换 RGB 颜色字符串 |
| intToArgbString | 颜色值 转换 ARGB 颜色字符串 |
| getRandomColor | 获取随机颜色值 |
| judgeColorString | 判断是否为 ARGB 格式的十六进制颜色, 例如: FF990587 |
| setDark | 颜色加深 ( 单独修改 RGB 值, 不变动透明度 ) |
| setLight | 颜色变浅, 变亮 ( 单独修改 RGB 值, 不变动透明度 ) |
| setAlphaDark | 设置透明度加深 |
| setAlphaLight | 设置透明度变浅 |


* **转换工具类 (Byte、Hex 等 ) ->** [ConvertUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ConvertUtils.java)

| 方法 | 注释 |
| :- | :- |
| convert | Object 转换所需类型对象 |
| toString | char[] 转 String |
| toInt | 字符串 转 int |
| toBoolean | 字符串 转 boolean |
| toFloat | 字符串 转 float |
| toDouble | 字符串 转 double |
| toLong | 字符串 转 long |
| toShort | 基本类型对象 转 short |
| toChar | 基本类型对象 转 char |
| toByte | 基本类型对象 转 byte |
| toCharInt | char 转换 unicode 编码 |
| toChars | 字符串 获取 char[] |
| toBytes | 字符串 获取 byte[] |
| parseInt | 字符串转换对应的进制 |
| parseLong | 字符串转换对应的进制 |
| bytesToObject | byte[] 转为 Object |
| objectToBytes | Object 转为 byte[] |
| bytesToChars | byte[] 转换 char[], 并且进行补码 |
| charsToBytes | char[] 转换 byte[] |
| intsToStrings | int[] 转换 string[] |
| doublesToStrings | double[] 转换 string[] |
| longsToStrings | long[] 转换 string[] |
| floatsToStrings | float[] 转换 string[] |
| intsToDoubles | int[] 转换 double[] |
| intsToLongs | int[] 转换 long[] |
| intsToFloats | int[] 转换 float[] |
| stringsToInts | string[] 转换 int[] |
| stringsToDoubles | string[] 转换 double[] |
| stringsToLongs | string[] 转换 long[] |
| stringsToFloats | string[] 转换 float[] |
| doublesToInts | double[] 转换 int[] |
| longsToInts | long[] 转换 int[] |
| floatsToInts | float[] 转换 int[] |
| toBinaryString | 将 字节转换 为 二进制字符串 |
| decodeBinary | 二进制字符串 转换 byte[] 解码 |
| isHex | 判断是否十六进制数据 |
| decodeHex | 将十六进制字节数组解码 |
| hexToInt | 十六进制 char 转换 int |
| toHexString | int 转换十六进制 |
| toHexChars | 将 string 转换为 十六进制 char[] |
| bytesBitwiseAND | 按位求补 byte[] 位移编解码 ( 共用同一个方法 ) |


* **坐标 (GPS 纠偏 ) 相关工具类 ->** [CoordinateUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/CoordinateUtils.java)

| 方法 | 注释 |
| :- | :- |
| bd09ToGcj02 | BD09 坐标转 GCJ02 坐标 |
| gcj02ToBd09 | GCJ02 坐标转 BD09 坐标 |
| gcj02ToWGS84 | GCJ02 坐标转 WGS84 坐标 |
| wgs84ToGcj02 | WGS84 坐标转 GCJ02 坐标 |
| bd09ToWGS84 | BD09 坐标转 WGS84 坐标 |
| wgs84ToBd09 | WGS84 坐标转 BD09 坐标 |
| outOfChina | 判断是否中国境外 |


* **日期工具类 ->** [DateUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/DateUtils.java)

| 方法 | 注释 |
| :- | :- |
| getDateNow | 获取当前日期的字符串 - yyyy-MM-dd HH:mm:ss |
| formatTime | 将时间戳转换日期字符串 |
| formatDate | 将 Date 转换日期字符串 |
| parseDate | 将时间戳转换成 Date |
| parseLong | 解析时间字符串转换为 long 毫秒 - 默认表示 time 属于 yyyy-MM-dd HH:mm:ss 格式 |
| parseToString | 转换时间为指定字符串 |
| getTimeDiffMinute | 获取时间差 - 分钟 |
| getTimeDiffHour | 获取时间差 - 小时 |
| getTimeDiffDay | 获取时间差 - 天 |
| getTimeDiff | 获取时间差 - ( 传入时间 - 当前时间 ) |
| getYear | 获取年 |
| getMonth | 获取月 (0 - 11) + 1 |
| getDay | 获取日 |
| getWeek | 获取日期是星期几 |
| get24Hour | 获取时 - 24 |
| get12Hour | 获取时 - 12 |
| getMinute | 获取分 |
| getSecond | 获取秒 |
| convertTime | 转换时间处理, 小于 10, 则自动补充 0x |
| isLeapYear | 判断是否闰年 |
| getMonthDayNumberAll | 根据年份、月份, 获取对应的天数 ( 完整天数, 无判断是否属于未来日期 ) |
| getYearMonthNumber | 根据年份, 获取对应的月份 |
| getMonthDayNumber | 根据年份、月份, 获取对应的天数 |
| getArrayToHH | 生成 HH 按时间排序数组 |
| getListToHH | 生成 HH 按时间排序集合 |
| getArrayToMM | 生成 MM 按时间排序数组 |
| getListToMM | 生成 MM 按时间排序集合 |
| getArrayToHHMM | 生成 HH:mm 按间隔时间排序数组 |
| getListToHHMM | 生成 HH:mm 按间隔时间排序集合 |
| getListToHHMMPosition | 获取 HH:mm 按间隔时间排序的集合中, 指定时间所在索引 |
| secToTimeRetain | 传入时间, 获取时间 (00:00:00 格式 ) - 不处理大于一天 |
| convertTimeArys | 传入时间, 时间参数 ( 小时、分钟、秒 ) |
| millisToFitTimeSpan | 转换时间 |
| millisToTimeArys | 转换时间为数组 |
| isInTimeHHmm | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| isInTimeHHmmss | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| isInTime | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| isInDate | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| getEndTimeDiffHHmm | 获取指定时间距离该时间第二天的指定时段的时间 ( 判断凌晨情况 ) |
| getEndTimeDiff | 获取指定时间距离该时间第二天的指定时段的时间差 ( 判断凌晨情况 ) |


* **开发常用方法工具类 ->** [DevCommonUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/DevCommonUtils.java)

| 方法 | 注释 |
| :- | :- |
| timeRecord | 耗时时间记录 |
| getOperateTime | 获取操作时间 |
| sleepOperate | 堵塞操作 |
| isHttpRes | 判断是否网络资源 |
| whileMD5 | 循环 MD5 加密处理 |
| randomUUID | 获取随机唯一数 |
| randomUUIDToHashCode | 获取随机唯一数 HashCode |
| getRandomUUID | 获取随机规则生成 UUID |
| getRandomUUIDToString | 获取随机规则生成 UUID 字符串 |
| converHideMobile | 转换手机号 |
| converSymbolHide | 转换符号处理 |
| subEllipsize | 裁剪超出的内容, 并且追加符号 ( 如 ...) |
| subSymbolHide | 裁剪符号处理 |
| subSetSymbol | 裁剪内容, 设置符号处理 |
| substring | 裁剪字符串 |
| toReplaceSEWith | 替换 ( 删除 - 替换成 "") 字符串中符合 特定标记字符的 startsWith - endsWith |
| toReplaceStartsWith | 替换开头字符串 |
| toReplaceEndsWith | 替换结尾字符串 |
| toClearSEWiths | 这个方法功能主要把字符符合标记的 头部和尾部都替换成 "" |
| toClearStartsWith | 清空属于特定字符串开头的字段 |
| toClearEndsWith | 清空属于特定字符串结尾的字段 |
| replaceStr | 替换字符串 |
| replaceStrToNull | 替换字符串 |
| replaceStrs | 替换字符串 |
| isEmpty | 判断数组是否为 null |
| isNotEmpty | 判断数组是否不为 null |
| length | 获取数组长度 |
| isLength | 判断数组长度是否等于期望长度 |
| equals | 判断两个值是否一样 |
| isEquals | 判断多个字符串是否相等, 只有全相等才返回 true - 对比大小写 |
| isOrEquals | 判断多个字符串, 只要有一个符合条件则通过 |
| isContains | 判断一堆值中, 是否存在符合该条件的 ( 包含 ) |
| isStartsWith | 判断内容, 是否属于特定字符串开头 - 对比大小写 |
| isEndsWith | 判断内容, 是否属于特定字符串结尾 - 对比大小写 |
| isSpace | 判断字符串是否为 null 或全为空白字符 |
| toClearSpace | 清空字符串全部空格 |
| toClearSpaceTrim | 清空字符串前后所有空格 |
| appendSpace | 追加空格 |
| appendTab | 追加 Tab |
| appendLine | 追加换行 |
| toCheckValue | 检查字符串 |
| toCheckValues | 检查字符串 - 多个值 |
| toCheckValuesSpace | 检查字符串 - 多个值 ( 删除前后空格对比判断 ) |
| getFormatString | 获取格式化后的字符串 |
| getAutoFormatString | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| getAutoFormatString2 | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| appends | StringBuilder 拼接处理 |


* **编码工具类 ->** [EncodeUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/EncodeUtils.java)

| 方法 | 注释 |
| :- | :- |
| base64Encode | Base64 编码 |
| base64EncodeToString | Base64 编码 |
| base64Decode | Base64 解码 |
| base64DecodeToString | Base64 解码 |
| htmlEncode | Html 字符串编码 |


* **变量字段工具类 ->** [FieldUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/FieldUtils.java)

| 方法 | 注释 |
| :- | :- |
| isSerializable | 判断是否序列化 |
| set | 设置字段的值 |
| get | 获取字段的值 |
| isLong | 是否 long/Long 类型 |
| isFloat | 是否 float/Float 类型 |
| isDouble | 是否 double/Double 类型 |
| isInteger | 是否 int/Integer 类型 |
| isString | 是否 String 类型 |
| getGenericType | 获取字段的泛型类型, 如果不带泛型返回 null |
| getComponentType | 获取数组的类型 |
| getAllDeclaredFields | 获取全部 Field, 包括父类 |
| isInvalid | 是静态常量或者内部结构属性 |


* **文件 (IO 流 ) 工具类 ->** [FileIOUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/FileIOUtils.java)

| 方法 | 注释 |
| :- | :- |
| setBufferSize | 设置缓冲区的大小, 默认大小等于 8192 字节 |
| writeFileFromIS | 通过输入流写入文件 |
| writeFileFromBytesByStream | 通过字节流写入文件 |
| writeFileFromBytesByChannel | 通过 FileChannel 把字节流写入文件 |
| writeFileFromBytesByMap | 通过 MappedByteBuffer 把字节流写入文件 |
| writeFileFromString | 通过字符串写入文件 |
| readFileToList | 读取文件内容, 返回换行 List |
| readFileToString | 读取文件内容, 返回字符串 |
| readFileToBytesByStream | 读取文件内容, 返回 byte[] |
| readFileToBytesByChannel | 通过 FileChannel, 读取文件内容, 返回 byte[] |
| readFileToBytesByMap | 通过 MappedByteBuffer, 读取文件内容, 返回 byte[] |


* **文件操作工具类 ->** [FileUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/FileUtils.java)

| 方法 | 注释 |
| :- | :- |
| getFile | 获取文件 |
| getFileByPath | 获取文件 |
| getFileCreateFolder | 获取路径, 并且进行创建目录 |
| getFilePathCreateFolder | 获取路径, 并且进行创建目录 |
| createFolder | 判断某个文件夹是否创建, 未创建则创建 ( 纯路径 - 无文件名 ) |
| createFolderByPath | 创建文件夹目录 - 可以传入文件名 |
| createFolderByPaths | 创建多个文件夹, 如果不存在则创建 |
| createOrExistsDir | 判断目录是否存在, 不存在则判断是否创建成功 |
| createOrExistsFile | 判断文件是否存在, 不存在则判断是否创建成功 |
| createFileByDeleteOldFile | 判断文件是否存在, 存在则在创建之前删除 |
| getPath | 获取文件路径 |
| getAbsolutePath | 获取文件绝对路径 |
| getName | 获取文件名 |
| getFileSuffix | 获取文件后缀名 ( 无 "." 单独后缀 ) |
| getFileNotSuffix | 获取文件名 ( 无后缀 ) |
| getFileNotSuffixToPath | 获取文件名 ( 无后缀 ) |
| getFileNameNoExtension | 获取路径中的不带拓展名的文件名 |
| getFileExtension | 获取路径中的文件拓展名 |
| isFileExists | 检查是否存在某个文件 |
| isFile | 判断是否文件 |
| isDirectory | 判断是否文件夹 |
| isHidden | 判断是否隐藏文件 |
| getFileLastModified | 获取文件最后修改的毫秒时间戳 |
| getFileCharsetSimple | 获取文件编码格式 |
| getFileLines | 获取文件行数 |
| getFileSize | 获取文件大小 |
| getDirSize | 获取目录大小 |
| getFileLength | 获取文件大小 |
| getDirLength | 获取目录全部文件大小 |
| getFileLengthNetwork | 获取文件大小 - 网络资源 |
| getFileName | 获取路径中的文件名 |
| getDirName | 获取路径中的最长目录地址 |
| rename | 重命名文件 - 同个目录下, 修改文件名 |
| formatFileSize | 传入文件路径, 返回对应的文件大小 |
| formatByteMemorySize | 字节数转合适内存大小 保留 3 位小数 (%.位数f) |
| deleteFile | 删除文件 |
| deleteFiles | 删除多个文件 |
| deleteFolder | 删除文件夹 |
| saveFile | 保存文件 |
| appendFile | 追加文件 ( 使用 FileWriter) |
| readFileBytes | 读取文件 |
| readFile | 读取文件 |
| copyFile | 复制单个文件 |
| copyFolder | 复制文件夹 |
| moveFile | 移动 ( 剪切 ) 文件 |
| moveFolder | 移动 ( 剪切 ) 文件夹 |
| copyOrMoveDir | 复制或移动目录 |
| copyOrMoveFile | 复制或移动文件 |
| copyDir | 复制目录 |
| moveDir | 移动目录 |
| deleteDir | 删除目录 |
| deleteAllInDir | 删除目录下所有东西 |
| deleteFilesInDir | 删除目录下所有文件 |
| deleteFilesInDirWithFilter | 删除目录下所有过滤的文件 |
| listFilesInDir | 获取目录下所有文件 - 不递归进子目录 |
| listFilesInDirWithFilter | 获取目录下所有过滤的文件 - 不递归进子目录 |
| isImageFormats | 根据文件名判断文件是否为图片 |
| isAudioFormats | 根据文件名判断文件是否为音频 |
| isVideoFormats | 根据文件名判断文件是否为视频 |
| isFileFormats | 根据文件名判断文件是否为指定格式 |
| getFileMD5 | 获取文件 MD5 值 |
| getFileMD5ToHexString | 获取文件 MD5 值 |


* **Http 参数工具类 ->** [HttpParamsUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/HttpParamsUtils.java)

| 方法 | 注释 |
| :- | :- |
| splitParams | 拆分参数 |
| joinParams | 拼接请求参数 - value(String) |
| joinParamsObj | 拼接请求参数 - value(Object) |
| toConvertObjToMS | 进行转换对象处理 ( 请求发送对象 ) |
| toConvertObjToMO | 进行转换对象处理 ( 请求发送对象 ) |
| toUrlEncode | 进行 URL 编码, 默认 UTF-8 |


* **HttpURLConnection 网络工具类 ->** [HttpURLConnectionUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/HttpURLConnectionUtils.java)

| 方法 | 注释 |
| :- | :- |
| doGetAsyn | 异步的 Get 请求 |
| doPostAsyn | 异步的 Post 请求 |
| request | 发送请求 |
| getNetTime | 获取网络时间 - 默认使用百度链接 |


* **Map 工具类 ->** [MapUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/MapUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断 Map 是否为 null |
| isNotEmpty | 判断 Map 是否不为 null |
| length | 获取 Map 长度 |
| isLength | 获取长度 to Map 是否等于期望长度 |
| greaterThan | 判断 Map 长度是否大于指定长度 |
| greaterThanOrEqual | 判断 Map 长度是否大于等于指定长度 |
| lessThan | 判断 Map 长度是否小于指定长度 |
| lessThanOrEqual | 判断 Map 长度是否小于等于指定长度 |
| get | 获取 value |
| getKeyByValue | 通过 value 获取 key |
| getKeysByValue | 通过 value 获取 key 集合 ( 返回等于 value 的 key 集合 ) |
| getKeys | 通过 Map 获取 key 集合 |
| getKeysToArrays | 通过 Map 获取 key 数组 |
| getValues | 通过 Map 获取 value 集合 |
| getValuesToArrays | 通过 Map 获取 value 数组 |
| getFirst | 获取第一条数据 |
| getLast | 获取最后一条数据 |
| getNext | 根据指定 key 获取 key 所在位置的下一条数据 |
| getPrevious | 根据指定 key 获取 key 所在位置的上一条数据 |
| put | 添加一条数据 |
| putNotNull | 添加一条数据, 不允许 key 为 null |
| putAll | 添加多条数据 |
| putAllNotNull | 添加多条数据, 不允许 key 为 null |
| remove | 移除一条数据 |
| removeToKeys | 移除多条数据 |
| removeToValue | 移除等于 value 的所有数据 |
| removeToValues | 移除等于 value 的所有数据 (Collection<Value>) |
| equals | 判断两个值是否一样 |
| toggle | 切换保存状态 |
| isNullToValue | 判断指定 key 的 value 是否为 null |
| containsKey | 判断 Map 是否存储了 key |
| containsValue | 判断 Map 是否存储了 value |
| putToList | 添加一条数据 - (Value) List<T> |
| removeToList | 移除一条数据 - (Value) List<T> |
| removeToLists | 移除多条数据 - (Value) List<T> |
| removeToMap | 移除多条数据 - 通过 Map 进行移除 |


* **数字 ( 计算 ) 工具类 ->** [NumberUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/NumberUtils.java)

| 方法 | 注释 |
| :- | :- |
| percentI | 计算百分比值 ( 最大 100%) |
| percentD | 计算百分比值 ( 最大 100%) |
| percentL | 计算百分比值 ( 最大 100%) |
| percentF | 计算百分比值 ( 最大 100%) |
| percentI2 | 计算百分比值 ( 可超出 100%) |
| percentD2 | 计算百分比值 ( 可超出 100%) |
| percentL2 | 计算百分比值 ( 可超出 100%) |
| percentF2 | 计算百分比值 ( 可超出 100%) |
| clamp | 返回的 value 介于 max、min 之间, 若 value 小于 min, 返回 min, 若大于 max, 返回 max |
| getMultiple | 获取倍数 ( 自动补 1) |
| getMultipleI | 获取倍数 |
| getMultipleD | 获取倍数 |
| getMultipleL | 获取倍数 |
| getMultipleF | 获取倍数 |
| numberToCHN | 数字转中文数值 |
| isNumber | 检验数字 |
| isNumberDecimal | 检验数字或包含小数点 |


* **对象相关工具类 ->** [ObjectUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ObjectUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断对象是否为空 |
| isNotEmpty | 判断对象是否非空 |
| equals | 判断两个值是否一样 |
| requireNonNull | 检查对象是否为 null, 为 null 则抛出异常, 不为 null 则返回该对象 |
| getOrDefault | 获取非空或默认对象 |
| hashCode | 获取对象哈希值 |
| getObjectTag | 获取一个对象的独一无二的标记 |
| converObj | 获取转换对象 |


* **随机工具类 ->** [RandomUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/RandomUtils.java)

| 方法 | 注释 |
| :- | :- |
| nextBoolean | 获取伪随机 boolean 值 |
| nextBytes | 获取伪随机 byte[] |
| nextDouble | 获取伪随机 double 值 |
| nextGaussian | 获取伪随机高斯分布值 |
| nextFloat | 获取伪随机 float 值 |
| nextInt | 获取伪随机 int 值 |
| nextLong | 获取伪随机 long 值 |
| getRandomNumbers | 获取数字自定义长度的随机数 |
| getRandomLowerCaseLetters | 获取小写字母自定义长度的随机数 |
| getRandomCapitalLetters | 获取大写字母自定义长度的随机数 |
| getRandomLetters | 获取大小写字母自定义长度的随机数 |
| getRandomNumbersAndLetters | 获取数字、大小写字母自定义长度的随机数 |
| getRandom | 获取自定义数据自定义长度的随机数 |
| shuffle | 洗牌算法 ( 第一种 ), 随机置换指定的数组使用的默认源的随机性 ( 随机数据源小于三个, 则无效 ) |
| shuffle2 | 洗牌算法 ( 第二种 ), 随机置换指定的数组使用的默认源的随机性 |
| nextIntRange | 获取指定范围 int 值 |
| nextLongRange | 获取指定范围 long 值 |
| nextDoubleRange | 获取指定范围 double 值 |
| ints | 获取随机 int[] |
| longs | 获取随机 long[] |
| doubles | 获取随机 double[] |


* **反射相关工具类 ->** [Reflect2Utils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/Reflect2Utils.java)

| 方法 | 注释 |
| :- | :- |
| setProperty | 设置某个对象变量值 ( 可设置静态变量 ) |
| getProperty | 获取某个对象的变量 ( 可获取静态变量 ) |
| getStaticProperty | 获取某个类的静态变量 ( 只能获取静态变量 ) |
| invokeMethod | 执行某个对象方法 ( 可执行静态方法 ) |
| invokeStaticMethod | 执行某个类的静态方法 ( 只能执行静态方法 ) |
| newInstance | 新建实例 ( 构造函数创建 ) |
| isInstance | 是不是某个类的实例 |
| getArgsClass | 获取参数类型 |
| getPropertyByParent | 获取父类中的变量对象 |
| getDeclaredFieldParent | 获取父类中的变量对象 ( 循环向上转型, 获取对象的 DeclaredField) |


* **反射相关工具类 ->** [ReflectUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ReflectUtils.java)

| 方法 | 注释 |
| :- | :- |
| reflect | 设置要反射的类 |
| newInstance | 实例化反射对象 |
| field | 设置反射的字段 |
| setEnumVal | 设置枚举值 |
| method | 设置反射的方法 |
| proxy | 根据类, 代理创建并返回对象 |
| type | 获取类型 |
| get | 获取反射想要获取的 |
| hashCode | 获取 HashCode |
| equals | 判断反射的两个对象是否一样 |
| toString | 获取反射获取的对象 |


* **计算比例工具类 ->** [ScaleUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ScaleUtils.java)

| 方法 | 注释 |
| :- | :- |
| calcScaleToWidth | 计算缩放比例 - 根据宽度比例转换高度 |
| calcScaleToHeight | 计算缩放比例 - 根据高度比例转换宽度 |
| calcWidthHeightToScale | 通过宽度、高度根据对应的比例, 转换成对应的比例宽度高度 - 智能转换 |
| calcWidthToScale | 以宽度为基准, 转换对应比例的高度 |
| calcHeightToScale | 以高度为基准, 转换对应比例的宽度 |


* **流操作工具类 ->** [StreamUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/StreamUtils.java)

| 方法 | 注释 |
| :- | :- |
| inputToOutputStream | 输入流转输出流 |
| outputToInputStream | 输出流转输入流 |
| inputStreamToBytes | 输入流转 byte[] |
| bytesToInputStream | byte[] 转输出流 |
| outputStreamToBytes | 输出流转 byte[] |
| bytesToOutputStream | byte[] 转 输出流 |
| inputStreamToString | 输入流转 String |
| stringToInputStream | String 转换输入流 |
| outputStreamToString | 输出流转 String |
| stringToOutputStream | String 转 输出流 |


* **字符串工具类 ->** [StringUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/StringUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断字符串是否为 null |
| isNotEmpty | 判断字符串是否不为 null |
| length | 获取字符串长度 |
| isLength | 获取字符串长度 是否等于期望长度 |
| equals | 判断两个值是否一样 |
| isEquals | 判断多个字符串是否相等, 只有全相等才返回 true - 对比大小写 |
| isOrEquals | 判断多个字符串, 只要有一个符合条件则通过 |
| countMatches | 统计字符串匹配个数 |
| countMatches2 | 统计字符串匹配个数 |
| isContains | 判断一堆值中, 是否存在符合该条件的 ( 包含 ) |
| isStartsWith | 判断内容, 是否属于特定字符串开头 - 对比大小写 |
| isEndsWith | 判断内容, 是否属于特定字符串结尾 - 对比大小写 |
| isSpace | 判断字符串是否为 null 或全为空白字符 |
| toClearSpace | 清空字符串全部空格 |
| toClearSpaceTrim | 清空字符串前后所有空格 |
| appendSpace | 追加空格 |
| appendTab | 追加 Tab |
| appendLine | 追加换行 |
| colonSplit | 冒号分割处理 |
| toCheckValue | 检查字符串 |
| toCheckValues | 检查字符串 - 多个值 |
| toCheckValuesSpace | 检查字符串 - 多个值 ( 删除前后空格对比判断 ) |
| getFormatString | 获取格式化后的字符串 |
| getAutoFormatString | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| getAutoFormatString2 | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| appends | StringBuilder 拼接处理 |
| toGBKEncode | 字符串进行 GBK 编码 |
| toGBK2312Encode | 字符串进行 GBK2312 编码 |
| toUTF8Encode | 字符串进行 UTF-8 编码 |
| toStrEncode | 进行字符串编码 |
| toUrlEncode | 进行 URL 编码, 默认 UTF-8 |
| toUrlDecode | 进行 URL 解码, 默认 UTF-8 |
| toASCII | 将字符串转移为 ASCII 码 |
| toUnicode | 将字符串转移为 Unicode 码 |
| toUnicodeString | 将字符数组转移为 Unicode 码 |
| toDBC | 转化为半角字符 |
| toSBC | 转化为全角字符 如: a = ａ, A = Ａ |
| checkChineseToString | 检测字符串是否全是中文 |
| isChinese | 判定输入汉字 |
| upperFirstLetter | 首字母大写 |
| lowerFirstLetter | 首字母小写 |
| reverse | 反转字符串 |
| concat | 字符串连接, 将参数列表拼接为一个字符串 |
| concatSpiltWith | 字符串连接, 将参数列表拼接为一个字符串 |
| underScoreCaseToCamelCase | 下划线命名转为驼峰命名 |
| camelCaseToUnderScoreCase | 驼峰命名法转为下划线命名 |
| sqliteEscape | 字符串数据库字符转义 |


* **异常处理工具类 ->** [ThrowableUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ThrowableUtils.java)

| 方法 | 注释 |
| :- | :- |
| getThrowable | 获取异常信息 |
| getThrowableStackTrace | 获取异常栈信息 |


* **压缩相关工具类 ->** [ZipUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/ZipUtils.java)

| 方法 | 注释 |
| :- | :- |
| zipFiles | 批量压缩文件 |
| zipFile | 压缩文件 |
| unzipFile | 解压文件 |
| unzipFileByKeyword | 解压带有关键字的文件 |
| getFilesPath | 获取压缩文件中的文件路径链表 |
| getComments | 获取压缩文件中的注释链表 |


## <span id="devutilscommonassist">**`dev.utils.common.assist`**</span>


* **均值计算 ( 用以统计平均数 ) 辅助类 ->** [Averager.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/assist/Averager.java)

| 方法 | 注释 |
| :- | :- |
| add | 添加一个数字 |
| clear | 清除全部 |
| size | 获取参与均值计算的数字个数 |
| getAverage | 获取平均数 |
| print | 输出参与均值计算的数字 |


* **时间均值计算辅助类 ->** [TimeAverager.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/assist/TimeAverager.java)

| 方法 | 注释 |
| :- | :- |
| start | 开始计时 ( 毫秒 ) |
| end | 结束计时 ( 毫秒 ) |
| endAndRestart | 结束计时, 并重新启动新的计时 |
| average | 求全部计时均值 |
| print | 输出全部时间值 |
| clear | 清除计时数据 |


* **时间计时辅助类 ->** [TimeCounter.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/assist/TimeCounter.java)

| 方法 | 注释 |
| :- | :- |
| start | 开始计时 ( 毫秒 ) |
| durationRestart | 获取持续的时间并重新启动 ( 毫秒 ) |
| duration | 获取持续的时间 ( 毫秒 ) |
| getStartTime | 获取开始时间 ( 毫秒 ) |


* **堵塞时间辅助类 ->** [TimeKeeper.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/assist/TimeKeeper.java)

| 方法 | 注释 |
| :- | :- |
| waitForEndAsyn | 设置等待一段时间后, 通知方法 ( 异步 ) |
| waitForEnd | 设置等待一段时间后, 通知方法 ( 同步 ) |


## <span id="devutilscommonassistsearch">**`dev.utils.common.assist.search`**</span>


* **文件广度优先搜索算法 ( 多线程 + 队列, 搜索某个目录下的全部文件 ) ->** [FileBreadthFirstSearchUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/assist/search/FileBreadthFirstSearchUtils.java)

| 方法 | 注释 |
| :- | :- |
| setSearchHandler | 设置搜索处理接口 |
| getQueueSameTimeNumber | 获取任务队列同时进行数量 |
| setQueueSameTimeNumber | 任务队列同时进行数量 |
| isRunning | 是否搜索中 |
| stop | 停止搜索 |
| isStop | 是否停止搜索 |
| getStartTime | 获取开始搜索时间 ( 毫秒 ) |
| getEndTime | 获取结束搜索时间 ( 毫秒 ) |
| getDelayTime | 获取延迟校验时间 ( 毫秒 ) |
| setDelayTime | 设置延迟校验时间 ( 毫秒 ) |
| query | 搜索目录 |


* **文件深度优先搜索算法 ( 递归搜索某个目录下的全部文件 ) ->** [FileDepthFirstSearchUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/assist/search/FileDepthFirstSearchUtils.java)

| 方法 | 注释 |
| :- | :- |
| setSearchHandler | 设置搜索处理接口 |
| isRunning | 是否搜索中 |
| stop | 停止搜索 |
| isStop | 是否停止搜索 |
| getStartTime | 获取开始搜索时间 ( 毫秒 ) |
| getEndTime | 获取结束搜索时间 ( 毫秒 ) |
| query | 搜索目录 |


## <span id="devutilscommoncipher">**`dev.utils.common.cipher`**</span>


* **Base64 工具类 ->** [Base64.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/cipher/Base64.java)

| 方法 | 注释 |
| :- | :- |
| decode | Decode the Base64-encoded data in input and return the data in |
| encodeToString | Base64-encode the given data and return a newly allocated |
| encode | Base64-encode the given data and return a newly allocated |


* **Base64 编解码 ( 并进行 ) 加解密 ->** [Base64Cipher.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/cipher/Base64Cipher.java)

| 方法 | 注释 |
| :- | :- |
| decrypt | 解码 |
| encrypt | 编码 |


* **加密工具类 ->** [CipherUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/cipher/CipherUtils.java)

| 方法 | 注释 |
| :- | :- |
| encrypt | 加密方法 |
| decrypt | 解密方法 |


## <span id="devutilscommonencrypt">**`dev.utils.common.encrypt`**</span>


* **AES 对称加密工具类 ->** [AESUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/AESUtils.java)

| 方法 | 注释 |
| :- | :- |
| initKey | 生成密钥 |
| encrypt | AES 加密 |
| decrypt | AES 解密 |


* **CRC 工具类 ->** [CRCUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/CRCUtils.java)

| 方法 | 注释 |
| :- | :- |
| getCRC32 | 获取 CRC32 值 |
| getCRC32ToHexString | 获取 CRC32 值 |
| getFileCRC32 | 获取文件 CRC32 值 |


* **DES 对称加密工具类 ->** [DESUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/DESUtils.java)

| 方法 | 注释 |
| :- | :- |
| getDESKey | 获取可逆算法 DES 的密钥 |
| encrypt | DES 加密 |
| decrypt | DES 解密 |


* **加解密通用工具类 ->** [EncryptUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/EncryptUtils.java)

| 方法 | 注释 |
| :- | :- |
| encryptMD2 | MD2 加密 |
| encryptMD2ToHexString | MD2 加密 |
| encryptMD5 | MD5 加密 |
| encryptMD5ToHexString | MD5 加密 |
| encryptMD5File | 获取文件 MD5 值 |
| encryptMD5FileToHexString | 获取文件 MD5 值 |
| encryptSHA1 | SHA1 加密 |
| encryptSHA1ToHexString | SHA1 加密 |
| encryptSHA224 | SHA224 加密 |
| encryptSHA224ToHexString | SHA224 加密 |
| encryptSHA256 | SHA256 加密 |
| encryptSHA256ToHexString | SHA256 加密 |
| encryptSHA384 | SHA384 加密 |
| encryptSHA384ToHexString | SHA384 加密 |
| encryptSHA512 | SHA512 加密 |
| encryptSHA512ToHexString | SHA512 加密 |
| encryptHmacMD5 | HmacMD5 加密 |
| encryptHmacMD5ToHexString | HmacMD5 加密 |
| encryptHmacSHA1 | HmacSHA1 加密 |
| encryptHmacSHA1ToHexString | HmacSHA1 加密 |
| encryptHmacSHA224 | HmacSHA224 加密 |
| encryptHmacSHA224ToHexString | HmacSHA224 加密 |
| encryptHmacSHA256 | HmacSHA256 加密 |
| encryptHmacSHA256ToHexString | HmacSHA256 加密 |
| encryptHmacSHA384 | HmacSHA384 加密 |
| encryptHmacSHA384ToHexString | HmacSHA384 加密 |
| encryptHmacSHA512 | HmacSHA512 加密 |
| encryptHmacSHA512ToHexString | HmacSHA512 加密 |
| encryptDES | DES 加密 |
| encryptDESToBase64 | DES 加密 |
| encryptDESToHexString | DES 加密 |
| decryptDES | DES 解密 |
| decryptDESToBase64 | DES 解密 |
| decryptDESToHexString | DES 解密 |
| encrypt3DES | 3DES 加密 |
| encrypt3DESToBase64 | 3DES 加密 |
| encrypt3DESToHexString | 3DES 加密 |
| decrypt3DES | 3DES 解密 |
| decrypt3DESToBase64 | 3DES 解密 |
| decrypt3DESToHexString | 3DES 解密 |
| encryptAES | AES 加密 |
| encryptAESToBase64 | AES 加密 |
| encryptAESToHexString | AES 加密 |
| decryptAES | AES 解密 |
| decryptAESToBase64 | AES 解密 |
| decryptAESToHexString | AES 解密 |
| encryptRSA | RSA 加密 |
| encryptRSAToBase64 | RSA 加密 |
| encryptRSAToHexString | RSA 加密 |
| decryptRSA | RSA 解密 |
| decryptRSAToBase64 | RSA 解密 |
| decryptRSAToHexString | RSA 解密 |


* **字符串 ( 编解码 ) 工具类 ->** [EscapeUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/EscapeUtils.java)

| 方法 | 注释 |
| :- | :- |
| escape | 编码 |
| unescape | 解码 - 本方法不论参数 data 是否经过 escape() 编码, 均能获取正确的 ( 解码 ) 结果 |


* **MD5 加密工具类 ->** [MD5Utils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/MD5Utils.java)

| 方法 | 注释 |
| :- | :- |
| md5 | 加密内容 (32 位小写 MD5) |
| md5Upper | 加密内容 (32 位大写 MD5) |
| getFileMD5 | 获取文件 MD5 值 |
| getFileMD5ToHexString | 获取文件 MD5 值 |


* **SHA 加密工具类 ->** [SHAUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/SHAUtils.java)

| 方法 | 注释 |
| :- | :- |
| sha1 | 加密内容 SHA1 |
| sha224 | 加密内容 SHA224 |
| sha256 | 加密内容 SHA256 |
| sha384 | 加密内容 SHA384 |
| sha512 | 加密内容 SHA512 |
| getFileSHA1 | 获取文件 SHA1 值 |
| getFileSHA256 | 获取文件 SHA256 值 |
| shaHex | 加密内容 SHA 模板 |
| getFileSHA | 获取文件 SHA 值 |


* **3DES 对称加密工具类 ->** [TripleDESUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/TripleDESUtils.java)

| 方法 | 注释 |
| :- | :- |
| initKey | 生成密钥 |
| encrypt | 3DES 加密 |
| decrypt | 3DES 解密 |


* **异或 ( 加密 ) 工具类 ->** [XorUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/encrypt/XorUtils.java)

| 方法 | 注释 |
| :- | :- |
| encryptAsFix | 加解密 ( 固定 Key 方式 ) 这种方式 加解密 方法共用 |
| encrypt | 加密 ( 非固定 Key 方式 ) |
| decrypt | 解密 ( 非固定 Key 方式 ) |


## <span id="devutilscommonrandom">**`dev.utils.common.random`**</span>


* **随机概率采样算法 ->** [AliasMethod.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/random/AliasMethod.java)

| 方法 | 注释 |
| :- | :- |
| next | 获取随机索引 ( 对应几率索引 ) |


## <span id="devutilscommonthread">**`dev.utils.common.thread`**</span>


* **线程池管理工具类 ->** [DevThreadManager.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/thread/DevThreadManager.java)

| 方法 | 注释 |
| :- | :- |
| getInstance | 获取 DevThreadManager 实例 |
| initConfig | 初始化配置信息 |
| putConfig | 添加配置信息 |
| removeConfig | 移除配置信息 |


* **线程池 ( 构建类 ) ->** [DevThreadPool.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/thread/DevThreadPool.java)

| 方法 | 注释 |
| :- | :- |
| getThreads | 获取线程数 |
| getCalcThreads | 获取线程数 |
| execute | 加入到线程池任务队列 |
| shutdown | shutdown 会等待所有提交的任务执行完成, 不管是正在执行还是保存在任务队列中的已提交任务 |
| shutdownNow | shutdownNow 会尝试中断正在执行的任务 ( 其主要是中断一些指定方法如 sleep 方法 ), 并且停止执行等待队列中提交的任务 |
| isShutdown | 判断线程池是否已关闭 - isShutDown 当调用 shutdown() 方法后返回为 true |
| isTerminated | 若关闭后所有任务都已完成, 则返回 true |
| awaitTermination | 请求关闭、发生超时或者当前线程中断 |
| submit | 提交一个 Callable 任务用于执行 |
| invokeAll | 执行给定的任务 |
| invokeAny | 执行给定的任务 |
| schedule | 延迟执行 Runnable 命令 |
| scheduleWithFixedRate | 延迟并循环执行命令 |
| scheduleWithFixedDelay | 延迟并以固定休息时间循环执行命令 |


## <span id="devutilscommonvalidator">**`dev.utils.common.validator`**</span>


* **银行卡管理工具类 ->** [BankCheckUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/validator/BankCheckUtils.java)

| 方法 | 注释 |
| :- | :- |
| checkBankCard | 校验银行卡卡号是否合法 |
| getBankCardCheckCode | 从不含校验位的银行卡卡号采用 Luhm 校验算法获取校验位 |
| getNameOfBank | 通过银行卡的 前六位确定 判断银行开户行及卡种 |


* **居民身份证工具类 ->** [IDCardUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/validator/IDCardUtils.java)

| 方法 | 注释 |
| :- | :- |
| validateIdCard15 | 身份证校验规则, 验证 15 位身份编码是否合法 |
| validateIdCard18 | 身份证校验规则, 验证 18 位身份编码是否合法 |
| convert15CardTo18 | 将 15 位身份证号码转换为 18 位 |
| validateTWCard | 验证台湾身份证号码 |
| validateHKCard | 验证香港身份证号码 ( 部份特殊身份证无法检查 ) |
| validateIdCard10 | 判断 10 位数的身份证号, 是否合法 |
| validateCard | 验证身份证是否合法 |
| getAgeByIdCard | 根据身份编号获取年龄 |
| getBirthByIdCard | 根据身份编号获取生日 |
| getBirthdayByIdCard | 根据身份编号获取生日 |
| getYearByIdCard | 根据身份编号获取生日 ( 年份 ) |
| getMonthByIdCard | 根据身份编号获取生日 ( 月份 ) |
| getDateByIdCard | 根据身份编号获取生日 ( 天数 ) |
| getGenderByIdCard | 根据身份编号获取性别 |
| getProvinceByIdCard | 根据身份编号获取户籍省份 |
| getPowerSum | 将身份证的每位和对应位的加权因子相乘之后, 再获取和值 |
| getCheckCode18 | 将 POWER 和值与 11 取模获取余数进行校验码判断 |


* **校验工具类 ->** [ValidatorUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/validator/ValidatorUtils.java)

| 方法 | 注释 |
| :- | :- |
| match | 通用匹配函数 |
| isNumber | 检验数字 |
| isNumberDecimal | 检验数字或包含小数点 |
| isLetter | 判断字符串是不是全是字母 |
| isContainNumber | 判断字符串是不是包含数字 |
| isNumberLetter | 判断字符串是不是只含字母和数字 |
| isSpec | 检验特殊符号 |
| isWx | 检验微信号 |
| isRealName | 检验真实姓名 |
| isNickName | 校验昵称 |
| isUserName | 校验用户名 |
| isPassword | 校验密码 |
| isEmail | 校验邮箱 |
| isUrl | 校验 URL |
| isIPAddress | 校验 IP 地址 |
| isChinese | 校验汉字 ( 无符号, 纯汉字 ) |
| isChineseAll | 判断字符串是不是全是中文 |
| isContainChinese | 判断字符串中包含中文、包括中文字符标点等 |


* **检验联系 ( 手机号, 座机 ) 工具类 ->** [ValiToPhoneUtils.java](https://github.com/afkT/DevUtils/blob/master/lib/DevJava/src/main/java/dev/utils/common/validator/ValiToPhoneUtils.java)

| 方法 | 注释 |
| :- | :- |
| isPhoneCheck | 中国手机号格式验证, 在输入可以调用该方法, 点击发送验证码, 使用 isPhone |
| isPhone | 是否中国手机号 |
| isPhoneToChinaTelecom | 是否中国电信手机号码 |
| isPhoneToChinaUnicom | 是否中国联通手机号码 |
| isPhoneToChinaMobile | 是否中国移动手机号码 |
| isPhoneToHkMobile | 判断是否香港手机号 |
| isPhoneCallNum | 验证电话号码的格式 |