package com.study.mvpdemo.login;

/**
 * Created by zhb on 2019/4/18.
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void loginSuccess();

    void loginFail();
}
