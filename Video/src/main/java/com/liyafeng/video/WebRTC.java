package com.liyafeng.video;

public class WebRTC {

    /**
     *
     * =====================介绍===================
     * WebRTC，名称源自网页即时通信（英语：Web Real-Time Communication）的缩写
     *      * 是一个支持网页浏览器进行实时语音对话或视频对话的API。
     *      * 它于2011年6月1日开源并在Google、Mozilla、Opera支持下被纳入万维网联盟的W3C推荐标准[2][3][4]。
     *      * 2010年5月，Google以6820万美元收购VoIP软件开发商Global IP Solutions的GIPS引擎[17][18][19]，并改为名为“WebRTC”
     *      * WebRTC使用GIPS引擎，实现了基于网页的视频会议，并支持722，PCM，ILBC，ISAC等编码，
     *      * 同时使用谷歌自家的VP8影片解码器；同时支持RTP/SRTP传输等
     *      * 2012年1月，谷歌已经把这款软件集成到Chrome浏览器中。
     *
     *
     * ================实现多人音视频通话==========
     * https://www.agora.io/cn/blog/%E5%9F%BA%E4%BA%8Ewebrtc%E6%8A%80%E6%9C%AF%E7%9A%84%E5%A4%9A%E4%BA%BA%E9%9F%B3%E8%A7%86%E9%A2%91%E8%A7%A3%E5%86%B3%E6%96%B9%E6%A1%88/
     * （声网基于webrtc的多人音视频通话解决方案）
     * 它是基于p2p(点对点)的交换音视频媒体流，和数据流的技术
     * 要实现多对多就有难度
     * 1.网状模型（P2P模式），两两连接，浪费上行带宽
     * 2.混流或者转发模型（服务器模式）（将不同的帧标记id，一起通过一个通道发送给客户端，客户端通过id进行分帧）
     * 第二种模型不是webrtc的原生实现，需要我们自己服务端进行实现
     * ==============原生的webrtc服务器模型====================
     * http://www.52im.net/thread-356-1-1.html
     * 三部分：
     *   信令服务器（（Signaling Server））
     *   TURN和STUN服务器：
     * 媒体服务器（房间服务器（Room Server））：
     *
     * Google webrtc的服务器Demo：详见https://github.com/webrtc/apprtc
     *
     * ================webrtc服务端（多人的）实现原理==============
     * 大家都知道WebRTC的服务器模型有两种，
     * 分别是MCU(Multipoint Control Unit 多点控制单元)和SFU(Selective Forwarding Unit 选择方向单元)两种
     * 这两个是模型，模型定义了功能有哪些，可以有很多不同逻辑细节的实现，但提供的主要功能都是一样的
     * 我们说某某开源系统只支持SFU，只是说他实现了这个功能
     * SFU实现的是简单转发的路由功能，而MCU可以提供更多扩展性的功能实现，
     * 而且MCU型的服务器往往包含SFU，所以MCU的实现难度较大
     *
     * MCU :对接收到的多路流进行 转码 和混合，输出为1路流，从而节省下行带宽
     *      还能够对不同网络条件的用户，订制不同码率的输出视频流，让多人场景有更好的用户体验
     *      还可以对视频流进行视频分析，做人脸检测和前景识别等，实现比较炫酷的功能
     *
     * SFU:（相当于转发路由）转发各路媒体流，典型的应用场景是1对多的直播服务，
     *      SFU从发布客户端复制音视频流的信息，然后分发到多个订阅客户端
     *
     * --------------------开源的webrtc服务器(多人的)----------------------
     * 目前在开源社区有免费的WebRTC 服务器实现，比较著名的有Licode和Kurento，
     * 使用它们可以很方便的进行服务部署并且实现多人的音视频互通功能
     *
     * ---------------------webrtc原理---------------------
     * https://blog.csdn.net/foruok/article/details/53005728 （webrtc资料大全）
     * https://hpbn.co/webrtc/ （翻墙）
     * http://luoxia.me/code/2017/01/23/WebRTC%E9%80%9A%E4%BF%A1%E5%88%9D%E6%8E%A2/（WebRTC通信初探）
     *
     * WebRTC 音频编解码是OPUS，视频编解码是VP8编解码器
     * WebRTC的传输协议是RTP/RTCP
     * 整个WebRTC通信是基于UDP的
     *
     * 他其实用到了很多协议
     * （https://developer.mozilla.org/en-US/docs/Web/API/WebRTC_API/Protocols）
     *
     *
     * 大家都知道现今直播的发展要得益于CDN分发体系，CDN主要通过RTMP协议进行传输，
     * 而WebRTC的传输协议是RTP/RTCP，所以如果我们需要使用CDN网络进行分发，
     * 就需要在服务器中将RTP/RTCP转成RTMP。在WebRTC中，编码格式是OPUS，
     * 而RTMP协议对应的编解码格式一般是AAC，通常这两种编码格式之间的转换也是非常现实的需求。
     * 同时，在MCU模型中，我们还可以在服务器中增加录制、混流的功能，在直播连麦的情况下，
     * 通过混流的方式可以大大减少下行的带宽。
     *
     * 除了实现以上功能外，由于如今的直播中美颜、滤镜几乎成为了标配，所以实现这种附加功能也是市场普遍的需求。
     * 虽然在WebRTC中并没有提供实现美颜、滤镜的接口，但是我们可以在服务器端实现类似的附加功能。
     * 根据实际的业务需求，通过MCU多点控制单元，可以实现这类附加功能。
     *
     * =================连麦和观众观看==========================
     * 互动直播由连麦互动和直播两部分组成，其中连麦互动基于音视频通话实现，
     * 可以实现1个主播+3个连麦者的音视频通话连麦（基于私有协议实现）。
     *
     * 主播和连麦者的音视频数据在互动直播高性能服务器合成为一道流后推流到CDN流媒体服务器，
     * 普通观众拉流观看即可（RTMP推流协议）。
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     *
     */
    public void f1(){

    }
}
