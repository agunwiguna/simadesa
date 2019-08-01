package com.agunwgn.simadesa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    CarouselView carouselView;
    CardView usulan,umkm,card_info,card_prestasi,card_layanan,card_mitra,card_komoditi,card_agenda,card_kontak;
    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        card_info = view.findViewById(R.id.card_info);
        card_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InfoActivity.class);
                startActivity(i);
            }
        });

        usulan = view.findViewById(R.id.card_usulan);
        usulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UsulanActivity.class);
                startActivity(i);
            }
        });

        card_prestasi = view.findViewById(R.id.card_prestasi);
        card_prestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PrestasiActivity.class);
                startActivity(i);
            }
        });

        umkm = view.findViewById(R.id.card_umkm);
        umkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UmkmActivity.class);
                startActivity(i);
            }
        });

        card_mitra = view.findViewById(R.id.card_mitra);
        card_mitra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MitraActivity.class);
                startActivity(i);
            }
        });

        card_komoditi = view.findViewById(R.id.card_komoditi);
        card_komoditi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), KomoditiActivity.class);
                startActivity(i);
            }
        });

        card_kontak = view.findViewById(R.id.card_kontak);
        card_kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), KontakActivity.class);
                startActivity(i);
            }
        });

        card_agenda = view.findViewById(R.id.card_agenda);
        card_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AgendaActivity.class);
                startActivity(i);
            }
        });

        card_layanan = view.findViewById(R.id.card_layanan);
        card_layanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LayananActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
