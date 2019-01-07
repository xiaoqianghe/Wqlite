package com.wqhe.superphoto.superphoto.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wqhe.superphoto.superphoto.R;

/**
 * Author：Wq
 * Date：2018/5/15 15:51
 * Description：//todo
 */

public class GlideUtils {

    public static  void GlideView(Context mContext,ImageView view,String  url){
        Glide.with(mContext)
                .load(url)
                .into(view);
    }
}
