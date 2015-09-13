package cn.jk.pearl.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import cn.jk.pearl.dao.BaseDao;

@Service(value = "baseDao")
@Lazy(value = true)
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	protected Class<T> clazz;
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		clazz = (Class<T>) ptype.getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public T get(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	public List<T> query() {
		String hql = "from " + this.clazz.getSimpleName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public void delete(int id) {
		String hql = "delete from " + this.clazz.getSimpleName()
				+ " where id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("id", id);
		query.executeUpdate();

	}

	public List<T> getContentByPage(int pageSize, int pageNow) {
		String hql = "from " + this.clazz.getSimpleName();
		int firstmovie = (pageNow - 1) * pageSize;
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).setFirstResult(firstmovie)
				.setMaxResults(pageSize).list();
	}

	public long getCount() {
		String hql = "select count(*) from " + this.clazz.getSimpleName();
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.createQuery(hql).uniqueResult();
	}
}
