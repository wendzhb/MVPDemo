package com.study.mvpdemo.basemvp;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by zhb on 2019/4/18.
 * <p>
 * 这是Fragment基类，基本上和BaseMvpActivity类如出一辙。
 */
public abstract class BaseMvpFragment<M extends Model, V extends View, P extends BasePresenter> extends Fragment implements BaseMvp<M, V, P> {
    protected P presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        presenter = createPresenter();
        if (presenter != null) {
            presenter.registerModel(createModel());
            presenter.registerView(createView());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
