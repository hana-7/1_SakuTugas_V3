package com.example.a1_sakutugas_v3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {
    private TextView tugas;
    private TextView tanggal;
    private TextView keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Bundle bundle = getIntent().getExtras();

//        TextView tugas = findViewById(R.id.DetailTugas);
//        TextView tanggal = findViewById(R.id.DetailTanggal);
//        TextView keterangan = findViewById(R.id.DetailKeterangan);

        tugas = findViewById(R.id.DetailTugas);
        tanggal = findViewById(R.id.DetailTanggal);
        keterangan = findViewById(R.id.DetailKeterangan);

        tugas.setText(bundle.getString("tugas"));
        tanggal.setText(bundle.getString("tanggal"));
        keterangan.setText(bundle.getString("keterangan"));

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}