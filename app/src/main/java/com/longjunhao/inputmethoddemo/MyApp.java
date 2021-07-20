package com.longjunhao.inputmethoddemo;

import android.app.Application;
import android.content.Context;

/**
 * .MyApp
 *
 * @author Admitor
 * @date 2021/07/20
 */
public class MyApp extends Application {
    private static MyApp instance;
    
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    
    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
