package com.eeepay.libbase.net;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by ixzus on 2017/12/27.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public abstract class NetNDObserver<T> implements Observer<T> {
    private final int RESPONSE_CODE_OK = 200;      //自定义的业务逻辑，成功返回积极数据
    private final int RESPONSE_CODE_FAILED = -1; //返回数据失败

    private RxManager mRxManager;
    private int mWhichRequest;
    private String mKey;


    public NetNDObserver(String key, int whichRequest) {
        this.mKey = key;
        this.mWhichRequest = whichRequest;
        mRxManager = RxManager.getInstance();
    }


    @Override
    public final void onSubscribe(Disposable d) {
        mRxManager.add(mKey, d);
        onStart(mWhichRequest);
    }

    @Override
    public final void onNext(T response) {
        if (null == response) {
            return;
        }
        onSuccess(mWhichRequest, response);
//        if (response.getCode() == RESPONSE_CODE_OK) {
//            onSuccess(mWhichRequest, response.getResult());
//        } else {
//            onFailure(response.getCode(), response.getError());
//        }
    }

    @Override
    public final void onError(Throwable t) {
        int code = 0;
        String errorMessage = "未知错误";
        if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            String meg = httpException.response().toString();
            code = httpException.code();
            errorMessage = httpException.getMessage();
        } else if (t instanceof SocketTimeoutException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "服务器响应超时";
        } else if (t instanceof ConnectException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "网络连接异常，请检查网络";
        } else if (t instanceof RuntimeException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "运行时错误";
        } else if (t instanceof UnknownHostException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "无法解析主机，请检查网络连接";
        } else if (t instanceof UnknownServiceException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "未知的服务器错误";
        } else if (t instanceof IOException) {  //飞行模式等
            code = RESPONSE_CODE_FAILED;
            errorMessage = "没有网络，请检查网络连接";
        }

        /**
         * 严重的错误弹出dialog，一般的错误就只要Toast
         */
//        if (RESPONSE_CODE_FAILED == code) {
//            onFailure(RESPONSE_CODE_FAILED, errorMessage);
//        } else {
//            if (mContext != null && !((Activity) mContext).isFinishing()) {
//                Toast.makeText(mContext, errorMessage + " - " + code, Toast.LENGTH_SHORT).show();
//            }
//        }
//        onFailure(code, errorMessage);
        disposeEorCode(code, errorMessage);
        onError(code, errorMessage);
//        onError(mWhichRequest, errorMessage);
    }

    public void onFailure(int code, String message) {
        if (code == RESPONSE_CODE_FAILED) {
//            HttpUiTips.alertTip(mContext, message, code);
        } else {
            disposeEorCode(code, message);
        }
    }

    private final void disposeEorCode(int code, String message) {
        switch (code) {
            case 302:
            case 401:
            case 404:
//                ACache.get(BaseApplication.getBaseApplication()).put("TOKEN", "");
//                ARouter.getInstance().build("/login/loginActivity").withString("token", "token").navigation();
                break;
            case 500:
            case 502:
//                Toast.makeText(mContext, "服务器开小差,努力抢修中...", Toast.LENGTH_SHORT).show();
                break;
            default:
//                Toast.show(code + "-" + message);
                break;
        }
    }

    @Override
    public final void onComplete() {
    }

    public abstract void onSuccess(int whichRequest, T t);

    public abstract void onError(int whichRequest, String errorMessage);

    public void onStart(int whichRequest) {
//        if (!NetworkUtil.isNetworkAvailable(context)) {
//        if (!NetworkUtils.isAvailableByPing()) {
//            Toast.show("当前网络不可用，请检查网络情况");
////            Toast.makeText(App.getApplication(), "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
////            NetworkUtils.openWirelessSettings();
////            ActivityManager.getInstance().getCurrentActivity().startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
////            if (isNeedCahe) {
////                //无网络已经读取缓存
////            }
//            // **一定要主动调用下面这一句**
//            onComplete();
//            return;
//        }
        // 显示进度条

    }

}