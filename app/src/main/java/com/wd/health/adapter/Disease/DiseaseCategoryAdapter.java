package com.wd.health.adapter.Disease;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.model.bean.DepartmentBean;
import com.wd.health.model.bean.DiseaseCategoryBean;

import java.util.ArrayList;
import java.util.List;

public class DiseaseCategoryAdapter extends RecyclerView.Adapter<DiseaseCategoryAdapter.MyAdapter> {
    Context context;
    List<DiseaseCategoryBean.ResultBean>list=new ArrayList<>();
    private View inflate;

    public DiseaseCategoryAdapter(Context context, List<DiseaseCategoryBean.ResultBean> list) {
        this.context = context;
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.disease_fragment, viewGroup, false);
        return new MyAdapter(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter myAdapter, int i) {
        DiseaseCategoryBean.ResultBean resultBean = list.get(i);
         myAdapter.name.setText(resultBean.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyAdapter extends RecyclerView.ViewHolder {


        private final TextView department;
        private final TextView name;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            department = itemView.findViewById(R.id.tv_department);

        }
    }
}
