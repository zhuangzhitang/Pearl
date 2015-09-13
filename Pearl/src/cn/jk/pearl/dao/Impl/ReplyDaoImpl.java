package cn.jk.pearl.dao.Impl;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.ReplyDao;
import cn.jk.pearl.pojo.Reply;

@Component("replyDao")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao {

	public long queryReplyNumByUser(int userId) {
		Calendar cal=Calendar.getInstance();
		java.util.Date date=cal.getTime();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
		String time=df.format(date);
		String hql="select count(r.replyId) from Reply r where r.user.userId=:id and r.replyTime like '%"+time+"%'";
		return (Long)sessionFactory.getCurrentSession().createQuery(hql)
				.setInteger("id",userId).uniqueResult();
	}
}
