package com.test.news.util;

import java.util.List;

import com.test.news.activity.R;
import com.test.news.adapter.NewsAdapter;
import com.test.news.bean.News;
import com.test.news.service.HttpService;

import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {
	
	private int page = 0;
	
	private List<News> news;

	private NewsAdapter adapter;
	
	private ListView list;
	

	@Override
	protected String doInBackground(String... params) {
		try {
			String response = HttpService.get(page);
			Log.d("MyAsyncTask" , "---------response----------");
//			news = JsonParser.parseJSONWithJSONObject(response);
			return response;
			} catch (Exception e) {
				e.printStackTrace();
			}

		return null;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(String result) {
		Log.d("MyAsyncTask", "--------onPostExecute---------");
		news = JsonParser.parseJSONWithJSONObject(result);
//		View view = inflater.inflate(R.layout.news2_fragment, container, false);
//		
//		View view = LayoutInflater.from()
//		
		list = (ListView) 
		if (list.getAdapter() == null) {
			Log.d("TAG_ADAPTER" , "----------HANDLIER---------");
			list.setAdapter(adapter);
		}
		adapter.addAll(news);
		adapter.notifyDataSetChanged(); 
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	
}
