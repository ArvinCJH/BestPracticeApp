package com.liyafeng.view.match;

import android.app.Activity;
import android.os.Bundle;

import com.liyafeng.view.R;

public class MatchActivity extends Activity {

    /**
     *
     * dip        ： Density independent pixels ，设备无关像素。
     * dp        ：就是dip
     * px        ： 像素
     * dpi       ：dots per inch ， 直接来说就是一英寸多少个像素点。常见取值 120，160，240。我一般称作像素密度，简称密度
     * density ： 直接翻译的话貌似叫 密度。常见取值 1.5 ， 1.0 。和标准dpi的比例（160px/inc）
     * 分辨率   ： 横纵2个方向的像素点的数量，常见取值 480X800 ，320X480
     * 屏幕尺寸： 屏幕对角线的长度。1英寸=2.54cm
     * 电脑电视同理。屏幕比例的问题。因为只确定了对角线长，2边长度还不一定。所以有了4：3、16：9这种，这样就可以算出屏幕边长了。
     *
     *
     *
     * =================屏幕适配========================
     *
     * https://developer.android.google.cn/training/multiscreen/screendensities.html
     * https://www.jianshu.com/p/ec5a1a30694b （适配方案）
     * https://www.jianshu.com/p/220404575079 （Android设备兼容处理（二）：屏幕适配）
     * https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA 头条适配方案
     *
     * <p>
     * dpi dots per inch 每英寸的像素点个数 ，一定程度上代表屏幕的大小（屏幕密度）
     * <p>
     * dip 独立像素密度  pixel
     * <p>
     * 标准的是 在dpi为160 的设备上 1px = 1dp ，这个160是认为定义
     * <p>
     * mdpi-160-1  ldpi-120-0.75  hdpi-240-1.5 xhdpi-320-2 xxhdpi- 480-3
     * <p>
     * <p>
     * px = dp * (dpi /160)
     * <p>
     * <p>
     * <p>
     * 一般设计师根据某个分辨率设计出来后，有专门的单位转换工具，比如标你妹
     * 上面可以生成其他 dpi的dp值，我们依照写即可
     * <p>
     * 这个是按每英寸的像素来定义的，但是dpi相同分辨率也可能不同
     * 所以需要单独的 values-xxx适配
     * <p>
     * RelativeLayout + 多文件夹的 dp
     * <p>
     * LinearLayout 的权重
     * <p>
     * <p>
     * <p>
     * 代码动态计算宽高
     * <p>
     * 针对特殊value-xx重写布局
     * <p>
     * 对照生成指定的像素转换文件（鸿翔）
     * <p>
     * ==========为什么标准dpi是160dpi （160像素/英寸）======
     * 1 （1）Android Design [1] 里把主流设备的 dpi 归成了四个档次，120 dpi、160 dpi、240 dpi、320 dpi
     *  160 好换算
     * 2.（2）这个在Google的官方文档中有给出了解释，因为第一款Android设备（HTC的T-Mobile G1）是属于160dpi的。
     *
     *
     * ==========================mipmap===================
     * https://developer.android.google.cn/guide/topics/resources/providing-resources.html（官方的目录介绍）
     * mipmap在图片缩放上会有优化，但是在同等dpi的设备上，图片不缩放，那么和drawable是一样的效果
     * 所以mipmap用来存放app的启动图片。原来的图片还是放在drawable下
     * <p>
     * <p>
     *
     * <p>
     * <p>
     * <p>
     * ==================icon========
     * 放在mipmap-*dpi下，文件名为ic_launcher.png
     * <p>
     * LDPI (Low Density Screen，120 DPI)，其图标大小为 36 x 36 px。
     * MDPI (Medium Density Screen, 160 DPI)，其图标大小为 48 x 48 px。
     * HDPI (High Density Screen, 240 DPI)，其图标大小为 72 x 72 px。
     * xhdpi (Extra-high density screen, 320 DPI)，其图标大小为 96 x 96 px。
     * xxhdpi（xx-high density screen, 480 DPI）,其图标大小为144 x 144 px。
     * xxxhdpi（xxx-high density screen, 640 DPI）,其图标大小为192 x 192 px。
     *
     *
     * ===============分辨率对应dpi=========
     * https://blog.csdn.net/u012741741/article/details/51075518
     * 宽×高(标准值)	240×320	320×480	480×800	720×1280	1080×1920	1440×2560
     * DPI等级	    LDPI	MDPI	HDPI	XHDPI	    XXHDPI	    XXXHDPI
     * DPI数值	    120	    160	    240	    320	        480	        640
     * 对应比例	    3	    4	    6	    8	        12	        16
     * 1DP=？PX	    0.75	1	    1.5	    2	        3	        4
     * sw(Smallest-width)   320dp   320dp   360dp       360dp       360dp
     *
     * context.getResources().getDisplayMetrics().density
     * 在160dpi的屏幕上，density = 1  dpi的缩放因子  320dpi就是 density = 2
     *
     * context.getResources().getDisplayMetrics().densityDpi
     * 每英寸的像素点数，屏幕密度的另一种表示。densityDpi = density * 160
     *
     *
     * dpi是个范围不是特定的数值，比如440dpi和500dpi都会划分到xxhdpi
     *
     * android中的 2k屏就是宽度像素为1440？？
     *
     * 720P是一种在逐行扫描下达到1280×720的分辨率的显示格式。
     *
     * 720P是美国电影电视工程师协会(SMPTE)制定的高等级高清数字电视的格式标准，
     * 有效显示格式为：1280×720.SMPTE
     * (美国电影电视工程协会)将数字高清信号数字电视扫描线的不同分为1080p、1080i、720P(i是interlace,隔行的意思，p是Progressive,逐行的意思)。
     *
     * 720指的是屏幕的宽度
     *
     * 由于构成数字图像的像素数量巨大，通常以K来表示210即1024，因此：1K=2^10=1024，2K=2^11=2048，4K=2^12=4096。
     *
     *
     *
     * 一般手机的宽度不变，高度可以变，所以根据手机宽度能确定他是哪个 dpi
     *
     * =========RelativeLayout====
     * 如果里面的控件是 imageview或者textview,是warp_content 这个时候如果外部指定的高度小了
     * 里面会压缩
     *
     * =========layout适配===========================
     * res文件下资源文件夹的命名规则
     *      * https://developer.android.google.cn/guide/topics/resources/providing-resources.html
     *
     * res/layout-sw480dp的意思，sw的意思是smallest width最小宽度，
     *  设备的 smallestWidth 是屏幕可用高度和宽度的最小尺寸（您也可以将其视为屏幕的“最小可能宽度”）
     *  应用为多个资源目录提供不同的 smallestWidth 限定符值时，系统会使用最接近（但未超出）设备 smallestWidth 的值。
     *
     *
     * 5.0英寸1080P（1080x1920）的手机屏幕宽度就是1080/(440/160) = 392dp
     *
     * layout-sw480dp-land/
     *
     *
     * 限定符命名规则:
     * 您可以为单组资源指定多个限定符，并使用短划线分隔。例如，drawable-en-rUS-land 适用于横排美国英语设备
     * 这些限定符必须遵循表 2 中列出的顺序。例如：
     * 错误：drawable-hdpi-port/
     * 正确：drawable-port-hdpi/
     *
     *
     * 将备用资源保存到以这些限定符命名的目录中之后，Android 会根据当前设备配置在应用中自动应用这些资源。
     * 每次请求资源时，Android 都会检查备用资源目录是否包含所请求的资源文件，然后查找最佳匹配资源（下文进行介绍）。
     * 如果没有与特定设备配置匹配的备用资源，则 Android 会使用相应的默认资源（一组用于不含配置限定符的特定资源类型的资源）
     *
     * large限定符是 Android3.2 以前的版本
     * sw 限定符是 3.2后的版本
     * a. 版本低于 3.2 的平板会匹配 large的文件
     * b. 版本高于 3.2 的平板会匹配 sw600dp的文件
     *
     * =============平板适配===============
     * 如下文，很显然，平板的smallest-width 都是600dp以上
     * 而手机的sw是320dp或者360dp
     * 所以我们能根据这个来确定哪个是平板，哪个是手机
     *
     *
     *
     *
     *
     * =========1080像素===============
     * https://www.zhihu.com/question/20440405
     *
     * 比如有 1080*1920 （4.95英寸）的手机，和vivo nex 是 1080*2316（6.59英寸）
     *
     * 横屏情况下，他们的高度是一样的，只不过（4.95英寸）的手机屏幕窄，只是显示的内容少了
     * 如果是基于 alignParentRight 的布局那么也会相应缩短，（如果是横向listview那么只是显示内容少了）
     * 如果宽高给指定数值都是100dp，那么这个方块在两款手机上的大小是一样的
     * 但这样，横向占据的屏幕比例就不一样了
     *
     * 16/9=1.77777
     * 4/3 = 1.33333
     *
     * Android主流的手机 都是1080p，只不过长度会长，
     * 华为p20 ：2244x1080 5.8英寸,
     * vivo nex 2316*1080 6.59英寸
     * 小米mix2 2160*1080 5.99英寸
     * OPPO R17 2340x1080 6.4英寸,
     * 小米9    2340x1080 6.39英寸,
     * 荣耀V20  2310x1080 6.4英寸,
     * 一加6T   2340x1080 6.41英寸,
     * 魅族16th 2160x1080 6英寸,
     * 小米Max3 2160x1080 6.9英寸
     * 红米Note7 2340x1080 6.3英寸
     *
     * 华为P30        2880x1440 6英寸, 2:1
     * 华为Mate20Pro  3120×1440 6.39英寸
     * 三星Note9      2960x1440  6.4英寸
     * 三星Galaxy S10  3040x1440 6.1英寸,
     *
     * =========平板 ===============
     * 华为的平板就三个尺寸
     * 1280x800（HDPI）    这个对应的手机的是 480×800  缩放因子1.3312501
     * 1920x1200（XHDPI）  这个对应的手机的是 720×1280  缩放因子2.0
     * 2560x1600（XXHDPI） 这个对应的手机的是 1080×1920  缩放因子3.0
     * 这个屏幕扩大的1.333倍 ，而缩放因子却扩大了1.5倍，所以同样的10dp，在2560x1600的屏幕上显示要大1.125倍
     * （如果这两个分辨率的屏幕在物理上一样大）
     *
     * 所以 1920x1200 的中点位置是 1920/2=960px =480dp
     *     2560x1600 的中点是    2560/2 = 1280px = 426.66dp
     *
     * 480dp/426.66dp = 1.125 ( 3/2/(4/3)=1.125 )
     *
     * 这三个的比例一致都是1.6
     * 1920x1200 => 2560x1600 大了 4/3=1.33 倍 而缩放因子大了1.5倍
     *
     * 1280x800 => 1920x1200 大了 1.5倍 ，而缩放因子大了 1.50倍
     *
     * 所以10dp宽度在 1280x800  1920x1200 大小是一样的，所以只需要一套dp即可
     *
     * 1920x1200 => 2560x1600 在前者的10dp,后者就需要写 10dp/1.125 = 8.8888dp
     * 所以在这两个屏幕上 一个写10dp 一个写8.88dp ，两者在屏幕上的占比是一样的
     *
     *
     *
     * ==================主流平板=================
     * 主流的平板都是上面的尺寸
     * 还有             1024*768 2048x1536 这种尺寸就是模仿 ipad  4/3 = 1.33
     * 三星、神州都有这种尺寸的平板
     *
     * 所以Android pad会长点
     *
     * 华为平板 M5 青春版
     * 1920x1200 10.1英寸
     *
     * 华为平板 M5 8.4英寸
     * 2560x1600
     *
     * 荣耀畅玩平板2（9.6英寸）
     * 1280x800
     *
     *
     * mi pad 4   8英寸
     * 1920*1200
     *
     *
     * 小米平板1-3 7.9英寸 （停产）
     * 2048x1536
     *
     *
     * 三星Galaxy Tab S5e 10.5英寸
     * 2560x1600
     *
     *
     * 华硕ZenPad 3S 10（Z500M/64GB） 9.7英寸
     * 2048x1536
     *
     *
     * ==========2018.1月市售手机分辨率=============
     * 安卓：
     * 2560 x 1440
     * 1920 x 1080
     * 1280 x 720
     *
     *
     * =========适配总结================
     * 使用"wrap_content"、"match_parent"和"weight“来控制视图组件的宽度和高度
     * 使用ConstantLayout 适配
     *
     *
     *
     *
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
    }
}
