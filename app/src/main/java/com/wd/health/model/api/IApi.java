package com.wd.health.model.api;

import com.wd.health.model.bean.DepartmentBean;
import com.wd.health.model.bean.DiseaseCategoryBean;
import com.wd.health.model.bean.BannerBean;
import com.wd.health.model.bean.ConsultingListBean;
import com.wd.health.model.bean.DrugBean;
import com.wd.health.model.bean.HealthBean;
import com.wd.health.model.bean.KeListBean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.SymptomBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IApi {
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> login(@FieldMap Map<String, Object> map);

    //根据科室查询
    @GET("share/knowledgeBase/v1/findDepartment")
     Observable<DepartmentBean> getDepart();

    @GET("share/knowledgeBase/v1/findDiseaseCategory")
    Observable<DiseaseCategoryBean> getDiseaseCategory(@Query("departmentId")int depatid);

    //banner轮播
     @GET("share/v1/bannersShow")
     Observable<BannerBean> getBanner();
    //症状
    @GET("share/knowledgeBase/v1/findDiseaseCategory")
    Observable<SymptomBean> getSymptom();
    //常见药瓶
    @GET("share/knowledgeBase/v1/findDiseaseCategory")
    Observable<DrugBean> getDrug(@Query("drugsCategoryId") int drugsCategoryId,@Query("page") int page,@Query("count") int count);
    //查询科室列表
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<KeListBean> getKeLian();
    //查询健康资讯板块
    @GET("share/information/v1/findInformationPlateList")
    Observable<HealthBean> getHealthBean();
    //根据资讯板块查询资讯列表
    @GET("share/information/v1/findInformationList")
    Observable<ConsultingListBean> getConsultingList(int plateId,int page, int count);
}
