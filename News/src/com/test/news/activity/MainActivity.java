package com.test.news.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.astuetz.PagerSlidingTabStrip;
import com.test.news.adapter.BaseAdapter;
import com.test.news.adapter.FragAdapter;
import com.test.news.fragment.AboutFragment;
import com.test.news.fragment.NewsFragment;
import com.test.news.fragment.SuperAwesomeCardFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private TextView textView1, textView2;

	private FragAdapter fragAdapter;

	private ViewPager viewPager;
	
	private HorizontalScrollMenu hsm_container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViewB();
		
	}
	
	private void initViewA() {
		setContentView(R.layout.pager_sliding_tab_strip);
		ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
		pager.setAdapter(new FragAdapter(getSupportFragmentManager()));
		
		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		tabs.setViewPager(pager);
		tabs.setOnPageChangeListener(listener);
		tabs.setIndicatorColor(0xFFF4842D);
	}
	
	private void initViewB() {
		setContentView(R.layout.activity_main);
		hsm_container = (HorizontalScrollMenu) findViewById(R.id.hsm_container);
//		hsm_container.setSwiped(false);
		hsm_container.setAdapter(new MenuAdapter());
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
	
	
	class MenuAdapter extends BaseAdapter
	{
		String[] names = new String[]
				{ "美女", "国内", "社会", "国际", "体育", "娱乐", "科技" };
		@Override
		public List<String> getMenuItems()
		{
			// TODO Auto-generated method stub
			return Arrays.asList(names);
		}

		@Override
		public FragmentPagerAdapter getContentViews()
		{

			fragAdapter = new FragAdapter(getSupportFragmentManager());
			return fragAdapter;
		}

		@Override
		public void onPageChanged(int position, boolean visitStatus)
		{
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this,
					"内容页：" + (position + 1) + " 访问状态：" + visitStatus,
					Toast.LENGTH_SHORT).show();
		}

	}
}
