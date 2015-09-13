package cn.jk.pearl.service;

import cn.jk.pearl.pojo.SuperUser;

public interface SuperUserService {
	public SuperUser login(String username,String userpass);//登录
	public boolean isExistUsername(String username);//是否存在该用户名
}
