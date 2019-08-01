package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.UmkmModel;

import java.util.List;

public class UmkmAdapter extends RecyclerView.Adapter<UmkmAdapter.MyHolder> {

    List<UmkmModel> mList;
    Context ctx;

    public UmkmAdapter(Context ctx,List<UmkmModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public UmkmAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_umkm,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(UmkmAdapter.MyHolder holder,final int position) {

        final UmkmModel umkmModel = mList.get(position);
        String img_url = "http://desa-babakanasem.id/"+umkmModel.getFoto();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.foto);
        holder.nama_perusahaan.setText(umkmModel.getNama_perusahaan());
        holder.barang.setText(umkmModel.getBarang());

        holder.kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = umkmModel.getKontak();
                String formatNumber = phoneNumber.replaceFirst("0","+62");
                String url = "https://api.whatsapp.com/send?phone="+formatNumber;
                Intent dialphone = new Intent(Intent.ACTION_VIEW);
                dialphone.setData(Uri.parse(url));
                ctx.startActivity(dialphone);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView nama_perusahaan, barang, pemilik;
        ImageView foto;
        Button kontak;

        public MyHolder(View v) {
            super(v);

            nama_perusahaan = v.findViewById(R.id.txtPerusahaan);
            barang = v.findViewById(R.id.txtProduk);
            foto = v.findViewById(R.id.imgProduk);
            kontak = v.findViewById(R.id.btnPesan);
        }
    }
}
