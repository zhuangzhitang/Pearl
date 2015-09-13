package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.SystemMessage;

public interface SystemMessageDao extends BaseDao<SystemMessage>{
	public List<SystemMessage> querySystemMessage(int userid);
}
