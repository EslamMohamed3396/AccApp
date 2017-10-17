package com.example.eslam.accapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eslam.accapp.DataBaseSQLlite.DataBaseHelper;

public class LogIn extends AppCompatActivity {
    EditText na;
    EditText pa;
    Button Login;
    Button Register;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        na = (EditText) findViewById(R.id.NAME);
        pa = (EditText) findViewById(R.id.PASSWORD);
        Login = (Button) findViewById(R.id.btn_login);
        Register = (Button) findViewById(R.id.btn_register);
        db = new DataBaseHelper(this);

    }

    public void Click(View v) {
        if (v.getId() == R.id.btn_login) {
            log();
        } else if (v.getId() == R.id.btn_register) {
            Intent in = new Intent(LogIn.this, Registeration.class);
            startActivity(in);
        }


    }

    public void log() {
        String Name = na.getText().toString();
        String Password = pa.getText().toString();
        Cursor cursor = db.Login(Name, Password);
        if (cursor.getCount() != 0) {
            Intent i=new Intent(LogIn.this,MainActivity.class);
            i.putExtra("username",Name);
            startActivity(i);
        } else {

            Toast.makeText(LogIn.this, "Not Found", Toast.LENGTH_LONG).show();

        }

    }
}
