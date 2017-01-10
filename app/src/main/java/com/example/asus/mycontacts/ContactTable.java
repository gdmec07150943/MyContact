package com.example.asus.mycontacts;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by ASUS on 2016/10/25.
 */
public class ContactTable {
    private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactTable(Context context){
        db=new MyDB(context);
        if(!db.isTableExists(TABLENAME)){
            String createTableSql="CREATE TABLE IF NOT EXISTS"+TABLENAME+"(id_DB integer"+
                    "primary key AUTOINCREMENT,"+
                    User.NAME+"VARCHAR,"+
                    User.MOBILE+"VARCHAR,"+
                    User.QQ+"VARCHAR,"+
                    User.DANWEI+"VARCHAR,"+
                    User.ADDRESS+"VARCHAR)";
            db.createTable(createTableSql);
        }
    }

    //增加数据
    public boolean addData(User user){
        //创建contentValues对象用于保存数据
        ContentValues values=new ContentValues();
        //contentvalue赋值
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        //保存数据
        return db.save(TABLENAME,values);
    }

}
