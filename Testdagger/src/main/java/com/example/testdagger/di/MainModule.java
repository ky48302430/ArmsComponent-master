package com.example.testdagger.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.example.testdagger.HttpClient;
import com.example.testdagger.RetroftManger;
import com.example.testdagger.bean.ActivityBean;
import com.example.testdagger.bean.Appbean;
import com.example.testdagger.liveData.UserViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yanlm on 2018/5/23.
 *
 *  提供第三示例对象
 */
@Module
public class MainModule {
    AppCompatActivity  appCompatActivity;
    ActivityBean  activityBean;
    private int cacheSize;
    public  MainModule(int cacheSize,ActivityBean activityBean,AppCompatActivity  activity){
        this.cacheSize    = cacheSize;
        this.activityBean = activityBean;
        this.appCompatActivity = activity;
    }
//     这里没有提供此类实例  会去他的构造函数去看是否有@inject 标签
//    @Provides
//    HttpClient provideHttpClient(){
//        HttpClient  hc =    new HttpClient();
//        hc.setCacheSize(cacheSize);
//        return hc;
//    }


    @Provides
    UserViewModel provideUserViewModel(){
        return  ViewModelProviders.of(appCompatActivity).get(UserViewModel.class);
    }

    @Provides
    RetroftManger provideRetroftManger(HttpClient  client){
        client.setCacheSize(cacheSize);
        return new RetroftManger(client);
    }

    @Provides
    ActivityBean provideActivityBean(){
        return this.activityBean;
    }


    public ActivityBean getActivityBean() {
        return activityBean;
    }

    public void setActivityBean(ActivityBean activityBean) {
        this.activityBean = activityBean;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
