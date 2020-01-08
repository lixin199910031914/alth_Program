package com.wd.health.model.api;

import com.wd.health.model.bean.BannerBean;
import com.wd.health.model.bean.LoginBean;

import java.util.Map;
import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApi {
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> login(@FieldMap Map<String, Object> map);

     @GET("share/v1/bannersShow")
     Observable<BannerBean> getBanner();
}
