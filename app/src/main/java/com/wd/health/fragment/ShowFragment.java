package com.wd.health.fragment;
/**
 *@describe(描述)：ShowFragment
 *@data（日期）: 2020/1/9 0009
 *@time（时间）: 下午 3:13
 *@author（作者）: 李昕
 **/
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wd.health.R;
import com.wd.health.adapter.ShowAdapter;
import com.wd.health.base.BaseFragment;
import com.wd.health.contract.BannerContract;
import com.wd.health.bean.BannerBean;
import com.wd.health.bean.ConsultingListBean;
import com.wd.health.bean.DrugBean;
import com.wd.health.bean.HealthBean;
import com.wd.health.bean.KeListBean;
import com.wd.health.bean.SymptomBean;
import com.wd.health.presenter.BannerPresenter;

import java.util.List;

public class ShowFragment extends BaseFragment< BannerPresenter> implements BannerContract.IView {

    private List<KeListBean.ResultBean> result02;
    private List<BannerBean.ResultBean> result01;
    private List<HealthBean.ResultBean> result03;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void initView() {
        super.initView();
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = getView().findViewById(R.id.show_recycler_view_01);
    }

    @Override
    protected void initData() {
        super.initData();
        if (mPresenter != null) {
        mPresenter.getBanner();
        mPresenter.getHealthSeccess();
        mPresenter.getKeList();
        }
    }

    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.show_fragment;
    }

    @Override
    public void BannerSuccess(BannerBean bannerBean) {
        result01 = bannerBean.getResult();

    }

    @Override
    public void SymptomSuccess(SymptomBean symptomBean) {
        List<SymptomBean.ResultBean> result = symptomBean.getResult();
    }
    @Override
    public void DrugSeccess(DrugBean drugBean) {

    }
    @Override
    public void KeLianSeccess(KeListBean listBean) {
        result02 = listBean.getResult();

    }
    @Override
    public void HealthSeccess(HealthBean healthBean) {
        result03 = healthBean.getResult();
        ShowAdapter showAdapter = new ShowAdapter(result01, result02, result03, getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(showAdapter);
    }
    @Override
    public void CondultingSeccess(ConsultingListBean consultingListBean) {

    }
    @Override
    public void BannerFailure(String mag) {

    }


}
