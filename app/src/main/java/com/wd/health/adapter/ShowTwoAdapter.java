package com.wd.health.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.model.bean.KeListBean;

import java.util.List;

public class ShowTwoAdapter extends RecyclerView.Adapter <ShowTwoAdapter.TwoHolder>{
    List<KeListBean.ResultBean> result02;
    Context context;
    private View inflate;

    public ShowTwoAdapter(List<KeListBean.ResultBean> result02, Context context) {
        this.result02 = result02;
        this.context = context;
    }


    @NonNull
    @Override
    public TwoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.showitem_two_01, viewGroup, false);
        return new TwoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TwoHolder twoHolder, int i) {
        twoHolder.simpleDraweeVie.setImageURI(result02.get(i).getPic());
        twoHolder.textView.setText(result02.get(i).getDepartmentName());
    }

    @Override
    public int getItemCount() {
        return result02.size();
    }

    class TwoHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeVie;
        private final TextView textView;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeVie = inflate.findViewById(R.id.show_image_01);
            textView = inflate.findViewById(R.id.show_name_02);
        }
    }
}
