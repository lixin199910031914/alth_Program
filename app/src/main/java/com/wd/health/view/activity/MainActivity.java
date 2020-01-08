package com.wd.health.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wd.health.R;
import com.wd.health.base.BaseActivity;
import com.wd.health.contract.ILoginContract;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.presenter.LoginPresenter;

import java.util.HashMap;

import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter>implements ILoginContract.IView {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected LoginPresenter ProvidePresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Log.i("TAG", "登录成功: " + loginBean.toString());
        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Throwable e) {
        Log.i("TAG", "登录失败: " + e.toString());
        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }
@OnClick(R.id.btn_login)
    public void onViewClicked() {
        //去登录
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("phone", "15501186660");
        paramsMap.put("pwd", "123456");
        mPresenter.login(paramsMap);
    }
}
