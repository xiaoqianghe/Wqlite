package com.wqhe.superphoto.superphoto.ui.push;

import android.content.Context;

import com.eeepay.libbase.util.ACache;
import com.wqhe.superphoto.superphoto.BuildConfig;
import com.wqhe.superphoto.superphoto.R;


import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by ixzus on 2018/1/10.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class PushUtil {

    public static void init(Context context) {
        JPushInterface.setDebugMode(BuildConfig.DEBUG);
        JPushInterface.init(context);
    }

    public static void open(Context context) {
        ACache.get(context).put("PUSH_SATUS", "open");
    }

    public static void close(Context context) {
        ACache.get(context).put("PUSH_SATUS", "close");
    }

    public static boolean isClose(Context context) {
        return "close".equals(ACache.get(context).getAsString("PUSH_SATUS"));
    }

    public static void setAlias(Context context) {
//        JPushInterface.setAlias(context, 1, UserInfo.getUserId(context));
        JPushInterface.setAlias(context, 1, "");
    }

    public static void stopPush(Context context) {
        JPushInterface.stopPush(context);
    }

    public static void resumePush(Context context) {
        JPushInterface.resumePush(context);
    }

    public static void isPushStopped(Context context) {
        JPushInterface.isPushStopped(context);
    }

    public static void setPushTime(Context context) {
        Set<Integer> days = new HashSet<Integer>();
        days.add(1);
        days.add(2);
        days.add(3);
        days.add(4);
        days.add(5);
        JPushInterface.setPushTime(context, days, 9, 18);
    }

    public static void PushNotification(Context context){
        CustomPushNotificationBuilder builder = new
                CustomPushNotificationBuilder(context,
                R.layout.customer_notitfication_layout,
                R.id.icon,
                R.id.title,
                R.id.text);
        // 指定定制的 Notification Layout
        builder.statusBarDrawable = R.mipmap.ic_launcher;
        // 指定最顶层状态栏小图标
        builder.layoutIconDrawable = R.mipmap.ic_launcher;
        // 指定下拉状态栏时显示的通知图标
        JPushInterface.setPushNotificationBuilder(2, builder);
    }

}
