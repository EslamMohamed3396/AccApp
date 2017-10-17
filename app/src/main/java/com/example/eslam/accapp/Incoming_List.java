package com.example.eslam.accapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eslam.accapp.DataBaseSQLlite.DataBaseHelper;
import com.example.eslam.accapp.DataBaseSQLlite.IncomingGoods;
import com.example.eslam.accapp.entities.IncomingAdabter;
import com.example.eslam.accapp.entities.IncomingEntity;

import java.util.ArrayList;

public class Incoming_List extends AppCompatActivity {
    DataBaseHelper db;
    ListView listView;
    IncomingAdabter adabter;
    ArrayList<IncomingEntity> list;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming__list);
        listView = (ListView) findViewById(R.id.lv_Incoming_list);
        db = new DataBaseHelper(this);
        Intent i = this.getIntent();
        name = i.getExtras().getString("username");
        show();

    }

    public void show() {
        list = new ArrayList<>();
        Cursor cursor = db.show_data(IncomingGoods.TABLE_NAME, IncomingGoods.USER_NAME, name);
        if (cursor.getCount() == 0) {
            list.add(new IncomingEntity("Empty", "Empty", "Empty", "Empty"));
        } else {
            while (cursor.moveToNext()) {
                list.add(new IncomingEntity("" + cursor.getString(cursor.getColumnIndex(IncomingGoods.NAME)),
                        "" + cursor.getString(cursor.getColumnIndex(IncomingGoods.PRICE)),
                        "" + cursor.getString(cursor.getColumnIndex(IncomingGoods.NUMBER)),
                        "" + cursor.getString(cursor.getColumnIndex(IncomingGoods.C_ID))));
                adabter = new IncomingAdabter(list, this);
                listView.setAdapter(adabter);
            }

        }


    }

}
