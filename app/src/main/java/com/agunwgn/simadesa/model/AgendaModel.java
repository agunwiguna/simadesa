package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class AgendaModel {

    @SerializedName("tgl_pelaksanaan")
    private String tgl_pelaksanaan;
    @SerializedName("hari")
    private String hari;
    @SerializedName("nama_kegiatan")
    private String nama_kegiatan;
    @SerializedName("ketua_pelaksana")
    private String ketua_pelaksana;
    @SerializedName("tempat")
    private String tempat;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("status")
    private String status;

    public String getTgl_pelaksanaan() {
        return tgl_pelaksanaan;
    }

    public String getHari() {
        return hari;
    }

    public String getNama_kegiatan() {
        return nama_kegiatan;
    }

    public String getKetua_pelaksana() {
        return ketua_pelaksana;
    }

    public String getTempat() {
        return tempat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }
}
