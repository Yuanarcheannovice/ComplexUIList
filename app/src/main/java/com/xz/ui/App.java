package com.xz.ui;

import android.app.Application;

import com.xz.ui.util.ToastUtil;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.init(this);
    }
}
