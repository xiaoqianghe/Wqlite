package com.eeepay.libbase.widget.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eeepay.libbase.R;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ixzus on 2017/12/25.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class Webview extends WebView {
    private static final String TAG = "XWebview";
    private ProgressBar progressbar;
    private int progressHeight = 3;
    private TextView title;
    private List<String> listHistory = new ArrayList<>();

    public List<String> getListHistory() {
        return listHistory;
    }

    public Webview(Context arg0) {
        this(arg0, null);

    }

    @SuppressLint("SetJavaScriptEnabled")
    public Webview(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        setBackgroundColor(85621);
        this.setWebViewClient(client);
        this.setWebChromeClient(chromeClient);
        // WebStorage webStorage = WebStorage.getInstance();
        initWebViewSettings(arg0);
        this.getView().setClickable(true);
    }


    private void initWebViewSettings(Context context) {
        WebSettings webSetting = this.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);//多窗口事件
        webSetting.setAllowFileAccess(true);//设置可以访问文件
        webSetting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);//设置WebView底层的布局算法
        webSetting.setSupportZoom(false);//是否支持使用屏幕控件或手势进行缩放，默认是true
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);//多窗口事件
        // webSetting.setLoadWithOverviewMode(true);//是否使用预览模式加载界面
        webSetting.setAppCacheEnabled(true);// 开启Application H5 Caches 功能
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);//设置DOM Storage缓存
        webSetting.setGeolocationEnabled(true);//启用地理定位
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);//让WebView支持播放插件
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);//设置渲染优先级
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);

        // this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
        // settings 的设计

        webSetting.setDatabaseEnabled(true);
        webSetting.setDatabasePath("/data/data");
        webSetting.setJavaScriptEnabled(true);//支持js脚本
        webSetting.setPluginsEnabled(true);//支持插件
        webSetting.supportMultipleWindows();//多窗口
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);//关闭webview中缓存
        webSetting.setNeedInitialFocus(true);//当webview调用requestFocus时为webview设置节点
        webSetting.setLoadsImagesAutomatically(true);//支持自动加载图片
        webSetting.setBuiltInZoomControls(true);//支持缩放
//        this.setInitialScale(35);//设置缩放比例
        webSetting.setSaveFormData(true);//是否保存表单数据
        webSetting.setUseWideViewPort(false);//false时，加载页面的宽度总是适应WebView控件宽度
        // 设置编码格式
        webSetting.setDefaultTextEncodingName("utf-8");

        String appCachePath = getContext().getCacheDir().getAbsolutePath();
        webSetting.setAppCachePath(appCachePath);


        progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressbar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, progressHeight, 0));
        Drawable drawable = context.getResources().getDrawable(R.drawable.webview_loading);
        progressbar.setProgressDrawable(drawable);
        addView(progressbar);
        if (null != getX5WebViewExtension()) {
            getX5WebViewExtension().setScrollBarFadingEnabled(false);
        }

    }

    private WebViewClient client = new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (onOverrideUrlListener != null) {
                onOverrideUrlListener.shouldOverrideUrlLoading(view, url);
            }
            if (url.startsWith("weixin://wap/pay?") || url.startsWith("weixin") || url.startsWith("wechat")
                    || url.startsWith("mqqapi") || url.startsWith("mqqwpa")
                    || url.startsWith("alipays:") || url.startsWith("alipay")) {
                try {
                    getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;

            }
//            if (!(url.startsWith("http") || url.startsWith("https"))) {
////                view.loadUrl(url);
//                return true;
//            }
            if (url.startsWith("http") || url.startsWith("https")) {
                view.loadUrl(url);
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            //https 忽略证书
            sslErrorHandler.proceed();
        }


        @Override
        public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
            listHistory.add(s);
            super.onPageStarted(webView, s, bitmap);
        }

        @Override
        public void onPageFinished(WebView webView, String s) {
//            if (onXWebViewListener != null) {
//                onXWebViewListener.onPageFinish(webView);
//            }
            super.onPageFinished(webView, s);
        }
    };


    private WebChromeClient chromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(final WebView webView, int i) {
            if (i == 100) {
                progressbar.setProgress(100);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressbar.setVisibility(GONE);
                        progressbar.setProgress(0);
                        if (onXWebViewListener != null) {
                            onXWebViewListener.onPageFinish(webView);
                        }
                    }
                }, 300);
            } else {
                if (progressbar.getVisibility() == GONE) {
                    progressbar.setVisibility(VISIBLE);
                }
                progressbar.setProgress(i);
            }
            if (onXWebViewListener != null) {
                onXWebViewListener.onProgressChange(webView, i);
            }
            super.onProgressChanged(webView, i);
        }

        @Override
        public void onReceivedTitle(WebView webView, String s) {
            super.onReceivedTitle(webView, s);
            if (onXWebViewListener != null) {
                onXWebViewListener.onTitle(s);
            }
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String s, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            //local
            geolocationPermissionsCallback.invoke(s, true, false);
            super.onGeolocationPermissionsShowPrompt(s, geolocationPermissionsCallback);
        }
    };


    private onXWebViewListener onXWebViewListener;

    public void setOnXWebViewListener(onXWebViewListener onXWebViewListener) {
        this.onXWebViewListener = onXWebViewListener;
    }

    public interface onXWebViewListener {
        void onProgressChange(WebView webView, int progress);

        void onPageFinish(WebView webView);

        void onTitle(String title);
    }

    private onOverrideUrlListener onOverrideUrlListener;

    public void setOnOverrideUrlListener(Webview.onOverrideUrlListener onOverrideUrlListener) {
        this.onOverrideUrlListener = onOverrideUrlListener;
    }

    public interface onOverrideUrlListener {
        void shouldOverrideUrlLoading(WebView view, String url);
    }


//    @Override
//    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
//        boolean ret = super.drawChild(canvas, child, drawingTime);
//        canvas.save();
//        Paint paint = new Paint();
//        paint.setColor(0x7fff0000);
//        paint.setTextSize(24.f);
//        paint.setAntiAlias(true);
//        if (getX5WebViewExtension() != null) {
//            canvas.drawText(this.getContext().getPackageName() + "-pid:"
//                    + android.os.Process.myPid(), 10, 50, paint);
//            canvas.drawText(
//                    "X5  Core:" + QbSdk.getTbsVersion(this.getContext()), 10,
//                    100, paint);
//        } else {
//            Log.e(TAG, "drawChild: 加载失败 " );
//            canvas.drawText(this.getContext().getPackageName() + "-pid:"
//                    + android.os.Process.myPid(), 10, 50, paint);
//            canvas.drawText("Sys Core", 10, 100, paint);
//        }
//        canvas.drawText(Build.MANUFACTURER, 10, 150, paint);
//        canvas.drawText(Build.MODEL, 10, 200, paint);
//        canvas.restore();
//        return ret;
//    }

}
