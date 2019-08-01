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
import com.agunwgn.simadesa.DetailStrukturActivity;
import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.StrukturModel;

import java.util.List;

public class StrukturAdapter extends RecyclerView.Adapter<StrukturAdapter.MyHolder> {

    List<StrukturModel> mList;
    Context ctx;

    public StrukturAdapter(Context ctx,List<StrukturModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public StrukturAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_struktur,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(StrukturAdapter.MyHolder holder, final int position) {
        final StrukturModel sm = mList.get(position);
        String img_url = "http://desa-babakanasem.id/"+sm.getFoto();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.foto);
        holder.nama.setText(sm.getNama());
        holder.jabatan.setText(sm.getJabatan());

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, DetailStrukturActivity.class);
                i.putExtra(DetailStrukturActivity.EXTRA_NAMA,sm.getNama());
                i.putExtra(DetailStrukturActivity.EXTRA_JABATAN,sm.getJabatan());
                i.putExtra(DetailStrukturActivity.EXTRA_NO_KONTAK,sm.getNo_kontak());
                i.putExtra(DetailStrukturActivity.EXTRA_ALAMAT,sm.getAlamat());
                i.putExtra(DetailStrukturActivity.EXTRA_FOTO,sm.getFoto());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView nama,jabatan;
        ImageView foto;

        public MyHolder(View v) {
            super(v);

            nama = v.findViewById(R.id.txtNamaStruktur);
            jabatan = v.findViewById(R.id.txtJabatanStruktur);
            foto = v.findViewById(R.id.imgStruktur);

        }
    }
}
