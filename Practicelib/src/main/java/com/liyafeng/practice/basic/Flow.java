package com.liyafeng.practice.basic;

/**
 * Created by liyafeng on 2018/4/25.
 */

public class Flow {


    /**
     * PersistentDataBlockService: not able to find package com.google.android.gms
     * android.content.pm.PackageManager$NameNotFoundException: com.google.android.gms
     * at android.app.ApplicationPackageManager.getPackageUid(ApplicationPackageManager.java:231)
     * at com.android.server.PersistentDataBlockService.getAllowedUid(PersistentDataBlockService.java:96)
     * at com.android.server.PersistentDataBlockService.<init>(PersistentDataBlockService.java:87)
     * at java.lang.reflect.Constructor.newInstance(Native Method)
     * at com.android.server.SystemServiceManager.startService(SystemServiceManager.java:89)
     * at com.android.server.SystemServer.startOtherServices(SystemServer.java:637)
     * at com.android.server.SystemServer.run(SystemServer.java:283)
     * at com.android.server.SystemServer.main(SystemServer.java:175)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
     * <p>
     * ========================================================
     * <p>
     * <p>
     * Unable to load component info ResolveInfo{8790e63 com.tools.cit/.NFCTest m=0x108000}
     * org.xmlpull.v1.XmlPullParserException: No android.nfc.action.TECH_DISCOVERED meta-data
     * at com.android.nfc.RegisteredComponentCache.parseComponentInfo(RegisteredComponentCache.java:186)
     * at com.android.nfc.RegisteredComponentCache.generateComponentsList(RegisteredComponentCache.java:161)
     * at com.android.nfc.RegisteredComponentCache.<init>(RegisteredComponentCache.java:61)
     * at com.android.nfc.NfcDispatcher.<init>(NfcDispatcher.java:90)
     * at com.android.nfc.NfcService.<init>(NfcService.java:818)
     * at com.android.nfc.NfcApplication.onCreate(NfcApplication.java:61)
     * at android.app.Instrumentation.callApplicationOnCreate(Instrumentation.java:1014)
     * at android.app.ActivityThread.handleBindApplication(ActivityThread.java:4707)
     * at android.app.ActivityThread.access$1600(ActivityThread.java:150)
     * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1405)
     * at android.os.Handler.dispatchMessage(Handler.java:102)
     * at android.os.Looper.loop(Looper.java:148)
     * at android.app.ActivityThread.main(ActivityThread.java:5417)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
     * <p>
     * =======================================================
     * android.os.DeadObjectException
     * at android.os.BinderProxy.transactNative(Native Method)
     * at android.os.BinderProxy.transact(Binder.java:503)
     * at android.nfc.INfcAdapter$Stub$Proxy.setForegroundDispatch(INfcAdapter.java:525)
     * at android.nfc.NfcAdapter.disableForegroundDispatchInternal(NfcAdapter.java:1245)
     * at android.nfc.NfcAdapter.disableForegroundDispatch(NfcAdapter.java:1233)
     * at com.pinzhikeji.snack.MainActivity.onPause(MainActivity.java:1934)
     * at android.app.Activity.performPause(Activity.java:6397)
     * at android.app.Instrumentation.callActivityOnPause(Instrumentation.java:1312)
     * at android.app.ActivityThread.performPauseActivity(ActivityThread.java:3367)
     * at android.app.ActivityThread.performPauseActivity(ActivityThread.java:3340)
     * at android.app.ActivityThread.handlePauseActivity(ActivityThread.java:3315)
     * at android.app.ActivityThread.access$1100(ActivityThread.java:150)
     * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1355)
     * at android.os.Handler.dispatchMessage(Handler.java:102)
     * at android.os.Looper.loop(Looper.java:148)
     * at android.app.ActivityThread.main(ActivityThread.java:5417)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * at com.pinzhikeji.snack.adapter.RemarksAdapter.onBindViewHolder(RemarksAdapter.java:65)
     * at com.pinzhikeji.snack.adapter.RemarksAdapter.onBindViewHolder(RemarksAdapter.java:24)
     * at android.support.v7.widget.RecyclerView$Adapter.onBindViewHolder(RecyclerView.java:5825)
     * at android.support.v7.widget.RecyclerView$Adapter.bindViewHolder(RecyclerView.java:5858)
     * at android.support.v7.widget.RecyclerView$Recycler.getViewForPosition(RecyclerView.java:5094)
     * at android.support.v7.widget.RecyclerView$Recycler.getViewForPosition(RecyclerView.java:4970)
     * at android.support.v7.widget.LinearLayoutManager$LayoutState.next(LinearLayoutManager.java:2029)
     * at android.support.v7.widget.GridLayoutManager.layoutChunk(GridLayoutManager.java:541)
     * at android.support.v7.widget.LinearLayoutManager.fill(LinearLayoutManager.java:1377)
     * at android.support.v7.widget.LinearLayoutManager.onLayoutChildren(LinearLayoutManager.java:578)
     * at android.support.v7.widget.GridLayoutManager.onLayoutChildren(GridLayoutManager.java:170)
     * at android.support.v7.widget.RecyclerView.dispatchLayoutStep2(RecyclerView.java:3315)
     * at android.support.v7.widget.RecyclerView.onMeasure(RecyclerView.java:2843)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
     * at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
     * at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
     * at android.view.View.measure(View.java:18813)
     * at android.widget.RelativeLayout.measureChildHorizontal(RelativeLayout.java:716)
     * at android.widget.RelativeLayout.onMeasure(RelativeLayout.java:462)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
     * at android.view.View.measure(View.java:18813)
     * at android.widget.RelativeLayout.measureChildHorizontal(RelativeLayout.java:716)
     * at android.widget.RelativeLayout.onMeasure(RelativeLayout.java:462)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
     * at android.support.v7.widget.ContentFrameLayout.onMeasure(ContentFrameLayout.java:135)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
     * at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
     * at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
     * at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
     * at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5956)
     * at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
     * at com.android.internal.policy.PhoneWindow$DecorView.onMeasure(PhoneWindow.java:2643)
     * at android.view.View.measure(View.java:18813)
     * at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2100)
     * at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:1216)
     * at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1452)
     * at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
     * at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
     * at android.view.Choreogr
     */
    public void measureFlow() {

    }


