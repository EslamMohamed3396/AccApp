package com.example.eslam.accapp.DataBaseSQLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eslam on 10/10/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Accounting.db";
    public static final int VERSION = 3;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.QUERY);
        db.execSQL(IncomingGoods.QUERY);
        db.execSQL(OutgoingGoods.QUERY);
        db.execSQL(Categories.QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + IncomingGoods.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + OutgoingGoods.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Categories.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String table_Name, String[] column_name, String[] value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < column_name.length; i++) {
            contentValues.put(column_name[i], value[i]);
        }
        long result = db.insert(table_Name, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor Login(String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + User.TABLE_NAME + " where " +
                User.NAME + " = ? AND " + User.PASSWORD + " = ? ", new String[]{name, password});
        return cursor;

    }

    public Cursor show_data(String table_name, String ColumnName, String ColumnValue) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + table_name + " where " + ColumnName + " =? ",
                new String[]{ColumnValue});
        return cursor;
    }

    public boolean update(String table_Name, String[] column_name, String[] value
            , String column_to_update, String value_to_update) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < column_name.length; i++) {
            contentValues.put(column_name[i], value[i]);
        }
        db.update(table_Name, contentValues, column_to_update + " = ?", new String[]{value_to_update});
        return true;
    }

    public Integer delete(String table_name, String cid, String cvalue) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name, cid + "= ? ", new String[]{cvalue});
    }
}
