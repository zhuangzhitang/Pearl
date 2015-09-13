package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.SystemMessageDao;
import cn.jk.pearl.pojo.SystemMessage;

@Component("systemMessageDao")
public class SystemMessageDaoImpl extends BaseDaoImpl<SystemMessage> implements SystemMessageDao{
	@SuppressWarnings("unchecked")
	public List<SystemMessage> querySystemMessage(int userid){
		String hql="from SystemMessage sys where sys.user.userId=:id";
		List<SystemMessage> systemMessageList=sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userid).list();
	    for(SystemMessage sys:systemMessageList){
	    	String delhql="delete from SystemMessage s where s.systemMessageId=:id";
	    	sessionFactory.getCurrentSession().createQuery(delhql).setInteger("id",sys.getSystemMessageId()).executeUpdate();
	    }
	    return systemMessageList;
	}
}