    /**
     * at com.liyafeng.MainActivity.onCreate(MainActivity.java:41)
     * at android.app.Activity.performCreate(Activity.java:6102)
     * at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1106)
     * at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2280)
     * at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2389)
     * at android.app.ActivityThread.access$800(ActivityThread.java:151)
     * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1305)
     * at android.os.Handler.dispatchMessage(Handler.java:102)
     * at android.os.Looper.loop(Looper.java:135)
     * at android.app.ActivityThread.main(ActivityThread.java:5271)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at java.lang.reflect.Method.invoke(Method.java:372)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:902)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:697)
     */
    void startActivityFlow() {

        //新的进程都是从zygote中fork出来的，ZygoteInit有socket接受消息
        //收到消息后创建新的进程，代码从ZygoteInit中开始，然后创建ActivityThread
        //里面接受AMS的启动页面消息，收到消息后创建Activity对象
        //通过WMS来将视图显示

    }

    /**
     * at com.pinzhikeji.snack.mobile.ui.dialog.MobileNumberDialog$3.onClick(MobileNumberDialog.java:106)
     * at android.view.View.performClick(View.java:4781)
     * at android.view.View$PerformClick.run(View.java:19874)
     * at android.os.Handler.handleCallback(Handler.java:739)
     * at android.os.Handler.dispatchMessage(Handler.java:95)
     * at android.os.Looper.loop(Looper.java:135)
     * at android.app.ActivityThread.main(ActivityThread.java:5271)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at java.lang.reflect.Method.invoke(Method.java:372)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:902)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:697)
     */
    void clickFlow() {


    }


