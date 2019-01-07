package com.wqhe.superphoto.superphoto.ui.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class ClickReceiver extends BroadcastReceiver {
    private static final String TAG = "ClickReceiver";
    private IPushReceive pushReceive;

    public ClickReceiver(IPushReceive pushReceive) {
        this.pushReceive = pushReceive;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("PUSH_MSG");
        String url = intent.getStringExtra("PUSH_URL");
        Log.e(TAG, "onReceive: " + msg + url);
        pushReceive.pushcallback(url);
    }
}