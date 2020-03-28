package com.loftblog.loftmoney.screens.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loftblog.loftmoney.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<ItemModel> mDataList = new ArrayList<>();

    public void setNewData(List<ItemModel> newData){
        mDataList.clear();
        mDataList.addAll(newData);
        notifyDataSetChanged();
    }

    public void addDataToTop(ItemModel model) {
        mDataList.add(0, model);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ItemViewHolder(layoutInflater.inflate(R.layout.cell_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName = itemView.findViewById(R.id.txtItemName);
        private TextView txtValue = itemView.findViewById(R.id.txtItemValue);


             ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        void bind(ItemModel itemModel){
            txtName.setText(itemModel.getName());
            txtValue.setText(itemModel.getValue());
        }
    }
}
