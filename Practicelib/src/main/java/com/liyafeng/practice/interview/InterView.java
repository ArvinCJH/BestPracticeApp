package com.liyafeng.practice.interview;

/**
 * Created by liyafeng on 2018/2/23.
 */

public class InterView {

    /**
     * 面试
     * ======================
     * （hr电话询问基本情况）
     * -------现场----------
     * 自我介绍
     * 知识点问答
     * 项目介绍
     * boss问答
     * hr问答
     * =======================
     * 1.解决问题的能力：问一些没有接触过的难题，看你给出的解决方案
     * <p>
     * 2.考察沟通能力，就是你能不能听懂面试官的问题，还有你的态度，和你表达的要让面试官听懂
     * 这点可以在介绍项目，和自我介绍的时候考察，
     * 或者问一些需求不是很明确的问题，这时你需要
     * 和面试官沟通，你向他提问，这样有利于在需求不明确的时候能及时理解需求
     * <p>
     * 3.学习能力，这点考察一般会问你：
     * <p>
     * 4.知识迁移能力（举一反三问题）：
     * 抛出一个新概念，能否用现有的方法类比解决
     * 其实就是出一个全新的问题，但他可以用旧的问题的解决方法改变一下就能解决
     * <p>
     * -------------------------
     * 你的表达要有条理，列出一二三，表述要清晰，不要忽略前提条件
     * 表述要详略得当，突出重点
     * <p>
     * ============================================
     * 1.面试官关心你问的问题，这样能体现出你是一个什么样的人
     * 比如你问薪资，那说明这个人只在乎薪资，很容易跳槽
     * 所以正确的一般是问现在的团队情况，和项目情况
     * <p>
     * 2.写代码的习惯，如果不注重健壮性，那么会认为你做的项目不够稳定
     * 那么你是一个不靠谱的人。所以手写代码要考虑健壮性
     * <p>
     * 3.问你一道题，条件模糊，你询问条件是什么？然后会问你如果是这个条件会怎么样？
     * 然后你说答案，然后说如果是另个条件呢？
     * <p>
     * ===========================================
     * 原理考察深入
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    //region 项目经历 考察

    /**
     * 介绍一下你最近的项目？
     * 介绍一下你印象最深的项目？
     * 里面用到比较深的技术是什么？
     * 你项目中有什么难点？
     * 里面使用了哪些框架？为什么使用它？它的原理是什么？
     * 如何避免因为引入开源库而导致的安全性和稳定性问题？
     * 里面使用了哪些自定义控件？如何实现的？
     * 你在项目中有做出什么突出的贡献吗？你是如何实现的？（比如速度快了，内存消耗低了，crash率低了，开发效率高了）
     * 你在项目中遇到最大的困难有哪些？你是如何解决的？
     * 你在项目中遇到最难解的bug有哪些？你是如何解决的？
     *
     *
     *
     */
    public void a1() {
        /*
        * ==============介绍一下你最近的项目？=====================
        * =================介绍一下你印象最深的项目？=================
        *
        * ===================项目里用到比较深的技术是什么？================
        * 热修复技术，（插件化、视频编解码播放、推送、即时通信、组件化, JNI）
        *
        * ===============你项目中有什么难点？=====================
        * 问题的目的是面试官想深入了解你的项目，需要你说出你做过项目中的亮点，是用来证明你的经历和能力
        * 实际上这个和项目用到比较深的技术是一个意思
        * ----------------------
        * 实现项目组件化是个难点，难在如何灵活的拆分各个组件，使得他们能够在开发的时候能独立编译成apk进行调试
        * 还有解决各个组件之间通信的问题，比如这个组件要启动另一个组件的页面，获取另一个组件的对象。
        * 经过调研和研究，
        * ++++++++++++++++++++++++++++++++++
        * 进程保活
        *
        * =====================你在项目中遇到最大的困难有哪些？你是如何解决的？=================
        * 说个常见的模块，做通讯录好友匹配模块的时候。我们要监听通信新添加和删除的联系人，及时的在app中显示有新的联系人好友了
        * ，难点在于如何判断新的联系人是app好友，如何判断新注册的用户在联系人中显示为“可以添加好友”，
        * 开始的逻辑是每次读取所有联系，上传服务器，服务器返回可添加好友的联系人。
        * 但是这样的做法给服务器带来很大压力，因为每次都要全量上传，而且服务端判断速度很慢，后来服务端使用MemoryCache，
        * 速度快很多，但是还是会导致服务端的计算压力。
        *
        * 后来是在app本地建表，读取所有联系人保存到本地，每次还是读取所有联系人，然后读取的和本地的比较，判断哪些删除，哪些
        * 新增加，然后把只把新增加的传给服务端，然后如果这个时候有联系人中新注册的用户，那么新注册的用户也会返回。
        * 而且标记时间戳，每次app携带时间戳请求，在这个时间点之后注册的新用户才返回。
        *
        * 这样几本功能实现差不多，但是有一个问题是比较新旧联系人集合非常耗时，因为要一一比较是否是新增或者删除
        * 比如原来有1000个联系人，后来变成1001个，找出多的那一个（又可以还是删除了一个新增了两个），就要比较100w次
        * 时间复杂度是n^2，是平方级别的
        * 所以后来改变了数据结构，使用hashmap来存储联系人。找出删除和新增的联系人复杂度就变成n了。是线性级别的
        *
        * ======================你在项目中遇到最难解的bug有哪些？你是如何解决的？=====================
        *
        *
        *
        * =============里面使用了哪些框架？为什么使用它？它的原理是什么？=======
        * 事件总线：EventBus
        * 响应式框架 RxJava
        * 网络框架：volley ,retrofit+okhttp
        * 图片框架，Picasso ，Glide ,Fresco
        * ORM框架 greenDao
        * 插件化框架：virtual-apk
        * 热修复框架：tinker
        * 组件化框架 ARouter
        * 依赖注入框架 ButterKnife ，Dagger2
        * 内存泄漏检测框架 LeakCanary
        * bug收集上报框架 bugTags
        * 架构框架 dataBinding  Android-Architecture-Component
        *
        * ===================如何避免因为引入开源库而导致的安全性和稳定性问题？================
        * 没安全性问题，选知名的框架，且在维护的。或者自己拿到源码自己改
        *
        * ==================里面使用了哪些自定义控件？如何实现的？=========================
        * 自定义图表，支持惯性滑动，缩放，数据点击监听，
        * ===================你在项目中有做出什么突出的贡献吗？你是如何实现的？
        * 1，减少卡顿，用android monitor的cpu模块检测方法的耗时时间，对耗时方法进行改进
        * 比如使用享元模式对对象进行复用，减少对象的创建时间
        * 改变算法或者数据结构减少数据查找时间，比如使用散列表
        * 2.开发效率提高，采用了组件化的开发，视频模块和主模块分离，减少了开发时的编译时间
        *   减少主工程代码的入侵，减少代码冲突
        *
        * 3.减少内存使用率，使用Android Monitor或者Profiler，的memory模块来进行内存使用分析
        * 定位到申请内存多的方法，进行针对优化，比如懒加载，对象池复用，使用基本数据类型替换
        * 类类型，使用MAT或者LeakCanary来检测内存泄漏。 优化图片加载，根据ImageView大小
        * 对图片进行缩放，减少图片的内存占用
        *
        * 4.搭建早期的bug统计模块，利用UnCaughtExceptionHandler,来将异常保存到本地，然后上传到服务器
        * 后面引进了第三方bug统计上报框架bugtags，减少了crash，更能及时修复bug
        *
        *
        *
        */
    }


