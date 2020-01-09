package com.wd.health.model;

import com.wd.health.contract.BannerContract;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.BannerBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

import io.reactivex.Observable;

public class BannerModel  implements BannerContract.IModdel {
    @Override
    public void getBanner(String path, BannerCallBack bannerCallBack) {
        RetrofitManager.getInstance().create()
                .getBanner().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        bannerCallBack.BannerSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                           bannerCallBack.BannerFailure(e.getMessage());
                    }
                });

    }
}
