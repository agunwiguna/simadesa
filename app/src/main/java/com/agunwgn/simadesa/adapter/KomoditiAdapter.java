package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.KomoditiModel;

import java.util.List;

public class KomoditiAdapter extends RecyclerView.Adapter<KomoditiAdapter.MyHolder>{

    List<KomoditiModel> mList;
    Context ctx;

    public KomoditiAdapter(Context ctx, List<KomoditiModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public KomoditiAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_komoditi,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(KomoditiAdapter.MyHolder holder,final int position) {

        final KomoditiModel km = mList.get(position);
        String img_url = "http://desa-babakanasem.id/"+km.getFoto();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.foto);
        holder.jenis.setText(km.getJenis());
        holder.nama_komoditi.setText(km.getNama_komoditi());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView jenis, nama_komoditi;
        ImageView foto;

        public MyHolder(View v) {
            super(v);

            jenis = v.findViewById(R.id.txtJenis);
            nama_komoditi = v.findViewById(R.id.txtKomoditi);
            foto = v.findViewById(R.id.imgKomoditi);

        }
    }
}
