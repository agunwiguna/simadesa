package com.agunwgn.simadesa;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class ProfileFragment extends Fragment {

    ImageView icMap,icSetting,icWeb,img;
    RelativeLayout header;

    int imgProfile = R.drawable.logo_desa;
    int imgMap = R.drawable.map;
    int imgWeb = R.drawable.domain;
    int imgSetting = R.drawable.setting;
    int imgHeader = R.drawable.bgheader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,null);

        header = view.findViewById(R.id.headerProfile);
        Glide.with(this).load(imgHeader).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    header.setBackground(resource);
                }
            }
        });

        img = view.findViewById(R.id.profile_image);
        Glide
                .with(getContext())
                .load(imgProfile)
                .into(img);

        icMap = view.findViewById(R.id.icMap);
        Glide
                .with(getContext())
                .load(imgMap)
                .into(icMap);
        icMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("geo:-6.757837,108.058473");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

        icSetting = view.findViewById(R.id.ic_setting);
        Glide
                .with(getContext())
                .load(imgSetting)
                .into(icSetting);
        icSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),SettingActivity.class);
                startActivity(i);
            }
        });

        icWeb = view.findViewById(R.id.icWeb);
        Glide
                .with(getContext())
                .load(imgWeb)
                .into(icWeb);
        icWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://desa-babakanasem.id/"));
                startActivity(i);
            }
        });


        return view;
    }
}
