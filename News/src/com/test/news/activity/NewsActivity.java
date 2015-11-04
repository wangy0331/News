package com.test.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class NewsActivity extends Activity {
	
	private WebView mWebView;
	
	private Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.news_article);
		
		Intent intent = getIntent();
		String url = intent.getStringExtra("news_url");
		Log.d("TAG_URL_news", url);
		mWebView = (WebView) findViewById(R.id.news_article);
		
		mButton = (Button) findViewById(R.id.fanhui);
		
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
//		mWebView.loadUrl(url);
		init(url);
		
	}
	
	private void init(String url) {
		// WebView加载web资源
		mWebView.loadUrl(url);
		// 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				return true;
			}
		});
	}

}
