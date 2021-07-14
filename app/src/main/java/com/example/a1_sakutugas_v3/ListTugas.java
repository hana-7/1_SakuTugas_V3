package com.example.a1_sakutugas_v3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "listTugas_table")
public class ListTugas {

//    @PrimaryKey (autoGenerate = true)
//    private int id;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "listTugas")
    private String tugas;

//    @NonNull
//    @ColumnInfo(name = "tanggal")
    private String tanggal;

//    @NonNull
//    @ColumnInfo(name = "keterangan")
    private String keterangan;

    public ListTugas(@NonNull String tugas, String tanggal, String keterangan) {
        this.tugas = tugas;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
