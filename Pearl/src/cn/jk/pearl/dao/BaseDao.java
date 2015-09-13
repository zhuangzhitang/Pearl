package cn.jk.pearl.dao;

import java.util.List;



public interface BaseDao<T>{
	 public void save(T t);
	 public void update(T t);
	 public T get(int id);
	 public List<T> query();
	 public void delete(int id);
	 public List<T> getContentByPage(int pageSize,int pageNow);
	 public long getCount();
}
