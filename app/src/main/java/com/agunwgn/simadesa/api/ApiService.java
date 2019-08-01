package com.agunwgn.simadesa.api;

import com.agunwgn.simadesa.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Android/add_usulan")
    Call<ResponseModel> postUsulan(@Field("nama") String nama,
                                   @Field("rt") String rt,
                                   @Field("usulan") String usulan);

    @GET("Android/tampil_info")
    Call<ResponseModel> getInfo();

    @GET("Android/tampil_prestasi")
    Call<ResponseModel> getPrestasi();

    @GET("Android/tampil_umkm")
    Call<ResponseModel> getUmkm();

    @GET("Android/tampil_komoditi")
    Call<ResponseModel> getKomoditi();

    @GET("Android/tampil_kontak")
    Call<ResponseModel> getKontak();

    @GET("Android/tampil_galeri")
    Call<ResponseModel> getGaleri();

    @GET("Android/tampil_struktur")
    Call<ResponseModel> getStruktur();

    @GET("Android/tampil_layanan")
    Call<ResponseModel> getLayanan();

    @GET("Android/tampil_mitra")
    Call<ResponseModel> getMitra();

    @GET("Android/tampil_agenda_rutin")
    Call<ResponseModel> getAgendaRutin();

    @GET("Android/tampil_agenda_no_rutin")
    Call<ResponseModel> getAgendaNoRutin();

}
