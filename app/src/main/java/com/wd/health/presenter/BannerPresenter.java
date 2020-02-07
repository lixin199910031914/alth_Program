
package com.wd.health.presenter;

import com.wd.health.base.BasePresenter;
import com.wd.health.contract.BannerContract;
import com.wd.health.model.BannerModel;
import com.wd.health.bean.BannerBean;
import com.wd.health.bean.ConsultingListBean;
import com.wd.health.bean.DrugBean;
import com.wd.health.bean.HealthBean;
import com.wd.health.bean.KeListBean;
import com.wd.health.bean.SymptomBean;

public class BannerPresenter extends BasePresenter<BannerContract.IView>implements BannerContract.IPresenter {

    private BannerModel bannerModel;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
    }

    @Override
    public void getBanner() {
           bannerModel.getBanner( new BannerContract.IModdel.BannerCallBack() {
               @Override
               public void BannerSuccess(BannerBean bannerBean) {
                   getView().BannerSuccess(bannerBean);
               }

               @Override
               public void SymptomSuccess(SymptomBean symptomBean) {

               }

               @Override
               public void DrugSeccess(DrugBean drugBean) {

               }

               @Override
               public void KeLianSeccess(KeListBean listBean) {

               }

               @Override
               public void HealthSeccess(HealthBean healthBean) {

               }

               @Override
               public void CondultingSeccess(ConsultingListBean consultingListBean) {

               }

               @Override
               public void BannerFailure(String mag) {
                   getView().BannerFailure(mag);
               }
           });
    }

    @Override
    public void Symptom() {
        bannerModel.getSymptomSuccess( new BannerContract.IModdel.BannerCallBack() {
            @Override
            public void BannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void SymptomSuccess(SymptomBean symptomBean) {
                getView().SymptomSuccess(symptomBean);
            }

            @Override
            public void DrugSeccess(DrugBean drugBean) {

            }

            @Override
            public void KeLianSeccess(KeListBean listBean) {

            }

            @Override
            public void HealthSeccess(HealthBean healthBean) {

            }

            @Override
            public void CondultingSeccess(ConsultingListBean consultingListBean) {

            }

            @Override
            public void BannerFailure(String mag) {
                getView().BannerFailure(mag);
            }
        });
    }

    @Override
    public void getDrug(int drugsCategoryId, int page, int count) {
        bannerModel.getDrug(drugsCategoryId,page,count, new BannerContract.IModdel.BannerCallBack() {
            @Override
            public void BannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void SymptomSuccess(SymptomBean symptomBean) {

            }

            @Override
            public void DrugSeccess(DrugBean drugBean) {
                getView().DrugSeccess(drugBean);
            }

            @Override
            public void KeLianSeccess(KeListBean listBean) {

            }

            @Override
            public void HealthSeccess(HealthBean healthBean) {

            }

            @Override
            public void CondultingSeccess(ConsultingListBean consultingListBean) {

            }

            @Override
            public void BannerFailure(String mag) {
                getView().BannerFailure(mag);
            }
        });
    }

    @Override
    public void getKeList() {
        bannerModel.getKeList(new BannerContract.IModdel.BannerCallBack() {
            @Override
            public void BannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void SymptomSuccess(SymptomBean symptomBean) {

            }

            @Override
            public void DrugSeccess(DrugBean drugBean) {

            }

            @Override
            public void KeLianSeccess(KeListBean listBean) {
                getView().KeLianSeccess(listBean);
            }

            @Override
            public void HealthSeccess(HealthBean healthBean) {

            }

            @Override
            public void CondultingSeccess(ConsultingListBean consultingListBean) {

            }

            @Override
            public void BannerFailure(String mag) {
                getView().BannerFailure(mag);
            }
        });
    }

    @Override
    public void getHealthSeccess() {
        bannerModel.getHealthSeccess(new BannerContract.IModdel.BannerCallBack() {
            @Override
            public void BannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void SymptomSuccess(SymptomBean symptomBean) {

            }

            @Override
            public void DrugSeccess(DrugBean drugBean) {

            }

            @Override
            public void KeLianSeccess(KeListBean listBean) {

            }

            @Override
            public void HealthSeccess(HealthBean healthBean) {
                getView().HealthSeccess(healthBean);
            }

            @Override
            public void CondultingSeccess(ConsultingListBean consultingListBean) {

            }

            @Override
            public void BannerFailure(String mag) {
                getView().BannerFailure(mag);
            }
        });
    }
    @Override
    public void getConsulting(int plateId, int page, int count) {
        bannerModel.getConsulting(plateId,page,count,new BannerContract.IModdel.BannerCallBack() {
            @Override
            public void BannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void SymptomSuccess(SymptomBean symptomBean) {

            }

            @Override
            public void DrugSeccess(DrugBean drugBean) {

            }

            @Override
            public void KeLianSeccess(KeListBean listBean) {

            }

            @Override
            public void HealthSeccess(HealthBean healthBean) {

            }

            @Override
            public void CondultingSeccess(ConsultingListBean consultingListBean) {
                getView().CondultingSeccess(consultingListBean);
            }

            @Override
            public void BannerFailure(String mag) {
                getView().BannerFailure(mag);
            }
        });
    }
}