package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.Farmer;

public interface FarmerService {
	public boolean isExistFarmername(String farmername);//是否存在该用户名
	public void register(Farmer farmer);//注册养殖户
	public long getFarmerCount();//使用本系统的养殖户的人数
	public long getpageCount(int pageSize);//获得总页数
	public List<Farmer> getpageContent(int pageSize,int pageNow);//获得本页面的养殖户信息
	public void updateFarmer(Farmer farmer);
	public Farmer login(String farmerName,String farmerPass);
	public void resetPhone(String newPhone,int farmerId);//修改手机号
	public void resetEmail(String newEmail,int farmerId);//修改邮箱
	public void resetPass(String newPass,int farmerId);//修改密码
}
