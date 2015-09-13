package cn.jk.pearl.dao.Impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.SuperUserDao;
import cn.jk.pearl.pojo.SuperUser;
/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value = "superUserDao")
public class SuperUserDaoImpl extends BaseDaoImpl<SuperUser> implements
		SuperUserDao {

	public SuperUser login(String username, String userpass) {

		String hql = "from SuperUser s where s.superName=:username and s.superPass=:superPass";
		Session session = sessionFactory.getCurrentSession();
		return (SuperUser) session.createQuery(hql)
				.setString("username", username)
				.setString("superPass", userpass).uniqueResult();
	}

	public boolean isExistUsername(String username) {
		String hql = "from SuperUser s where s.superName=:username";
		Session session = sessionFactory.getCurrentSession();
		Object flag = session.createQuery(hql).setString("username", username).uniqueResult();
		if(flag!=null){
			return true;
		}else{
			return false;
		}
	}
}
