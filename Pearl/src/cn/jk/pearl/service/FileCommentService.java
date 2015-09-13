package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.FileComment;

public interface FileCommentService {
	public long getPageCount(int pageSize,int fileCommentId);//获取文档评论的总页数
	public List<FileComment> getFileComment(int pageSize,int pageNow,int fileCommentId);//获取该文档对应的当前页面的评论
	public void sendFileComment(FileComment fileComment);//发表评论
}
