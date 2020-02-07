package com.wd.health.presenter;

import com.wd.health.base.BasePresenter;
import com.wd.health.bean.JianKangBean;
import com.wd.health.bean.LoginBean;
import com.wd.health.contract.ILoginContract;
import com.wd.health.contract.MyContract;
import com.wd.health.model.LoginModel;
import com.wd.health.model.MyModel;

public class MyPresenter extends BasePresenter<MyContract.IView> implements MyContract.IPresenter {


    private MyModel myModel;

    @Override
    protected void initModel() {
        myModel = new MyModel();
    }
    @Override
    public void getJianKang() {
        myModel.getJianKang(new MyContract.IModel.MyCallback() {
            @Override
            public void onJianKangSuccess(JianKangBean jianKangBean) {
                getView().onJianKangSuccess(jianKangBean);
            }
            @Override
            public void onFailure(Throwable e) {
            getView().onFailure(e);
            }
        });
    }
}
