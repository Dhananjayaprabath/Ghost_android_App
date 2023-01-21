package com.ceylon.ghost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class BlogviewActivity extends AppCompatActivity {

    TextView tital;
    ImageView imageView;
    WebView webView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogview);



        tital = findViewById(R.id.tital);
        imageView=findViewById(R.id.app_bar_image);



        Intent intent = getIntent();
        String maintital =intent.getStringExtra("titals");
       tital.setText(maintital);
        String imgs =intent.getStringExtra("coverimgs");
        String surls =intent.getStringExtra("urls");

        Picasso.get().load(imgs).into(imageView);




        webView =findViewById(R.id.webview);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";

floatingActionButton=findViewById(R.id.floatingActionButton1);
floatingActionButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intentt = new Intent(Intent.ACTION_SEND);

        // setting type of data shared as text
        intentt.setType("text/plain");
        intentt.putExtra(Intent.EXTRA_SUBJECT,maintital );

        // Adding the text to share using putExtra
        intentt.putExtra(Intent.EXTRA_TEXT, surls);
        startActivity(Intent.createChooser(intentt, "Share Via"));
    }
});


        String html =intent.getStringExtra("htmlpost");

       webView.loadDataWithBaseURL("","<style>img{display: inline;height: auto;max-width: 100%;}</style>"+ html, mimeType, encoding, "");


    }


    }
