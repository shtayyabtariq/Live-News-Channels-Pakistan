package xeon.com.youtube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mopub.xeon.com.mopub.ApplicationController;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class NewsDetailActivity extends AppCompatActivity {

    WebView webView;
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().registerActivityLifecycleCallbacks(ApplicationController.getInstance());

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_detail);


        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        //  Toast.makeText(getApplicationContext(),getIntent().getStringExtra("Url"),Toast.LENGTH_LONG).show();
        webView.loadUrl(getIntent().getStringExtra("Url"));
        mContentView = findViewById(R.id.newsdetailactivity);
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


    }


}
