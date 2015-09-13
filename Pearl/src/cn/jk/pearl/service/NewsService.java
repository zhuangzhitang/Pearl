package cn.jk.pearl.service;

import java.util.List;
import java.util.Map;

import cn.jk.pearl.pojo.News;
import cn.jk.pearl.pojo.NewsTemporary;

public interface NewsService {
    public List<News> getNewsTitleByType(int i,int pageSize,int pageNum);
    public News getNewsContent(int id);
    public void deleteUpdateNews();
    public void NotDeleteUpdateNews();
    public void releaseNews(int[] id);
    public void deleteNews(int[] id);
    public void updateReleasedNews(News news);
    public void updateUnReleasedNews(NewsTemporary news);
    public NewsTemporary getNewsTemporaryContent(int id);
    @SuppressWarnings("rawtypes")
	public List queryAllNews(int pageSize,int pageNum);
    public Map<Integer, Integer> updateClickNum(Map<Integer,Integer> map);
    public Map<Integer,Integer> getAllNewsId();
    public long queryAllNewsPageNum(long pageSize);
    public long getNewsPageNumByType(int i,long pageSize);
}
