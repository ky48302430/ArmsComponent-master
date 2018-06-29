package com.example.testdagger.di;

import android.app.Application;

import com.example.testdagger.bean.Appbean;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Yanlm on 2018/5/25.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
//    TestMainComponent.MainBuilder  mainBuild();
    Appbean       provideAppbean();
    Application  application();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
