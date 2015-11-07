package com.test.news.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.test.news.util.UrlType;

import android.util.Log;

public class HttpService {
	
//	private static String key = "a715621ee14553d7cc6385b413261bed";
//	
	private static String url = "";
//	
//	private static String meinv = "http://api.huceo.com/wxnew/other/";

	public static String get(int page, String type) {
		String result = null;
		
		if ("美女".equals(type)) {
			url = UrlType.getMeinv();
		} else if ("国内".equals(type)) {
			url = UrlType.getGuonei();
		} else if ("社会".equals(type)) {
			url = UrlType.getSocial();
		} else if ("国际".equals(type)) {
			url = UrlType.getWorld();
		} else if ("体育".equals(type)) {
			url = UrlType.getTiyu();
		} else if ("科技".equals(type)) {
			url = UrlType.getKeji();
		} else if ("娱乐".equals(type)) {
			url = UrlType.getHuabian();
		}
		Log.d("TAG_URL" , url);
//		url = url.
		String httpArg = String.format("page=%s", page);
		url = url + "&" + httpArg;
//		meinv = meinv + "?key=" + key + "&num=10&" + httpArg;
		
//		Log.d("URL", meinv.toString());
		try {
			HttpClient httpClient = new DefaultHttpClient();
			//
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				//
				HttpEntity entity = httpResponse.getEntity();
				result = EntityUtils.toString(entity ,"UTF-8");
			}
		} catch (IOException e) {
			Log.d("catch" , e.toString());
		}
		return result;
	}

}
