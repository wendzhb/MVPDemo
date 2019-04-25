package com.study.mvpdemo.main;

import com.study.mvpdemo.basemvp.View;

/**
 * Created by zhb on 2019/4/18.
 */
public interface MainView extends View {
    /**
     * 设置数据
     *
     * @param str
     */
    void setData(String str);
}
