package com.study.mvpdemo.login;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.study.mvpdemo.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("正在登陆");
        progressDialog.setProgressStyle(android.R.style.Widget_Material_Light_ProgressBar_Small_Inverse);

        LoginPresent loginPresent = new LoginPresentImpl(this, new LoginModelImpl());
        loginPresent.doLogin("zhangsan", "lisi");
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
