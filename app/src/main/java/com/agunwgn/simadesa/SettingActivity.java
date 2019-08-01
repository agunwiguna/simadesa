package com.agunwgn.simadesa;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class SettingActivity extends AppCompatActivity {

    private AppCompatDialog dialog;
    TextView aboutApp;

    private static final String PREF_SWITCH_NEWS = "switch_news";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        aboutApp = findViewById(R.id.aboutApp);
        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new AppCompatDialog(SettingActivity.this);
                dialog.setContentView(R.layout.dialog_about);
                dialog.show();

            }
        });

        Switch switchNews = findViewById(R.id.switchNews);
        switchNews.setChecked(isSwitchChecked(PREF_SWITCH_NEWS));
        switchNews.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                setSwitchChecked(PREF_SWITCH_NEWS, checked);

                if(checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("news");
                    Toast.makeText(getApplicationContext(), "Notifikasi Diaktifkan" , Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
                    Toast.makeText(getApplicationContext(), "Notifikasi Dinonaktifkan" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setSwitchChecked(String permission, boolean isChecked) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(permission, isChecked);
        editor.apply();
    }

    private boolean isSwitchChecked(String permission) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getBoolean(permission, false);
    }
}
