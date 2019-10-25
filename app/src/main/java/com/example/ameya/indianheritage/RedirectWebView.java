package com.example.ameya.indianheritage;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

public class RedirectWebView extends AppCompatActivity {
    public WebView mWebView = null;
    public HeritageDetails data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("DEBUG", "redirected");
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        Bundle mBundle  = getIntent().getExtras();
        String url = i.getStringExtra("url");

        setContentView(R.layout.activity_web_view);
        mWebView = (android.webkit.WebView) findViewById(R.id.web_view);
        mWebView.getSettings().getJavaScriptEnabled();
        // Log.d("DEBUG", url);
        Log.d( "LOGCAT",""+url );
        if(mBundle != null) {
            mWebView.loadUrl( mBundle.getString( "url" ) );
        }
    }
}
