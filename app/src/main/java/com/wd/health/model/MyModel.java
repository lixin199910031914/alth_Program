package com.wd.health.model;

import com.wd.health.bean.DepartmentBean;
import com.wd.health.bean.JianKangBean;
import com.wd.health.contract.MyContract;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

public class MyModel implements MyContract.IModel {
    @Override
    public void getJianKang(MyCallback myCallback) {
        RetrofitManager.getInstance().create()
                .getJianKang()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<JianKangBean>() {
                    @Override
                    public void onNext(JianKangBean jianKangBean) {
                        myCallback.onJianKangSuccess(jianKangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallback.onFailure(e);
                    }
                });
    }
}
