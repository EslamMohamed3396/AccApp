package com.example.eslam.accapp;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eslam.accapp.DataBaseSQLlite.DataBaseHelper;
import com.example.eslam.accapp.DataBaseSQLlite.User;

public class Registeration extends AppCompatActivity {
    EditText _name;
    EditText _pass;
    EditText _age;
    Button button_save;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        _name = (EditText) findViewById(R.id.ed_name);
        _pass = (EditText) findViewById(R.id.ed_pass);
        _age = (EditText) findViewById(R.id.ed_age);
        button_save = (Button) findViewById(R.id.btn_save);
        db = new DataBaseHelper(this);
    }

    public void save_click(View view) {
        bt_save();
    }

    public void bt_save() {
        String name = _name.getText().toString();
        String pass = _pass.getText().toString();
        String age = _age.getText().toString();
        try {
            boolean result = db.insertData(User.TABLE_NAME, new String[]{User.NAME, User.PASSWORD, User.AGE}, new String[]{name, pass, age});
            if (result == true)
                Toast.makeText(Registeration.this, "Done", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Registeration.this, "Not Done", Toast.LENGTH_LONG).show();
        } catch (SQLException ex) {
            Toast.makeText(Registeration.this, ex.getMessage(), Toast.LENGTH_LONG).show();


        }


    }
}
