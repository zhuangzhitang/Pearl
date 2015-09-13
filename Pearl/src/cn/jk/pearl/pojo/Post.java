package cn.jk.pearl.pojo;
// default package

import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeSet;

import cn.jk.pearl.util.ReplyComparator;


/**
 * Post entity. @author MyEclipse Persistence Tools
 */

public class Post implements java.io.Serializable {


    // Fields    
	 private static final long serialVersionUID = 1L;
	 private Integer postId;
     private String postTitle;
     private User user;
     private Timestamp postTime;
     private Integer istop;
     private Timestamp postToptime;
     private Integer postStatus;
     private Set<Reply> replySet=new TreeSet<Reply>(new ReplyComparator());
    // Constructors

    /** default constructor */
    public Post() {
    }

    
    /** full constructor */
    public Post(String postTitle,User user, Timestamp postTime, Integer istop, Timestamp postToptime, Integer postStatus) {
        this.postTitle = postTitle;
        this.setUser(user);
        this.postTime = postTime;
        this.istop = istop;
        this.postToptime = postToptime;
        this.postStatus = postStatus;
    }

   
    // Property accessors

    public Integer getPostId() {
        return this.postId;
    }
    
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return this.postTitle;
    }
    
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

   
    public Timestamp getPostTime() {
        return this.postTime;
    }
    
    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public Integer getIstop() {
        return this.istop;
    }
    
    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    public Timestamp getPostToptime() {
        return this.postToptime;
    }
    
    public void setPostToptime(Timestamp postToptime) {
        this.postToptime = postToptime;
    }

    public Integer getPostStatus() {
        return this.postStatus;
    }
    
    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Reply> getReplySet() {
		return replySet;
	}


	public void setReplySet(Set<Reply> replySet) {
		this.replySet=replySet;
	}









}