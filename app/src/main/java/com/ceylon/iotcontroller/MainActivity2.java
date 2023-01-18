package com.ceylon.iotcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webView =findViewById(R.id.webview);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";



        Intent intent = getIntent();
        String html =intent.getStringExtra("htmlpost");

        webView.loadDataWithBaseURL("","<style>img{display: inline;height: auto;max-width: 100%;}</style>"+ html, mimeType, encoding, "");
    }
}