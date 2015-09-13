package cn.jk.pearl.dao;

import cn.jk.pearl.pojo.Reply;


public interface ReplyDao extends BaseDao<Reply>{
   public long queryReplyNumByUser(int userId);
}
