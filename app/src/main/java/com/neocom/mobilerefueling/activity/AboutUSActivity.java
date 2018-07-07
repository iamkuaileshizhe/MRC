package com.neocom.mobilerefueling.activity;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.neocom.mobilerefueling.R;

import butterknife.BindView;

/**
 * Created by admin on 2017/12/13.
 * 关于我们
 */

public class AboutUSActivity extends BaseActivity {

    @BindView(R.id.web_intro)
    WebView webIntro;

    @Override
    public void initContentView() {
        setContentView(R.layout.about_us_layout);
    }

    @Override
    public void initView() {


        findViewById(R.id.top_title_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        WebSettings settings = webIntro.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        webIntro.loadUrl("file:///android_asset/index.html");
        webIntro.setWebViewClient(new WebViewClient());

    }


    @Override
    public void initData() {

    }
}
