package cn.jk.pearl.util;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.HeadingTag;
import org.htmlparser.tags.ParagraphTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.util.ParserException;

import cn.jk.pearl.pojo.NewsCategory;
import cn.jk.pearl.pojo.NewsTemporary;
/**
 * 
 * @author zaopeng
 * 该工具类是针对于http://zz.6b2.com新闻的抓包
 *
 */
public class SpiderByzz6b2Util {
	/**
	 * 抓取链接中新闻的全部内容，包括标题 来源 作者 内容
	 * @param url 链接
	 * @return    新闻的全部内容
	 */
    private static String getAllContent(String url){
		String html=SpiderUtil.getHtml(HttpClientFactory.getHttpclient(),url,"中国珍珠网首页</font>","·上一篇文章：");
		return html;
	}
    /**
     * 抓取某一类新闻的所有链接
     * @param url 链接
     * @param type 新闻的类别
     * @return 该类别新闻的所有的链接
     */
    private static Map<String,Integer> getNewsLink(String url,Integer type){
    	Map<String,Integer> map=new HashMap<String,Integer>();
    	String html=SpiderUtil.getHtml(HttpClientFactory.getHttpclient(),url,null,null);
    	List<String> listString=SpiderUtil.getLink(SpiderUtil.parseTags(html,ParagraphTag.class,"align","left"),"http://zz.6b2.com");
    	for(String link:listString){
    		map.put(link,type);
    	}
    	return map;
    }
   /**
     * <h1 align="center">
     * 抓取新闻的标题
     * @param html 抓取到的新闻的全部内容
     * @return     返回新闻标题
     */
    private static String getTitle(String html){
    	return SpiderUtil.parseTag(html, HeadingTag.class,"align","center").toPlainTextString();
    }
    /**
     * <TD class=titleNewsRemark 来源：中国珍珠网　文章作者：佚名　点击数：
     * 抓取新闻的来源和作者
     * @param html 抓取到的新闻全部内容
     * @return     新闻来源和作者的集合
     */
    private static Map<String,String> getNewFromAndAuthor(String html){
    	Map<String,String> map=new HashMap<String, String>();
    	String text=SpiderUtil.parseTag(html,TableColumn.class,"class","titleNewsRemark").toPlainTextString();
    	String from=text.substring(3,text.indexOf("文")-1);
    	String author=text.substring(text.indexOf("者")+2,text.indexOf("点")-1);
    	map.put(from,author);
    	return map;
    }
    /**
     * <DIV style="LINE-HEIGHT: 200%">
     * 获取新闻的主要内容。
     * @param html 抓取到的内容
     * @return    新闻的主要内容
     * @throws ParserException 
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    private static String getNewsContent(String html) throws ParserException, ClientProtocolException, IOException{
    	String contentHtml=SpiderUtil.parseTag(html,Div.class,"style","LINE-HEIGHT: 200%").toHtml();
    	return contentHtml;
    }
    /**
     * 抓取所有的各个类别的新闻的所有内容
     * @return 返回key是新闻的全部内容，value是新闻的类别的map集合
     */
    private static Map<String,Integer> getAllTypeNewsContent(){
    	Map<String,Integer> linkMap=new HashMap<String,Integer>();
    	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/yangzhi/",2));
    	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/zisi/",4));
     	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/zisi/index_2.htm",4));
     	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/story/",5));
     	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/lishi/",6));
     	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/zzbj/",7));
     	linkMap.putAll(SpiderByzz6b2Util.getNewsLink("http://zz.6b2.com/news/zzmr/",8));
    	Map<String,Integer> contentMap=new HashMap<String, Integer>();
        for(Entry<String,Integer> set:linkMap.entrySet()){
        	contentMap.put(SpiderByzz6b2Util.getAllContent(set.getKey()),set.getValue());
        }
    	return contentMap;
    }
    /**
	   * 
	   * @return  返回抓取到的新闻对象的集合
	   * @throws ParserException
	   * @throws ClientProtocolException
	   * @throws IOException
	   */
	  public static List<NewsTemporary> getListNews() throws ParserException, ClientProtocolException, IOException{
		 List<NewsTemporary> list=new ArrayList<NewsTemporary>();
		 for(Entry<String,Integer> set:SpiderByzz6b2Util.getAllTypeNewsContent().entrySet()){
			 String html=set.getKey();
			 String title=SpiderByzz6b2Util.getTitle(html);
			 String from="";
			 String author="";
			for(Entry<String, String> fromAuthor:SpiderByzz6b2Util.getNewFromAndAuthor(html).entrySet()){
				from=fromAuthor.getKey();
				author=fromAuthor.getValue();
			}
			String content=SpiderByzz6b2Util.getNewsContent(html);
			NewsCategory category=new NewsCategory();
			category.setNewsCategoryId(set.getValue());
			NewsTemporary news=new NewsTemporary(title, from, author, content,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()) ,category);
			list.add(news);
		 }
		 return list;
	 }
}
