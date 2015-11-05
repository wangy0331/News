package com.test.news.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;
import com.test.news.bean.News;
import com.test.news.bean.NewsList;

public class JsonParser {

	public static List<NewsList> parseJSONWithJSONObject(String response) {
		Log.d("JsonParser", "--------JsonParser----------");
//		List<News> list = null;
		List<NewsList> list2 = null;
		try {
//			JSONArray jsonArray = new JSONObject(response).getJSONArray("detail");
			
			JSONArray jsonArray2 = new JSONObject(response).getJSONArray("newslist");
			
//			list = new ArrayList<News>();
			
			list2 = new ArrayList<NewsList>();
			
//			for (int i = 0; i < jsonArray.length(); i++) {
//				News news = new News();
//				JSONObject jsonObject = jsonArray.getJSONObject(i);
//				news.setId(jsonObject.getString("group_id"));
//				news.setTitle(jsonObject.getString("title"));
//				news.setSource(jsonObject.getString("source"));
//				news.setArticle_url(jsonObject.getString("article_url"));
//				news.setBehot_time(jsonObject.getString("behot_time"));
//				news.setDigg_count(jsonObject.getString("digg_count"));
//				news.setBury_count(jsonObject.getString("bury_count"));
//				news.setRepin_count(jsonObject.getString("repin_count"));
//				list.add(news);
//			}
			
			for (int i = 0; i < jsonArray2.length(); i++) {
				NewsList newsList = new NewsList();
				JSONObject jsonObject = jsonArray2.getJSONObject(i);
				newsList.setTitle(jsonObject.getString("title"));
				newsList.setDesc(jsonObject.getString("description"));
				newsList.setPicUrl(jsonObject.getString("picUrl"));
				newsList.setUrl(jsonObject.getString("url"));
				list2.add(newsList);
			}
			
			
		} catch (Exception e) {
			Log.d("catch" , e.toString());
		}
		return list2;
	}

}
