package com.example.administrator.teamyikezhong.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 初始化
 * Created by 兰昊琼 on 2018/6/5.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
