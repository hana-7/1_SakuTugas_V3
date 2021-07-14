package com.example.a1_sakutugas_v3;

public class ListTugasSelesai {
    private String tugas2;
    private String tanggal2;
    private String keterangan2;

    public ListTugasSelesai(String tugas, String tanggal, String keterangan) {
        this.tugas2 = tugas;
        this.tanggal2 = tanggal;
        this.keterangan2 = keterangan;
    }

    public String getTugas() {
        return tugas2;
    }

    public void setTugas(String tugas) {
        this.tugas2 = tugas;
    }

    public String getTanggal() {
        return tanggal2;
    }

    public void setTanggal(String tanggal) {
        this.tanggal2 = tanggal;
    }

    public String getKeterangan() {
        return keterangan2;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan2 = keterangan;
    }
}
