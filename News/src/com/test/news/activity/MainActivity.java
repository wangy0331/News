package com.test.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	Button mButtonScrollMenu,mButtonTabStrip;
	
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		mButtonScrollMenu = (Button) findViewById(R.id.scrollMenu);
		
		mButtonTabStrip = (Button) findViewById(R.id.tabStrip);
		
		mButtonScrollMenu.setOnClickListener(click);
		
		mButtonTabStrip.setOnClickListener(click);
	}
	
	
	OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.scrollMenu:
					intent = new Intent(MainActivity.this, ScrollMenu.class);
					startActivity(intent);
				break;
			case R.id.tabStrip:
					intent = new Intent(MainActivity.this, TabStrip.class);
					startActivity(intent);
				break;
			default:
				break;
			}
		}
	};
}
