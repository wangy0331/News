package com.test.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.test.news.activity.NewsActivity;
import com.test.news.activity.R;
import com.test.news.bean.NewsList;

public class NewsAdapter extends ArrayAdapter<NewsList>{
	
	private View view;
	
	private TextView newsTitle;
	
	private TextView newsDesc;
	
	private ImageView newsImage;
	
	private TextView newSource;
	
	private TextView newsDigg;
	
	private TextView newsBury;
	
	private TextView newsRepin;
	
	private TextView newsTime;
	
	private TextView newsUrl;
	
	private String type = "yyyy-MM-dd HH:mm:ss";

	public NewsAdapter(Context context) {
		super(context, 0);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// 获取笑话实例
		final NewsList news = getItem(position);
		view = LayoutInflater.from(getContext()).inflate(R.layout.new_item, null);
		
		// 获取imageView和textView的实例
		newsTitle = (TextView) view.findViewById(R.id.news_title);
		
		newsDesc = (TextView) view.findViewById(R.id.news_desc);
		
		newsImage = (ImageView) view.findViewById(R.id.image);
		
		newsTitle.setText(news.getTitle());
		newsDesc.setText(news.getDesc());
		
		
		if (!"".equals(news.getPicUrl())) {
			ImageLoader.getInstance().displayImage(news.getPicUrl(),newsImage);
		} else {
			newsImage.setVisibility(View.GONE);
		}
		
		
		newsImage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ImageLoader.getInstance().getMemoryCache();
				String path = news.getUrl();
					
					Intent intent = new Intent(getContext(), NewsActivity.class);
					intent.putExtra("news_url", news.getUrl());
					getContext().startActivity(intent);
			}
		});
		

		
		
//		newsTitle = (TextView) view.findViewById(R.id.news_title);
//		
//		newSource = (TextView) view.findViewById(R.id.news_source);
//		
//		newsDigg = (TextView) view.findViewById(R.id.news_digg);
//		
//		newsBury = (TextView) view.findViewById(R.id.news_bury);
//		
//		newsRepin = (TextView) view.findViewById(R.id.news_repin);
//		
//		newsTime = (TextView) view.findViewById(R.id.news_time);
//		
//		newsUrl = (TextView) view.findViewById(R.id.news_time);
//		
//		newsTitle.setText(news.getTitle());
//		
//		newSource.setText(news.getSource());
//		
//		newsDigg.setText("赞" + news.getDigg_count());
//		
//		newsBury.setText("踩" + news.getRepin_count());
//		
//		newsRepin.setText("收藏" + news.getRepin_count());
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");//初始化Formatter的转换格式。  
		  
//		String hms = formatter.format(news.getBehot_time()); 
		
//		newsTime.setText(DateChange.getFormatedDateTime(type, news.getBehot_time()));
		
		
		return view;
	}

	

}
