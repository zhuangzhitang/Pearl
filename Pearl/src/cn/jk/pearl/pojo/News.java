package cn.jk.pearl.pojo;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer newsId;
	private String newsTitle;
	private String newsFrom;
	private String newsAuthor;
	private String newsContent;
	private Integer newsClicknum;
	private Timestamp newsCreatetime;
	private Timestamp newsLastupdatetime;
	private NewsCategory newsCategory;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String newsTitle, String newsFrom, String newsAuthor,
			String newsContent, Integer newsClicknum, Timestamp newsCreatetime,
			Timestamp newsLastupdatetime, NewsCategory newsCategory) {
		this.newsTitle = newsTitle;
		this.newsFrom = newsFrom;
		this.newsAuthor = newsAuthor;
		this.newsContent = newsContent;
		this.newsClicknum = newsClicknum;
		this.newsCreatetime = newsCreatetime;
		this.newsLastupdatetime = newsLastupdatetime;
		this.setNewsCategory(newsCategory);
	}
   
	public News(Integer newsId,String newsTitle){
		this.newsId=newsId;
		this.newsTitle=newsTitle;
	}
	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsFrom() {
		return this.newsFrom;
	}

	public void setNewsFrom(String newsFrom) {
		this.newsFrom = newsFrom;
	}

	public String getNewsAuthor() {
		return this.newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Integer getNewsClicknum() {
		return this.newsClicknum;
	}

	public void setNewsClicknum(Integer newsClicknum) {
		this.newsClicknum = newsClicknum;
	}

	public Timestamp getNewsCreatetime() {
		return this.newsCreatetime;
	}

	public void setNewsCreatetime(Timestamp newsCreatetime) {
		this.newsCreatetime = newsCreatetime;
	}

	public Timestamp getNewsLastupdatetime() {
		return this.newsLastupdatetime;
	}

	public void setNewsLastupdatetime(Timestamp newsLastupdatetime) {
		this.newsLastupdatetime = newsLastupdatetime;
	}

	public NewsCategory getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}
}