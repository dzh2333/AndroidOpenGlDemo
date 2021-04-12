package com.mark.androidopengldemo;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication application;

    public static MainApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
