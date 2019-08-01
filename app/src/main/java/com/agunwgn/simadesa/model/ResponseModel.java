package com.agunwgn.simadesa.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ResponseModel {

    List<InfoModel> result;
    List<PrestasiModel> pResult;
    List<UmkmModel> uResult;
    List<KomoditiModel> kResult;
    List<KontakModel> ktkResult;
    List<GaleriModel> gResult;
    List<StrukturModel> sResult;
    List<LayananModel> lResult;
    List<MitraModel> mResult;
    List<AgendaModel> arResult;
    List<AgendaModel> anrResult;
    @SerializedName("status_code")
    private String statusCode;
    @SerializedName("message")
    private String message;

    public List<InfoModel> getResult() {
        return result;
    }

    public void setResult(List<InfoModel> result) {
        this.result = result;
    }

    public List<PrestasiModel> getpResult() {
        return pResult;
    }

    public void setpResult(List<PrestasiModel> pResult) {
        this.pResult = pResult;
    }

    public List<UmkmModel> getuResult() {
        return uResult;
    }

    public void setuResult(List<UmkmModel> uResult) {
        this.uResult = uResult;
    }

    public List<KomoditiModel> getkResult() {
        return kResult;
    }

    public void setkResult(List<KomoditiModel> kResult) {
        this.kResult = kResult;
    }

    public List<KontakModel> getktkResult() {
        return ktkResult;
    }

    public void setktkResult(List<KontakModel> ktkResult) {
        this.ktkResult = ktkResult;
    }

    public List<GaleriModel> getgResult() {
        return gResult;
    }

    public void setgResult(List<GaleriModel> gResult) {
        this.gResult = gResult;
    }

    public List<StrukturModel> getsResult() {
        return sResult;
    }

    public void setsResult(List<StrukturModel> sResult) {
        this.sResult = sResult;
    }

    public List<LayananModel> getlResult() {
        return lResult;
    }

    public void setlResult(List<LayananModel> lResult) {
        this.lResult = lResult;
    }

    public List<MitraModel> getmResult() {
        return mResult;
    }

    public void setmResult(List<MitraModel> mResult) {
        this.mResult = mResult;
    }

    public List<AgendaModel> getArResult() {
        return arResult;
    }

    public void setArResult(List<AgendaModel> arResult) {
        this.arResult = arResult;
    }

    public List<AgendaModel> getAnrResult() {
        return anrResult;
    }

    public void setAnrResult(List<AgendaModel> anrResult) {
        this.anrResult = anrResult;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
