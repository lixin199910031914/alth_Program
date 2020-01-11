package com.wd.health.adapter.Disease;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.fragment.CircleOfFriendsFragment;
import com.wd.health.model.bean.DepartmentBean;

import java.util.ArrayList;
import java.util.List;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.MyAdapter> {
    Context context;
    List<DepartmentBean.ResultBean>list=new ArrayList<>();
    private View inflate;

    public DiseaseAdapter(Context context, List<DepartmentBean.ResultBean> list) {
        this.context = context;
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.depart_fragment, viewGroup, false);

        return new MyAdapter(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter myAdapter, int i) {
        DepartmentBean.ResultBean resultBean = list.get(i);
        myAdapter.name.setText(resultBean.getDepartmentName());
        myAdapter.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iCallBack.getId(resultBean.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyAdapter extends RecyclerView.ViewHolder {

        private final TextView name;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_departname);
        }
    }
    public   interface ICallBack{
        void  getId(int id);
    }
    public    ICallBack iCallBack;

    public void setiCallBack(ICallBack iCallBack) {
        this.iCallBack = iCallBack;
    }
}
