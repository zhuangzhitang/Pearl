package cn.jk.pearl.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.SuperUserDao;
import cn.jk.pearl.pojo.SuperUser;
import cn.jk.pearl.service.SuperUserService;
/**
 * 
 *  超级管理员的登录
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value="superUserService")
public class SuperUserServiceImpl implements SuperUserService{
	
	@Resource
	SuperUserDao superUserDao = null;
	/*
	 * 登录
	 */
	public SuperUser login(String username, String userpass) {
		
		return superUserDao.login(username, userpass);
	}
	/*
	 * 是否存在该用户名
	 */
	public boolean isExistUsername(String username) {
		
		return superUserDao.isExistUsername(username);
	}

}
