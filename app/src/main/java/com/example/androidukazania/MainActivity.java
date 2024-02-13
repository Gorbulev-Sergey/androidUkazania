package com.example.androidukazania;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://svelte-ukazania.netlify.app/");

        SwipeRefreshLayout swiper = findViewById(R.id.swiper);
        swiper.setOnRefreshListener(() -> {
            webView.loadUrl("https://svelte-ukazania.netlify.app/");
            swiper.setRefreshing(false);
        });


    }
}