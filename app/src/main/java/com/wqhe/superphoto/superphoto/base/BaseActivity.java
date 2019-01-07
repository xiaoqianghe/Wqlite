package com.wqhe.superphoto.superphoto.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @包名: com.xiaoqianghe.wqplay.ui.activity
 * @类名: BaseActivity
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/27 17:12
 * @描述 : TODO  所有Activity的页面的基类
 */

public abstract class BaseActivity extends AppCompatActivity {



    private Unbinder mUnbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder= ButterKnife.bind(this);

        init();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder!=Unbinder.EMPTY){
            mUnbinder.unbind();

        }
    }

    protected abstract void init();//初始化

    protected abstract int setLayout();//设置布局文件Id






}
