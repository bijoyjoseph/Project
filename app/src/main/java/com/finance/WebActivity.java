package com.finance;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Avinash on 5/18/2016.
 */
public class WebActivity extends Activity {
    private WebView webView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initUi();
    }

    private void initUi() {
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(getIntent().getStringExtra("URL"));
    }
}
