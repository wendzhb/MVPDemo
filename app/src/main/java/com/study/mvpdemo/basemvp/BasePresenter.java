package com.study.mvpdemo.basemvp;

import java.lang.ref.WeakReference;

/**
 * Created by zhb on 2019/4/18.
 * <p>
 * BasePresenter是我们要直接继承使用的Presenter层父类，它实现了Presenter接口中的抽象方法，并且为了防止内存泄漏，
 * 我们View层的引用要使用弱引用。
 * <p>
 * 在MVP模式中，内存泄漏的主要原因是由于当前View层（如Activity或者Fragment）在卸载时，
 * Model层中仍有业务没有结束（如子线程未完成、网络请求超时等），而这里的Presenter层中拥有Mode层和View层的引用，
 * 所以Presenter层也暂时无法释放，最终导致View的引用也没有释放，我们的Activity或者Fragment就算时销毁了，
 * GC也无法回收它们，因为还有引用在指向它们呢。
 * <p>
 * 我们也不必非要使用弱引用来维护View层，其实在View层卸载时，只要主动让指向View的引用为空，也可以让Activity或者Fragment顺利回收，
 * 而且在View卸载时我们也可以选择是否停止当前Model层的业务，在BasePresenter类中，我们也同样实现了这个逻辑，就是destroy()方法，
 * 它通过调用onViewDestroy()来让具体实现这个方法的类来完成相应的业务逻辑。
 */
public abstract class BasePresenter<M extends Model, V extends View> implements Presenter<M, V> {

    /**
     * 使用弱引用来防止内存泄漏
     */
    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        wrf = new WeakReference<>(view);
    }

    @Override
    public V getView() {
        return wrf == null ? null : wrf.get();
    }

    /**
     * 在Activity或Fragment卸载时调用View结束的方法
     */
    @Override
    public void destroy() {
        if (wrf != null) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }

    protected abstract void onViewDestroy();
}
