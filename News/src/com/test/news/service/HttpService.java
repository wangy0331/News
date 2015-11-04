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
	
	private static String url = "http://api.1-blog.com/biz/bizserver/news/list.do";

	public static String get(int page) {
		String result = null;
		String httpArg = String.format("pag=%s", page);
		url = url + "?" + httpArg;
		
		try {
			HttpClient httpClient = new DefaultHttpClient();
			//指定访问的服务器地址
			HttpGet httpGet = new HttpGet(url);
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
