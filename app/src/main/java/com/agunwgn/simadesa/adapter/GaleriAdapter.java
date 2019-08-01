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
import com.agunwgn.simadesa.model.GaleriModel;

import java.util.List;

public class GaleriAdapter extends RecyclerView.Adapter<GaleriAdapter.MyHolder> {

    List<GaleriModel> mList;
    Context ctx;

    public GaleriAdapter(Context ctx, List<GaleriModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public GaleriAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(GaleriAdapter.MyHolder holder,final int position) {

        final GaleriModel gm = mList.get(position);
        String img_url = "http://desa-babakanasem.id/"+gm.getFoto();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.foto);
        holder.judul.setText(gm.getJudul());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView judul;
        ImageView foto;

        public MyHolder(View v) {
            super(v);

            judul = v.findViewById(R.id.txtJudulGaleri);
            foto = v.findViewById(R.id.imgGaleri);

        }
    }
}
