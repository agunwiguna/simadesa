package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class LayananModel {

    @SerializedName("nama")
    private String nama;
    @SerializedName("haris")
    private String haris;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("petugas")
    private String petugas;
    @SerializedName("kontak")
    private String kontak;

    public String getNama() {
        return nama;
    }

    public String getHaris() {
        return haris;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getPetugas() {
        return petugas;
    }

    public String getKontak() {
        return kontak;
    }
}
