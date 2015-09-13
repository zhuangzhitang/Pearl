package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.MovieComment;

public interface MVCommentService {
	public long getPageCount(int pageSize,int movieId);//获取视频评论的总页数
	public List<MovieComment> getMVComment(int pageSize,int pageNow,int movieId);//获取
	public void sendMVComment(MovieComment movieComment);//发表评论
}
