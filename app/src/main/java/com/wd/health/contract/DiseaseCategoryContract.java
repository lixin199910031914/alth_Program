package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.bean.DepartmentBean;
import com.wd.health.bean.DiseaseCategoryBean;

public interface DiseaseCategoryContract {
    interface IView extends IBaseView {

        //根据科室查询
        void DepartSuccess(DepartmentBean departmentBean);
        void DepartErorr(String mag);
        //根据科室查询对应病症
        void DiseaseSuccess(DiseaseCategoryBean diseaseCategoryBean);
        void DiseaseErorr(String mag);
    }
    interface IModel{
        //根据科室查询
        void getDepart(DepartCallBack departCallBack);
        //根据科室查询对应病症
        void getDisease(int path,DiseaseCallBack diseaseCallBack);
        interface DiseaseCallBack{
            void DiseaseSuccess(DiseaseCategoryBean diseaseCategoryBean);
            void DiseaseErorr(String mag);
        }
        interface DepartCallBack{
            void DepartSuccess(DepartmentBean departmentBean);
            void DepartErorr(String mag);
        }
    }
    interface IPresenter{
        //根据科室查询
        void getDepart();
        //根据科室查询对应病症
        void getDisease(int path);

    }
}
