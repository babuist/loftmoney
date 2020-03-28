package com.loftblog.loftmoney.screens.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.loftblog.loftmoney.screens.addItem.AddItemActivity;
import com.loftblog.loftmoney.R;
import com.loftblog.loftmoney.screens.main.adapter.ItemModel;
import com.loftblog.loftmoney.screens.main.adapter.ItemsAdapter;

public class MainActivity extends AppCompatActivity {

    private ItemsAdapter itemsAdapter = new ItemsAdapter();
    static int ADD_ITEM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                false));

        findViewById(R.id.fabMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(getApplicationContext(), AddItemActivity.class);
                startActivityForResult(addIntent, ADD_ITEM_REQUEST);
            }
        });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_ITEM_REQUEST && resultCode == RESULT_OK && data != null) {
            ItemModel itemModel = (ItemModel) data.getSerializableExtra(ItemModel.KEY_NAME);
            itemsAdapter.addDataToTop(itemModel);
        }
    }
}
