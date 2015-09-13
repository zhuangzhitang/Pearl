package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.SymptomPower;

public interface SymptomPowerDao extends BaseDao<SymptomPower>{
	public List<SymptomPower> getSymptomPowerbySymptomId(int SymptomId);//通过症状Id获得对应的疾病和权重
	
}
