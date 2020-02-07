package com.wd.health.utils;


import com.wd.health.app.Constant;
import com.wd.health.api.IApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private Retrofit mRetrofit;
    private static final String BASE_URL = Constant.BASE_URL;
    private IApi mIApi;

    private static final class SingleHolder {
        private static final RetrofitManager _INSTANCE = new RetrofitManager(BASE_URL);
    }

    public static RetrofitManager getInstance() {
        return SingleHolder._INSTANCE;
    }

    private RetrofitManager(String url) {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .client(buildOkhttpClient())
                .build();
    }

    private OkHttpClient buildOkhttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    public <T> T create(final Class<T> service) {
        return mRetrofit.create(service);
    }


    public IApi create() {
        if (mIApi == null) {
            mIApi = create(IApi.class);
        }
        return mIApi;
    }

}
