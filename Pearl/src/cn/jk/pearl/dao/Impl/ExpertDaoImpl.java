package cn.jk.pearl.dao.Impl;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.ExpertDao;
import cn.jk.pearl.pojo.Expert;

@Component("expertDao")
public class ExpertDaoImpl extends BaseDaoImpl<Expert> implements ExpertDao {
	public Expert queryExpertMessage(int userid){
		String hql="from Expert e where e.user.userId=:id";
		return (Expert)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userid).uniqueResult();
	}

	public long queryExpertNum() {
	    String hql="select count(e.expertId) from Expert e";
		return (Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

}
