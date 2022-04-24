package com.example.newsapp11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity2 extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    private ImageView imageView;
    private TextView appbar_title, appbar_subtitle, date, time, title;
    private boolean isHideToolBarView = false;
    private FrameLayout date_behaviour;
    private LinearLayout titleAppBar;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private String mUrl, mImg, mDate, mSource, mAuthor,mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("");
        appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(this);
        date_behaviour = findViewById(R.id.date_behavior);
        titleAppBar = findViewById(R.id.title_appbar);
        imageView = findViewById(R.id.backdrop);
        appbar_title = findViewById(R.id.title_on_appbar);
        appbar_subtitle = findViewById(R.id.subtitle_on_appbar);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        title = findViewById(R.id.title);
        Intent intent=getIntent();
        mUrl=intent.getStringExtra("url");
        mImg=intent.getStringExtra("img");
        mTitle=intent.getStringExtra("title");
        mDate=intent.getStringExtra("date");
        mSource=intent.getStringExtra("source");
        mAuthor=intent.getStringExtra("author");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(Utils.getRandomDrawbleColor());
        Glide.with(this)
                .load(mImg)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
        appbar_title.setText(mSource);
        appbar_subtitle.setText(mUrl);
        date.setText(Utils.DateFormat(mDate));
        title.setText(mTitle);
        String author = null;
        if(mAuthor != null || mAuthor !=""){
            mAuthor = "\u2022"+mAuthor;
        }else { author=""; }
        time.setText(mSource+author+"\u2022"+Utils.DateToTimeFormat(mDate));
        initWebView(mUrl); }
    private void  initWebView(String url){
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url); }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition(); }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;}
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset)/(float)maxScroll;

        if (percentage == 1f && isHideToolBarView) {
            date_behaviour.setVisibility(View.GONE);
            titleAppBar.setVisibility(View.VISIBLE);
            isHideToolBarView = !isHideToolBarView;
        } else if (percentage < 1f && isHideToolBarView) {
            date_behaviour.setVisibility(View.VISIBLE);
            titleAppBar.setVisibility(View.GONE);
            isHideToolBarView = !isHideToolBarView; } }}