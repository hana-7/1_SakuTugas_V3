package com.example.a1_sakutugas_v3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListTugasSelesaiAdapter extends RecyclerView.Adapter<ListTugasSelesaiAdapter.ListTugasSelesaiViewHolder> {
    private ArrayList<ListTugasSelesai> listTugasSelesai;

    public ListTugasSelesaiAdapter(ArrayList<ListTugasSelesai> listTugasSelesai) {
        this.listTugasSelesai = listTugasSelesai;
    }

    @NonNull
    @Override
    public ListTugasSelesaiAdapter.ListTugasSelesaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_tugas_selesai, parent, false);
        return new ListTugasSelesaiAdapter.ListTugasSelesaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTugasSelesaiViewHolder holder, int position) {
        holder.tvTugas2.setText(listTugasSelesai.get(position).getTugas());
        holder.tvTanggal2.setText(listTugasSelesai.get(position).getTanggal());
        holder.tvKeterangan2.setText(listTugasSelesai.get(position).getKeterangan());

    }

    @Override
    public int getItemCount() {
        // return listTugasSelesai.size();
        return (listTugasSelesai != null) ? listTugasSelesai.size() : 0;
    }

    public class ListTugasSelesaiViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTugas2, tvTanggal2, tvKeterangan2;

        public ListTugasSelesaiViewHolder(View view) {
            super(view);

            tvTugas2 = view.findViewById(R.id.tvTugas2);
            tvTanggal2 = view.findViewById(R.id.tvTanggal2);
            tvKeterangan2 = view.findViewById(R.id.tvKeterangan2);
        }
    }
}
