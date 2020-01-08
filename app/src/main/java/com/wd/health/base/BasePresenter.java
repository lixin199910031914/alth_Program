package com.wd.health.base;

import android.content.Context;

import com.wd.health.app.App;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {

    private WeakReference<V> mWeakReference;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected  void attchView(V v){
        mWeakReference = new WeakReference<>(v);
    }
    protected void detachView(){
        if (mWeakReference!=null) {
            mWeakReference.clear();
            mWeakReference=null;
        }
    }
    protected boolean isViewAttached(){
        if (mWeakReference==null || mWeakReference.get()==null) {
            return false;
        }
        return true;
    }
    protected V getView(){
        return mWeakReference.get();
    }
    protected Context context() {
        if (isViewAttached() && getView().context() != null) {
            return getView().context();
        }
        return App.getAppContext();
    }



}
