package cn.jk.pearl.dao.Impl;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.SymptomDao;
import cn.jk.pearl.pojo.Symptom;

/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value = "symptomDao")
@SuppressWarnings("unchecked")
public class SymptomDaoImpl extends BaseDaoImpl<Symptom> implements SymptomDao {
	
	public List<Symptom> getSymptomsByGroupId(int groupId) {
		String hql = "from Symptom s where s.symptomGroup.symptomGroupId=:groupId";
		Session session = sessionFactory.getCurrentSession();
		return (List<Symptom>)session.createQuery(hql)
					.setInteger("groupId", groupId)
					.list();

	}

}
