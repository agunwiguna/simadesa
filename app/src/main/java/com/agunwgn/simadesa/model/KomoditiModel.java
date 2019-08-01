package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class KomoditiModel {

    @SerializedName("jenis")
    private String jenis;
    @SerializedName("nama_komoditi")
    private String nama_komoditi;
    @SerializedName("foto")
    private String foto;

    public String getJenis() {
        return jenis;
    }

    public String getNama_komoditi() {
        return nama_komoditi;
    }

    public String getFoto() {
        return foto;
    }
}
