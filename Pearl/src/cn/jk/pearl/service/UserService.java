package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.User;

public interface UserService {
	public boolean isExistUsername(String username);//是否存在该用户名
	public boolean isExistEmail(String email);//是否存在该邮箱
	public void register(User user);//注册用户
	public boolean isResetUserpass(String username,String email);//忘记密码：通过用户名和邮箱判断用户是否可以重置密码
	public void resetPassByName(String newPass,String username);//忘记密码:通过用户名修改密码
	public User login(String username,String userpass);//通过用户名和密码得到该用户，如果不存在则返回空
	public void resetPassById(String newPass,int userId); //通过userId修改密码
	public void resetEmailById(String newEmail,int userId);//通过userID修改邮箱
	public void resetUserPhotoById(String photopath,int userId);//设置头像
	public void setManagerPower(int isManage,int userId);//设置用户的管理权限，isMananager当1：设置为管理员，当0，为普通用户
	public List<User> getManager();//获得所有管理员集合
	public List<User> seekUser(String seekContent);//查找用户
	public long getUserCount();//获得该系统的用户的总人数
}
