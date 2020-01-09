package com.wd.health.fragment;

import com.wd.health.R;
import com.wd.health.base.BaseFragment;
import com.wd.health.base.BasePresenter;

public class ShowFragment extends BaseFragment {
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.show_fragment;
    }
}