    //endregion

    //region 个人成长能力 考察

    /**
     * 对业内信息的关注（获取）渠道有哪些？
     * 如何学习新知识的？
     * 经常浏览哪些技术网站/博客/公众号/大牛的文章？
     * 看IO大会吗？这届io上有什么新特性发布？
     * 看技术书籍吗？最近都看了哪些书？
     * 有开源项目吗？为什么要做这个？如何实现的？
     * 自己最擅长的技术？如何证明你擅长？
     * 说一件最能证明你能力的事？
     * 你做过的哪件事最令自己感到骄傲？
     * 说一说你最擅长的领域？除了android还有什么擅长的吗？
     * 在上一家公司工作期间，你最大的收获是什么？
     * 针对这个职位，你认为你现在还欠缺什么？
     * 面对一个问题，说说你是如何找到解决方法的？
     * 你的职业规划是什么？
     * 评价一下自己的技术水平，代码质量如何？
     * 说说你对行业、技术发展趋势的看法？
     * 工作过程中周围同事/同学有哪些值得学习的地方？
     */
    public void a2() {
        /*
        *
        */
    }
    //endregion


    //region 个人性格 考察

    /**
     * 你之前离职的原因是什么？
     * 说一说你印象最深的一件事？
     * 与上级意见不一致，你怎么办？
     * 自己的优缺点是什么？举例说说？
     * 如果录取了你，工作一段时间发现这个职位不适合你怎么办？
     * 如果没录取你，你有什么打算？
     * 都投了哪些公司？有哪些offer?如果我们同时录取你如何选择？
     * 你有哪些业余爱好？
     * 假如你晚上要去送一个出国的同学去机场，可单位临时有事非你办不可，你怎么办？
     * 你对一份工作更看重哪些方面？平台，技术，氛围，城市，还是money？
     * 理想薪资范围？
     * 理想中的工作环境是什么？
     * 谈谈你对跳槽的看法？
     * 如果你的工作出现失误，给本公司造成经济损失，你认为该怎么办？
     * 若上司在公开会议上误会你了，该如何解决？
     * 你看中公司的什么？或者公司的那些方面最吸引你？
     */
    public void a3() {
        /*
        *
        */
    }
    //endregion
}
