package com.example.a1_sakutugas_v3;

import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  ListTugasAdapter extends ListAdapter<ListTugas, ListTugasViewHolder> {
    private ItemClickListener itemListener;

    public ListTugasAdapter(@NonNull DiffUtil.ItemCallback<ListTugas> diffCallback) {
        super(diffCallback);
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ListTugasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ListTugasViewHolder.create(parent, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTugasViewHolder holder, int position) {
        ListTugas current = getItem(position);
        holder.bind(current.getTugas(), current.getTanggal(), current.getKeterangan());

    }

    static class ListTugasDiff extends DiffUtil.ItemCallback<ListTugas> {

        @Override
        public boolean areItemsTheSame(@NonNull ListTugas oldItem, @NonNull ListTugas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ListTugas oldItem, @NonNull ListTugas newItem) {
            return oldItem.getTugas().equals(newItem.getTugas());
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }

}
