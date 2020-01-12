package com.wd.health.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.wd.health.R;
import com.wd.health.adapter.Disease.DiseaseAdapter;
import com.wd.health.adapter.Disease.DiseaseCategoryAdapter;
import com.wd.health.base.BaseFragment;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.DiseaseCategoryContract;
import com.wd.health.model.bean.DepartmentBean;
import com.wd.health.model.bean.DiseaseCategoryBean;
import com.wd.health.presenter.DiseaseCategoryPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.OnClick;

public class CircleOfFriendsFragment extends BaseFragment<DiseaseCategoryPresenter> implements DiseaseCategoryContract.IView {
    private static final String TAG = "CircleOfFriendsFragment";
    private RecyclerView rlv;
    private RecyclerView rlv2;


    @Override
    protected int provideLayoutId() {
        return R.layout.circle_fragment;

    }

    @Override
    protected DiseaseCategoryPresenter providePresenter() {
        return new DiseaseCategoryPresenter();

    }

    @Override
    protected void initView() {
        super.initView();
         rlv = getView().findViewById(R.id.rlv);
         rlv2 = getView().findViewById(R.id.rlv2);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        this.rlv.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        this.rlv2.setLayoutManager(linearLayoutManager1);
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("Id",1 );
        Log.d(TAG, "initData: "+id);
        mPresenter.getDepart();

    }

    @Override
    public void DepartSuccess(DepartmentBean departmentBean) {
        List<DepartmentBean.ResultBean> result = departmentBean.getResult();
        DiseaseAdapter diseaseAdapter = new DiseaseAdapter(getContext(), result);
        rlv.setAdapter(diseaseAdapter);
        diseaseAdapter.setiCallBack(new DiseaseAdapter.ICallBack() {
            @Override
            public void getId(int id) {
                mPresenter.getDisease(id);
            }
        });

    }

    @Override
    public void DepartErorr(String mag) {

    }

    @Override
    public void DiseaseSuccess(DiseaseCategoryBean diseaseCategoryBean) {
        List<DiseaseCategoryBean.ResultBean> result = diseaseCategoryBean.getResult();
        DiseaseCategoryAdapter diseaseCategoryAdapter = new DiseaseCategoryAdapter(getContext(), result);
        rlv2.setAdapter(diseaseCategoryAdapter);

    }

    @Override
    public void DiseaseErorr(String mag) {

    }

}
