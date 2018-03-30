package com.liyafeng.practice;

import android.content.Context;

/**
 * Created by liyafeng on 16/11/2017.
 */

public class Tools {

    /**
     * 编译打包的过程
     * http://blog.csdn.net/luoshengyang/article/details/8744683
     * http://mouxuejie.com/blog/2016-08-04/build-and-package-flow-introduction/
     */
    void a1(Context context) {
        context.getResources().getDrawable(R.drawable.build_simplified);
        /*
        *
        * */
    }

    /**
     * android studio 目录下build/下的文件夹都是什么作用？
     */
    public void a1_1() {
        /*
        * The "generated" folder contains java code generated by Android Studio for the module. The primary file here is "R.java" which assigns symbolic names to each of the items in the "res" directory so they can be referenced in java source code.

        *The "intermediates" folder contains individual files that are created during the build process and which are eventually combined to produce the "apk" file.
        *
        *The output folder is missing because the module ".iml" file explicitly excludes it with the following statement:
        *
        *<excludeFolder url="file://$MODULE_DIR$/build/outputs" />
        *
        *Remove that line and the "output" directory will appear under build.
        */
    }

    /**
     * android-apt的使用?
     * https://joyrun.github.io/2016/07/19/AptHelloWorld/
     * https://www.jianshu.com/p/2494825183c5
     * https://juejin.im/entry/584a29a5128fe1006c7923a5
     * */
    public void a1_2(){
        /*
        * 最早我们用android-apt 这个工具，但是现在已经维护了
        * 因为Gradle推出了官方的处理工具 annotationProcessor
        *
        * Annotation Processing Tool 注解处理工具，用注解来生成代码
        */
        //这是以前的android-apt工具使用
//        buildscript {
//            repositories {
//                jcenter()
//            }
//            dependencies {
//                classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
//            }
//        }
//        apply plugin: 'com.neenbedankt.android-apt'
//        dependencies {
//            compile 'org.greenrobot:eventbus:3.0.0'
//            apt'org.greenrobot:eventbus-annotation-processor:3.0.1'//apt
//        }

        //Gradle自带的  annotationProcessor
//        dependencies {
//            compile 'org.greenrobot:eventbus:3.0.0'
//            annotationProcessor  'org.greenrobot:eventbus-annotation-processor:3.0.1'
//        }
    }
}
