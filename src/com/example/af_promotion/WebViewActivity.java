package com.example.af_promotion;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
	
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		
		webView = (WebView) findViewById(R.id.webView1);
		//webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
		webView.getSettings().setAllowFileAccess(true);
		webView.getSettings().setAppCacheEnabled(true);
		webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		
		//This Loads Offline
		if (!isNetworkAvailable()) {
		    webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		    webView.loadUrl("https://m.hollisterco.com");
		    Log.i("Network is not Available", "Cached Version");
		}
		
		Log.i("Network is available", "Non-Cached Version");
		webView.loadUrl("https://m.hollisterco.com");
		
		finish();
	}
	
	//Function that checks if network is available
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityMan = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
	    NetworkInfo activeInfo = connectivityMan.getActiveNetworkInfo();
	    return activeInfo != null && activeInfo.isConnected();
	}
}
