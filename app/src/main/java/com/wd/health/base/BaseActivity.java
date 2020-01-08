package com.wd.health.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wd.health.utils.NetUtil;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected  P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
          mPresenter = ProvidePresenter();
        if (mPresenter!=null) {
            mPresenter.attchView(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int provideLayoutId();


    protected abstract P ProvidePresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null) {
            mPresenter.detachView();
        }
    }
    //判断网络
    public boolean hasNetwork(){
        return NetUtil.hasNetwork(this);
    }
    public void showNoNetTip() {
        Toast.makeText(BaseActivity.this, "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context(){
        return this;
    }
}
