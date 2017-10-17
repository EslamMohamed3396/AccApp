package com.example.eslam.accapp.DataBaseSQLlite;

/**
 * Created by Eslam on 10/10/2017.
 */

public abstract class User {
    public static final String TABLE_NAME="users";

    public static final String ID="id";
    public static final String NAME="name";
    public static final String PASSWORD="password";
    public static final String AGE="age";

    public static final String QUERY="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
            NAME+" TEXT , "+PASSWORD+" TEXT , "+AGE+" TEXT );";

}
