package com.example.administrator.teamyikezhong.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class MyApp extends Application {
    {
        //  PlatformConfig.setWeixin("wx396ea2b17e2f8938", "a33aae6c6649257cbb48de80ddb0bf90");
        PlatformConfig.setQQZone("1106856414", "dHByyWjizkOJihqy");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        UMConfigure.init(this, "5ada9fbbb27b0a700b000182", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
    }
}
