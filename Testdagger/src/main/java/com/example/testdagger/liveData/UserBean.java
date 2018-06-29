package com.example.testdagger.liveData;

/**
 * Created by Yanlm on 2018/6/28.
 */

public class UserBean {
    public  String   name;
    public  String   userId;
    public  String   phone;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
