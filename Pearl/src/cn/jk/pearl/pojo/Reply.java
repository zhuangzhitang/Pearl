package cn.jk.pearl.pojo;

import java.sql.Timestamp;


/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("rawtypes")
public class Reply  implements java.io.Serializable,Comparable{


    // Fields  
	 private static final long serialVersionUID = 1L;
	 private Integer replyId;
     private Integer replyType;
     private User user;
     private Timestamp replyTime;
     private Post post;
     private String replyContent;
     private Integer replyFirst;
     private Integer replyIsread;
     


    // Constructors

    /** default constructor */
    public Reply() {
    }

    
    /** full constructor */
    public Reply(Integer replyType, User user, Timestamp replyTime, Post post, String replyContent, Integer replyFirst,Integer replyIsread) {
        this.replyType = replyType;
        this.setUser(user);
        this.replyTime = replyTime;
        this.setPost(post);
        this.replyContent = replyContent;
        this.setReplyFirst(replyFirst);
        this.replyIsread = replyIsread;
    }

   
    // Property accessors

    public Integer getReplyId() {
        return this.replyId;
    }
    
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyType() {
        return this.replyType;
    }
    
    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Timestamp getReplyTime() {
        return this.replyTime;
    }
    
    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyContent() {
        return this.replyContent;
    }
    
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getReplyIsread() {
        return this.replyIsread;
    }
    
    public void setReplyIsread(Integer replyIsread) {
        this.replyIsread = replyIsread;
    }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public Integer getReplyFirst() {
		return replyFirst;
	}


	public void setReplyFirst(Integer replyFirst) {
		this.replyFirst = replyFirst;
	}


	public int compareTo(Object o) {
		if(o instanceof Reply){
			Reply r=(Reply)o;
			if(this.getReplyTime().compareTo(r.getReplyTime())>0){
				return -1;
			}else if(this.getReplyTime().compareTo(r.getReplyTime())==0){
				return 0;
			}else if(this.getReplyTime().compareTo(r.getReplyTime())<0){
				return 1;
			}
		}
		return 0;
	}
   








}