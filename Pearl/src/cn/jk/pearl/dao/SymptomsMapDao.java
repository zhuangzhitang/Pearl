package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.SymptomsMap;

public interface SymptomsMapDao extends BaseDao<SymptomsMap> {
	public List<SymptomsMap> getSymptomsMap(int diseaseId);//疾病的症状图
}
