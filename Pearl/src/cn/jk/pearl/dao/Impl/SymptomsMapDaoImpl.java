package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.SymptomsMapDao;
import cn.jk.pearl.pojo.SymptomsMap;
/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value="symptomsMapDao")
@SuppressWarnings("unchecked")
public class SymptomsMapDaoImpl extends BaseDaoImpl<SymptomsMap> implements
		SymptomsMapDao {
	public List<SymptomsMap> getSymptomsMap(int diseaseId) {
		String hql = "from SymptomsMap s where s.diseaseId=:diseaseId";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).setInteger("diseaseId", diseaseId).list();
	}
}
