package cn.jk.pearl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import cn.jk.pearl.pojo.Post;
import cn.jk.pearl.vo.CheckReplyVO;

public interface PostDao extends BaseDao<Post>{
	public List<Post> queryPost();
	public long queryPostPageNum(long pageSize);
	public Integer savePost(Post post);
	public Post queryPostContent(int postid);
	public void updateTopPost(int postId);
	public void deletePost(int postId);
	public List<Post> queryMyPost(int userid);
	public List<CheckReplyVO> queryPostCheckReplyVO(Integer userId);
	public long queryPostNumByUser(int userId);
}
