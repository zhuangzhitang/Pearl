package cn.jk.pearl.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.NewsDao;
import cn.jk.pearl.pojo.News;

@Repository("newsDao")
/**
 * 
 * @author zaopeng
 *
 */
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{

	@SuppressWarnings("unchecked")
	/**
	 * pageSize 一页的数目
	 * pageNum  第几页
	 */
	public List<News> queryNewsTitlezByType(int newsTypeId,int pageSize,int pageNum) {
		String hql="select new News(n.newsId,n.newsTitle) from News n where n.newsCategory.newsCategoryId=:id";
		int firstmovie = (pageNum - 1) * pageSize;
		return sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",newsTypeId)
				.setFirstResult(firstmovie).setMaxResults(pageSize).list();
    }

	public void deleteALLNew(){
		String hql="delete from News";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}
	public Map<Integer, Integer> updateClickNum(Map<Integer,Integer> map) {
		Set<Entry<Integer, Integer>> set=map.entrySet();
		for(Entry<Integer, Integer> newsClickNum:set){
			if(newsClickNum.getValue()==0){
				set.remove(newsClickNum);
			}
			Integer newsId=newsClickNum.getKey();
			Integer clickNum=newsClickNum.getValue();
		    String hql="update News n set n.newsClicknum+=:clickNum where n.newsId=:newsId";
		    sessionFactory.getCurrentSession().createQuery(hql).setInteger("clickNum",clickNum)
		                  .setInteger("newsId",newsId).executeUpdate();
		}
		return this.getAllNewsId();
	}
   @SuppressWarnings("unchecked")
	public Map<Integer,Integer> getAllNewsId(){
		   String hql="selext n.newsId from News n";
		   Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		  for(News n:(List<News>)sessionFactory.getCurrentSession().createQuery(hql).list()){
			  map.put(n.getNewsId(),0);
		  }
		  return map;
    }

	public long getNewsPageNumByType(int i, long pageSize) {
		String hql="select count(n.newsTitle) from News n where n.newsCategory.newsCategoryId=:id";
		long countNum=(Long)sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",i).uniqueResult();
		long pageNum=countNum/pageSize;
		if(countNum%pageSize!=0){
			pageNum=pageNum+1;
		}
		return pageNum;
	}
	
	public long queryAllNewsPageNum(long pageSize) {
		String hql1="select count(n.newsTitle) from News n";
		String hql2="select count(nt.newsTemporaryTitle) from NewsTemporary nt";
		long countNum=(Long)sessionFactory.getCurrentSession().createQuery(hql1).uniqueResult()+
				       (Long)sessionFactory.getCurrentSession().createQuery(hql2).uniqueResult();
		long pageNum=countNum/pageSize;
		if(countNum%pageSize!=0){
			pageNum=pageNum+1;
		}
		return pageNum;
	}
}
