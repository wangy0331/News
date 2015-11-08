package com.test.news.activity;

import java.util.Arrays;
import java.util.List;

import com.test.news.adapter.BaseAdapter;
import com.test.news.adapter.FragAdapter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

public class ScrollMenu extends FragmentActivity{

	private HorizontalScrollMenu hsm_container;
	
	private FragAdapter fragAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}
	
	private void initView() {
		setContentView(R.layout.activity_main);
		hsm_container = (HorizontalScrollMenu) findViewById(R.id.hsm_container);
		hsm_container.setAdapter(new MenuAdapter());
	}
	
	class MenuAdapter extends BaseAdapter
	{
		String[] names = new String[]
				{ "美女图片", "国内新闻", "社会新闻", "国际新闻", "体育新闻", "娱乐花边", "科技新闻", "奇闻趣事", "生活健康", "旅游热点", "苹果新闻"};

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
		}

	}
	
}
