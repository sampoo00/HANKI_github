package com.hanki.hanki.ShopOrder.ShopPayment.IamPort;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopPayment.IamPort.sdk.KcpWebViewClient;

public class iamPortMainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iam_port_main);

        setUpToolbar();
        setUpWebView();
    }

    public void setUpToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.iamPort_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("결제 창");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void setUpWebView(){
        mWebView = (WebView) findViewById(R.id.iamPort_webView);

        mWebView.setWebViewClient(new KcpWebViewClient(this, mWebView));
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setAcceptThirdPartyCookies(mWebView, true);
        }

        Intent intent = getIntent();
        Uri intentData = intent.getData();


        mWebView.loadUrl("http://www.iamport.kr/demo");
    }

}
