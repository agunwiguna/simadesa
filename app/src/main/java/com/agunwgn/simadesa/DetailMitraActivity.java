package com.agunwgn.simadesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMitraActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA_MITRA   = "extra_nama_mitra";
    public static final String EXTRA_KONTAK_MITRA = "extra_kontak_mitra";
    public static final String EXTRA_ALAMAT_MITRA = "extra_alamat_mitra";
    public static final String EXTRA_KERJASAMA_MITRA = "extra_kerjasama_mitra";
    public static final String EXTRA_AWAL_MITRA = "extra_awal_mitra";
    public static final String EXTRA_AKHIR_MITRA = "extra_akhir_mitra";
    public static final String EXTRA_LOGO = "extra_logo";

    TextView tvNama,tvKontak,tv_alamat,tv_kerjasama,tv_awal,tv_akhir;
    ImageView tvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mitra);

        tvNama = findViewById(R.id.txt_nama_detail_mitra);
        tvKontak = findViewById(R.id.txt_detail_kontak_mitra);
        tv_alamat = findViewById(R.id.txt_detail_alamat_mitra);
        tv_kerjasama = findViewById(R.id.txt_detail_kerjasama);
        tv_awal = findViewById(R.id.txt_detail_awal_mitra);
        tv_akhir = findViewById(R.id.txt_detail_akhir_mitra);
        tvLogo =findViewById(R.id.img_detail_mitra);

        String nama = getIntent().getStringExtra(EXTRA_NAMA_MITRA);
        String kontak = getIntent().getStringExtra(EXTRA_KONTAK_MITRA);
        String alamat = getIntent().getStringExtra(EXTRA_ALAMAT_MITRA);
        String kerjasama = getIntent().getStringExtra(EXTRA_KERJASAMA_MITRA);
        String awal = getIntent().getStringExtra(EXTRA_AWAL_MITRA);
        String akhir = getIntent().getStringExtra(EXTRA_AKHIR_MITRA);
        String logo = getIntent().getStringExtra(EXTRA_LOGO);

        tvNama.setText(nama);
        tvKontak.setText(kontak);
        tv_alamat.setText(alamat);
        tv_kerjasama.setText(kerjasama);
        tv_awal.setText(awal);
        tv_akhir.setText(akhir);

        String img_url = "http://desa-babakanasem.id/"+logo;
        Glide.with(this).load(img_url).into(tvLogo);

    }
}
