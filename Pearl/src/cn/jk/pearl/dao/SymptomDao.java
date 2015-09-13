package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.Symptom;
/**
 * 
 *  对 symptom 表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface SymptomDao extends BaseDao<Symptom> {
	
	public List<Symptom> getSymptomsByGroupId(int groupId);//通过症状组的id号拿到属于该组症状的所有成员
}
