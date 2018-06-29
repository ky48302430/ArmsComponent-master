package com.example.testdagger.di;

import com.example.testdagger.HttpClient;
import com.example.testdagger.RetroftManger;
import com.example.testdagger.bean.Appbean;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yanlm on 2018/5/25.
 */
@Module
public class AppModule {
    @Provides
    Appbean provideAppbean(){
        return new Appbean();
    }
}
