package cn.jk.pearl.vo;

import cn.jk.pearl.pojo.Expert;

public class ExpertAllMessageVO {
   private Expert expert;
   private Double  evaluateScore; //评价分数
   private long replyPostNum;//回复帖子的数目
   
	public ExpertAllMessageVO(Expert expert, Double evaluateScore,long replyPostNum) {
		this.expert = expert;
		this.evaluateScore = evaluateScore;
		this.replyPostNum = replyPostNum;
}
	public Expert getExpert() {
		return expert;
	}
	public void setExpert(Expert expert) {
		this.expert = expert;
	}
	public Double getEvaluateScore() {
		return evaluateScore;
	}
	public void setEvaluateScore(Double evaluateScore) {
		this.evaluateScore = evaluateScore;
	}
	public long getReplyPostNum() {
		return replyPostNum;
	}
	public void setReplyPostNum(long replyPostNum) {
		this.replyPostNum = replyPostNum;
	}
   
}
