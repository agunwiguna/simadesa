package com.agunwgn.simadesa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agunwgn.simadesa.adapter.GaleriAdapter;
import com.agunwgn.simadesa.api.ApiEndPoint;
import com.agunwgn.simadesa.api.ApiService;
import com.agunwgn.simadesa.model.GaleriModel;
import com.agunwgn.simadesa.model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private GaleriAdapter viewAdapter;
    private List<GaleriModel> mItems = new ArrayList<>();
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery,null);

        recyclerView = view.findViewById(R.id.recyclerGaleri);
        progressBar = view.findViewById(R.id.progress_bar);

        viewAdapter = new GaleriAdapter(getContext(), mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataGaleri();

        return view;
    }

    private void loadDataGaleri() {

        ApiService api = ApiEndPoint.getClient().create(ApiService.class);
        Call<ResponseModel> call = api.getGaleri();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                String statusCode = response.body().getStatusCode();
                progressBar.setVisibility(View.GONE);
                if (statusCode.equals("200")) {
                    mItems = response.body().getgResult();
                    viewAdapter = new GaleriAdapter(getContext(), mItems);
                    recyclerView.setAdapter(viewAdapter);
                }

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Oops, Tidak Ada Koneksi Internet!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
