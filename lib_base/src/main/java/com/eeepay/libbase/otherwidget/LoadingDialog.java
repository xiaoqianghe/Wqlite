package com.eeepay.libbase.otherwidget;

import android.support.v4.app.FragmentManager;

import com.eeepay.libbase.R;


public class LoadingDialog extends AbsDialog {


    public static LoadingDialog init() {
        return new LoadingDialog();
    }

    @Override
    public int intLayoutId() {
        return R.layout.base_dialog_loading;
    }

    @Override
    public void convertView(ViewHolder holder, AbsDialog dialog) {
    }

    @Override
    public AbsDialog show(FragmentManager manager) {
        return super.show(manager);
    }

}