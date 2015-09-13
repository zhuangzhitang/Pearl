package cn.jk.pearl.dao.Impl;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.SecondReplyDao;
import cn.jk.pearl.pojo.SecondReply;
import cn.jk.pearl.vo.CheckReplyVO;


@SuppressWarnings("unchecked")
@Component("secondReplyDao")
public class SecondReplyDaoImpl extends BaseDaoImpl<SecondReply> implements SecondReplyDao {
	public long querySecondReplyNum(Integer reply_id){
		String hql="select count(s.secondReplyId) from SecondReply s where s.reply.replyId=:id";
		Long num=(Long)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",reply_id).uniqueResult();
		return num;
	}
	public List<SecondReply> querySecondReply(Integer reply_id){
		String hql="from SecondReply s where s.reply.replyId=:id order by s.secondReplyTime";
		return (List<SecondReply>)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",reply_id).list();
	}
	public List<CheckReplyVO> queryReplyCheckReplyVO(Integer userId) {
		String hql="select distinct sr from SecondReply sr left join fetch sr.reply as r left join sr.user left join r.post where r.user.userId=:id and sr.secondReplyIsread=0";
		//String hql="from SecondReply sr left join fetch sr.reply as r left join fetch sr.user left join fetch r.post where r.user.userId=:id and sr.secondReplyIsread=0";
		List<SecondReply> secondReply=sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userId).list();		
		List<CheckReplyVO> replyVO=new ArrayList<CheckReplyVO>();
		for(SecondReply sr:secondReply){
			   CheckReplyVO checkReplyVO=new CheckReplyVO();
			   checkReplyVO.setReplyType(sr.getSecondReplyType());
			   checkReplyVO.setReplyContent(sr.getSecondReplyContent());
			   checkReplyVO.setReplyedType(sr.getReply().getReplyType());
			   checkReplyVO.setReplyedContent(sr.getReply().getReplyContent());
			   checkReplyVO.setPostId(sr.getReply().getPost().getPostId());
			   checkReplyVO.setName(sr.getUser().getUserName());
			   String updateHql="update SecondReply sr set sr.secondReplyIsread=1 where sr.secondReplyId=:sId";
		    	sessionFactory.getCurrentSession().createQuery(updateHql).setInteger("sId",sr.getSecondReplyId()).executeUpdate();
		    	replyVO.add(checkReplyVO);
		   }
		  	return replyVO;
	}
	public long querySecondReplyNumByUser(int userId) {
		Calendar cal=Calendar.getInstance();
		java.util.Date date=cal.getTime();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
		String time=df.format(date);
		String hql="select count(sr.secondReplyId) from SecondReply sr where sr.user.userId=:id and sr.secondReplyTime like '%"+time+"%'";
		return (Long)sessionFactory.getCurrentSession().createQuery(hql)
				.setInteger("id",userId).uniqueResult();
	}
}
