package com.agunwgn.simadesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agunwgn.simadesa.adapter.UmkmAdapter;
import com.agunwgn.simadesa.api.ApiEndPoint;
import com.agunwgn.simadesa.api.ApiService;
import com.agunwgn.simadesa.model.ResponseModel;
import com.agunwgn.simadesa.model.UmkmModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UmkmActivity extends AppCompatActivity {

    private UmkmAdapter viewAdapter;
    private List<UmkmModel> mItems = new ArrayList<>();
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umkm);

        recyclerView = findViewById(R.id.recyclerUmkm);
        progressBar = findViewById(R.id.progress_bar);

        viewAdapter = new UmkmAdapter(this, mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataUmkm();
    }

    private void loadDataUmkm() {

        ApiService api = ApiEndPoint.getClient().create(ApiService.class);
        Call<ResponseModel> call = api.getUmkm();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                String statusCode = response.body().getStatusCode();
                progressBar.setVisibility(View.GONE);
                if (statusCode.equals("200")) {
                    mItems = response.body().getuResult();
                    viewAdapter = new UmkmAdapter(UmkmActivity.this, mItems);
                    recyclerView.setAdapter(viewAdapter);
                }

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(UmkmActivity.this, "Oops, Tidak Ada Koneksi Internet!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
