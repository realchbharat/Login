package com.example.bharatkumar.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PasswordSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_save);
    }

    public void login(View view)
    {
        Toast.makeText(this,"LOGIN",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void register(View view)
    {
        Toast.makeText(this,"REGISTER",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,RegisterActivity.class));
    }
}
