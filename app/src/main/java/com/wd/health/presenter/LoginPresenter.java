package com.wd.health.presenter;

import com.wd.health.base.BasePresenter;
import com.wd.health.contract.ILoginContract;
import com.wd.health.model.LoginModel;
import com.wd.health.model.bean.LoginBean;

import java.util.Map;

public class LoginPresenter extends BasePresenter<ILoginContract.IView>implements ILoginContract.IPresenter {

    private LoginModel model;

    @Override
    protected void initModel() {
        model = new LoginModel();
    }

    @Override
    public void login(Map<String, Object> paramsMap) {
         model.login(paramsMap, new ILoginContract.IModel.IModelCallback() {
             @Override
             public void onLoginSuccess(LoginBean loginBean) {
                 getView().onLoginSuccess(loginBean);
             }

             @Override
             public void onLoginFailure(Throwable e) {
                getView().onLoginFailure(e);
             }
         });
    }
}
