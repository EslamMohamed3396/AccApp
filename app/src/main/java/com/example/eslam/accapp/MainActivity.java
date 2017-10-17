package com.example.eslam.accapp;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eslam.accapp.DataBaseSQLlite.DataBaseHelper;
import com.example.eslam.accapp.DataBaseSQLlite.User;

public class MainActivity extends AppCompatActivity {
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = this.getIntent();
        name = i.getExtras().getString("username");
    }

    public void click(View view) {
        if (view.getId() == R.id.btn_Main_Add_new) {
            Intent i = new Intent(this, Additem.class);
            i.putExtra("username", name);
            startActivity(i);
        } else if (view.getId() == R.id.btn_Main_in) {
            Intent i = new Intent(this, Incoming_List.class);
            i.putExtra("username", name);
            startActivity(i);
        }else if (view.getId()==R.id.btn_Main_out)
        {
            Intent i = new Intent(this, OutingGoods.class);
            i.putExtra("username", name);
            startActivity(i);

        }

    }
}

