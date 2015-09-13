package cn.jk.pearl.dao;


import cn.jk.pearl.pojo.Expert;

public interface ExpertDao extends BaseDao<Expert>{
	public Expert queryExpertMessage(int userid);
	public long queryExpertNum();
}
