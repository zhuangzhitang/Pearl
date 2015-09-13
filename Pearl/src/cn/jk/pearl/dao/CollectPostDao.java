package cn.jk.pearl.dao;

import java.util.Set;

import cn.jk.pearl.pojo.Post;
import cn.jk.pearl.pojo.PostCollected;

public interface CollectPostDao extends BaseDao<PostCollected>{
	public Set<Post> queryCollectPost(Integer userId);
	public void deleteCollectPost(int userid, int collectPostId);
}
