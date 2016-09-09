package com.example.bharatkumar.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        editText= (EditText) findViewById(R.id.e1);
        String pass=editText.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE);
        String password = sharedPreferences.getString("password", "");

        if (pass.equals(password)) {
            Intent intent=new Intent(this,StoredDataActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"passwored enter is worng",Toast.LENGTH_SHORT).show();
        }

    }
}
