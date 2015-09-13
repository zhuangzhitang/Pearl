package cn.jk.pearl.service.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.CollectPostDao;
import cn.jk.pearl.dao.ExpertApplicationDao;
import cn.jk.pearl.dao.ExpertDao;
import cn.jk.pearl.dao.ExpertEvaluateDao;
import cn.jk.pearl.dao.PostDao;
import cn.jk.pearl.dao.ReplyDao;
import cn.jk.pearl.dao.SecondReplyDao;
import cn.jk.pearl.dao.SystemMessageDao;
import cn.jk.pearl.dao.UserDao;
import cn.jk.pearl.pojo.Expert;
import cn.jk.pearl.pojo.ExpertApplication;
import cn.jk.pearl.pojo.ExpertEvaluate;
import cn.jk.pearl.pojo.Post;
import cn.jk.pearl.pojo.PostCollected;
import cn.jk.pearl.pojo.Reply;
import cn.jk.pearl.pojo.SecondReply;
import cn.jk.pearl.pojo.SystemMessage;
import cn.jk.pearl.pojo.User;
import cn.jk.pearl.service.ForumService;
import cn.jk.pearl.util.ReplyComparator;
import cn.jk.pearl.vo.CheckReplyVO;
import cn.jk.pearl.vo.ExpertAllMessageVO;

@Service("forumService")
public class ForumServiceImpl implements ForumService {
    @Resource
    private PostDao postDao;
    @Resource
    private ReplyDao replyDao;
    @Resource
    private SecondReplyDao secondReplyDao;
    @Resource
    private CollectPostDao collectPostDao;
    @Resource
    private ExpertDao expertDao;
    @Resource
    private ExpertEvaluateDao expertEvaluateDao;
    @Resource
    private UserDao userDao;
    @Resource
    private ExpertApplicationDao expertApplicationDao;
    @Resource
    private SystemMessageDao systemMessageDao;
	public List<Post> queryPost(int pageSize, int pageNum) {
	    List<Post> postList=postDao.queryPost();
		int from=(pageNum-1)*pageSize;
		int to=from+pageSize;
		if(to<=postList.size()){
		   return postList.subList(from, to);
		}else{
			List<Post> result=new ArrayList<Post>();
			for(int i=from;i<postList.size();i++){
				result.add(postList.get(i));
			}
			return result;
		}
	}

	public long queryPostPageNum(long pageSize) {
		return postDao.queryPostPageNum(pageSize);
	}

	public void savePost(Post post, Reply reply) {
		Integer i=postDao.savePost(post);
		post.setPostId(i);
		reply.setPost(post);
		reply.setReplyFirst(1);
		reply.setReplyIsread(1);                          //设置为已读，1为已读
        replyDao.save(reply);
	}

	public long querySecondReplyNum(Integer reply_id) {
		return secondReplyDao.querySecondReplyNum(reply_id);
	}

	public List<SecondReply> querySecondReply(Integer reply_id) {
	   return secondReplyDao.querySecondReply(reply_id);
	}

	public void replyPost(Reply reply) {
		replyDao.save(reply);
	}

	public void replyFirstReply(SecondReply secondReply) {
	   secondReplyDao.save(secondReply);
	}
   //待研究中,观察运行结果
	public Post queryPostContent(int postid) {
		return postDao.queryPostContent(postid);
	}
    public Post queryPostByPage(Post post,int pageSize,int pageNum){
    	Set<Reply> setReply=post.getReplySet();
    	Object[] replys= setReply.toArray();
    	int from=(pageNum-1)*pageSize;
    	int to=from+pageSize;
    	Set<Reply> result=new TreeSet<Reply>(new ReplyComparator());
    	if(to>=replys.length){
    		for(int i=from;i<replys.length;i++){
    			result.add((Reply) replys[i]);
    		}
    	}else{
    		for(int i=from;i<to;i++){
    			result.add((Reply) replys[i]);
    		}
    	}
    	post.setReplySet(result);
    	return post;
    }
	public Integer queryPostPageNum(Post post,Integer pageSize) {
		Set<Reply> replySet=post.getReplySet();
		int num=replySet.size();
		int pageNum=num/pageSize;
		if(num%pageSize!=0){
			pageNum+=1;
		}
		return pageNum;
	}

