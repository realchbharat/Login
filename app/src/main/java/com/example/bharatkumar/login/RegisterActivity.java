package com.example.bharatkumar.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText password;
    EditText re_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void submit(View view)
    {
        password= (EditText) findViewById(R.id.e1);
        re_password= (EditText) findViewById(R.id.e2);

        String pass=password.getText().toString();
        String re_pass=re_password.getText().toString();

        if(pass.equals(re_pass))
        {
            SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("password", pass);
            editor.apply();
            Toast.makeText(this,"password is saved",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"password is not matching",Toast.LENGTH_SHORT).show();
        }
    }


}
