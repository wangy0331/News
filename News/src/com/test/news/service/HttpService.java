package com.test.news.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HttpService {
	
	private static String key = "a715621ee14553d7cc6385b413261bed";
	
	private static String url = "http://api.1-blog.com/biz/bizserver/news/list.do";
	
	private static String meinv = "http://api.huceo.com/meinv/other/";

	public static String get(int page, String type) {
		String result = null;
		url = url.
		String httpArg = String.format("page=%s", page);
		url = url + "?" + httpArg;
		meinv = meinv + "?key=" + key + "&num=10&" + httpArg;
		
		Log.d("URL", meinv.toString());
		try {
			HttpClient httpClient = new DefaultHttpClient();
			//指定访问的服务器地址
			HttpGet httpGet = new HttpGet(meinv);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				//请求响应成功了
				HttpEntity entity = httpResponse.getEntity();
				result = EntityUtils.toString(entity ,"UTF-8");
			}
		} catch (IOException e) {
			Log.d("catch" , e.toString());
		}
		return result;
	}

}
