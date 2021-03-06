package com.test.news.adapter;

import java.util.ArrayList;
import java.util.List;

import com.test.news.fragment.NewsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragAdapter extends FragmentPagerAdapter {
	
	String[] names = new String[]
			{ "美女图片", "国内新闻", "社会新闻", "国际新闻", "体育新闻", "娱乐花边", "科技新闻", "奇闻趣事", "生活健康", "旅游热点", "苹果新闻"};

	
	private List<Fragment> fragments;

	public FragAdapter(FragmentManager fm) {
		super(fm);
		fragments = new ArrayList<Fragment>();
		for (String str : names)
		{
			fragments.add(new NewsFragment(str));
		}
	}
	
	public FragAdapter(FragmentManager fm, List<Fragment> fragments) {  
        super(fm);  
        this.fragments = fragments;  
	}  

	@Override
	public CharSequence getPageTitle(int position) {
		return names[position];
	}
	
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments != null ? fragments.size() : 0;
	}
	
	

}
