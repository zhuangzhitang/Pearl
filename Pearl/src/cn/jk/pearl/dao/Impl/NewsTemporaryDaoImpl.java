package cn.jk.pearl.dao.Impl;

import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.NewsTemporaryDao;
import cn.jk.pearl.pojo.NewsTemporary;

/**
 * 
 * @author zaopeng
 *
 */
@Repository("newsTemporaryDao")
public class NewsTemporaryDaoImpl extends BaseDaoImpl<NewsTemporary> implements NewsTemporaryDao{

	public void deleteAll() {
		String hql="delete from NewsTemporary";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

}
