package com.agunwgn.simadesa;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agunwgn.simadesa.api.ApiEndPoint;
import com.agunwgn.simadesa.api.ApiService;
import com.agunwgn.simadesa.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsulanActivity extends AppCompatActivity {

    private EditText edtNama;
    private EditText edtRt;
    private EditText edtUsulan;
    private Button btnSend;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan);

        edtNama = findViewById(R.id.edtNama);
        edtRt = findViewById(R.id.edtRt);
        edtUsulan = findViewById(R.id.edtUsulan);

        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = edtNama.getText().toString();
                String rt = edtRt.getText().toString();
                String usulan = edtUsulan.getText().toString();

                boolean isEmptyFields = false;

                if(TextUtils.isEmpty(nama)){
                    isEmptyFields = true;
                    edtNama.setError("Field ini tidak boleh kosong");
                }

                if(TextUtils.isEmpty(rt)){
                    isEmptyFields = true;
                    edtRt.setError("Field ini tidak boleh kosong");
                }

                if(TextUtils.isEmpty(usulan)){
                    isEmptyFields = true;
                    edtUsulan.setError("Field ini tidak boleh kosong");
                }

                if(!isEmptyFields){

                    progress = new ProgressDialog(UsulanActivity.this);
                    progress.setCancelable(false);
                    progress.setMessage("Loading ...");
                    progress.show();

                    ApiService api = ApiEndPoint.getClient().create(ApiService.class);
                    Call<ResponseModel> addUsulanCall = api.postUsulan(nama,rt,usulan);
                    addUsulanCall.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                            String statusCode = response.body().getStatusCode();
                            String message = response.body().getMessage();

                            progress.dismiss();

                            edtNama.setText("");
                            edtRt.setText("");
                            edtUsulan.setText("");

                            if (statusCode.equals("200")) {
                                Toast.makeText(UsulanActivity.this, message, Toast.LENGTH_SHORT).show();
                            } else if (statusCode.equals("404")) {
                                Toast.makeText(UsulanActivity.this, message, Toast.LENGTH_SHORT).show();
                            } else if (statusCode.equals("500")) {
                                Toast.makeText(UsulanActivity.this, message, Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {

                            progress.dismiss();
                            Toast.makeText(UsulanActivity.this, "Oops, Tidak Ada Koneksi Internet!! ", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });

    }
}
