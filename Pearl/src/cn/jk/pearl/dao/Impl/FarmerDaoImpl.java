package cn.jk.pearl.dao.Impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.FarmerDao;
import cn.jk.pearl.pojo.Farmer;

/**
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository(value="farmerDao")
public class FarmerDaoImpl extends BaseDaoImpl<Farmer> implements FarmerDao {
	
	/*
	 * 验证是否存在用户名
	 */
	public boolean isExistFarmername(String farmername) {
		String hql="from Farmer f where f.farmerName=:farmername";
		Session session = sessionFactory.getCurrentSession();
		if(session.createQuery(hql)!=null){
			return true;
		}
		return false;
	}
	/*
	 * 修改手机号码
	 */
	public void resetPhone(String newPhone, int farmerId) {
		String hql = "update Farmer f set f.farmerPhone=:newPhone where f.farmerId=:farmerId ";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql)
				.setString("newPhone", newPhone)
				.setInteger("farmerId", farmerId)
				.executeUpdate();
	}
	
	/*
	 * 修改邮件
	 */
	public void resetEmail(String newEmail, int farmerId) {
		String hql = "update Farmer f set f.farmerEmail=:newEmail where f.farmerId=:farmerId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql)
				.setString("newEmail", newEmail)
				.setInteger("farmerId", farmerId)
				.executeUpdate();
	}
	
	/*
	 * 修改密码
	 */
	public void resetPass(String newPass, int farmerId) {
		String hql = "update Farmer f set f.farmerPass=:newPass where f.farmerId =:farmerId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql)
				.setString("newPass", newPass)
				.setInteger("farmerId", farmerId)
				.executeUpdate();
	}
	public Farmer login(String farmerName, String farmerPass) {
		String hql = "from Farmer f where f.farmerName=:farmerName and f.farmerPass=:farmerPass";
		Session session = sessionFactory.getCurrentSession();
		return (Farmer) session.createQuery(hql)
							.setString("farmerName", farmerName)
							.setString("farmerPass", farmerPass)
							.uniqueResult();
	}
	public Integer saveFarmer(Farmer farmer) {
		return (Integer) sessionFactory.getCurrentSession().save(farmer);
	}

	

}
