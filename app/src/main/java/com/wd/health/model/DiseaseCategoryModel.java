package com.wd.health.model;

import com.wd.health.contract.DiseaseCategoryContract;
import com.wd.health.bean.DepartmentBean;
import com.wd.health.bean.DiseaseCategoryBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

public class DiseaseCategoryModel implements DiseaseCategoryContract.IModel {
    @Override
    public void getDepart( DepartCallBack departCallBack) {
        RetrofitManager.getInstance().create()
                .getDepart()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DepartmentBean>() {
                    @Override
                    public void onNext(DepartmentBean departmentBean) {
                        departCallBack.DepartSuccess(departmentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                     departCallBack.DepartErorr(e.getMessage());
                    }
                });
    }
    @Override
    public void getDisease(int path, DiseaseCallBack diseaseCallBack) {
        RetrofitManager.getInstance().create()
                .getDiseaseCategory(path)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DiseaseCategoryBean>() {
                    @Override
                    public void onNext(DiseaseCategoryBean diseaseCategoryBean) {
                         diseaseCallBack.DiseaseSuccess(diseaseCategoryBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        diseaseCallBack.DiseaseErorr(e.getMessage());
                    }
                });
    }
}
