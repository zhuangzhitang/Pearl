package cn.jk.pearl.dao;

import java.util.List;
import java.util.Map;

import cn.jk.pearl.pojo.News;
/**
 * 
 * @author zaopeng
 *
 */
public interface NewsDao extends BaseDao<News>{
    public List<News> queryNewsTitlezByType(int newsTypeId,int pageSize,int pageNum);
    public void deleteALLNew();
    /**
     * 更新各个新闻的点击数
     * @param map 一个存放各个新闻点击量的集合 key是新闻的ID值，value是该新闻一段时间内的点击数。
     * return    返回一个集合,key为各个新闻的ID值，value为点击量，都是0.
     */
    public Map<Integer,Integer> updateClickNum(Map<Integer,Integer> map);
    /**
     * 获取新闻表里面所有新闻的ID值
     * @return key为新闻的ID值，value为新闻的点击数 置0的集合
     */
    public Map<Integer,Integer> getAllNewsId();
    public long getNewsPageNumByType(int i,long pageSize);
    public long queryAllNewsPageNum(long pageSize);
}
