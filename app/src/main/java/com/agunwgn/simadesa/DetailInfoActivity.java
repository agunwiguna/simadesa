package com.agunwgn.simadesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailInfoActivity extends AppCompatActivity {

    public static final String EXTRA_JUDUL   = "extra_judul";
    public static final String EXTRA_ISI = "extra_isi";
    public static final String EXTRA_PENGIRIM = "extra_pengirim";
    public static final String EXTRA_TANGGAL = "extra_tanggal";
    public static final String EXTRA_PHOTO = "extra_photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView tvJudul,tvIsi,tvPengirim,tvTanggal;
        ImageView imgFoto;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvJudul = findViewById(R.id.tvJudul);
        tvIsi = findViewById(R.id.tvIsi);
        tvPengirim = findViewById(R.id.tvPengirim);
        tvTanggal = findViewById(R.id.tvTanggal);
        imgFoto = findViewById(R.id.imgFoto);

        String judul = getIntent().getStringExtra(EXTRA_JUDUL);
        String isi = getIntent().getStringExtra(EXTRA_ISI);
        String pengirim = getIntent().getStringExtra(EXTRA_PENGIRIM);
        String tanggal = getIntent().getStringExtra(EXTRA_TANGGAL);
        String foto = getIntent().getStringExtra(EXTRA_PHOTO);

        String rIsi = Html.fromHtml(isi).toString().replaceAll("\n", "").trim();

        String img_url = "http://desa-babakanasem.id/"+foto;

        Glide.with(this).load(img_url).into(imgFoto);

        tvJudul.setText(judul);
        tvIsi.setText(rIsi);
        tvPengirim.setText(pengirim);
        tvTanggal.setText(tanggal);
    }
}
