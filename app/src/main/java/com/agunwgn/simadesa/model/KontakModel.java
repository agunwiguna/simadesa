package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class KontakModel {

    @SerializedName("nama")
    private String nama;
    @SerializedName("jabatan")
    private String jabatan;
    @SerializedName("nomor")
    private String nomor;

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getNomor() {
        return nomor;
    }
}
