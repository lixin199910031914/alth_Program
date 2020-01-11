package com.wd.health.model.api;

import com.wd.health.model.bean.DepartmentBean;
import com.wd.health.model.bean.DiseaseCategoryBean;
import com.wd.health.model.bean.LoginBean;

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

}
