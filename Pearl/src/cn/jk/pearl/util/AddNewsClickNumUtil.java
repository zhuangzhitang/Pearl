package cn.jk.pearl.util;

import java.util.Map;


import com.opensymphony.xwork2.ActionContext;

public class AddNewsClickNumUtil {
	/**
	 * 点击新闻后，该新闻的点击量加1
	 * @param 新闻的ID值
	 */
    @SuppressWarnings("unchecked")
	public synchronized void addClickNum(Integer newsid){
    	Map<Integer,Integer> map=(Map<Integer, Integer>) ActionContext.getContext().getApplication().get("newsClickNum");
    	Integer clickNum=map.get(newsid);
    	map.put(newsid,clickNum+1);
    }
}
