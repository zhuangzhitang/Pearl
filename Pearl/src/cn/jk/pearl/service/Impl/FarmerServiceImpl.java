package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.FarmerDao;
import cn.jk.pearl.dao.ParameterDao;
import cn.jk.pearl.pojo.Farmer;
import cn.jk.pearl.service.FarmerService;
/**
 * 
 *  养殖户的管理
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value="farmerService")
public class FarmerServiceImpl implements FarmerService {
	
	@Resource
	FarmerDao farmerDao = null;
	@Resource
	private ParameterDao parameterDao;
	
	//用户名是否存在
	public boolean isExistFarmername(String farmername) {
		
		return farmerDao.isExistFarmername(farmername);
	}
	//注册
	public void register(Farmer farmer) {
        //farmerDao.save(farmer);
       Integer i=farmerDao.saveFarmer(farmer);
       parameterDao.savePersonalParameter(farmerDao.get(i));
	}
	
	//获得本系统养殖户的总人数
	public long getFarmerCount() {

		return farmerDao.getCount();
	}
	
	//获得养殖户集合的总页数
	public long getpageCount(int pageSize) {
		long farmerCount = farmerDao.getCount();
		long pageCount = 0 ;
		if(farmerCount%pageSize==0){
			pageCount = farmerCount/pageSize ;
		}else{
			pageCount = farmerCount/pageSize + 1;
		}
		return pageCount;
	}
	
	//获得当前页面的养殖户集合
	public List<Farmer> getpageContent(int pageSize, int pageNow) {

		return farmerDao.getContentByPage(pageSize, pageNow);
	}

	public void updateFarmer(Farmer farmer) {
		
		farmerDao.update(farmer);
	}
	
	//修改电话号码
	public void resetPhone(String newPhone, int farmerId) {
	
		farmerDao.resetPhone(newPhone, farmerId);
	}
	
	//修改邮箱
	public void resetEmail(String newEmail, int farmerId) {
		
		farmerDao.resetEmail(newEmail, farmerId);
	}
	
	//修改密码
	public void resetPass(String newPass, int farmerId) {
		
		farmerDao.resetPass(newPass, farmerId);
	}
	
	//登录
	public Farmer login(String farmerName, String farmerPass) {
		
		return farmerDao.login(farmerName, farmerPass);
	}

}
