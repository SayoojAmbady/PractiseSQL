package com.example.practisesql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Add_Dialog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button add;

    EditText cntry, cury;
    String cnt,cry;

    DBManager dbobj = new DBManager(getContext());


    public Add_Dialog(@NonNull Activity a) {
        super(a);
        this.c= a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_dialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_dialog);
        add = (Button) findViewById(R.id.addb);
        add.setOnClickListener(this);


        cntry= findViewById(R.id.country);
        cury= findViewById(R.id.currency);

    }

    @Override
    public void onClick(View v) {

        cnt= String.valueOf(cntry.getText());
        cry= String.valueOf(cury.getText());

        dbobj.Open();
        dbobj.Insert(cnt,cry);
        dbobj.Close();

        Intent intent= new Intent(c, MainActivity.class);
        c.startActivity(intent);

        dismiss();
    }

}