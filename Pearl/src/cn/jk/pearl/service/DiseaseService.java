package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.Disease;
import cn.jk.pearl.pojo.Symptom;
import cn.jk.pearl.pojo.SymptomGroup;
import cn.jk.pearl.pojo.SymptomPower;
import cn.jk.pearl.pojo.SymptomsMap;

/**
 * 
 *  疾病诊断接口 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface DiseaseService {
	public List<SymptomGroup> getAllSymptomGroup();//获得所有的症状组
	public List<Symptom> getSymptomsByGroupId(int GroupId);//获得症状组的所有症状
	public List<SymptomPower> getDiseases(int[] symptomId);//获得疾病的疾病的排名
	public List<SymptomsMap> getSymptomsMap(int diseaseId);//疾病的症状图
	public Disease getDisease(int diseaseId);
}
