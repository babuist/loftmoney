package com.loftblog.loftmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMainNext).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addItemActivity = new Intent(getApplicationContext(), AddItemActivity.class);

                //secondActivity.putExtra(name: "Title", value: "Iron man");
                startActivity(addItemActivity);
            }
        });
    }
}
