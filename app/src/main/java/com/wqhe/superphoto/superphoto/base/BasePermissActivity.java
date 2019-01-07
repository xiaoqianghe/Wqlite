package com.wqhe.superphoto.superphoto.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.wqhe.superphoto.superphoto.utils.PermissionUtils;


/**
 * Author：Wq
 * Date：2018/4/11 10:51
 * Description：//todo
 */

public class BasePermissActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 检查权限
     *
     * @param permission
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean checkPermission(String permission) {
        boolean b = PermissionUtils.checkPermissionWrapper(this, permission);
        return b;
    }

    /**
     * 申请权限
     *
     * @param permission
     * @param requestCode
     */
    public void requestPerssion(String[] permission, int requestCode) {
        PermissionUtils.requestPermissionsWrapper(this, permission, requestCode);
    }

}

