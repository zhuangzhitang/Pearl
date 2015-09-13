package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.FileCommentDao;
import cn.jk.pearl.pojo.FileComment;
import cn.jk.pearl.service.FileCommentService;
/**
 * 
 *  文档评论的管理
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value = "fileCommentService")
public class FileCommentServiceImpl implements FileCommentService {

	@Resource
	FileCommentDao fileCommentDao = null;

	/*
	 *  @param pageSize:一个页面要显示的评论个数
	 *  @param fileCommentId:文档的id
	 *  return 返回总页数
	 */
	public long getPageCount(int pageSize, int fileCommentId) {
		long commentCount = fileCommentDao.getCountByFileId(fileCommentId);
		long pageCount = 0;
		if(commentCount%pageSize==0){
			pageCount = commentCount/pageSize ;
		}else{
			pageCount = commentCount/pageSize+1 ;
		}
		
		return pageCount ;
	}
	
	/*
	 * 
	 * @param pageSize:一个页面要显示的评论个数
	 * @param pageNow:当前所在的页数
	 * @param fileCommentId:文档的id
	 * return 返回某一文档对应的评论消息
	 *
	 */
	public List<FileComment> getFileComment(int pageSize, int pageNow,
			int fileCommentId) {

		return fileCommentDao.getFileComment(pageSize, pageNow, fileCommentId);
	}
	
	/*
	 * 发送文档
	 */
	public void sendFileComment(FileComment fileComment) {
		
		fileCommentDao.save(fileComment);
	}

}
