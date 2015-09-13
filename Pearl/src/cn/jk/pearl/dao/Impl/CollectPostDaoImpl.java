package cn.jk.pearl.dao.Impl;


import java.util.Set;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.CollectPostDao;
import cn.jk.pearl.pojo.Post;
import cn.jk.pearl.pojo.PostCollected;
import cn.jk.pearl.pojo.User;

@Component("collectPostDao")
public class CollectPostDaoImpl extends BaseDaoImpl<PostCollected> implements CollectPostDao{
	public Set<Post> queryCollectPost(Integer userId){
		String hql="from User u left join fetch u.collectPostSet where u.userId=:id";
		User u=(User)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userId).uniqueResult();
		return u.getCollectPostSet();
	}
	public void deleteCollectPost(int userid, int collectPostId){
		String hql="delete PostCollected pc where pc.postCollectedPostid=:cid and pc.userid=:uid";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("uid",userid)
		                                  .setInteger("cid",collectPostId).executeUpdate();
	}
}
