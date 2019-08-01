package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.agunwgn.simadesa.DetailMitraActivity;
import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.MitraModel;

import java.util.List;

public class MitraAdapter extends RecyclerView.Adapter<MitraAdapter.MyHolder> {

    List<MitraModel> mList;
    Context ctx;

    public MitraAdapter(Context ctx,List<MitraModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MitraAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mitra,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(MitraAdapter.MyHolder holder,final int position) {
        final MitraModel mm = mList.get(position);
        String img_url = "http://desa-babakanasem.id/"+mm.getLogo();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.logo);
        holder.nama_mitra.setText(mm.getNama_mitra());

        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, DetailMitraActivity.class);
                i.putExtra(DetailMitraActivity.EXTRA_NAMA_MITRA,mm.getNama_mitra());
                i.putExtra(DetailMitraActivity.EXTRA_ALAMAT_MITRA,mm.getAlamat_mitra());
                i.putExtra(DetailMitraActivity.EXTRA_KONTAK_MITRA,mm.getNo_kontak_mitra());
                i.putExtra(DetailMitraActivity.EXTRA_AWAL_MITRA,mm.getAwal_kerjasama_mitra());
                i.putExtra(DetailMitraActivity.EXTRA_AKHIR_MITRA,mm.getAkhir_kerjasama_mitra());
                i.putExtra(DetailMitraActivity.EXTRA_KERJASAMA_MITRA,mm.getBentuk_kerjasama_mitra());
                i.putExtra(DetailMitraActivity.EXTRA_LOGO,mm.getLogo());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView nama_mitra;
        ImageView logo;

        public MyHolder(View v) {
            super(v);

            nama_mitra = v.findViewById(R.id.txtNamaMitra);
            logo = v.findViewById(R.id.imgMitra);
        }
    }
}
