package com.example.nidecsnipeit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nidecsnipeit.DeviceDetails;
import com.example.nidecsnipeit.MainActivity;
import com.example.nidecsnipeit.MaintenanceAddActivity;
import com.example.nidecsnipeit.R;
import com.example.nidecsnipeit.model.ListItemModel;
import com.example.nidecsnipeit.model.MaintenanceAdapterListener;
import com.example.nidecsnipeit.model.MaintenanceItemModel;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceAdapter extends RecyclerView.Adapter<MaintenanceAdapter.ViewHolder> {
    private final List<MaintenanceItemModel> mData;
    private final LayoutInflater mInflater;
    private final RecyclerView recyclerView;
    public MaintenanceAdapter(Context context, List<MaintenanceItemModel> data, RecyclerView recyclerView) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_maintenance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MaintenanceItemModel currentItem = mData.get(position);

        holder.textView.setText(currentItem.getAssetMaintenanceType());
        holder.dateView.setText(currentItem.getStartDate());

        List<ListItemModel> dataList = new ArrayList<>();
        dataList.add(new ListItemModel("Title", currentItem.getTitle()));
        dataList.add(new ListItemModel("Supplier", currentItem.getSupplierName()));
        CustomRecyclerAdapter customAdapter = new CustomRecyclerAdapter(mInflater.getContext(), dataList, holder.contentView);
        holder.contentView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        holder.contentView.setAdapter(customAdapter);

        holder.buttonEditView.setOnClickListener(v -> {
            Intent intent = new Intent(mInflater.getContext(), MaintenanceAddActivity.class);
            mInflater.getContext().startActivity(intent);
        });

        holder.buttonDeleteView.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView dateView;
        RecyclerView contentView;
        Button buttonEditView;
        Button buttonDeleteView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_title_item);
            dateView = itemView.findViewById(R.id.date_title_item);
            contentView = itemView.findViewById(R.id.content_item);
            buttonEditView = itemView.findViewById(R.id.button_edit_item);
            buttonDeleteView = itemView.findViewById(R.id.button_delete_item);
        }
    }
}
