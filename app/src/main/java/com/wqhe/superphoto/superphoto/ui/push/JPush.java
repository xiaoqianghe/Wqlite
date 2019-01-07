package com.wqhe.superphoto.superphoto.ui.push;

import java.io.Serializable;

/**
 * Created by ixzus on 2018/1/10.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class JPush implements Serializable {

    private String type;
    private String code;
    private String msg;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
