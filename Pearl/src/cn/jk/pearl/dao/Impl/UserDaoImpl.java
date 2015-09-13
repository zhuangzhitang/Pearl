package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.UserDao;
import cn.jk.pearl.pojo.User;

/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public void UpdateStopSpeak(int userid){
		String hql="update User u set u.userIsstopspeak=1 where u.userId=:id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userid).executeUpdate();
	}

	public void degradateExpert(int userId) {
	    String hql="update User u set u.userLevel=0 where u.userId=:id";
	    sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userId).executeUpdate();
	}
	public void changeUserToExpert(int userId){
		String hql="update User u set u.userLevel=1 where u.userId=:id";
	    sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",userId).executeUpdate();
	}
	public boolean isExitUsername(String username) {

		String hql = "from User u where u.userName=:username";
		Session session = sessionFactory.getCurrentSession();
		Object flag = session.createQuery(hql).setString("username", username)
				.uniqueResult();
		if (flag != null)
			return true;
		return false;
	}

	public boolean isExitEmail(String email) {

		String hql = "from User u where u.userEmail=:email";
		Session session = sessionFactory.getCurrentSession();
		Object flag = session.createQuery(hql).setString("email", email)
				.uniqueResult();
		if (flag != null)
			return true;
		return false;
	}

	public User login(String username, String userpass) {

		String hql = "from User u where u.userName=:username and u.userPass=:userpass";
		Session session = sessionFactory.getCurrentSession();
		return (User) session.createQuery(hql).setString("username", username)
				.setString("userpass", userpass).uniqueResult();
	}

	public boolean isResetUserpass(String username, String email) {

		String hql = "from User u where u.userName=:username and u.userEmail=:email";
		Session session = sessionFactory.getCurrentSession();
		Object flag = session.createQuery(hql).setString("username", username)
				.setString("email", email).uniqueResult();
		if (flag != null)
			return true;
		return false;
	}

	public void resetPassByName(String newPass, String username) {

		String hql = "update User u set u.userPass=:newPass where u.userName=:username";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).setString("newPass", newPass)
				.setString("username", username).executeUpdate();
	}

	public void resetPassById(String newPass, int userId) {

		String hql = "update User u set u.userPass=:newPass where u.userId=:userId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).setString("newPass", newPass)
				.setInteger("userId", userId).executeUpdate();
	}

	public void resetEmailById(String newEmail, int userId) {

		String hql = "update User u set u.userEmail=:newEmail where u.userId=:userId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).setString("newEmail", newEmail)
				.setInteger("userId", userId).executeUpdate();
	}

	public void resetUserPhotoById(String photopath, int userId) {

		String hql = "update User u set u.userImagepath=:photopath where u.userId=:userId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).setString("photopath", photopath)
				.setInteger("userId", userId).executeUpdate();
	}

	public void setManagerPower(int isManage, int userId) {

		String hql = "update User u set u.userIsmanager=:isManager where u.userId=:userId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).setInteger("isManager", isManage)
				.setInteger("userId", userId).executeUpdate();
	}

	public List<User> getManager() {

		String hql = "from User u where u.userIsmanager=1";
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery(hql).list();
	}

	public List<User> seekUser(String seekContent) {

		String hql = "from User u where u.userName like '%" + seekContent + "%'";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
}
