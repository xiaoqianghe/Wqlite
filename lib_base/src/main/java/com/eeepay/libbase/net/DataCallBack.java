package com.eeepay.libbase.net;

/**
 * Created by ixzus on 2018/1/6.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public interface DataCallBack<T> {

    void onSuccess(T data);

    void onError(int code, String errMessage);
}
