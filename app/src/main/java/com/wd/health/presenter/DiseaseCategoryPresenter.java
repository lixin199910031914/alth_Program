package com.wd.health.presenter;

import com.wd.health.base.BasePresenter;
import com.wd.health.contract.DiseaseCategoryContract;
import com.wd.health.model.DiseaseCategoryModel;
import com.wd.health.bean.DepartmentBean;
import com.wd.health.bean.DiseaseCategoryBean;

public class DiseaseCategoryPresenter extends BasePresenter<DiseaseCategoryContract.IView>implements DiseaseCategoryContract.IPresenter {

    private DiseaseCategoryModel model;

    @Override
    protected void initModel() {
        model = new DiseaseCategoryModel();
    }

    @Override
    public void getDepart() {
         model.getDepart(new DiseaseCategoryContract.IModel.DepartCallBack() {
             @Override
             public void DepartSuccess(DepartmentBean departmentBean) {
                 getView().DepartSuccess(departmentBean);
             }

             @Override
             public void DepartErorr(String mag) {
                getView().DepartErorr(mag);
             }
         });
    }

    @Override
    public void getDisease(int path) {
      model.getDisease(path, new DiseaseCategoryContract.IModel.DiseaseCallBack() {
          @Override
          public void DiseaseSuccess(DiseaseCategoryBean diseaseCategoryBean) {
              getView().DiseaseSuccess(diseaseCategoryBean);
          }

          @Override
          public void DiseaseErorr(String mag) {
            getView().DiseaseErorr(mag);
          }
      });
    }
}
