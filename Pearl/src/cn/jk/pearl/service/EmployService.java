package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.EmployInformation;
/**
 * 
 *  招聘信息接口 
 * @author ZheTang
 * @date 2014-12-8
 *
 */
public interface EmployService {
	public List<EmployInformation> showEmployMessageById(int farmerId);//展示养殖户招聘信息
	public List<EmployInformation> showAllEmployMessages();//展示所有招聘信息
	public void deleteEmployMessage(int employId);//删除某条招聘信息
	public void sendEmployMessage(EmployInformation employInformation);//保存招聘信息
}
