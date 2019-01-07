package com.eeepay.libbase.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.eeepay.libbase.widget.webview.Webview;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by ixzus on 2017/12/27.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public abstract class BaseWebViewFragment extends MySupportFragment {

    protected Webview mWebView;
    protected FrameLayout fl_container;

    protected static final String ARG_PARAM1 = "param1";
    protected String mUrl;

//    public static BaseWebViewFragment newInstance(String param1) {
//        BaseWebViewFragment fragment = new BaseWebViewFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        initWebView(view);
        initView(view);
        return view;
    }

    protected void initWebView(View view) {
        fl_container = view.findViewById(initContainerId());
        mWebView = new Webview(_mActivity, null);
        fl_container.addView(mWebView, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });
        mWebView.loadUrl(mUrl);
    }

//    @Override
//    public boolean onBackPressedSupport() {
//        if (mWebView.canGoBack()) {
//            mWebView.goBack();
//            return true;
//        } else {
//            return super.onBackPressedSupport();
//        }
//    }

    protected abstract
    @LayoutRes
    int initLayout();

    protected abstract
    @IdRes
    int initContainerId();

    protected abstract void initView(View view);
}
