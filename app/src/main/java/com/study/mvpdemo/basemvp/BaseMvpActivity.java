package com.study.mvpdemo.basemvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhb on 2019/4/18.
 * <p>
 * 这是Activity基类（只是对我们MVP框架来说，我们完全可以在项目中再写一个BaseActivity来继承它，实现基类真正的功能），
 * 我们以后所写的Activity都要继承它，并实现它的抽象方法和BaseMvp中的接口。它的主要功能就是创建Model、View、Presenter层并注册。
 * 这里我们也看到了上面提到的BasePresenter中destroy()方法具体调用的地方，就是在Activity中的onDestroy()中。
 */
public abstract class BaseMvpActivity<M extends Model, V extends View, P extends BasePresenter> extends AppCompatActivity implements BaseMvp<M, V, P> {
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建Presenter
        presenter = createPresenter();
        if (presenter != null) {
            //将Model层注册到Presenter中
            presenter.registerModel(createModel());
            //将View层注册到Presenter中
            presenter.registerView(createView());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //Activity销毁时的调用，让具体实现BasePresenter中onViewDestroy()方法做出决定
            presenter.destroy();
        }
    }
}
