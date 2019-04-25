package com.study.mvpdemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.study.mvpdemo.R;
import com.study.mvpdemo.SecondActivity;
import com.study.mvpdemo.basemvp.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainModel, MainView, MainPresenter> implements MainView {

    private TextView tvFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirst = findViewById(R.id.tv_first);
        tvFirst.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }

        });
        init();
    }

    private void init() {
        if (presenter != null) {
            presenter.getData();
        }
    }

    @Override
    public MainModel createModel() {
        return new MainModelImpl();
    }

    @Override
    public MainView createView() {
        return this;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setData(String str) {
        tvFirst.setText(str);
    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showProgress() {

    }
}
