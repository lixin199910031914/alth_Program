package com.wd.health.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.model.bean.BannerBean;
import com.wd.health.model.bean.HealthBean;
import com.wd.health.model.bean.KeListBean;
import com.wd.health.model.bean.SymptomBean;
import com.wd.health.view.activity.FourActivity;
import com.wd.health.view.activity.ShowTwoActivity;
import com.xuezj.cardbanner.CardBanner;
import com.xuezj.cardbanner.ImageData;
import com.xuezj.cardbanner.imageloader.CardImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList list= new ArrayList();
    final  static int TYPE=0;
    final  static int TYPE_ONE=1;
    final  static int TYPE_TWO=2;
    final  static int TYPE_Thrww=3;
    final  static  int TYPE_FOUR=4;
    List<BannerBean.ResultBean> result01;
    List<KeListBean.ResultBean> result02;
    List<HealthBean.ResultBean> result03;
    Context context;
    private View inflate01;
    private View inflate02;
    private View inflate03;
    private View inflate04;
    private View inflate05;

    public ShowAdapter(List<BannerBean.ResultBean> result01, List<KeListBean.ResultBean> result02, List<HealthBean.ResultBean> result03, Context context) {
        this.result01 = result01;
        this.result02 = result02;
        this.result03 = result03;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType==TYPE) {
            inflate01 = LayoutInflater.from(context).inflate(R.layout.show_item_01, viewGroup, false);
            return new OneHolder(inflate01);
        }else if (viewType==TYPE_ONE){
            inflate02 = LayoutInflater.from(context).inflate(R.layout.show_item_02, viewGroup, false);
            return new TwoHolder(inflate02);
        }else if (viewType==TYPE_TWO){
            inflate03 = LayoutInflater.from(context).inflate(R.layout.show_item_03, viewGroup, false);
            return new ThreeHolder(inflate03);
        }else if (viewType==TYPE_Thrww){
            inflate04 = LayoutInflater.from(context).inflate(R.layout.show_item_04, viewGroup, false);
            return new FourHolder(inflate04);
        }else if (viewType==TYPE_FOUR){
            inflate05 = LayoutInflater.from(context).inflate(R.layout.show_item_05, viewGroup, false);
            return new FiveHolder(inflate05);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==TYPE) {
            if (result01 != null) {
                if (viewHolder instanceof OneHolder){
                    for (int i = 0; i < result01.size(); i++) {
                        String imageUrl = result01.get(i).getImageUrl();
                        ImageData imageData = new ImageData();
                        imageData.setImage(imageUrl);
                        list.add(imageData);
                    }
                    ((OneHolder) viewHolder).banner.setDatas(list).setCardImageLoader(new CardImageLoader() {
                        @Override
                        public void load(Context context, ImageView imageView, Object path) {
                            Glide.with(context).load(path).into(imageView);
                        }
                    }).setPlay(true).start();
                }
            }
        }else if (itemViewType==TYPE_ONE){
        if (viewHolder instanceof TwoHolder){
                ((TwoHolder) viewHolder).relativeLayout01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ShowTwoActivity.class);
                        context.startActivity(intent);
                    }
                });
        }

        }else if (itemViewType==TYPE_TWO){
            if (result02 != null) {
                if (viewHolder instanceof ThreeHolder){
                    GridLayoutManager linearLayoutManager = new GridLayoutManager(context,4);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    ((ThreeHolder) viewHolder).recyclerView.setLayoutManager(linearLayoutManager);
                    ShowTwoAdapter showTwoAdapter = new ShowTwoAdapter(result02, context);
                    ((ThreeHolder) viewHolder).recyclerView.setAdapter(showTwoAdapter);
                }
            }
        }else if (itemViewType==TYPE_Thrww){
        if (viewHolder instanceof FourHolder){
            ((FourHolder) viewHolder).imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FourActivity.class);
                    context.startActivity(intent);
                }
            });
        }


        }else if (itemViewType==TYPE_FOUR){
            if (result03 != null) {
                if (viewHolder instanceof FiveHolder){
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    ((FiveHolder) viewHolder).textView.setText(result03.get(position).getName());
                    ((FiveHolder) viewHolder).recyclerView.setLayoutManager(linearLayoutManager);

                }
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE;
        }else if (position==1){
            return TYPE_ONE;
        }else if (position==2){
            return TYPE_TWO;
        }else if (position==3){
            return TYPE_Thrww;
        }else  if (TYPE_FOUR==4){
            return TYPE_FOUR;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return 5;
    }
    class OneHolder extends RecyclerView.ViewHolder {

        private final CardBanner banner;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            banner = inflate01.findViewById(R.id.show_char_banner);
        }
    }
    class TwoHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout relativeLayout02;
        private final RelativeLayout relativeLayout01;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout01 = inflate02.findViewById(R.id.relativelayout_01);
            relativeLayout02 = inflate02.findViewById(R.id.relativelayout_02);
         }
    }
    class ThreeHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public ThreeHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = inflate03.findViewById(R.id.show_recycler_view_03);
        }
    }
    class FourHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public FourHolder(@NonNull View itemView) {
            super(itemView);
            imageView = inflate04.findViewById(R.id.image_view);
        }
    }
    class FiveHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final RecyclerView recyclerView;

        public FiveHolder(@NonNull View itemView) {
            super(itemView);
            textView = inflate05.findViewById(R.id.show_name_01);
            recyclerView = inflate05.findViewById(R.id.show_recycler_view_02);
        }
    }
}
