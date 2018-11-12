package com.liyafeng.video.practice.c_video_record;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;

import com.liyafeng.video.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CameraActivity extends Activity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private FrameLayout sv_content;
    private Camera cameraInstance;

    /**
     * camera api能获取图片和视频，5.0以后推荐camera2
     * 1.需要权限
     * 2.Android9.0 以后，如果app在后台就不能使用camera
     * <p>
     * =================将你的图片或者视频保存，让其他app可见============
     * https://developer.android.google.cn/guide/topics/media/camera#saving-media
     * <p>
     * ===================使用camera步骤=================
     * https://developer.android.google.cn/guide/topics/media/camera#custom-camera
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        sv_content = (FrameLayout) findViewById(R.id.sv_content);
        findViewById(R.id.btn_record).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                request();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
    }

    private void takePhoto() {
        if (cameraInstance != null) {

            cameraInstance.takePicture(null, null, new Camera.PictureCallback() {
                @Override
                public void onPictureTaken(byte[] data, Camera camera) {
                    File externalFilesDir = CameraActivity.this.getExternalFilesDir(null);
                    File file = new File(externalFilesDir, System.currentTimeMillis() + ".jpg");
                    FileOutputStream outputStream = null;
                    try {
                        outputStream = new FileOutputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (outputStream != null) {
                            outputStream.write(data);
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void request() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i("test", "授权了！！！");
                    start();
                } else {


                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    /**
     * 开启相机
     */
    private void start() {

        if (checkCameraHardware(this)) {
            //摄像头数量
            int numberOfCameras = Camera.getNumberOfCameras();
            cameraInstance = getCameraInstance();
            if (cameraInstance != null) {
                Camera.Parameters parameters = cameraInstance.getParameters();
                cameraInstance.setDisplayOrientation(90);//设置显示角度
                parameters.setRotation(90);//设置照出的图片角度

                /*
                * 这里的照片宽高只能选择系统支持的
                * */
                List<Camera.Size> supportedPictureSizes = cameraInstance.getParameters().getSupportedPictureSizes();
                Camera.Size size = supportedPictureSizes.get(0);//有很多像素选择
                parameters.setPictureSize(size.width,size.height);


                parameters.setPictureFormat(ImageFormat.JPEG);

                /*
                * 设置自动对焦，需要适配（可以实现触摸对焦，然后还有根据传感器判断手机移动后对焦）
                * https://blog.csdn.net/huweigoodboy/article/details/51378751
                * */
                parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);

                cameraInstance.setParameters(parameters);

                CameraPreview cameraPreview = new CameraPreview(this, cameraInstance);
                sv_content.addView(cameraPreview);
            }
        }
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /**
     * A safe way to get an instance of the Camera object.
     */
    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(cameraInstance!=null){
            cameraInstance.stopPreview();
            cameraInstance.release();
        }
    }
}
