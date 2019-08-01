package com.agunwgn.simadesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailStrukturActivity extends AppCompatActivity {

    public static final String EXTRA_JABATAN   = "extra_jabatan";
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_NO_KONTAK = "extra_no_kontak";
    public static final String EXTRA_ALAMAT = "extra_alamat";
    public static final String EXTRA_FOTO = "extra_foto";

    TextView txt_nama_detail_struktur,txt_detail_jabatan,txt_detail_kontak,txt_detail_alamat;
    ImageView img_detail_struktur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_struktur);

        txt_nama_detail_struktur = findViewById(R.id.txt_nama_detail_struktur);
        txt_detail_jabatan = findViewById(R.id.txt_detail_jabatan);
        txt_detail_kontak = findViewById(R.id.txt_detail_kontak);
        txt_detail_alamat = findViewById(R.id.txt_detail_alamat);
        img_detail_struktur = findViewById(R.id.img_detail_struktur);

        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String jabatan = getIntent().getStringExtra(EXTRA_JABATAN);
        String no_kontak = getIntent().getStringExtra(EXTRA_NO_KONTAK);
        String alamat = getIntent().getStringExtra(EXTRA_ALAMAT);
        String foto = getIntent().getStringExtra(EXTRA_FOTO);

        String img_url = "http://desa-babakanasem.id/"+foto;

        Glide.with(this).load(img_url).into(img_detail_struktur);

        txt_nama_detail_struktur.setText(nama);
        txt_detail_jabatan.setText(jabatan);
        txt_detail_kontak.setText(no_kontak);
        txt_detail_alamat.setText(alamat);
    }
}
