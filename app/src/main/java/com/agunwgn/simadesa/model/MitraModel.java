package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

public class MitraModel {

    @SerializedName("nama_mitra")
    private String nama_mitra;
    @SerializedName("no_kontak_mitra")
    private String no_kontak_mitra;
    @SerializedName("alamat_mitra")
    private String alamat_mitra;
    @SerializedName("bentuk_kerjasama_mitra")
    private String bentuk_kerjasama_mitra;
    @SerializedName("awal_kerjasama_mitra")
    private String awal_kerjasama_mitra;
    @SerializedName("akhir_kerjasama_mitra")
    private String akhir_kerjasama_mitra;
    @SerializedName("logo")
    private String logo;

    public String getNama_mitra() {
        return nama_mitra;
    }

    public String getNo_kontak_mitra() {
        return no_kontak_mitra;
    }

    public String getAlamat_mitra() {
        return alamat_mitra;
    }

    public String getBentuk_kerjasama_mitra() {
        return bentuk_kerjasama_mitra;
    }

    public String getAwal_kerjasama_mitra() {
        return awal_kerjasama_mitra;
    }

    public String getAkhir_kerjasama_mitra() {
        return akhir_kerjasama_mitra;
    }

    public String getLogo() {
        return logo;
    }
}
