package com.example.eslam.accapp.DataBaseSQLlite;

/**
 * Created by Eslam on 10/10/2017.
 */

public abstract class Categories {
    public static final String TABLE_NAME="categories";

    public static final String ID="id";
    public static final String NAME="name";

    public static final String QUERY="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+NAME+" TEXT);";

}
