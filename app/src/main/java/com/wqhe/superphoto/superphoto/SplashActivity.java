package com.wqhe.superphoto.superphoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wqhe.superphoto.superphoto.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：Wq
 * Date：2018/5/14 10:09
 * Description：//todo
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.tv_tonext)
    TextView tvTonext;



    @Override
    protected void init() {

        tvTonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this,MainActivity.class);
               startActivity(intent);

            }
        });
        
        initData();


    }

    private void initData() {




    }

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }


}
