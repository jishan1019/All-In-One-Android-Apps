package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import co.notix.interstitial.InterstitialLoader;
import co.notix.interstitial.NotixInterstitial;
import kotlin.Unit;

public class WebViewActivity extends AppCompatActivity {

    WebView webview;

    String url = "https://polite-rugelach-4352a6.netlify.app/";

    static InterstitialLoader interstitialLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview  = findViewById(R.id.webview);


        interstitialLoader = NotixInterstitial.Companion.createLoader(7204364);
        interstitialLoader.startLoading();

        webview.addJavascriptInterface(new WebAppInterface(this), "Android");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);

    }


    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        // Method to handle printing
        @JavascriptInterface
        public void showToast() {
            Toast.makeText(WebViewActivity.this, "Ami webview theke click", Toast.LENGTH_SHORT).show();
            showMonitag();
        }
    }


    private void showMonitag(){
        WebViewActivity.interstitialLoader.doOnNextAvailable(result -> {
            if (result != null) {
                NotixInterstitial.Companion.show(result);
            }
            return Unit.INSTANCE;
        });
    }

}