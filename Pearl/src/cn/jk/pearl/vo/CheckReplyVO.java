package cn.jk.pearl.vo;

public class CheckReplyVO {
   private Integer postId;        //帖子的Id值
   private String replyedContent; //被回复的内容，可以是帖子的标题，可以是一级回复的内容
   private String name;           //回复者的名字
   private String replyContent;   //回复的内容
   private Integer replyType;     //回复内容的类型
   private Integer replyedType;   //被回复的内容的类型
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getReplyedContent() {
		return replyedContent;
	}
	public void setReplyedContent(String replyedContent) {
		this.replyedContent = replyedContent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Integer getReplyType() {
		return replyType;
	}
	public void setReplyType(Integer replyType) {
		this.replyType = replyType;
	}
	public Integer getReplyedType() {
		return replyedType;
	}
	public void setReplyedType(Integer replyedType) {
		this.replyedType = replyedType;
	}
  
}
