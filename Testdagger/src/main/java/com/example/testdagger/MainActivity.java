package com.example.testdagger;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdagger.bean.ActivityBean;
import com.example.testdagger.bean.Appbean;
import com.example.testdagger.di.AppComponent;
import com.example.testdagger.di.DaggerTestMainComponent;
import com.example.testdagger.di.MainModule;
import com.example.testdagger.liveData.UserBean;
import com.example.testdagger.liveData.UserViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    UserViewModel mUserViewModel;

    @Inject
    MyPresent mMyPresent;

    @Inject
    TestPresent mPresent;

    @Inject
    RetroftManger mManger;

    @Inject
    Appbean appbean;

    @Inject
    ActivityBean activityBean;

    AppComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerTestMainComponent.create().inject(this);
//        DaggerTestMainComponent.builder()
//                .mainModule(new MainModule(100))
//                .build()
//                .inject(this);

        //subcomponent
//        App mApp = (App) getApplication();
//        mApp.getAppComponent().mainBuild()
//                .MainActivityModule(new MainModule(100, new ActivityBean()))
//                .build()
//                .inject(this);

        //Component
        App mApp = (App) getApplication();
        appComponent =  mApp.getAppComponent();
        DaggerTestMainComponent.builder().applicationComponent(appComponent)
                .application(appComponent.application())
                .mainmodule(new MainModule(100,new ActivityBean(),this))
                .build()
                .inject(this);

        final TextView tv = findViewById(R.id.action_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, activityBean.toString() + "," + appbean.toString() + ", " +appComponent.application().toString(), Toast.LENGTH_SHORT).show();
                if(mUserViewModel != null && mUserViewModel.getData() != null){
                    mUserViewModel.changeData();
                }

            }
        });

        getLifecycle().addObserver(mMyPresent);
//        mUserViewModel  = ViewModelProviders.of(this).get(UserViewModel.class);

        mUserViewModel.getData().observe(this, new Observer<UserBean>() {
            @Override
            public void onChanged(@Nullable UserBean userBean) {
                if (tv !=null) {
                    tv.setText(userBean.toString());
                }
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
