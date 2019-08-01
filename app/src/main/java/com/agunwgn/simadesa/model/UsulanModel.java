package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class UsulanModel {

    @SerializedName("nama")
    private String nama;
    @SerializedName("rt")
    private String rt;
    @SerializedName("usulan")
    private String usulan;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getUsulan() {
        return usulan;
    }

    public void setUsulan(String usulan) {
        this.usulan = usulan;
    }
}
