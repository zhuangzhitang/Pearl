package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.UserDao;
import cn.jk.pearl.pojo.User;
import cn.jk.pearl.service.UserService;
/**
 * 
 * 登录注册，普通用户的一些信息的修改
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource UserDao userDao = null;
	
	/*
	 *注册： 是否存在该用户
	 */
	public boolean isExistUsername(String username) {

		return userDao.isExitUsername(username);
	}
	
	/*
	 * 注册：是否存在邮箱
	 */
	public boolean isExistEmail(String email) {

		return userDao.isExitEmail(email);
	}
	
	/*
	 * 注册用户
	 */
	public void register(User user) {

		userDao.save(user);
	}
	
	/*
	 * 忘记密码:验证用户名，邮箱相同
	 */
	public boolean isResetUserpass(String username, String email) {

		return userDao.isResetUserpass(username, email);
	}
	
	/*
	 * 重置密码:通过用户名
	 */
	public void resetPassByName(String newPass, String username) {
		
		 userDao.resetPassByName(newPass, username);
	}
	
	/*
	 * 用户登录
	 */
	public User login(String username, String userpass) {

		return userDao.login(username, userpass);
	}
	
	/*
	 * 修改密码:用户登录后可以修改密码
	 */
	public void resetPassById(String newPass, int userId) {
		
		userDao.resetPassById(newPass, userId);
	}
	
	/*
	 * 修改邮箱:用户登录后可以修改邮箱
	 */
	public void resetEmailById(String newEmail, int userId) {
		
		userDao.resetEmailById(newEmail, userId);
	}
	
	/*
	 * 设置头像:用户可以在论坛中设置头像
	 */
	public void resetUserPhotoById(String photopath, int userId) {
	
		userDao.resetUserPhotoById(photopath, userId);
	}
	
	/*
	 * 设置用户名是否为管理员
	 */
	public void setManagerPower(int isManage, int userId) {
	
		userDao.setManagerPower(isManage, userId);
	}
	
	/*
	 * 获得该系统的管理员名单
	 */
	public List<User> getManager() {

		return userDao.getManager();
	}
	
	/*
	 * 搜索用户，返回匹配的用户列表
	 */
	public List<User> seekUser(String seekContent) {

		return userDao.seekUser(seekContent);
	}
	
	/*
	 * 返回本系统已注册的用户总人数
	 */
	public long getUserCount() {

		return userDao.getCount();
	}

}
