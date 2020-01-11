package com.wd.health.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ShowTwoAdapter extends RecyclerView.Adapter <ShowTwoAdapter.TwoHolder>{
    @NonNull
    @Override
    public TwoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TwoHolder twoHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class TwoHolder extends RecyclerView.ViewHolder {

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
