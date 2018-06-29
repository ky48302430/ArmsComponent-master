package com.example.testdagger.liveData;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

/**
 * Created by Yanlm on 2018/6/28.
 */

public class UserViewModel extends ViewModel{
    private String TAG = UserViewModel.class.getSimpleName();

    private MutableLiveData<UserBean> liveUser;
    public MutableLiveData<UserBean> getData(){
        if(liveUser == null){
            liveUser = new MutableLiveData<UserBean>();
        }
        liveUser.setValue(loadData());
        return this.liveUser;
    }

    public UserBean loadData() {
        Random rand = new Random();
        int id = rand.nextInt(100) + 1;
        UserBean user = new UserBean();
        user.userId = "ID" + id;
        user.name = "Jack" + id;
        user.phone ="158956537" + id;
        Log.i(TAG, "loadData(): " + user.toString());
        return user;
    }

    public void changeData(){
        if(liveUser != null){
            liveUser.setValue(loadData());
        }
    }
    public void clearData() {

    }
}
