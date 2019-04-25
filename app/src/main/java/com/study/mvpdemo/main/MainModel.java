package com.study.mvpdemo.main;

import com.study.mvpdemo.basemvp.Model;

/**
 * Created by zhb on 2019/4/18.
 */
public interface  MainModel extends Model {
    /**
     * 从网络获取数据
     *
     * @return
     */
    String getDataFromNet();

    /**
     * 停止请求
     */
    void stopRequest();
}
