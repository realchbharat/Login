package com.example.bharatkumar.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class StoredDataActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView textView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stored_data);

        editText1= (EditText) findViewById(R.id.e1);
        editText2= (EditText) findViewById(R.id.e2);
        textView= (TextView) findViewById(R.id.t4);
        dbHandler=new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void save(View view)
    {
        Accounts account=new Accounts(editText1.getText().toString(),editText2.getText().toString());
        dbHandler.addAccount(account);
        printDatabase();
    }

    public void printDatabase() {

        String dbString=dbHandler.databaseToString();
        textView.setText(dbString);
        editText1.setText("");
        editText2.setText("");
    }

}
