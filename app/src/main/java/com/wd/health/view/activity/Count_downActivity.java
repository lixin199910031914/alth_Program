package com.wd.health.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.wd.health.R;

public class Count_downActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        img = (ImageView) findViewById(R.id.img);

        // 第二种方法
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Count_downActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
