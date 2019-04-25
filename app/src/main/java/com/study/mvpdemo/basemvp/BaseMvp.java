package com.study.mvpdemo.basemvp;

/**
 * Created by zhb on 2019/4/18.
 */
public interface BaseMvp<M extends Model, V extends View, P extends BasePresenter> {
    M createModel();

    V createView();

    P createPresenter();
}
