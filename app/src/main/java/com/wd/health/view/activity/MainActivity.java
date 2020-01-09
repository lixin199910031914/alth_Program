package com.wd.health.view.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.health.R;
import com.wd.health.base.BaseActivity;
import com.wd.health.contract.ILoginContract;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.presenter.LoginPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.OnClick;

public class MainActivity extends Activity {
    private ViewPager viewPager;
    private int[]images={R.drawable.xiaowu,R.drawable.xiaoer,R.drawable.xiaosan,R.drawable.xiaosier,R.drawable.xiaoliuer};
    private List<ImageView> imageViews;//用来存放几个imageview的实例
    private LinearLayout li;
    private RelativeLayout rl;
    private ImageView red_Iv;
    private int left;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        li=(LinearLayout) findViewById(R.id.linear);
        rl=(RelativeLayout) findViewById(R.id.rl);
        btn=(Button) findViewById(R.id.btn);
        viewPager.setAdapter(new MyAdapter());
        imageViews=new ArrayList<ImageView>();
        for(int i=0;i<images.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            imageViews.add(imageView);
            ImageView gray_Iv=new ImageView(this);
            gray_Iv.setImageResource(R.drawable.gray_circle);
            //使用LayoutParams改变控件的位置
            LinearLayout.LayoutParams layoutParams=
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i>0){
                layoutParams.leftMargin=20;
            }
            gray_Iv.setLayoutParams(layoutParams);
            li.addView(gray_Iv);
        }
        red_Iv=new ImageView(this);
        red_Iv.setImageResource(R.drawable.red_circle);
        rl.addView(red_Iv);
        //示图树
        red_Iv.getViewTreeObserver().
                addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    //该方法就是在界面全面绘制结束之后回调
                    @SuppressLint("NewApi")
                    @Override
                    public void onGlobalLayout() {
                        // TODO Auto-generated method stub
                        //求距离
                        left=li.getChildAt(1).getLeft()-li.getChildAt(0).getLeft();
                        System.out.println("left为"+left);
                        red_Iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                if(position==images.length-1){
                    btn.setVisibility(View.VISIBLE);
                }else{
                    btn.setVisibility(View.GONE);
                }
            }
            //滑动的时候
            @Override
            public void onPageScrolled(int position, float posionOffset, int arg2) {
                // TODO Auto-generated method stub
                System.out.println(posionOffset);//滑动的百分比
                RelativeLayout.LayoutParams layoutParams=
                        (RelativeLayout.LayoutParams)red_Iv.getLayoutParams();
                layoutParams.leftMargin=(int)(left*posionOffset+position*left);
                red_Iv.setLayoutParams(layoutParams);
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });

        //跳转到主界面
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.length;
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0==arg1;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View)object);
        }
    }
}

