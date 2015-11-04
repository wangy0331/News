package com.test.news.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;
import com.test.news.bean.News;

public class JsonParser {

	public static List<News> parseJSONWithJSONObject(String response) {
		Log.d("JsonParser", "--------JsonParser----------");
		List<News> list = null;
		try {
			JSONArray jsonArray = new JSONObject(response).getJSONArray("detail");
			list = new ArrayList<News>();
			for (int i = 0; i < jsonArray.length(); i++) {
				News news = new News();
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				news.setId(jsonObject.getString("group_id"));
				news.setTitle(jsonObject.getString("title"));
				news.setSource(jsonObject.getString("source"));
				news.setArticle_url(jsonObject.getString("article_url"));
				news.setBehot_time(jsonObject.getString("behot_time"));
				news.setDigg_count(jsonObject.getString("digg_count"));
				news.setBury_count(jsonObject.getString("bury_count"));
				news.setRepin_count(jsonObject.getString("repin_count"));
				list.add(news);
			}
		} catch (Exception e) {
			Log.d("catch" , e.toString());
		}
		return list;
	}

}
