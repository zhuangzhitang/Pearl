package cn.jk.pearl.dao.Impl;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.ExpertEvaluateDao;
import cn.jk.pearl.pojo.ExpertEvaluate;

@Component("expertEvaluateDao")
public class ExpertEvaluateDaoImpl extends BaseDaoImpl<ExpertEvaluate> implements ExpertEvaluateDao {

	public Double queryExpertEvaluateAvgScore(int expertId) {
		String hql="select avg(ee.expertEvaluatePoint) from ExpertEvaluate ee where ee.expertEvaluateExpertid=:id";
		return (Double)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",expertId).uniqueResult();
	}

}
