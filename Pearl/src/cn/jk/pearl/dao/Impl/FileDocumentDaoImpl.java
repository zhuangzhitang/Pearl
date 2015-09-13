package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.FileDocumentDao;
import cn.jk.pearl.pojo.FileDocument;

/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value="fileDocumentDao")
@SuppressWarnings("unchecked")
public class FileDocumentDaoImpl extends BaseDaoImpl<FileDocument> implements FileDocumentDao {

	public void updateDownloadCount(int file_id, int count) {
		String hql = "update FileDocument f set f.fileDownloadcount=:count where f.fileId=:file_id";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql)
			.setInteger("count", count)
			.setInteger("file_id", file_id)
			.executeUpdate();
	}

	public void updateReadCount(int file_id, int readcount) {
		String hql = "update FileDocument f set f.fileReadcount =:readcount where f.fileId=:file_id";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql)
			.setInteger("readcount", readcount)
			.setInteger("file_id", file_id)
			.executeUpdate();
	}

	public List<FileDocument> topMovies(int topCount) {
		String hql = "from FileDocument f order by f.fileReadcount desc";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(topCount)
				.list();
	}

}
