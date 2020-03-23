package com.loftblog.loftmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().getExtras() != null) {
            String title = getIntent().getExtras().getString(key:"Title");
            Log.e(tag:"TAG", msg:"Title is " + title);
        }
    }
}