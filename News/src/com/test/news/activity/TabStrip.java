package com.test.news.activity;

import com.astuetz.PagerSlidingTabStrip;
import com.test.news.adapter.FragAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class TabStrip extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	private void initView() {
		setContentView(R.layout.pager_sliding_tab_strip);
		ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
		pager.setAdapter(new FragAdapter(getSupportFragmentManager()));

		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		tabs.setViewPager(pager);
		tabs.setOnPageChangeListener(listener);
		tabs.setIndicatorColor(0xFFF4842D);
	}

	OnPageChangeListener listener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};
}
