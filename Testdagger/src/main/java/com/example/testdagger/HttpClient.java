package com.example.testdagger;

import javax.inject.Inject;

/**
 * Created by Yanlm on 2018/5/22.
 */

public class HttpClient {

    @Inject
    public HttpClient() {
    }

    private int cacheSize;

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }


    @Override
    public String toString() {
        return "HttpClient: cacheSize==" + cacheSize;
    }
}
