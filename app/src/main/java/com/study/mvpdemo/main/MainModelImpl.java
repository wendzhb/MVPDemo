package com.study.mvpdemo.main;

import android.util.Log;

/**
 * Created by zhb on 2019/4/18.
 */
public class MainModelImpl implements MainModel {
    @Override
    public String getDataFromNet() {
        return "MVP 模式,into fragment";
    }

    @Override
    public void stopRequest() {
        Log.i("MainModelImpl", "stop request...");
    }
}
