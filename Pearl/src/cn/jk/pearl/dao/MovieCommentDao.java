package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.MovieComment;
/**
 * 
 * 对moviecomment表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface MovieCommentDao extends BaseDao<MovieComment> {
	public long getMVComentCountById(int movieId);//获取某一视频评论的总数
	public List<MovieComment> getMVComment(int pageSize,int pageNow,int movieId);//获取某一视频评论的当前评论信息
}
