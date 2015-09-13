package cn.jk.pearl.dao.Impl;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.ExpertApplicationDao;
import cn.jk.pearl.pojo.ExpertApplication;

@Component("expertApplicationDao")
public class ExpertApplicationDaoImpl extends BaseDaoImpl<ExpertApplication> implements ExpertApplicationDao{

	public void deleteExpertApplicationTiming() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-30);
		java.util.Date date=cal.getTime();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));
		Criteria  criteria = sessionFactory.getCurrentSession().createCriteria(ExpertApplication.class);
	    criteria.add(Restrictions.le("applicationTime",new java.sql.Date(date.getTime())));
	    @SuppressWarnings("unchecked")
		List<ExpertApplication> list = criteria.list();
	    for(ExpertApplication ea:list){
	    	if(ea.getApplicationIshandle()==1){
	    		sessionFactory.getCurrentSession().delete(ea);
	    	}
	    }
	}
	public boolean isApplicateExpert(Integer userId){
		String hql="select count(ea.applicationId) from ExpertApplication ea where ea.user.userId=:id";
		long i=(Long)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userId).uniqueResult();
		if(i==0){
			return true;
		}
		   return false;
	}
	@SuppressWarnings("unchecked")
	public List<ExpertApplication> queryAllExpertMessage() {
		String hql="from ExpertApplication ea left join fetch ea.user where ea.applicationIshandle=0";
		//String hql="from ExpertApplication ea left join ea.user where ea.applicationIshandle=0";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	public ExpertApplication queryExpertApplication(int expertApplicationId) {
		String hql="from ExpertApplication ea left join fetch ea.user where ea.applicationId=:id";
		return (ExpertApplication) sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",expertApplicationId).uniqueResult();
	}
	public void updateExpertApplicationIsHandle(int expertApplicationId) {
		String hql="update ExpertApplication ea set ea.applicationIshandle=1 where ea.applicationId=:id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",expertApplicationId).executeUpdate();
		
	}
}
