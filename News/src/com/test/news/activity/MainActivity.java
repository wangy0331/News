package com.test.news.activity;

import java.util.ArrayList;
import java.util.List;
import com.test.news.adapter.FragAdapter;
import com.test.news.fragment.AboutFragment;
import com.test.news.fragment.NewsFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	private TextView textView1,textView2;
	
	private FragAdapter fragAdapter;
	
    private ViewPager viewPager;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d("MainActivity" , "---------MainActivity----------");
		
		textView1 = (TextView) findViewById(R.id.list1);
		
		textView2 = (TextView) findViewById(R.id.list2);
		
		List<Fragment> fragments = new ArrayList<Fragment>();  
		fragments.add(new NewsFragment());  
		fragments.add(new AboutFragment());  
          
		fragAdapter = new FragAdapter(getSupportFragmentManager(), fragments);
		
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		
		viewPager.setAdapter(fragAdapter);
		
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			// 当滑动式，顶部的imageView是通过animation缓慢的滑动
			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					  	textView1.setBackgroundColor(Color.parseColor("#C2C2C2"));
						textView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
					break;
				case 1:
						textView2.setBackgroundColor(Color.parseColor("#C2C2C2"));
						textView1.setBackgroundColor(Color.parseColor("#FFFFFF"));
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
		 textView1.setOnClickListener(new View.OnClickListener() { 
	            @Override 
	            public void onClick(View arg0) { 
	                viewPager.setCurrentItem(0);
	                textView1.setBackgroundColor(Color.parseColor("#C2C2C2"));
					textView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            } 
	        }); 
	   
	        textView2.setOnClickListener(new View.OnClickListener() { 
	            @Override 
	            public void onClick(View arg0) { 
	                viewPager.setCurrentItem(1);
	                textView2.setBackgroundColor(Color.parseColor("#C2C2C2"));
					textView1.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            } 
	        }); 
		
		textView1.setBackgroundColor(Color.parseColor("#C2C2C2"));
		textView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
	}
}
