package com.example.testdagger.di;

import android.app.Application;
import android.view.View;

import com.example.testdagger.MainActivity;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Yanlm on 2018/5/22.
 *  起到 Module(非第三方 @Inject)和inject 对象的关联作用
 */
//@Subcomponent(modules = {MainModule.class,AppModule.class})
//public interface TestMainComponent {
//    void inject(MainActivity activity);
//
//    @Subcomponent.Builder
//    interface MainBuilder {
//
//        MainBuilder    MainActivityModule(MainModule  module);
//        TestMainComponent build();
//    }
//}


@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface TestMainComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface MainBuilder {
        TestMainComponent build();
        MainBuilder mainmodule(MainModule bm);
        MainBuilder applicationComponent(AppComponent appComponent);

        @BindsInstance
        MainBuilder application(Application application);
    }
}