package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.MovieDao;
import cn.jk.pearl.pojo.Movie;


/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value="movieDao")
@SuppressWarnings("unchecked")
public class MovieDaoImpl extends BaseDaoImpl<Movie> implements MovieDao {

	public void updateReadCount(int movie_id, int whatchcount) {
		String hql = "update Movie m set m.moviePlaynumber=:whatchcount where m.movieId= :movieId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql)
				.setInteger("whatchcount", whatchcount)
				.setInteger("movieId", movie_id)
				.executeUpdate();

	}

	
	public List<Movie> topMovies(int topCount) {
		String hql = "from Movie m order by m.moviePlaynumber desc";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(topCount)
				.list();
	}

/*	public long getMovieCount() {
		String hql= "select count(*) from Movie";
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createQuery(hql).uniqueResult();
	}*/
}
