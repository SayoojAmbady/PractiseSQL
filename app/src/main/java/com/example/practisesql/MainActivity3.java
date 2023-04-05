package com.example.practisesql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity
implements View.OnClickListener {

    Button btnUpdate, btndelete;
    EditText edit_currency, edit_country;
    TextView edit_id;

    DBManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent= getIntent();
        Bundle extras = intent.getBundleExtra("bundle");

        String ID= extras.getString("ID");
        String COUNTRY= extras.getString("COUNTRY");
        String CURRENCY = extras.getString("CURRENCY");

        edit_id = (TextView) findViewById((R.id.editTextTextPersonName));
        edit_country=(EditText) findViewById((R.id.editTextTextPersonName2));
        edit_currency= (EditText) findViewById((R.id.editTextTextPersonName3));

        edit_id.setText(ID);
        edit_country.setText(COUNTRY);
        edit_currency.setText(CURRENCY);

        btnUpdate= (Button) findViewById(R.id.button);
        btndelete= (Button) findViewById(R.id.button2);

        btnUpdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);

        dbManager = new DBManager(this);
        dbManager.Open();

    }

    @Override
    public void onClick(View v){

        Long _id= Long.valueOf(edit_id.getText().toString());

        String country = edit_country.getText().toString();
        String currency = edit_currency.getText().toString();

        switch (v.getId()){

            case R.id.button:

                dbManager.Update(_id,country,currency);
               ReturnHome();
                break;

            case R.id.button2:

                dbManager.Delete(_id);
                dbManager.Close();
                ReturnHome();

                break;

        }

    }

    private void ReturnHome() {
        Intent intent=new Intent(MainActivity3.this,MainActivity.class);
        startActivity(intent);
    }
}