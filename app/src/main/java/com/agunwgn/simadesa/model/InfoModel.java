package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class InfoModel {

    @SerializedName("judul")
    private String judul;
    @SerializedName("isi")
    private String isi;
    @SerializedName("pengirim")
    private String pengirim;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("foto")
    private String foto;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
