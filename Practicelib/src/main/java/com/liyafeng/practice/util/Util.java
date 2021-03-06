package com.liyafeng.practice.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import static android.util.Base64.DEFAULT;

/**
 * Created by liyafeng on 2018/1/8.
 */

public class Util {


    public static void refresh() {
//        MediaStore.Images.Media.insertImage(getContentResolver(), data.uri, "title", "description");
        //这个保存在sd卡的Picture文件夹中
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            final Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//            final Uri contentUri = Uri.fromFile(outputFile);
//            scanIntent.setData(contentUri);
//            sendBroadcast(scanIntent);
//        } else {
//            final Intent intent = new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory()));
//            sendBroadcast(intent);
//        }
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }



    /**
     * 获得NavigationBar的高度
     */
    public static int getNavigationBarHeight(Activity activity) {
        int result = 0;
        Resources resources = activity.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0 && checkHasNavigationBar(activity)) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static boolean checkHasNavigationBar(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        Display d = windowManager.getDefaultDisplay();

        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            d.getRealMetrics(realDisplayMetrics);
        }

        int realHeight = realDisplayMetrics.heightPixels;
        int realWidth = realDisplayMetrics.widthPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        d.getMetrics(displayMetrics);

        int displayHeight = displayMetrics.heightPixels;
        int displayWidth = displayMetrics.widthPixels;

