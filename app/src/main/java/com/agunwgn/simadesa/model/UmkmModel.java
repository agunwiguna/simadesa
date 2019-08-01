package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class UmkmModel {

    @SerializedName("nama_perusahaan")
    private String nama_perusahaan;
    @SerializedName("pemilik")
    private String pemilik;
    @SerializedName("barang")
    private String barang;
    @SerializedName("kontak")
    private String kontak;
    @SerializedName("foto")
    private String foto;

    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public String getPemilik() {
        return pemilik;
    }

    public String getBarang() {
        return barang;
    }

    public String getKontak() {
        return kontak;
    }

    public String getFoto() {
        return foto;
    }
}
