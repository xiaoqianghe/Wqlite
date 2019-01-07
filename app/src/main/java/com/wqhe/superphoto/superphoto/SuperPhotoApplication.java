package com.wqhe.superphoto.superphoto;

import android.app.Application;
import android.content.Context;
import android.content.RestrictionEntry;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.tencent.bugly.crashreport.CrashReport;
import com.wqhe.superphoto.superphoto.ui.push.PushUtil;
import com.wqhe.superphoto.superphoto.utils.DensityUtils;
import com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils.GlideLoader;
import com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils.ImageLoader;
import com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils.PicassoLoader;

import org.litepal.LitePal;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Author：Wq
 * Date：2018/5/15 17:43
 * Description：//todo
 */

public class SuperPhotoApplication extends Application{

    public static SuperPhotoApplication gApp;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        gApp=this;

        initData();

        //初始化图片库
//        ImageLoader.getInstance().setImageLoader(new PicassoLoader());


        ImageLoader.getInstance().setImageLoader(new GlideLoader());

        LitePal.initialize(this);//LitePal  数据库 初始化


        MultiDex.install(base);


        Utils.init(this);//工具类 初始化



        //数据统计初始化
        if(BuildConfig.DEBUG){
            CrashReport.initCrashReport(getApplicationContext(), "a0910659d9", true);
        }else{
            CrashReport.initCrashReport(getApplicationContext(), "8f02d2d7b0", false);
        }

        //极光推送的初始化
//        PushUtil.init(this);



//        initRealm();




    }

    private void initData() {

//        DensityUtils.setDensity(this);//屏幕适配初始化
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }





}
