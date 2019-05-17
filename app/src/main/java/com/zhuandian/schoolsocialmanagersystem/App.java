package com.zhuandian.schoolsocialmanagersystem;

import android.app.Application;


import cn.bmob.v3.Bmob;

/**
 * desc :
 * author：xiedong
 * date：2019/2/19
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "00d13d393b35eac7e23c3077d1c787ca");

    }
}
