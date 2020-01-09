package com.wd.health.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.wd.health.R;
import com.wd.health.fragment.CircleOfFriendsFragment;
import com.wd.health.fragment.MyFragment;
import com.wd.health.fragment.ShowFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager pager;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pager = findViewById(R.id.buttom_pager);
        group = findViewById(R.id.buttom_group);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShowFragment());
        fragments.add(new CircleOfFriendsFragment());
        fragments.add(new MyFragment());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            group.check(group.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.buttom_img_01:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.buttom_img_02:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.buttom_img_03:
                        pager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
