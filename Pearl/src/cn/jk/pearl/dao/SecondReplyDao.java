package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.SecondReply;
import cn.jk.pearl.vo.CheckReplyVO;

public interface SecondReplyDao extends BaseDao<SecondReply>{
	public long querySecondReplyNum(Integer reply_id);
	public List<SecondReply> querySecondReply(Integer reply_id);
	public List<CheckReplyVO> queryReplyCheckReplyVO(Integer userId);
	public long querySecondReplyNumByUser(int userId);
}
