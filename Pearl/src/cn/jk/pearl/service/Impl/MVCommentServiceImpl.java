package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.MovieCommentDao;
import cn.jk.pearl.pojo.MovieComment;
import cn.jk.pearl.service.MVCommentService;
/**
 * 
 *  新闻评论的管理
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value="mVCommentService")
public class MVCommentServiceImpl implements MVCommentService {
	
	@Resource
	MovieCommentDao movieCommentDao=null;
	
	/*
	 * 发送视频评论
	 */
	public void sendMVComment(MovieComment movieComment) {
		
		 movieCommentDao.save(movieComment);
	}
	
	/*
	 * @param pageSize:一个页面要显示的评论个数
	 * @param pageNow:当前所在的页数
	 * @param movieId:视频的id
	 * return 返回某一视频对应的评论消息
	 */
	public List<MovieComment> getMVComment(int pageSize, int pageNow,
			int movieId) {
		
		return movieCommentDao.getMVComment(pageSize, pageNow, movieId);
	}
	
	/*
	 *  @param pageSize:一个页面要显示的评论个数
	 *  @param movieId:视频的id
	 *  return 返回总页数
	 */
	public long getPageCount(int pageSize, int movieId) {
		long commentCount = movieCommentDao.getMVComentCountById(movieId);
		long pageCount = 0;
		if(commentCount%pageSize==0){
			pageCount = commentCount/pageSize ;
		}else{
			pageCount = commentCount/pageSize+1 ;
		}
		
		return pageCount ;
	}

}
