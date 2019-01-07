package com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils;

import android.graphics.Bitmap;

/**
 * Author：Wq
 * Date：2018/6/27 15:36
 * Description：//todo
 */

public interface BitmapCallBack {

    void onBitmapLoaded(Bitmap bitmap);

    void onBitmapFailed(Exception e);

    public static class EmptyCallback implements BitmapCallBack {


        @Override
        public void onBitmapLoaded(Bitmap bitmap) {

        }

        @Override
        public void onBitmapFailed(Exception e) {

        }
    }

}
