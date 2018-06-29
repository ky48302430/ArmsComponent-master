package com.example.testdagger;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Yanlm on 2018/6/14.
 */

public class MyPresent implements LifecycleObserver {
    public static String TAG = "MyPresent";
    @Inject
    MyPresent() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.i(TAG, "onCreate.........");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestry(LifecycleOwner owner) {
        Log.i(TAG, "onDestry........." + (owner == null));
    }
}
