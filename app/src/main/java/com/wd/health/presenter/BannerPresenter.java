package com.wd.health.presenter;

import com.wd.health.base.BasePresenter;
import com.wd.health.contract.BannerContract;
import com.wd.health.model.BannerModel;
import com.wd.health.model.bean.BannerBean;

public class BannerPresenter extends BasePresenter<BannerContract.IView>implements BannerContract.IPresenter {

    private BannerModel bannerModel;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
    }

    @Override
    public void getBanner(String path) {
           bannerModel.getBanner(path, new BannerContract.IModdel.BannerCallBack() {
               @Override
               public void BannerSuccess(BannerBean bannerBean) {
                   getView().BannerSuccess(bannerBean);
               }

               @Override
               public void BannerFailure(String mag) {
                   getView().BannerFailure(mag);
               }
           });
    }
}
