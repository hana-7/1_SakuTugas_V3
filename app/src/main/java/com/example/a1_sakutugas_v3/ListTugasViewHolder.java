package com.example.a1_sakutugas_v3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListTugasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView tvTugas;
    private final TextView tvTanggal;
    private final TextView tvKeterangan;
    ListTugasAdapter.ItemClickListener itemListener;

    private ListTugasViewHolder(View itemView, ListTugasAdapter.ItemClickListener itemListener) {
        super(itemView);
        tvTugas = itemView.findViewById(R.id.tvTugas);
        tvTanggal = itemView.findViewById(R.id.tvTanggal);
        tvKeterangan= itemView.findViewById(R.id.tvKeterangan);
        this.itemListener = itemListener;

        itemView.setOnClickListener(this);
    }

    public void bind(String tugas, String tanggal, String keterangan) {
        tvTugas.setText(tugas);
        tvTanggal.setText(tanggal);
        tvKeterangan.setText(keterangan);
    }

    static ListTugasViewHolder create(ViewGroup parent, ListTugasAdapter.ItemClickListener itemListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_tugas, parent, false);
        return new ListTugasViewHolder(view, itemListener);
    }

    @Override
    public void onClick(View v) {
        itemListener.onItemClick(getAdapterPosition());
    }
}
