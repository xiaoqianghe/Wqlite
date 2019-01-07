package com.eeepay.libbase.widget.webview;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by ixzus on 2017/12/25.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class WebViewPreLoadService extends IntentService {
    private static final String TAG = "WebViewPreLoadService";

    public WebViewPreLoadService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        init();
    }

    private void init() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                Log.d(TAG, " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };

        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

}