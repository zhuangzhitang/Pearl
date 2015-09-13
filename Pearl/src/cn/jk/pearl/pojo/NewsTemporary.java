package cn.jk.pearl.pojo;

import java.sql.Timestamp;


/**
 * NewsTemporary entity. @author MyEclipse Persistence Tools
 */

public class NewsTemporary  implements java.io.Serializable {


    // Fields 
	private static final long serialVersionUID = 1L;
	private Integer newsTemporaryId;
     private String newsTemporaryTitle;
     private String newsTemporaryFrom;
     private String newsTemporaryAuthor;
     private String newsTemporaryContent;
     private Timestamp newsTemporaryCreatetime;
     private Timestamp newsTemporaryLastupdatetime;
     private NewsCategory newsCategory;


    // Constructors

    /** default constructor */
    public NewsTemporary() {
    }

    
    /** full constructor */
    public NewsTemporary(String newsTemporaryTitle, String newsTemporaryFrom, String newsTemporaryAuthor, String newsTemporaryContent, Timestamp newsTemporaryCreatetime, Timestamp newsTemporaryLastupdatetime,NewsCategory newsCategory) {
        this.newsTemporaryTitle = newsTemporaryTitle;
        this.newsTemporaryFrom = newsTemporaryFrom;
        this.newsTemporaryAuthor = newsTemporaryAuthor;
        this.newsTemporaryContent = newsTemporaryContent;
        this.newsTemporaryCreatetime = newsTemporaryCreatetime;
        this.newsTemporaryLastupdatetime = newsTemporaryLastupdatetime;
        this.setNewsCategory(newsCategory);
    }

   
    // Property accessors

    public Integer getNewsTemporaryId() {
        return this.newsTemporaryId;
    }
    
    public void setNewsTemporaryId(Integer newsTemporaryId) {
        this.newsTemporaryId = newsTemporaryId;
    }

    public String getNewsTemporaryTitle() {
        return this.newsTemporaryTitle;
    }
    
    public void setNewsTemporaryTitle(String newsTemporaryTitle) {
        this.newsTemporaryTitle = newsTemporaryTitle;
    }

    public String getNewsTemporaryFrom() {
        return this.newsTemporaryFrom;
    }
    
    public void setNewsTemporaryFrom(String newsTemporaryFrom) {
        this.newsTemporaryFrom = newsTemporaryFrom;
    }

    public String getNewsTemporaryAuthor() {
        return this.newsTemporaryAuthor;
    }
    
    public void setNewsTemporaryAuthor(String newsTemporaryAuthor) {
        this.newsTemporaryAuthor = newsTemporaryAuthor;
    }

    public String getNewsTemporaryContent() {
        return this.newsTemporaryContent;
    }
    
    public void setNewsTemporaryContent(String newsTemporaryContent) {
        this.newsTemporaryContent = newsTemporaryContent;
    }

    public Timestamp getNewsTemporaryCreatetime() {
        return this.newsTemporaryCreatetime;
    }
    
    public void setNewsTemporaryCreatetime(Timestamp newsTemporaryCreatetime) {
        this.newsTemporaryCreatetime = newsTemporaryCreatetime;
    }

    public Timestamp getNewsTemporaryLastupdatetime() {
        return this.newsTemporaryLastupdatetime;
    }
    
    public void setNewsTemporaryLastupdatetime(Timestamp newsTemporaryLastupdatetime) {
        this.newsTemporaryLastupdatetime = newsTemporaryLastupdatetime;
    }


	public NewsCategory getNewsCategory() {
		return newsCategory;
	}


	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}
}