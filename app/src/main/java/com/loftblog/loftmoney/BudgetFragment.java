package com.loftblog.loftmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loftblog.loftmoney.screens.addItem.AddItemActivity;
import com.loftblog.loftmoney.screens.main.adapter.ItemModel;
import com.loftblog.loftmoney.screens.main.adapter.ItemsAdapter;

public class BudgetFragment extends Fragment {

    private ItemsAdapter itemsAdapter = new ItemsAdapter();
    static int ADD_ITEM_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerMain);
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false));

        view.findViewById(R.id.fabMain).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(getActivity(), AddItemActivity.class);
                startActivityForResult(addIntent, ADD_ITEM_REQUEST);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_ITEM_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            ItemModel itemModel = (ItemModel) data.getSerializableExtra(ItemModel.KEY_NAME);
            itemsAdapter.addDataToTop(itemModel);
        }
    }
}
