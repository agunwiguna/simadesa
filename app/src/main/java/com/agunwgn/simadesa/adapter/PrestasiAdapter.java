package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.PrestasiModel;

import java.util.List;

public class PrestasiAdapter extends RecyclerView.Adapter<PrestasiAdapter.MyHolder> {

    List<PrestasiModel> mList;
    Context ctx;

    public PrestasiAdapter(Context ctx,List<PrestasiModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public PrestasiAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prestasi,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(PrestasiAdapter.MyHolder holder,final int position) {

        final PrestasiModel pm = mList.get(position);
        holder.prestasi.setText(pm.getPrestasi());
        holder.tahun.setText(pm.getTahun());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView prestasi,tahun;

        public MyHolder(View v) {
            super(v);

            prestasi = v.findViewById(R.id.txtPrestasi);
            tahun = v.findViewById(R.id.txtTahun);
        }
    }
}
