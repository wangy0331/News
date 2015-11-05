package com.test.news.fragment;

import java.util.List;

import com.test.news.activity.NewsActivity;
import com.test.news.activity.R;
import com.test.news.adapter.NewsAdapter;
import com.test.news.bean.News;
import com.test.news.bean.NewsList;
import com.test.news.service.HttpService;
import com.test.news.util.JsonParser;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NewsFragment extends ListFragment{
	
	private List<NewsList> news;
	
	private int page = 1;
	
	private ListView list;
	
	private NewsAdapter adapter;
	
	private SwipeRefreshLayout mSwipeRefreshLayout;
	
	private MyTask mMyAsyncTask;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.news2_fragment, container, false);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.list_refresh1);
		
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				Log.d("TAG_FRESH" , "----------mSwipeRefreshLayout----------");
            	page = 0;
            	adapter.clear();
            	sendRequestWithHttpClient();
            }
		});	
		
		
		list = (ListView) view.findViewById(android.R.id.list);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				News news = (News) parent.getItemAtPosition(position);
				Log.d("TAG_ITEM" ,	news.getArticle_url());
				Intent intent = new Intent(getActivity(), NewsActivity.class);
				intent.putExtra("news_url", news.getArticle_url());
				startActivity(intent);
			}
		});
		
		adapter = new NewsAdapter(getActivity());
		
		return view;
	}
	
	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		NewsList news = (NewsList) l.getAdapter().getItem(position);
		Log.d("onListItemClick" ,	news.getUrl());
		Intent intent = new Intent(getActivity(), NewsActivity.class);
		intent.putExtra("news_url", news.getUrl());
		startActivity(intent);
	}



	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		sendRequestWithHttpClient();
	}
	
	class MyTask extends AsyncTask<String, Integer, String> {

		private String newsType;
		
		public MyTask(String type) {
			newsType = type;
		}

		@Override
		protected String doInBackground(String... params) {
			try {
				String response = HttpService.get(page,newsType);
				news = JsonParser.parseJSONWithJSONObject(response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			mSwipeRefreshLayout.setRefreshing(false);
			if (list.getAdapter() == null) {
				Log.d("TAG_ADAPTER" , "----------HANDLIER---------");
				list.setAdapter(adapter);
			}
			adapter.addAll(news);
			adapter.notifyDataSetChanged(); 
		}
		
	}
	

	private void sendRequestWithHttpClient() {
		String type = "meinv";
		mMyAsyncTask = new MyTask(type);
		mMyAsyncTask.execute();
		
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				try {
//				String response = HttpService.get(page);
//				Log.d("MainActivity" , "---------MainActivity2----------");
//				news = JsonParser.parseJSONWithJSONObject(response);
//				
//				myHandler.sendEmptyMessage(1);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//		}).start();
	}

//	Handler myHandler = new Handler() {
//
//		@Override
//		public void handleMessage(Message msg) {
//			super.handleMessage(msg);
//			Log.d("TAG_MSG" , String.valueOf(msg.what));
//			mSwipeRefreshLayout.setRefreshing(false);
//			switch (msg.what) {
//			case 1:
//				if (list.getAdapter() == null) {
//					Log.d("TAG_ADAPTER" , "----------HANDLIER---------");
//					list.setAdapter(adapter);
//				}
//				adapter.addAll(news);
//				adapter.notifyDataSetChanged(); 
//				break;
//
//			default:
//				break;
//			}
//		}
//	};
}
