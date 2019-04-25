package com.study.mvpdemo.login;

/**
 * Created by zhb on 2019/4/18.
 */
public interface LoginModel {

    interface OnLoginListener {

        void onLoginSuccess();

        void onLoginFail();
    }

    void login(String username, String password, OnLoginListener listener);

}
