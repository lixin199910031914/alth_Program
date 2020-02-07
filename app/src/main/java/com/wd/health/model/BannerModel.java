
package com.wd.health.model;

import com.wd.health.contract.BannerContract;
import com.wd.health.bean.BannerBean;
import com.wd.health.bean.ConsultingListBean;
import com.wd.health.bean.DrugBean;
import com.wd.health.bean.HealthBean;
import com.wd.health.bean.KeListBean;
import com.wd.health.bean.SymptomBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

public class BannerModel  implements BannerContract.IModdel {
    @Override
    public void getBanner( BannerCallBack bannerCallBack) {
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

    @Override
    public void getSymptomSuccess(BannerCallBack bannerCallBack) {
        RetrofitManager.getInstance().create()
                .getSymptom().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SymptomBean>() {
                    @Override
                    public void onNext(SymptomBean symptomBean) {
                        bannerCallBack.SymptomSuccess(symptomBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        bannerCallBack.BannerFailure(e.getMessage());
                    }
                });
    }

    @Override
    public void getDrug(int drugsCategoryId, int page, int count, BannerCallBack bannerCallBack) {
        RetrofitManager.getInstance().create()
                .getDrug(drugsCategoryId,page,count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DrugBean>() {
                    @Override
                    public void onNext(DrugBean drugBean) {
                        bannerCallBack.DrugSeccess(drugBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        bannerCallBack.BannerFailure(e.getMessage());
                    }
                });
    }

    @Override
    public void getKeList(BannerCallBack bannerCallBack) {
        RetrofitManager.getInstance().create()
                .getKeLian().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<KeListBean>() {
                    @Override
                    public void onNext(KeListBean keListBean) {
                        bannerCallBack.KeLianSeccess(keListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        bannerCallBack.BannerFailure(e.getMessage());
                    }
                });
    }

    @Override
    public void getHealthSeccess(BannerCallBack bannerCallBack) {
        RetrofitManager.getInstance().create()
                .getHealthBean().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<HealthBean>() {
                    @Override
                    public void onNext(HealthBean healthBean) {
                        bannerCallBack.HealthSeccess(healthBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        bannerCallBack.BannerFailure(e.getMessage());
                    }
                });
    }

    @Override
    public void getConsulting(int plateId, int page, int count, BannerCallBack bannerCallBack) {
        RetrofitManager.getInstance().create()
                .getConsultingList(plateId,page,count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ConsultingListBean>() {
                    @Override
                    public void onNext(ConsultingListBean consultingListBean) {
                        bannerCallBack.CondultingSeccess(consultingListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        bannerCallBack.BannerFailure(e.getMessage());
                    }
                });
    }
}