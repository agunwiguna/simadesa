package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class StrukturModel {

    @SerializedName("jabatan")
    private String jabatan;
    @SerializedName("nama")
    private String nama;
    @SerializedName("no_kontak")
    private String no_kontak;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("foto")
    private String foto;

    public String getJabatan() {
        return jabatan;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_kontak() {
        return no_kontak;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getFoto() {
        return foto;
    }
}
