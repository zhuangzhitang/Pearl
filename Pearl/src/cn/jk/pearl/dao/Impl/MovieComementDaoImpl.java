package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.MovieCommentDao;
import cn.jk.pearl.pojo.MovieComment;


/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value = "movieCommentDao")
@SuppressWarnings("unchecked")
public class MovieComementDaoImpl extends BaseDaoImpl<MovieComment> implements
		MovieCommentDao {

	public long getMVComentCountById(int movieId) {
		String hql = "select count(*) from MovieComment m where m.movie.movieId=:movieId";
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createQuery(hql).setInteger("movieId", movieId)
				.uniqueResult();
	}
	
	public List<MovieComment> getMVComment(int pageSize, int pageNow,
			int movieId) {
		String hql = "from MovieComment m where m.movie.movieId=:movieId";
		int firstcomment = (pageNow - 1) * pageSize;
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql)
						.setInteger("movieId", movieId)
						.setFirstResult(firstcomment).setMaxResults(pageSize).list();
	}

}
