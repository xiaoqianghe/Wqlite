package com.wqhe.superphoto.superphoto.ui.wx;

/**
 * Author：Wq
 * Date：2018/5/31 10:50
 * Description：//todo
 */

public interface WxActivityContract {

    interface Presenter{

        void toWxLogin();

        void toShare();

        void checkVersion();

        void downNewApp();

    }

    interface View{
        void showToast(String str);

        void showDialog(int type);
    }
}
