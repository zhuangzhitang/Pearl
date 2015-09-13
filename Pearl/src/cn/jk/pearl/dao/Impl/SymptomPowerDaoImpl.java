package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.SymptomPowerDao;
import cn.jk.pearl.pojo.SymptomPower;
/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value="symptomPowerDao")
@SuppressWarnings("unchecked")
public class SymptomPowerDaoImpl extends BaseDaoImpl<SymptomPower> implements
		SymptomPowerDao {

	
	public List<SymptomPower> getSymptomPowerbySymptomId(int symptomId) {
		String hql = "from SymptomPower s where s.symptomId=:symptomId";
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery(hql)
				.setInteger("symptomId", symptomId)
				.list();
	}

}
