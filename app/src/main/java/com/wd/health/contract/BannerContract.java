package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.BannerBean;

public interface BannerContract {
        interface IView extends IBaseView {
                void BannerSuccess(BannerBean bannerBean);
                void BannerFailure(String mag);
        }
        interface IModdel{
            void getBanner(String path,BannerCallBack bannerCallBack);
            interface BannerCallBack{
                void BannerSuccess(BannerBean bannerBean);
                void BannerFailure(String mag);
            }
        }
        interface IPresenter{
            void getBanner(String path);
        }
}
