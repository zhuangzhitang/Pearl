package cn.jk.pearl.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.DiseaseDao;
import cn.jk.pearl.dao.SymptomDao;
import cn.jk.pearl.dao.SymptomGroupDao;
import cn.jk.pearl.dao.SymptomPowerDao;
import cn.jk.pearl.dao.SymptomsMapDao;
import cn.jk.pearl.pojo.Disease;
import cn.jk.pearl.pojo.Symptom;
import cn.jk.pearl.pojo.SymptomGroup;
import cn.jk.pearl.pojo.SymptomPower;
import cn.jk.pearl.pojo.SymptomsMap;
import cn.jk.pearl.service.DiseaseService;
/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value="diseaseService")
public class DiseaseServiceImpl implements DiseaseService {
	
	@Resource
	SymptomPowerDao symptomPowerDao = null;
	
	@Resource
	SymptomGroupDao symptomGroupDao = null;
	
	@Resource
	SymptomDao symptomDao = null;
	
	@Resource 
	SymptomsMapDao symptomsMapDao = null;
	
	@Resource
	DiseaseDao diseaseDao = null;
	/*
	 * 获得症状组
	 */
	public List<SymptomGroup> getAllSymptomGroup() {

		return symptomGroupDao.query();
	}
	
	/*
	 * 获得症状组中的症状集合
	 */
	public List<Symptom> getSymptomsByGroupId(int groupId) {

		return symptomDao.getSymptomsByGroupId(groupId);
	}
	
	/*
	 * 疾病处理机，待完善
	 */
	public List<SymptomPower> getDiseases(int[] symptomId) {
		
		List<SymptomPower> symptomPowers = new ArrayList<SymptomPower>();
		List<SymptomPower> temp = new ArrayList<SymptomPower>();
		for (int i = 0; i < symptomId.length; i++) {
				symptomPowers.addAll(symptomPowerDao.getSymptomPowerbySymptomId(symptomId[i]));
		}
		
		for(SymptomPower sym:symptomPowers){
			if(temp.size()==0){
				temp.add(sym);
				continue;
			}
			int count =0;
			SymptomPower sPower=null;
			for ( int i = 0 ; i <temp.size();i++) {
				sPower = temp.get(i);
				count++;
				if(sPower.getDiseaseId()==sym.getDiseaseId()){
					SymptomPower sPower2 = sPower;
					sPower.setSymptompower(sPower.getSymptompower()+sym.getSymptompower());
					break;
				}		
			}
			if(count==temp.size()){
				temp.add(sym);
			}	
		}
		Collections.sort(temp);//降序
	return temp;
	}
	
	/*
	 * 症状图
	 */
	public List<SymptomsMap> getSymptomsMap(int diseaseId) {
		
		return symptomsMapDao.getSymptomsMap(diseaseId);
	}
	
	/*
	 * 获取疾病
	 */
	public Disease getDisease(int diseaseId) {
		
		return diseaseDao.get(diseaseId);
	}

}
