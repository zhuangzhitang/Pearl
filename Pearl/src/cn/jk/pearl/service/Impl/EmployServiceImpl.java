package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.EmployDao;
import cn.jk.pearl.pojo.EmployInformation;
import cn.jk.pearl.service.EmployService;
/**
 * 
 *  招聘信息的管理
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value="employService")
public class EmployServiceImpl implements EmployService {
	
	@Resource
	EmployDao employDao = null;
	
	/*
	 *@param 根据养殖户的ID号
	 *return 返回养殖户发布的招聘信息对应的相关实体
	 */
	public List<EmployInformation> showEmployMessageById(int farmerId) {
		
		return employDao.getEmployInformationsById(farmerId);
	}
	
	/*
	 * return ：返回所有的招聘信息对应的相关实体
	 */
	public List<EmployInformation> showAllEmployMessages() {

		return employDao.query();
	}
	
	/*
	 * 删除招聘信息
	 * @param employId :招聘信息的id号
	 */
	public void deleteEmployMessage(int employId) {
		
		 employDao.delete(employId);
	}
	
	/*
	 * 发送招聘信息
	 * @param employInformation:招聘信息对应的相关实体
	 */
	public void sendEmployMessage(EmployInformation employInformation) {
		employDao.save(employInformation);
	}

}
