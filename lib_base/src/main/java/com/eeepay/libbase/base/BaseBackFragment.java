package com.eeepay.libbase.base;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.eeepay.libbase.R;


/**
 * Created by ixzus on 2017/12/27.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class BaseBackFragment extends MySupportFragment {

    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
    }
}
