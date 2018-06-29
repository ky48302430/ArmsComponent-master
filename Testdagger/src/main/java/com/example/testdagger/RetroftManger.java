package com.example.testdagger;

/**
 * Created by Yanlm on 2018/5/22.
 */

public class RetroftManger {

    private HttpClient  client;

    public RetroftManger(HttpClient client) {
        this.client = client;
    }

    public HttpClient getClient() {
        return client;
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return  "RetroftManger: "+super.toString() + ", " + client.toString();
    }
}
