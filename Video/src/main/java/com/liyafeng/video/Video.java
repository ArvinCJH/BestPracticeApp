package com.liyafeng.video;

public class Video {


    /**
     * 视频入门指南
     * https://zhuanlan.zhihu.com/p/28518637 （七牛音视频架构师）
     * ===================3gp================
     * 3GP是一种多媒体单元格式，由Third Generation Partnership Project（3GPP）定义，主要用于3G手机上。
     * 3GP是 MPEG-4 第12部分，又被称为MPEG-4/JPEG2000基本媒体文件格式
     * 3GP是MPEG-4 Part 14（MP4）的一种简化版本，减少了存储空间和较低的带宽需求，
     * 让手机上有限的存储空间可以使用。
     * 3GP文件视频的部分可以用MPEG-4 Part 2、H.263或MPEG-4 Part 10 (AVC/H.264)等格式来存储，
     * 声音的部分则支持AMR-NB、AMR-WB、AMR-WB+、AAC-LC或HE-AAC来当作声音的编码。
     *
     * --------------------------
     * 3gp是一种容器，除了头部的视频信息外，还包括编码后的视频信息，而且支持多种编码方式
     * 很显然头部信息包含了编码方式。而且播放器的原理都是一样的，取出文件的头部信息
     * 然后将视频信息解码，然后播放
     *
     * ===========================YUV和RGB===================
     * YUV（YCbCr，YPbPr）和RGB都是颜色编码的方案，Y代表亮度，UV代表色彩信息
     * U是色度，V是浓度，因此黑白电影可省略UV
     * Y'UV最大的优点在于只需占用极少的带宽。
     *
     * YUV数据有两种格式
     * 紧缩格式（packed formats）yuv数据聚集在一起的数组
     * 平面格式（planar formats）三个分量存储在不同的矩阵中（代表一种存储风格）
     * 常用的YUV格式（平面格式） 有I420（4:2:0）、YV12、IYUV等（具体的存储格式）
     * 4:4:4表示完全取样。
     * 4:2:2表示2:1的水平取样，垂直完全采样。
     * 4:2:0表示2:1的水平取样，垂直2：1采样。
     * 4:1:1表示4:1的水平取样，垂直完全采样。
     *
     * DVD-Video是以YUV 4:2:0的方式记录，也就是我们俗称的I420
     *
     *  NV12与YV12类似，效果一样，YV12中U和V是连续排列的，而在NV12中，U和V就交错排列的
     *
     *  https://www.jianshu.com/p/e67f79f10c65（图片表示）
     *
     *  =======================mp4=========================
     *  MP4或称MPEG-4第14部分（英语：MPEG-4 Part 14）是一种标准的数字多媒体容器格式
     *  注意是容器格式
     * ---------------------------------
     * 同时拥有音频視频的MPEG-4文件通常使用标准扩展名.mp4
     * 仅有音频的MPEG-4文件会使用.m4a扩展名
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * http://www.infoq.com/cn/articles/improving-android-video-on-news-feed-with-litho
     * Facebook构建高性能Android视频组件实践之路
     *
     *
     */
    public void f1(){}
}