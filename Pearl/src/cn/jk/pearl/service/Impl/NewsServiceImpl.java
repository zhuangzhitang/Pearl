package cn.jk.pearl.service.Impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.util.ParserException;
import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.NewsDao;
import cn.jk.pearl.dao.NewsTemporaryDao;
import cn.jk.pearl.pojo.News;
import cn.jk.pearl.pojo.NewsTemporary;
import cn.jk.pearl.service.NewsService;
import cn.jk.pearl.util.SpiderByzz31Util;
import cn.jk.pearl.util.SpiderByzz6b2Util;

@Service("newsService")
/**
 * @author zaopeng
 * 新闻管理的service层。
 *
 */
public class NewsServiceImpl implements NewsService{
	@Resource
    private NewsDao newsDaoImpl;
	@Resource
	private NewsTemporaryDao newsTemporaryDaoImpl;
	/**
	 * 根据传入的新闻类别的ID值，获取该类别新闻的集合
	 * i--新闻类别的ID值
	 * pageSize---每页有多少项
	 * pageNum----第几页
	 */
	public List<News> getNewsTitleByType(int i, int pageSize, int pageNum) {
		return newsDaoImpl.queryNewsTitlezByType(i, pageSize, pageNum);
	}
	public long getNewsPageNumByType(int i,long pageSize){
		return newsDaoImpl.getNewsPageNumByType(i, pageSize);
	}
    /**
     * 根据传入的id值，返回该id对应的新闻对象
     */
	public News getNewsContent(int id) {
		return newsDaoImpl.get(id);
	}
    /**
     *  覆盖更新新闻的内容
     */
	public void deleteUpdateNews(){
		newsDaoImpl.deleteALLNew();
		newsTemporaryDaoImpl.deleteAll();
		 this.NotDeleteUpdateNews();
	}
    /**
     * 在不删除原来新闻的前提下，更新新闻的内容
     */
	public void NotDeleteUpdateNews() {
		try {
			for(NewsTemporary news:SpiderByzz6b2Util.getListNews()){
				newsTemporaryDaoImpl.save(news);
			}
			for(NewsTemporary news:SpiderByzz31Util.getListNews()){
				newsTemporaryDaoImpl.save(news);
			}
		} catch (ParserException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
   /**
    * 批量发布新闻，传入的是新闻的id值数组
    */
	public void releaseNews(int[] id) {
		for(int i:id){
			NewsTemporary n=newsTemporaryDaoImpl.get(i);
			News news=new News(n.getNewsTemporaryTitle(),n.getNewsTemporaryFrom(),n.getNewsTemporaryAuthor(), 
					          n.getNewsTemporaryContent(),0,n.getNewsTemporaryCreatetime(),n.getNewsTemporaryLastupdatetime(),
					          n.getNewsCategory());
			newsDaoImpl.save(news);
			newsTemporaryDaoImpl.delete(i);
		}
	}
  /**
   * 批量删除新闻，传入的是新闻的id值数组，
   * 这里删除新闻可以同时删除发布的新闻和未发布的新闻
   */
	public void deleteNews(int[] id) {
		for(int i:id){
			if(i>0){ //i>o表示新闻已经发布
				newsDaoImpl.delete(i);
			}else if(i<0){  //i<0表示新闻还是未发布的。
				newsTemporaryDaoImpl.delete(0-i);
			}
		}
	}
   //修改已经发布的新闻
	public void updateReleasedNews(News news) {
		news.setNewsLastupdatetime(new Timestamp(System.currentTimeMillis()));
		newsDaoImpl.update(news);
	}
   //修改未发布的新闻
	public void updateUnReleasedNews(NewsTemporary news) {
		news.setNewsTemporaryLastupdatetime(new Timestamp(System.currentTimeMillis()));
		newsTemporaryDaoImpl.update(news);
	}
  //根据传入的id值，返回该id对应的未发布的新闻对象
	public NewsTemporary getNewsTemporaryContent(int id) {
		return newsTemporaryDaoImpl.get(id);
	}
   //获取所有的新闻的集合，包括发布的和未发布的。
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List queryAllNews(int pageSize,int pageNum) {
		List allNews=new ArrayList();
		allNews.addAll(newsDaoImpl.query());
		allNews.addAll(newsTemporaryDaoImpl.query());
		int from=(pageNum-1)*pageSize;
		int to=from+pageSize;
		return allNews.subList(from,to);
	}
	public long queryAllNewsPageNum(long pageSize){
		return newsDaoImpl.queryAllNewsPageNum(pageSize);
	}
	public Map<Integer, Integer> updateClickNum(Map<Integer, Integer> map) {
		return newsDaoImpl.updateClickNum(map);
	}
	public Map<Integer, Integer> getAllNewsId() {
	   return newsDaoImpl.getAllNewsId();
	}
   
}
