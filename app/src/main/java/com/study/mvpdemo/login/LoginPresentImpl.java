package com.study.mvpdemo.login;

/**
 * Created by zhb on 2019/4/18.
 */
public class LoginPresentImpl implements LoginPresent, LoginModel.OnLoginListener {

    private LoginView mView;
    private LoginModel mModel;


    public LoginPresentImpl(LoginView mView, LoginModel mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void doLogin(String username, String password) {
        mView.showProgress();
        mModel.login(username, password, this);
    }

    @Override
    public void onLoginSuccess() {
        mView.hideProgress();
        mView.loginSuccess();
    }

    @Override
    public void onLoginFail() {
        mView.hideProgress();
        mView.loginFail();
    }
}
