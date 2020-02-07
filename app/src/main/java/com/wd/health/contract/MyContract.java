package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.bean.JianKangBean;
import com.wd.health.bean.LoginBean;

import java.util.Map;

public interface MyContract {
    interface IView extends IBaseView {
        void onJianKangSuccess(JianKangBean jianKangBean);
        void onFailure(Throwable e);
    }
    interface IPresenter{
        void getJianKang();
    }
    interface IModel{
        void getJianKang(MyCallback myCallback);
        interface MyCallback {
            void onJianKangSuccess(JianKangBean jianKangBean);
            void onFailure(Throwable e);
        }
    }
}
