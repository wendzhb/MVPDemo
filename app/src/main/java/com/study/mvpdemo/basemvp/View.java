package com.study.mvpdemo.basemvp;

/**
 * Created by zhb on 2019/4/18.
 * <p>
 * View接口，所有视图类的父类，在接口中可以做一些基本的展示过程，
 * 比如Toast、Progress的显示，或者检查网络状态后的提醒，具体的实现由子类决定，
 * 子类也可以仍然是一个接口，继续拓展View的功能
 */
public interface View {
    void showToast(String info);

    void showProgress();
}
