package com.example.eslam.accapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eslam.accapp.DataBaseSQLlite.DataBaseHelper;
import com.example.eslam.accapp.DataBaseSQLlite.IncomingGoods;

public class Additem extends AppCompatActivity {
    EditText name, price, quantity;
    Spinner category;
    DataBaseHelper db;
    String[] spinner;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        name = (EditText) findViewById(R.id.ed_Item_name);
        price = (EditText) findViewById(R.id.ed_Item_price);
        quantity = (EditText) findViewById(R.id.ed_Item_qua);
        category = (Spinner) findViewById(R.id.sp_Item_cate);
        Intent i = this.getIntent();
        Name = i.getExtras().getString("username");
        db = new DataBaseHelper(this);
        setspinner();
    }

    public void click(View view) {
        boolean result = db.insertData(IncomingGoods.TABLE_NAME, new String[]{IncomingGoods.NAME
                        , IncomingGoods.PRICE, IncomingGoods.NUMBER, IncomingGoods.C_ID, IncomingGoods.USER_NAME},
                new String[]{name.getText().toString(),
                        price.getText().toString(),
                        quantity.getText().toString(),
                        category.getSelectedItem().toString()
                        , Name});
        if (result == true) {
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }

    }

    public void setspinner() {
        spinner = new String[3];
        spinner[0] = "Category A";
        spinner[1] = "Category B";
        spinner[2] = "Category C";
        ArrayAdapter adapter = new ArrayAdapter(Additem.this, android.R.layout.simple_spinner_item, spinner);
        category.setAdapter(adapter);
    }

}
