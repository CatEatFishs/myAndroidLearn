package com.syd.mystudydemo;

import android.app.Application;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.exceptionhandler.ExceptionHandler;
import com.syd.mystudydemo.utils.UtilsProcess;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyApplication extends Application {
    public static String string =
            MyApplication.class.getSimpleName() + Process.myPid() + "===" + Process.myUid() + "===" + Process.myTid();
    public static String ss;
    String TAG = getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
//        CrashExceptionHandler.getInstace().init();

        //ExceptionHander的使用
        ExceptionHandler.install(new ExceptionHandler.CustomExceptionHandler() {
            @Override
            public void handlerException(Thread thread, Throwable throwable) {
                if (throwable != null)
                    Log.e("ExceptionHandler=====", throwable.getMessage() + "");
            }
        });

        ss = UtilsProcess.getProcessName(Process.myPid(), getApplicationContext());
        Log.e(TAG, TAG + AppConst.LOG_TAG);
        Log.e(TAG, TAG + "onCreate()");
        Log.e(TAG, "MyApplication.class.getName()-->" + MyApplication.class.getName());
        Log.e(TAG, "getBaseContext-->" + getBaseContext());
        Log.e(TAG, "getApplicationContext()-->" + getApplicationContext());
        Toast.makeText(this, "ddddd", Toast.LENGTH_LONG).show();

    }
}
