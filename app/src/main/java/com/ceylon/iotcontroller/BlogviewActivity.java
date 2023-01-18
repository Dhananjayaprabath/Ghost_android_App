package com.ceylon.iotcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

public class BlogviewActivity extends AppCompatActivity {

    TextView tital;
    ImageView imageView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogview);

        getSupportActionBar().hide();

        tital = findViewById(R.id.tital);
        imageView=findViewById(R.id.app_bar_image);



        Intent intent = getIntent();
       tital.setText(intent.getStringExtra("titals"));
        String imgs =intent.getStringExtra("coverimgs");

        Picasso.get().load(imgs).into(imageView);




        webView =findViewById(R.id.webview);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";




        String html =intent.getStringExtra("htmlpost");

       webView.loadDataWithBaseURL("","<style>img{display: inline;height: auto;max-width: 100%;}</style>"+ html, mimeType, encoding, "");


    }


    }
