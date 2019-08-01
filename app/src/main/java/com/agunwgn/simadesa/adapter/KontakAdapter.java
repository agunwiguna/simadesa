package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.KontakModel;

import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.MyHolder> {

    Context ctx;
    List<KontakModel> mList;

    public KontakAdapter(Context ctx, List<KontakModel> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public KontakAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kontak,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(KontakAdapter.MyHolder holder,final int position) {
        final KontakModel km = mList.get(position);
        holder.nama.setText(km.getNama());
        holder.jabatan.setText(km.getJabatan());
        holder.nomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = km.getNomor();
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                ctx.startActivity(dialPhoneIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView nama,jabatan;
        ImageView nomor;

        public MyHolder(View v) {
            super(v);

            nama = v.findViewById(R.id.txtNamaKontak);
            jabatan = v.findViewById(R.id.txtJabatan);
            nomor = v.findViewById(R.id.imgSekdes);
        }
    }
}
