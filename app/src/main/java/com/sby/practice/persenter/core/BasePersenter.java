package com.sby.practice.persenter.core;

/**
 * Created by kowal on 2016/12/4.
 */

public abstract class BasePersenter<T>
{
    protected T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }
}
