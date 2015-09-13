package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.EmployDao;
import cn.jk.pearl.pojo.EmployInformation;

/**
 * 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value="employDao")
@SuppressWarnings("unchecked")
public class EmployDaoImpl extends BaseDaoImpl<EmployInformation> implements
		EmployDao {
	public List<EmployInformation> getEmployInformationsById(int farmerId) {
		String hql = "from EmployInformation e where e.farmer.farmerId=:farmerId";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).
					setInteger("farmerId", farmerId)
					.list();
	}
}
