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
import com.agunwgn.simadesa.DetailInfoActivity;
import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.InfoModel;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyHolder> {

    List<InfoModel> mList;
    Context ctx;

    public InfoAdapter(Context ctx,List<InfoModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public InfoAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(InfoAdapter.MyHolder holder,final int position) {

        final InfoModel infoModel = mList.get(position);
        String img_url = "http://desa-babakanasem.id/"+infoModel.getFoto();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.foto);
        holder.judul.setText(infoModel.getJudul());
        holder.pengirim.setText(infoModel.getPengirim());

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, DetailInfoActivity.class);
                i.putExtra(DetailInfoActivity.EXTRA_JUDUL,infoModel.getJudul());
                i.putExtra(DetailInfoActivity.EXTRA_ISI,infoModel.getIsi());
                i.putExtra(DetailInfoActivity.EXTRA_PENGIRIM,infoModel.getPengirim());
                i.putExtra(DetailInfoActivity.EXTRA_TANGGAL,infoModel.getTanggal());
                i.putExtra(DetailInfoActivity.EXTRA_PHOTO,infoModel.getFoto());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView judul,isi,pengirim,tanggal;
        ImageView foto;

        public MyHolder(View v) {
            super(v);

            judul = v.findViewById(R.id.txtJudul);
            pengirim = v.findViewById(R.id.txtPengirm);
            foto = v.findViewById(R.id.imgInfo);

        }
    }
}
