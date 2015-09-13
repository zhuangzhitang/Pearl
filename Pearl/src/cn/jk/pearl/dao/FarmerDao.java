package cn.jk.pearl.dao;

import cn.jk.pearl.pojo.Farmer;
/**
 * 
 *  对farmer表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface FarmerDao extends BaseDao<Farmer> {
	public  boolean isExistFarmername(String farmername);//是否存在用户名
	public void resetPhone(String newPhone,int farmerId);//修改手机
	public void resetEmail(String newEmail,int farmerId);//修改邮箱
	public void resetPass(String newPass,int farmerId);//修改密码
	public Farmer login(String farmerName,String farmerPass);//登录
	public Integer saveFarmer(Farmer farmer);
}
