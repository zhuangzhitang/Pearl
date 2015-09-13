package cn.jk.pearl.pojo;

import java.sql.Timestamp;


/**
 * SecondReply entity. @author MyEclipse Persistence Tools
 */

public class SecondReply  implements java.io.Serializable {


    // Fields
	private static final long serialVersionUID = 1L;
	private Integer secondReplyId;
     private Integer secondReplyType; 
     private User user;
     private Timestamp secondReplyTime;
     private Reply reply;
     private String secondReplyContent;
     private Integer secondReplyIsread;


    // Constructors

    /** default constructor */
    public SecondReply() {
    }

    
    /** full constructor */
    public SecondReply(Integer secondReplyType,User user, Timestamp secondReplyTime,Reply reply, String secondReplyContent, Integer secondReplyIsread) {
        this.secondReplyType = secondReplyType;
        this.setUser(user);
        this.secondReplyTime = secondReplyTime;
        this.setReply(reply);
        this.secondReplyContent = secondReplyContent;
        this.secondReplyIsread = secondReplyIsread;
    }

   
    // Property accessors

    public Integer getSecondReplyId() {
        return this.secondReplyId;
    }
    
    public void setSecondReplyId(Integer secondReplyId) {
        this.secondReplyId = secondReplyId;
    }

    public Integer getSecondReplyType() {
        return this.secondReplyType;
    }
    
    public void setSecondReplyType(Integer secondReplyType) {
        this.secondReplyType = secondReplyType;
    }

    public Timestamp getSecondReplyTime() {
        return this.secondReplyTime;
    }
    
    public void setSecondReplyTime(Timestamp secondReplyTime) {
        this.secondReplyTime = secondReplyTime;
    }

    public String getSecondReplyContent() {
        return this.secondReplyContent;
    }
    
    public void setSecondReplyContent(String secondReplyContent) {
        this.secondReplyContent = secondReplyContent;
    }

    public Integer getSecondReplyIsread() {
        return this.secondReplyIsread;
    }
    
    public void setSecondReplyIsread(Integer secondReplyIsread) {
        this.secondReplyIsread = secondReplyIsread;
    }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Reply getReply() {
		return reply;
	}


	public void setReply(Reply reply) {
		this.reply = reply;
	}
   








}