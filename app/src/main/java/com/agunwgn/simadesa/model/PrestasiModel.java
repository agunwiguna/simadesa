package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class PrestasiModel {

    @SerializedName("prestasi")
    private String prestasi;
    @SerializedName("tahun")
    private String tahun;

    public String getPrestasi() {
        return prestasi;
    }

    public void setPrestasi(String prestasi) {
        this.prestasi = prestasi;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
