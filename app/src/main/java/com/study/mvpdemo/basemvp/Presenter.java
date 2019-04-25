package com.study.mvpdemo.basemvp;

/**
 * Created by zhb on 2019/4/18.
 * <p>
 * 这里的Presenter接口可能和想象的不太一样，可以看到这里面没有具体的业务逻辑方法，
 * 而是一些注册Mode和View层的抽象方法，在这里我们也可以获取传过来的View和Model，
 * 实际上这个接口更像是一个具有setter和getter的类。
 */
public interface Presenter<M extends Model, V extends View> {
    /**
     * 注册Model层
     *
     * @param model
     */
    void registerModel(M model);

    /**
     * 注册View层
     *
     * @param view
     */
    void registerView(V view);

    /**
     * 获取View
     *
     * @return
     */
    V getView();

    /**
     * 销毁动作（如Activity、Fragment的卸载）
     */
    void destroy();
}
