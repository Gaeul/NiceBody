package com.example.kobot.myposition;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kobot on 2017-09-25.
 */

public class MyDB extends SQLiteOpenHelper{

    public MyDB(Context context){
        super(context, "myDB", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS USERINFO" +
                "(USERNUMBER INTEGER NOT NULL" +
                ",NAME VARCHAR(10)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
