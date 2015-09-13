package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.FileCommentDao;
import cn.jk.pearl.pojo.FileComment;


/**
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value = "fileCommentDao")
@SuppressWarnings("unchecked")
public class FileCommentDaoImpl extends BaseDaoImpl<FileComment> implements
		FileCommentDao {

	public Long getCountByFileId(int file_id) {
		String hql = "select count(*) from FileComment f where f.fileDocument.fileId=:file_id";
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createQuery(hql).setInteger("file_id", file_id)
				.uniqueResult();
	}

	
	public List<FileComment> getFileComment(int pageSize, int pageNow,
			int fileDocumentId) {
		String hql = "from FileComment f where f.fileDocument.fileId=:fileDocumentId";
		int firstcomment = (pageNow - 1) * pageSize;
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql)
						.setInteger("fileDocumentId",fileDocumentId)
						.setFirstResult(firstcomment)
						.setMaxResults(pageSize)
						.list();
	}

	/*public List<FileComment> getCommentsByFileId(int file_id) {
		String hql = "from FileComment f  where f.fileDocument.fileId=:file_id";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql)
				.setInteger("file_id", file_id)
				.list();
	}*/
	
}
