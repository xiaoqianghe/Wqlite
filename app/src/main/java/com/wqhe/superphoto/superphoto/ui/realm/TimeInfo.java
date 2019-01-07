package com.wqhe.superphoto.superphoto.ui.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Author：Wq
 * Date：2018/5/31 17:15
 * Description：//todo
 */

public class TimeInfo extends RealmObject {


    //年月日信息
    private String ymD;
    //标题
    private String title;
    //内容
    private String content;
    //时间段信息  12：00-13：00
    @PrimaryKey
    private String addTime;
    //创建该条目时的时间
    private String createTime;
    //是否是新的任务
    private boolean isNew = true;
    //在列表中所处位置
    private int position = -1;


    public String getYmD() {
        return ymD;
    }

    public void setYmD(String ymD) {
        this.ymD = ymD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
