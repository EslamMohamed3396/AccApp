package com.example.eslam.accapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eslam.accapp.DataBaseSQLlite.DataBaseHelper;
import com.example.eslam.accapp.DataBaseSQLlite.IncomingGoods;
import com.example.eslam.accapp.DataBaseSQLlite.OutgoingGoods;
import com.example.eslam.accapp.entities.IncomingAdabter;
import com.example.eslam.accapp.entities.IncomingEntity;

import java.util.ArrayList;

public class OutingGoods extends AppCompatActivity {
    EditText name, price, quantity;
    Spinner category;
    DataBaseHelper db;
    String[] spinner;
    String Name;
    ListView listView;
    IncomingAdabter adabter;
    ArrayList<IncomingEntity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outing_goods);
        name = (EditText) findViewById(R.id.ed_Outing_name);
        price = (EditText) findViewById(R.id.ed_Outing_price);
        quantity = (EditText) findViewById(R.id.ed_Outing_Quantity);
        category = (Spinner) findViewById(R.id.sp_Outing);
        listView = (ListView) findViewById(R.id.lv_Outing_list);
        Intent i = this.getIntent();
        Name = i.getExtras().getString("username");
        db = new DataBaseHelper(this);
        setspinner();
        show();
    }
    public void click(View view) {
        boolean result = db.insertData(OutgoingGoods.TABLE_NAME, new String[]{OutgoingGoods.NAME
                        , OutgoingGoods.PRICE, OutgoingGoods.NUMBER, OutgoingGoods.C_ID, OutgoingGoods.USER_NAME},
                new String[]{name.getText().toString(),
                        price.getText().toString(),
                        quantity.getText().toString(),
                        category.getSelectedItem().toString()
                        , Name});
        if (result == true) {
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
            list.clear();
            show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }

    }

    public void setspinner() {
        spinner = new String[3];
        spinner[0] = "Category A";
        spinner[1] = "Category B";
        spinner[2] = "Category C";
        ArrayAdapter adapter = new ArrayAdapter(OutingGoods.this, android.R.layout.simple_spinner_item, spinner);
        category.setAdapter(adapter);
    }
    public void show() {
        list = new ArrayList<>();
        Cursor cursor = db.show_data(OutgoingGoods.TABLE_NAME, OutgoingGoods.USER_NAME, Name);
        if (cursor.getCount() == 0) {
            list.add(new IncomingEntity("Empty", "Empty", "Empty", "Empty"));
        } else {
            while (cursor.moveToNext()) {
                list.add(new IncomingEntity("" + cursor.getString(cursor.getColumnIndex(IncomingGoods.NAME)),
                        "" + cursor.getString(cursor.getColumnIndex(IncomingGoods.PRICE)),
                        "" + cursor.getString(cursor.getColumnIndex(IncomingGoods.NUMBER)),
                        "" + cursor.getString(cursor.getColumnIndex(IncomingGoods.C_ID))));
            }
            adabter = new IncomingAdabter(list, this);
            listView.setAdapter(adabter);
        }


    }
}
