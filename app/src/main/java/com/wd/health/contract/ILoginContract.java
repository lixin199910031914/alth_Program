package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.bean.LoginBean;

import java.util.Map;

public interface ILoginContract {
    interface IView extends IBaseView{
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable e);
    }
     interface IPresenter{
        void login(Map<String,Object> paramsMap);
     }
     interface IModel{
         void login(Map<String, Object> paramsMap, IModelCallback callback);
         interface IModelCallback {
             void onLoginSuccess(LoginBean loginBean);

             void onLoginFailure(Throwable e);
         }
     }
}
