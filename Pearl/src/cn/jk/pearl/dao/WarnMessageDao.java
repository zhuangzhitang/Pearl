package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.WarnMessage;

public interface WarnMessageDao extends BaseDao<WarnMessage>{
	public List<WarnMessage> queryAllWarnMessageByFarmerId(Integer farmerId);
	public void deleteWarnMessage(int warnMessageId);
}
