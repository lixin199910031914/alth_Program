package com.wd.health.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.adapter.Disease.DiseaseAdapter;
import com.wd.health.adapter.Disease.DiseaseCategoryAdapter;
import com.wd.health.base.BaseFragment;
import com.wd.health.bean.DepartmentBean;
import com.wd.health.bean.DiseaseCategoryBean;
import com.wd.health.contract.DiseaseCategoryContract;
import com.wd.health.presenter.DiseaseCategoryPresenter;

import java.util.List;

public class DiseaseFragment extends BaseFragment<DiseaseCategoryPresenter> implements DiseaseCategoryContract.IView {
    private static final String TAG = "CircleOfFriendsFragment";




    @Override
    protected int provideLayoutId() {
        return R.layout.disease_fragment;

    }

    @Override
    protected DiseaseCategoryPresenter providePresenter() {
        return new DiseaseCategoryPresenter();

    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {


    }

    @Override
    public void DepartSuccess(DepartmentBean departmentBean) {
    }

    @Override
    public void DepartErorr(String mag) {
    }

    @Override
    public void DiseaseSuccess(DiseaseCategoryBean diseaseCategoryBean) {
    }

    @Override
    public void DiseaseErorr(String mag) {
    }

}
