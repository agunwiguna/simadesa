package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class GaleriModel {

    @SerializedName("judul")
    private String judul;
    @SerializedName("foto")
    private String foto;

    public String getJudul() {
        return judul;
    }

    public String getFoto() {
        return foto;
    }
}
