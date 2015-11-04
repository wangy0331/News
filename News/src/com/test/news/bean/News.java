package com.test.news.bean;

public class News {
	//新闻id
	private String id;
	//标题
	private String title;
	//来源
	private String source;
	//新闻网址
	private String article_url;
	//收录时间
	private String behot_time;
	//赞的次数
	private String digg_count;
	//踩的次数
	private String bury_count;
	//收藏次数
	private String repin_count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getArticle_url() {
		return article_url;
	}

	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}

	public String getBehot_time() {
		return behot_time;
	}

	public void setBehot_time(String behot_time) {
		this.behot_time = behot_time;
	}

	public String getDigg_count() {
		return digg_count;
	}

	public void setDigg_count(String digg_count) {
		this.digg_count = digg_count;
	}

	public String getBury_count() {
		return bury_count;
	}

	public void setBury_count(String bury_count) {
		this.bury_count = bury_count;
	}

	public String getRepin_count() {
		return repin_count;
	}

	public void setRepin_count(String repin_count) {
		this.repin_count = repin_count;
	}
	
}
