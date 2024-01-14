package com.example.newtestadultomayor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Information extends AppCompatActivity {
    WebView p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        p = (WebView) findViewById(R.id.i);
        p.loadUrl("file:///android_asset/programador.html");
        WebSettings webSettings3 = p.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        webSettings3.setBuiltInZoomControls(true);
        webSettings3.setDisplayZoomControls(false);
        webSettings3.setLoadsImagesAutomatically(true);

    }
}