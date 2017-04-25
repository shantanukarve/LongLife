package com.example.tarat.longlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import static android.R.id.message;

public class Simulate extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulationcontainer);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String sex = intent.getStringExtra(MainActivity.EXTRA_SEX);

        mWebView = (WebView) findViewById(R.id.simulate_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
//        mWebView.loadUrl("http://www.example.com");
//        mWebView.loadUrl("file:///android_asset/example.html");
        mWebView.loadUrl("file:///android_asset/horizontal.html");

        // Capture the layout's TextView and set the string as its text
//        TextView textView = (TextView) findViewById(R.id.textView3);
//        textView.setText(message);

    }
}
