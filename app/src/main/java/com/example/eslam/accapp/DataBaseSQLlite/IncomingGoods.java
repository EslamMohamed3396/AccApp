package com.example.eslam.accapp.DataBaseSQLlite;

/**
 * Created by Eslam on 10/10/2017.
 */

public abstract class IncomingGoods {
    public static final String TABLE_NAME = "incoming_good";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String NUMBER = "number";
    public static final String C_ID = "c_id";
    public static final String USER_NAME = "user_name";


    public static final String QUERY = "CREATE TABLE " + TABLE_NAME + " (" + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT , " + NAME + " TEXT , " + PRICE + " TEXT , " +
            NUMBER + " TEXT , " + C_ID + " TEXT , " + USER_NAME + " TEXT);";


}