    /**
     * at com.pinzhikeji.snack.view.fragment.orderdish.OrderDishFragment.onCreateView(OrderDishFragment.java:362)
     * at android.support.v4.app.Fragment.performCreateView(Fragment.java:2080)
     * at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1108)
     * at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1290)
     * at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:801)
     * at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1677)
     * at android.support.v4.app.FragmentController.execPendingActions(FragmentController.java:388)
     * at android.support.v4.app.FragmentActivity.onStart(FragmentActivity.java:604)
     * at android.support.v7.app.AppCompatActivity.onStart(AppCompatActivity.java:178)
     * at android.app.Instrumentation.callActivityOnStart(Instrumentation.java:1238)
     * at android.app.Activity.performStart(Activity.java:6302)
     * at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2379)
     * at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2476) 
     * at android.app.ActivityThread.access$900(ActivityThread.java:150) 
     * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1344) 
     * at android.os.Handler.dispatchMessage(Handler.java:102) 
     * at android.os.Looper.loop(Looper.java:148) 
     * at android.app.ActivityThread.main(ActivityThread.java:5417) 
     * at java.lang.reflect.Method.invoke(Native Method) 
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726) 
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616) 
     */
    void fragmentFlow() {

    }

    /**
     * Process: com.liyafeng.view, PID: 10301
     * java.lang.OutOfMemoryError: pthread_create (1040KB stack) failed: Try again
     * at java.lang.Thread.nativeCreate(Native Method)
     * at java.lang.Thread.start(Thread.java:729)
     * at com.liyafeng.view.MainActivity.onCreate(MainActivity.java:149)
     * at android.app.Activity.performCreate(Activity.java:6861)
     * at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1119)
     * at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2693)
     * at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2801)
     * at android.app.ActivityThread.-wrap12(ActivityThread.java)
     * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1548)
     * at android.os.Handler.dispatchMessage(Handler.java:102)
     * at android.os.Looper.loop(Looper.java:163)
     * at android.app.ActivityThread.main(ActivityThread.java:6365)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:901)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:791)
     */
    void oomFlow() {

    }

    /**
     * java.lang.NullPointerException: Attempt to get length of null array
     * at com.liyafeng.view.camera.CameraActivity$1$2.onPictureTaken(CameraActivity.java:56)
     * at android.hardware.Camera$EventHandler.handleMessage(Camera.java:1175)
     * at android.os.Handler.dispatchMessage(Handler.java:102)
     * at android.os.Looper.loop(Looper.java:163)
     * at android.app.ActivityThread.main(ActivityThread.java:6365)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:901)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:791)
     */
    void camareFlow() {
    }


    /**
     * WindowAnimator: Failed to dispatch window animation state change.
     * android.os.DeadObjectException
     * at android.os.BinderProxy.transactNative(Native Method)
     * at android.os.BinderProxy.transact(Binder.java:503)
     * at android.view.IWindow$Stub$Proxy.onAnimationStarted(IWindow.java:520)
     * at com.android.server.wm.WindowAnimator.updateWindowsLocked(WindowAnimator.java:282)
     * at com.android.server.wm.WindowAnimator.animateLocked(WindowAnimator.java:678)
     * at com.android.server.wm.WindowAnimator.access$000(WindowAnimator.java:53)
     * at com.android.server.wm.WindowAnimator$1.doFrame(WindowAnimator.java:123)
     * at android.view.Choreographer$CallbackRecord.run(Choreographer.java:856)
     * at android.view.Choreographer.doCallbacks(Choreographer.java:670)
     * at android.view.Choreographer.doFrame(Choreographer.java:603)
     * at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
     * at android.os.Handler.handleCallback(Handler.java:739)
     * at android.os.Handler.dispatchMessage(Handler.java:95)
     * at android.os.Looper.loop(Looper.java:148)
     * at android.os.HandlerThread.run(HandlerThread.java:61)
     * at com.android.server.ServiceThread.run(ServiceThread.java:46)
     */
    void animatorFlow() {

    }
}