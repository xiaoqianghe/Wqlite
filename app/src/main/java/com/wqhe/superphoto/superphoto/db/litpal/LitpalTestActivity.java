package com.wqhe.superphoto.superphoto.db.litpal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.litepal.tablemanager.Connector;

/**
 * Author：Wq
 * Date：2018/5/23 15:36
 * Description：//todo
 */

public class LitpalTestActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDatabase db = Connector.getDatabase();//创建表


    }
}
