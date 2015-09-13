package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.WarnMessageDao;
import cn.jk.pearl.pojo.WarnMessage;

@Repository("warnMessageDao")
public class WarnMessageDaoImpl extends BaseDaoImpl<WarnMessage> implements WarnMessageDao{

	@SuppressWarnings("unchecked")
	public List<WarnMessage> queryAllWarnMessageByFarmerId(Integer farmerId) {
		return (List<WarnMessage>)sessionFactory.getCurrentSession().createCriteria(WarnMessage.class)
				.createCriteria("farmer").add(Restrictions.eq("farmerId",farmerId)).list();
	}

	public void deleteWarnMessage(int warnMessageId) {
		sessionFactory.getCurrentSession().delete(this.get(warnMessageId));
	}

}
