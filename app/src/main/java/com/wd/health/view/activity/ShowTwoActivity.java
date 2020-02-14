package com.wd.health.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wd.health.R;
import com.wd.health.fragment.DiseaseFragment;
import com.wd.health.fragment.DrugFragment;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class ShowTwoActivity extends AppCompatActivity {
    private int yaopin;
    private TabLayout showTab;
    private ViewPager shwo_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_two);
        showTab = findViewById(R.id.show_tab);
        shwo_vp = findViewById(R.id.shwo_vp);
        Intent intent = getIntent();
        yaopin = intent.getIntExtra("yaopin", 0);
        final ArrayList<Fragment> list = new ArrayList<>();
        final ArrayList<String> tablist = new ArrayList<>();
        list.add(new DiseaseFragment());
        list.add(new DrugFragment());
        tablist.add("常见病症");
        tablist.add("常用药品");
        shwo_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position);
            }
        });

        if (yaopin!=0){
            shwo_vp.setCurrentItem(2);
        }
        showTab.setupWithViewPager(shwo_vp);
        showTab.setSelectedTabIndicatorHeight(0);
    }
}
