package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.LayananModel;

import java.util.List;

public class LayananAdapter extends RecyclerView.Adapter<LayananAdapter.MyHolder> {

    List<LayananModel> mList;
    Context ctx;

    public LayananAdapter(Context ctx, List<LayananModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public LayananAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(LayananAdapter.MyHolder holder,final int position) {

        final LayananModel lm = mList.get(position);
        holder.nama.setText(lm.getNama());
        holder.haris.setText(lm.getHaris());
        holder.waktu.setText(lm.getWaktu());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView nama, haris, waktu;

        public MyHolder(View v) {
            super(v);

            nama = v.findViewById(R.id.txtLayanan);
            haris = v.findViewById(R.id.txtHariLayanan);
            waktu = v.findViewById(R.id.txtWaktuLayanan);
        }
    }
}
