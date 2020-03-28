package com.loftblog.loftmoney.screens.addItem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.loftblog.loftmoney.R;
import com.loftblog.loftmoney.screens.main.adapter.ItemModel;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final EditText textName = findViewById(R.id.textAddItemName);
        final EditText textValue = findViewById(R.id.textAddItemValue);
        Button buttonAdd = findViewById(R.id.add_button);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textName.getText().toString();
                String value = textValue.getText().toString();

                if (TextUtils.isEmpty(name)|| TextUtils.isEmpty(value)){
                    return;
                }

                String valueString = value + " P";
                ItemModel itemModel = new ItemModel(name, valueString);

                Intent intent = new Intent();
                intent.putExtra(ItemModel.KEY_NAME, itemModel);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}