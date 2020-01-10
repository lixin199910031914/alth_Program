package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.BannerBean;
import com.wd.health.model.bean.ConsultingListBean;
import com.wd.health.model.bean.DrugBean;
import com.wd.health.model.bean.HealthBean;
import com.wd.health.model.bean.KeListBean;
import com.wd.health.model.bean.SymptomBean;

public interface BannerContract {
        interface IView extends IBaseView {
                void BannerSuccess(BannerBean bannerBean);
                void  SymptomSuccess(SymptomBean symptomBean);
                void DrugSeccess(DrugBean drugBean);
                void KeLianSeccess(KeListBean listBean);
                void HealthSeccess(HealthBean healthBean);
                void CondultingSeccess(ConsultingListBean consultingListBean);
                void BannerFailure(String mag);
        }
        interface IModdel{
            void getBanner(BannerCallBack bannerCallBack);
            void getSymptomSuccess(BannerCallBack bannerCallBack);
            void getDrug(int drugsCategoryId,int page, int count,BannerCallBack bannerCallBack);
            void getKeList(BannerCallBack bannerCallBack);
            void getHealthSeccess(BannerCallBack bannerCallBack);
            void getConsulting(int plateId,int page,int count,BannerCallBack bannerCallBack);
            interface BannerCallBack{
                void BannerSuccess(BannerBean bannerBean);
                void  SymptomSuccess(SymptomBean symptomBean);
                void DrugSeccess(DrugBean drugBean);
                void KeLianSeccess(KeListBean listBean);
                void HealthSeccess(HealthBean healthBean);
                void CondultingSeccess(ConsultingListBean consultingListBean);
                void BannerFailure(String mag);
            }
        }
        interface IPresenter{
            void getBanner();
            void  Symptom();
            void getDrug(int drugsCategoryId, int page, int count);
            void getKeList();
            void getHealthSeccess();
            void getConsulting(int plateId, int page, int count);
        }

}
