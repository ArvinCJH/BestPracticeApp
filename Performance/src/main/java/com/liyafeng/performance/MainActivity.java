package com.liyafeng.performance;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.MemoryFile;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        StringBuilder

    }

    /**
     * 深入说说ANR
     *
     * 基础：https://developer.android.google.cn/topic/performance/vitals/anr.html#detect_and_diagnose_problems
     *
     * 深入源码：http://www.bijishequ.com/detail/569457?p=
     *
     * */
    public void a1(){
        /*
        * Activity在生命周期中阻塞超过5秒就会提示anr，broadcastReceiver 是10秒，service是20秒
        * ActivityManagerService中定义了 Activity和broadcastReceiver的超时时间
        * ActiveServices中定义了服务的超时时间
        *
        * 触发anr的原理就是在执行Activity的生命周期之前，AMS会发送一个Handler,延时5秒
        * 然后执行Activity的生命周期的方法，执行完成后，取消Handler中的超时消息
        * 如果超过5秒，回执行相应的超时处理方法，比如Activity超时会弹出弹窗
        * 然后将堆栈信息记录在data/anr/trace.txt中
        *
        */
    }

    /**
     * Android布局优化方案？
     * */
    public void a2(){
        /*
        * 少嵌套，
        * 可以使用ConstraintLayout，来实现扁平布局
        * 避免overdraw，就是说背景尽量少重叠
        * 用Android 系统开发者选项中的检测布局边界，来确定布局是否重叠度过高
        */
    }
}
