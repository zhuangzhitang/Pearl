package cn.jk.pearl.dao.Impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.jk.pearl.dao.PostDao;
import cn.jk.pearl.pojo.Post;
import cn.jk.pearl.pojo.Reply;
import cn.jk.pearl.vo.CheckReplyVO;

@SuppressWarnings("unchecked")
@Component("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {
	public List<Post> queryPost(){
		List<Post> allPost=new ArrayList<Post>();
		String tophql="from Post p left join fetch p.replySet as s where p.postStatus=1 and p.istop=1 and s.replyFirst=1 order by p.postToptime desc";
    	List<Post> topList=sessionFactory.getCurrentSession().createQuery(tophql)
    			         .setFirstResult(0).setMaxResults(3).list();
    	List<Integer> o=new ArrayList<Integer>();
    	for(Post p:topList){
    		o.add(p.getPostId());
    	}
    	Object[] i=o.toArray();
		String hql="select distinct p from Post p left join fetch p.replySet as s where p.postStatus=:sta and p.postId not in(:object) and s.replyFirst=:first order by p.postTime desc";
		List<Post> otherList=sessionFactory.getCurrentSession().createQuery(hql)
				.setInteger("sta",1).setParameterList("object",i).setInteger("first",1).list();
		allPost.addAll(topList);
		allPost.addAll(otherList);
		return allPost;
	}
	public long queryPostPageNum(long pageSize){
		String hql="select count(p.postTitle) from Post p where p.postStatus=1";
		Long num=(Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		long pageNum=num/pageSize;
		if(num%pageSize!=0){
			pageNum=pageNum+1;
		}
		return pageNum;
	}
	public Integer savePost(Post post){
		return (Integer)sessionFactory.getCurrentSession().save(post);
	}
	public Post queryPostContent(int postid){
		String hql="from Post p left join fetch p.replySet as s left join fetch s.user where p.postStatus=1 and p.postId=:id";
		return (Post)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",postid).uniqueResult();
	}
	public void updateTopPost(int postId) {
		Timestamp time=new Timestamp(System.currentTimeMillis());
		String hql="update Post p set p.istop=1, p.postToptime=:time where p.postId=:id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",postId).setTimestamp("time",time).executeUpdate();
		
	}
	public void deletePost(int postId){
		String hql="update Post p set p.postStatus=0 where p.postId=:id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",postId).executeUpdate();
	}
	public List<Post> queryMyPost(int userid){
		String hql="from Post p where p.user.userId=:id and p.postStatus=1";
		return sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userid).list();
	}
	public List<CheckReplyVO> queryPostCheckReplyVO(Integer userId) {
		List<CheckReplyVO> checkReplyVOList=new ArrayList<CheckReplyVO>();
	    String hql="select distinct p from Post p left join fetch p.replySet as s left join fetch s.user where p.user.userId=:id and s.replyIsread=0 and p.postStatus=1";
		List<Post> postList=sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userId).list();
		for(Post post:postList){
			if(post.getReplySet().size()==0){
				postList.remove(post);
			}
			for(Reply reply:post.getReplySet()){
			  CheckReplyVO replyVO=new CheckReplyVO();
			  replyVO.setName(reply.getUser().getUserName());
			  replyVO.setPostId(post.getPostId());
			  replyVO.setReplyContent(reply.getReplyContent());
			  replyVO.setReplyedContent(post.getPostTitle());
			  replyVO.setReplyedType(0);  //0表示的是文字
			  replyVO.setReplyType(reply.getReplyType());
			  checkReplyVOList.add(replyVO);
			  String updateHql="update Reply r set r.replyIsread=1 where r.replyId=:rId";
			  sessionFactory.getCurrentSession().createQuery(updateHql).setInteger("rId",reply.getReplyId()).executeUpdate();
			}
		}
		return checkReplyVOList;
	}
	public long queryPostNumByUser(int userId) {
		Calendar cal=Calendar.getInstance();
		java.util.Date date=cal.getTime();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
		String time=df.format(date);
		String hql="select count(p.postId) from Post p where p.user.userId=:id and p.postTime like '%"+time+"%'";
		return (Long)sessionFactory.getCurrentSession().createQuery(hql)
				.setInteger("id",userId).uniqueResult();
		
	}
	

}
