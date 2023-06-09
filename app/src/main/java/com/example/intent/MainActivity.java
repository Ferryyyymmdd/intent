package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void tampiltelepon(View view) {
        Intent teleponIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(teleponIntent);
    }

    public void tampilsms(View view) {
        Intent smsintent =new Intent(Intent.ACTION_MAIN);
        smsintent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(smsintent);
    }

    public void tampilkalender(View view) {
        Intent kalenderintent =new Intent(Intent.ACTION_MAIN);
        kalenderintent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(kalenderintent);
    }

    public void tampilbrowser(View view) {
        Intent browserintent = new Intent(Intent.ACTION_MAIN);
        browserintent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(browserintent);
    }


    public void tampilkontak(View view) {
        Intent kontakintent =new Intent(Intent.ACTION_MAIN);
        kontakintent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(kontakintent );
    }


    public void tampilgaleri(View view) {
        Intent galeriintent =new Intent(Intent.ACTION_MAIN);
        galeriintent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(galeriintent );
    }

    public void tampilwifi(View view) {
        Intent wifiintent =new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(wifiintent );
    }

    public void tampilsound(View view) {
        Intent soundIntent =new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(soundIntent);
    }

    public void tampilairplane(View view) {
        Intent airplaneintent =new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(airplaneintent);
    }


    public void tampilbluetooth(View view) {
        Intent bluetoothintent =new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(bluetoothintent);
    }


    public void tampilkalkulator(View view) {
        ArrayList<HashMap<String,Object>> items = new ArrayList<HashMap<String,Object>>();
        final PackageManager pm = getPackageManager();

        List<PackageInfo> packs = pm.getInstalledPackages(0);
        for (PackageInfo pi : packs){
            String packageName = pi.packageName.toString();
            String packageName_lowercase = packageName.toLowerCase();
            if (packageName_lowercase.contains("calcul")){
                HashMap<String,Object> map = new HashMap<String,Object>();
                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);

                items.add(map);
            }
        }

        int item_size = items.size();
        if (item_size >= 1){
            String packageName = (String) items.get(0).get("packageName");
            Intent i = pm.getLaunchIntentForPackage(packageName);
            if (i != null){
                startActivity(i);
            }else {
                Toast.makeText(getApplicationContext(),"Tidak ditemukan Aplikasi Kalkulator",Toast.LENGTH_SHORT).show();



            }
        }
    }
}