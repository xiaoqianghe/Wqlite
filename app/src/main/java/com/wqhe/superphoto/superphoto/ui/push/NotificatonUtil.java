package com.wqhe.superphoto.superphoto.ui.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;


import com.wqhe.superphoto.superphoto.MainActivity;
import com.wqhe.superphoto.superphoto.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by ixzus on 2018/1/11.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class NotificatonUtil {

    public static void showNotification(Context context, JPush jPush) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            initNotificationO(context, jPush);
        } else {
            initNofification(context, jPush);
        }
    }

    private static PendingIntent intentStart(Context context, JPush jPush) {
        if (MainActivity.isForeground) {
            Intent broadcastIntent = new Intent(context, ClickReceiver.class);
            broadcastIntent.setAction("CLICK_PUSH");
            Bundle bundle = new Bundle();
            bundle.putString("PUSH_MSG", "" + jPush.getMsg());
            bundle.putString("PUSH_URL", "" + jPush.getUrl());
            broadcastIntent.putExtras(bundle);
            LocalBroadcastManager.getInstance(context).sendBroadcast(broadcastIntent);
        }
//
//            PendingIntent pendingIntent = PendingIntent.
//                    getBroadcast(context, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//            return pendingIntent;
//        } else {
        Intent intent = new Intent(Intent.ACTION_MAIN);

        intent.putExtra("PUSH_MSG", "" + jPush.getMsg());
        intent.putExtra("PUSH_URL", "" + jPush.getUrl());

        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setClass(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

        PendingIntent pendingIntent = PendingIntent.getActivity(context
                , (int) SystemClock.uptimeMillis()
                , intent
                , PendingIntent.FLAG_UPDATE_CURRENT);

        return pendingIntent;
//        }
    }

    private static PendingIntent intentNext(Context context, Class cls) {
        Intent intent = new Intent();

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_SINGLE_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, cls);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(cls);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                (int) SystemClock.uptimeMillis()
                , PendingIntent.FLAG_UPDATE_CURRENT);

        return pendingIntent;
    }

    private static PendingIntent intentNext2(Context context, Class cls) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_SINGLE_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Intent secondIntent = new Intent(context, cls);
        Intent[] intents = {intent, secondIntent};
        PendingIntent pendingIntent = PendingIntent.getActivities(context
                , (int) SystemClock.uptimeMillis()
                , intents
                , PendingIntent.FLAG_UPDATE_CURRENT);

        return pendingIntent;
    }

    private static void initNofification(Context context, JPush jPush) {
        String orgName="";
        try {
            orgName = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getString("ORGNAME");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        Notification notification = new Notification.Builder(context)
                .setLargeIcon(bitmap)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(orgName)
                .setContentText(jPush.getMsg())
                .setWhen(System.currentTimeMillis())
//                .setSubText("Sub_tex")
                .setContentIntent(intentStart(context, jPush))
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void initNotificationO(Context context, JPush jPush) {
        String orgName="";
        try {
            orgName = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getString("ORGNAME");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        NotificationChannel channel = new NotificationChannel("1", "channel", NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.setShowBadge(true);

        Notification notification = new Notification.Builder(context, "1")
                .setLargeIcon(bitmap)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(orgName)
                .setContentText(jPush.getMsg())
                .setWhen(System.currentTimeMillis())
//                .setSubText("Sub_tex")
                .setContentIntent(intentStart(context, jPush))
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, notification);
    }

}
