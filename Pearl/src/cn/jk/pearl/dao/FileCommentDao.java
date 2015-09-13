package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.FileComment;
/**
 * 
 *  对 FileComment表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface FileCommentDao extends BaseDao<FileComment>{
	//获取该文档的评论的总条数
	public Long getCountByFileId(int file_id);
	public List<FileComment> getFileComment(int pageSize,int pageNow,int fileDocummentId);//获取某一文档评论的当前评论信息
}
