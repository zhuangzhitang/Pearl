package cn.jk.pearl.dao;

import cn.jk.pearl.pojo.SuperUser;
/**
 * 
 * 对superuser表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface SuperUserDao extends BaseDao<SuperUser> {
	public SuperUser login(String username,String userpass);//登录
	public boolean isExistUsername(String username);//用户名是否存在
}
