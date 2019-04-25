package com.study.mvpdemo.login;

import android.os.Handler;

/**
 * Created by zhb on 2019/4/18.
 */
public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.equals("1") && password.equals("1")) {
                    listener.onLoginSuccess();
                } else {
                    listener.onLoginFail();
                }
            }
        }, 3000);

    }
}
