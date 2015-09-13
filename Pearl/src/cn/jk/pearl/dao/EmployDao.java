package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.EmployInformation;
/**
 * 
 *  对 employ表的操作 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface EmployDao extends BaseDao<EmployInformation>{
	public List<EmployInformation> getEmployInformationsById(int farmerId);//通过养殖户的id获得养殖户发送的招聘信息
}
