package com.agunwgn.simadesa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agunwgn.simadesa.R;
import com.agunwgn.simadesa.model.AgendaModel;

import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.MyHolder> {

    List<AgendaModel> mList;
    Context ctx;

    public AgendaAdapter( Context ctx, List<AgendaModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public AgendaAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda_rutin,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(AgendaAdapter.MyHolder holder,final int position) {
        final AgendaModel am = mList.get(position);
        holder.ketua_pelaksana.setText(am.getKetua_pelaksana());
        holder.haris.setText(am.getHari());
        holder.tempat.setText(am.getTempat());
        holder.deskripsi.setText(am.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView ketua_pelaksana,haris,tempat,deskripsi;

        public MyHolder(View v) {
            super(v);

            ketua_pelaksana = v.findViewById(R.id.txtKetuaRutin);
            haris = v.findViewById(R.id.txtHariRutin);
            tempat = v.findViewById(R.id.txtTempatRutin);
            deskripsi = v.findViewById(R.id.txtKeteranganRutin);

        }
    }
}