        return (realWidth - displayWidth) > 0 || (realHeight - displayHeight) > 0;
    }



    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    /**
     * 禁用EditText的长按事件（粘贴）
     *
     * @param editText
     */
    public static void disableEditTextLongClick(EditText editText) {
        editText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    /**
     * EditText隐藏键盘
     *
     * @param editText
     */
    public static void disableShowSoftInput(EditText editText) {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            editText.setInputType(InputType.TYPE_NULL);
        } else {
            Class<EditText> cls = EditText.class;
            Method method;
            try {
                method = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                method.setAccessible(true);
                method.invoke(editText, false);
            } catch (Exception e) {
                // TODO: handle exception
            }

            try {
                method = cls.getMethod("setSoftInputShownOnFocus", boolean.class);
                method.setAccessible(true);
                method.invoke(editText, false);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }


    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }


    /**
     * 获取高度
     *
     * @param adapter
     * @return
     */
    public static int getListViewHeight(Adapter adapter, int add, GridView gv_rule) {
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i += add) {
            View listItem = adapter.getView(i, null, gv_rule);
            listItem.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += listItem.getMeasuredHeight();
        }
        return totalHeight;
    }


    /**
     * 获取一个像素多少字节
     *
     * @param config
     * @return
     */
    static int getBytesPerPixel(Config config) {
        if (config == Config.ARGB_8888) {
            return 4;
        } else if (config == Config.RGB_565) {
            return 2;
        } else if (config == Config.ARGB_4444) {
            return 2;
        } else if (config == Config.ALPHA_8) {
            return 1;
        }
        return 1;
    }


    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);

        if (manager == null) {
            return false;
        }

        //需要权限
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();

        if (networkinfo == null || !networkinfo.isAvailable()) {
            return false;
        }

        return true;
    }


    /**
     * 版本升级
     */
    public void checkVersion() {
        //https://blog.csdn.net/qq_34161388/article/details/73248703


        //https://blog.csdn.net/u013278099/article/details/52692008

        //https://segmentfault.com/a/1190000010172260

        //一般强制更新得`我们自己实现，下载时显示dialog不可关闭
    }


    public static int getVerCode(Context context) {
        int verCode = -1;
        try {
            verCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return verCode;
    }

    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return verName;
    }


    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    public static void dismiss(Context context) {
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
////隐藏软键盘 //
//        imm.hideSoftInputFromWindow(et_edit.getWindowToken(), 0);
////显示软键盘
//        imm.showSoftInputFromInputMethod(tv.getWindowToken(), 0);
//        //切换软键盘的显示与隐藏
//        imm.toggleSoftInputFromWindow(tv.getWindowToken(), 0, InputMethodManager.HIDE_NOT_ALWAYS);
//
//
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
////隐藏软键盘 //
//        imm.hideSoftInputFromWindow(context.getWindow().getDecorView().getWindowToken(), 0);
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
        }
        return versionName;
    }

    public static void showSoftInput(Context context, View view) {


        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        }
    }

    public static void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
        }
    }


    public static boolean isShowSoftInput(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        return isOpen;
    }

    /**
     * 禁用回车
     *
     * @param editText
     */
    public static void disableEnter(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });
    }


    /**
     * 保留两位小数
     *
     * @param v
     * @return
     */
    public static double round2(double v) {
        BigDecimal bg = new BigDecimal(v);
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


//        String.format("%.2f", f)

//        DecimalFormat df = new DecimalFormat("#.00");
    }


    /**
     * 判断新版本要比老的大
     *
     * @param newVersion
     * @return
     */
    public static boolean isUpdate(Context context, String newVersion) {
        try {
            String currentVersion = getAppVersionName(context);
            if (TextUtils.isEmpty(newVersion) || TextUtils.isEmpty(currentVersion)) {
                return false;
            }
            if (newVersion.equals(currentVersion)) {
                return false;
            }

            String[] split = newVersion.split("[.]");
            //必须有一个从左起对应位置比老版本大才行
            String[] split_old = currentVersion.split("[.]");

            for (int i = 0; i < split.length; i++) {
                String newstr = split[i];
                if (i < split_old.length) {
                    String current = split_old[i];
                    int newNum = Integer.parseInt(newstr);
                    int currentNum = Integer.parseInt(current);
                    if (newNum > currentNum) {
                        return true;//新的大，要更新
                    } else if (newNum < currentNum) {
                        return false;//服务端返回的小，不用更新
                    }
                } else {
                    break;
                }
            }

            //说明两个 版本交集部分相等,而且现在两个不相等
            if (newVersion.length() > currentVersion.length()) {//如果新的版本长，需要更新
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;//说明新的版本 短或者等于当前版本，说明比当前版本低

    }


    public static boolean isAlive(Context context) {
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            List<ActivityManager.AppTask> appTasks = am.getAppTasks();//这个返回当前应用的task，
            for (int i = 0; i < appTasks.size(); i++) {
                ComponentName baseActivity = appTasks.get(i).getTaskInfo().baseActivity;
                if (context.getPackageName().equals(baseActivity.getPackageName())) {
                    Log.i("test", "找到了当前应用" + appTasks.get(i).getTaskInfo().topActivity);
                    break;
                }
//                int baseActivity = appTasks.get(i).getTaskInfo().numActivities;
            }
        } else {//这种是返回当前app的task和 launcher的task
            List<ActivityManager.RunningTaskInfo> runningTasks = am.getRunningTasks(50);
            for (int i = 0; i < runningTasks.size(); i++) {
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(i);
                if (runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                    int numActivities = runningTaskInfo.numActivities;
                    Log.i("test", "当前应用页面" + numActivities);

                    break;
                }
            }
        }

        return false;
    }


    /**
     * @return
     */
    public static String getOkUserAgent(Context context) {
        try {
            String userAgent = "";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                try {
                    userAgent = WebSettings.getDefaultUserAgent(context);
                } catch (Exception e) {
                    userAgent = System.getProperty("http.agent");
                }
            } else {
                userAgent = System.getProperty("http.agent");
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0, length = userAgent.length(); i < length; i++) {
                char c = userAgent.charAt(i);
                if (c <= '\u001f' || c >= '\u007f') {
                    sb.append(String.format("\\u%04x", (int) c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "okhttp/" + getAppVersionName(context);
    }


    /**
     * 获取当前进程名
     *
     * @return
     */
    public static String getProcessName(Context context) {
        try {
            int i = Process.myPid();
            ActivityManager service = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (service != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = service.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo procInfo : runningAppProcesses) {
                    if (procInfo.pid == i) {
                        return procInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


    /**
     * 解密
     *
     * @param content
     * @return
     */
    public static String decrypt(String content) {
        try {
            StringBuilder builder = new StringBuilder("123456");
            for (int i = 0; i < 10; i++) {
                builder.append('\0');
            }


            // 创建AES秘钥
            SecretKeySpec key = new SecretKeySpec(builder.toString().getBytes(), "AES");

            byte[] decode = Base64.decode(content, DEFAULT);

            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            // 初始化加密器
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] doFinal = cipher.doFinal(decode);
            int end = doFinal.length;
            while (end > 0 && --end > 0 && doFinal[end] == 0) {

            }

            return new String(doFinal, 0, end + 1);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return content;
    }


    /**
     * 加密，然后base64编码
     *
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText) {
        try {

            StringBuilder builder = new StringBuilder("123456");
            for (int i = 0; i < 10; i++) {
                builder.append('\0');
            }


            // 创建AES秘钥
            SecretKeySpec key = new SecretKeySpec(builder.toString().getBytes(), "AES");

            //获得加密器
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            // 初始化加密器
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] p = plainText.getBytes();
            int size = (16 - p.length % 16);
            StringBuilder builder_content = new StringBuilder(plainText);
            for (int i = 0; i < size; i++) {
                builder_content.append('\0');
            }

            //明文进行加密
            byte[] result = cipher.doFinal(builder_content.toString().getBytes());
            byte[] encode = Base64.encode(result, DEFAULT);
            return new String(encode);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return plainText;
    }


    //解决SwipeRefreshLayout和ViewPager的滑动冲突
//    fun solveScroll(viewPager: ViewPager, swipeRefreshLayout: SwipeRefreshLayout) {
//
//        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrollStateChanged(state: Int) {
//                val b = state == ViewPager.SCROLL_STATE_IDLE
//                swipeRefreshLayout.isEnabled = b
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            }
//
//            override fun onPageSelected(position: Int) {
//            }
//
//        }
//        )
//    }


    /**
     * 判断是否在主进程，这样application的oncreate方法中判断可以只初始化一次
     * 是否是主进程
     * @param context
     * @return
     */
    private boolean shouldInit(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = am.getRunningAppProcesses();
        String mainProcessName = context.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : runningAppProcesses) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 识别小米设备
     */
    private void isMi() {
        //https://dev.mi.com/doc/p=254/index.html
    }


    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        Resources resources = Resources.getSystem();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }


    /**
     * 隐藏虚拟栏 ，显示的时候再隐藏掉
     *
     * @param window
     */
    static public void hideNavigationBar(final Window window) {
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                //布局位于状态栏下方 不设置会导致 bar隐藏了，但是布局还在bar上方
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        //布局位于状态栏下方
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        //全屏
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        //隐藏导航栏
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                if (Build.VERSION.SDK_INT >= 19) {
                    uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                } else {
                    uiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
                }
                window.getDecorView().setSystemUiVisibility(uiOptions);
            }
        });
    }


    /**
     * Return pseudo unique ID
     *
     * @return ID
     */
    public static String getDeviceID() {
        // If all else fails, if the user does have lower than API 9 (lower
        // than Gingerbread), has reset their device or 'Secure.ANDROID_ID'
        // returns 'null', then simply the ID returned will be solely based
        // off their Android device information. This is where the collisions
        // can happen.
        // Thanks http://www.pocketmagic.net/?p=1662!
        // Try not to use DISPLAY, HOST or ID - these items could change.
        // If there are collisions, there will be overlapping data
        //Build.CPU_ABI 这个不靠谱，代表App支持的abi，有可能会变，所以要把这个去掉
        String m_szDevIDShort = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);

        // Thanks to @Roman SL!
        // http://stackoverflow.com/a/4789483/950427
        // Only devices with API >= 9 have android.os.Build.SERIAL
        // http://developer.android.com/reference/android/os/Build.html#SERIAL
        // If a user upgrades software or roots their device, there will be a duplicate entry
        String serial = null;
        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();

            // Go ahead and return the serial for api => 9
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            // String needs to be initialized
            serial = "serial"; // some value
        }

        // Thanks @Joe!
        // http://stackoverflow.com/a/2853253/950427
        // Finally, combine the values we have found by using the UUID class to create a unique identifier
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }



    /**
     * 解压zip到指定的路径
     *
     * @param zipFileString ZIP的名称
     * @param outPathString 要解压缩路径
     */
    public static void unZipFolder(String zipFileString, String outPathString) throws Exception {
        ZipInputStream inZip = new ZipInputStream(new FileInputStream(zipFileString));
        ZipEntry zipEntry;
        String szName = "";
        while ((zipEntry = inZip.getNextEntry()) != null) {
            szName = zipEntry.getName();
            if (zipEntry.isDirectory()) {
                //获取部件的文件夹名
                szName = szName.substring(0, szName.length() - 1);
                File folder = new File(outPathString + File.separator + szName);
                folder.mkdirs();
            } else {
//                Log.e(TAG,outPathString + File.separator + szName);
                File file = new File(outPathString + File.separator + szName);
                if (!file.exists()) {
//                    Log.e(TAG, "Create the file:" + outPathString + File.separator + szName);
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                // 获取文件的输出流
                FileOutputStream out = new FileOutputStream(file);
                int len;
                byte[] buffer = new byte[1024];
                // 读取（字节）字节到缓冲区
                while ((len = inZip.read(buffer)) != -1) {
                    // 从缓冲区（0）位置写入（字节）字节
                    out.write(buffer, 0, len);
                    out.flush();
                }
                out.close();
            }
        }
        inZip.close();
    }


    /**
     * 获取zip的文件个数（包含文件夹）
     * @param zipFileString
     */
    public void getZipSize(String zipFileString){

        try {
            ZipFile zipFile = new ZipFile(zipFileString);
            int zipCount= zipFile.size();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 判断Activity是否存在
     * @param context
     * @param cls
     * @return
     */
    public static boolean isExistMainActivity(Context context, Class<?> cls) {
        try {
            Intent intent = new Intent(context, cls);
            ComponentName cmpName = intent.resolveActivity(context.getPackageManager());
            boolean flag = false;
            // 说明系统中存在这个activity
            if (cmpName != null) {
                ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningTaskInfo> taskInfoList = am.getRunningTasks(10);
                for (ActivityManager.RunningTaskInfo taskInfo : taskInfoList) {
                    // 说明它已经启动了
                    if (taskInfo.baseActivity.equals(cmpName)) {
                        flag = true;
                        break;  //跳出循环，优化效率
                    }
                }
            }
            return flag;
        } catch (Exception e) {
            Log.e("error",e.getMessage());
        }
        return false;
    }



}
