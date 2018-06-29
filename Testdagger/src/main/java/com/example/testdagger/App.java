package com.example.testdagger;

import android.app.Application;

import com.example.testdagger.di.AppComponent;
import com.example.testdagger.di.DaggerAppComponent;

/**
 * Created by Yanlm on 2018/5/25.
 */

public class App extends Application {
    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent =   DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