	public void collectPost(PostCollected collectPost) {
		collectPostDao.save(collectPost);
	}

	public Expert queryExpertMessage(int userid) {
		return expertDao.queryExpertMessage(userid);
	}

	public void saveEmployExpert(ExpertEvaluate e) {
		expertEvaluateDao.save(e);
	}

	public void updateTopPost(int postId) {
       postDao.updateTopPost(postId);
	}

	public void deletePost(int postId) {
	   postDao.deletePost(postId);
	}

	public void UpdateStopSpeak(int userid) {
		userDao.UpdateStopSpeak(userid);
	}

	public Set<Post> queryCollectPost(Integer userId) {
		return collectPostDao.queryCollectPost(userId);
	}

	public void deleteCollectPost(int userid, int collectPostId) {
		collectPostDao.deleteCollectPost(userid, collectPostId);
	}

	public List<Post> queryMyPost(int userid) {
		return postDao.queryMyPost(userid); 
	}

	public List<CheckReplyVO> queryMyReply(int userId) {
		List<CheckReplyVO> voList=new ArrayList<CheckReplyVO>();
		voList.addAll(postDao.queryPostCheckReplyVO(userId));
		voList.addAll(secondReplyDao.queryReplyCheckReplyVO(userId));
		return voList;
	}
    public boolean isApplicateExpert(Integer userId){
    	return expertApplicationDao.isApplicateExpert(userId);
    }
	public void saveExpertApplication(ExpertApplication ea) {
		ea.setApplicationIshandle(0);
		ea.setApplicationTime(new Timestamp(System.currentTimeMillis()));
		expertApplicationDao.save(ea);
	}
  
	public List<SystemMessage> querySystemMessage(int userid) {
	   return systemMessageDao.querySystemMessage(userid);
	}

	public long queryExpertNum() {
		return expertDao.queryExpertNum();
	}

	public List<ExpertAllMessageVO> queryExpertAllMessageVOList() {
		List<Expert> expertList=expertDao.query();
		List<ExpertAllMessageVO> expertMessageList=new ArrayList<ExpertAllMessageVO>();
		for(Expert e:expertList){
			Double avg=expertEvaluateDao.queryExpertEvaluateAvgScore(e.getExpertId());
			if(avg==null){
				avg=0.0;
			}
			int userId=e.getUser().getUserId();
			long num=postDao.queryPostNumByUser(userId)+replyDao.queryReplyNumByUser(userId)+secondReplyDao.querySecondReplyNumByUser(userId);
			expertMessageList.add(new ExpertAllMessageVO(e,avg,num));
		}
		return expertMessageList;
	}

	public void saveSystemMessage(SystemMessage sm) {
		 systemMessageDao.save(sm);
	}

	public void degradateExpert(int expertId) {
		Expert e=expertDao.get(expertId);
		userDao.degradateExpert(e.getUser().getUserId());
		expertDao.delete(expertId);
	}

	public List<ExpertApplication> queryExpertApllicationIDAndUserName() {
		return expertApplicationDao.queryAllExpertMessage();
	}

	public ExpertApplication queryExpertApplication(int expertApplicationId) {
		return expertApplicationDao.queryExpertApplication(expertApplicationId);
	}

	public void agreeExpertApplication(int expertApplicationId) {
		ExpertApplication ea=expertApplicationDao.get(expertApplicationId);
		User user=new User();
		user.setUserId(ea.getUser().getUserId());
		Expert e=new Expert(ea.getExpertName(),ea.getExpertSex(),ea.getExpertPhone(),ea.getExpertQq(),
				            ea.getExpertJob(),ea.getExpertJobarea(),ea.getExpertJobpalace(),ea.getExpeertHonor(),
				            user);
		expertDao.save(e);
		userDao.changeUserToExpert(ea.getUser().getUserId());
		expertApplicationDao.delete(expertApplicationId);
	}

	public void refuseExpertApplication(int expertApplicationId) {
		expertApplicationDao.updateExpertApplicationIsHandle(expertApplicationId);
	}

}
