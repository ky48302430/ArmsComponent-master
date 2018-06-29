package com.example.testdagger;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by Yanlm on 2018/5/22.
 */

public class TestPresent {
    @Inject
    TestPresent(){
    }

    @Override
    public String toString() {
        return "TestPresent:" + super.toString();
    }
}
