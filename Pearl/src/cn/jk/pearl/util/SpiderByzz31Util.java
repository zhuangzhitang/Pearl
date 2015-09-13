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
import org.htmlparser.tags.Span;
import org.htmlparser.util.ParserException;
import cn.jk.pearl.pojo.NewsCategory;
import cn.jk.pearl.pojo.NewsTemporary;
/**
 * 
 * @author zaopeng
 * 该工具类是针对于http://www.zz31.com新闻的抓取
 *
 */
public class SpiderByzz31Util {
   /**
     * 抓取某一类新闻的所有链接
     * @param url 链接
     * @param type 新闻的类别
     * @return 该类别新闻的所有的链接的集合
     */
	private static Map<String,Integer> getNewsLink(String url,Integer type){
    	Map<String,Integer> map=new HashMap<String,Integer>();
    	String html=SpiderUtil.getHtml(HttpClientFactory.getHttpclient(),url,null,null);
    	List<String> listString=SpiderUtil.getLink(SpiderUtil.parseTags(html,Span.class,"class","newlist"),"http://www.zz31.com");
    	for(String link:listString){
    		map.put(link,type);
    	}
    	return map;
    }
	/**
	 * 抓取链接中新闻的全部内容，包括标题 来源 作者 内容
	 * @param url 链接
	 * @return    新闻的全部内容
	 */
	 private static String getAllContent(String url){
			String html=SpiderUtil.getHtml(HttpClientFactory.getHttpclient(),url,"<!--主要内容-->","编辑推荐</div>");
			return html;
    }
   /**
     * div class="browtitle"
     * 抓取新闻的标题
     * @param html 抓取到的新闻的全部内容
     * @return     返回新闻标题
     */
	 private static String getTitle(String html){
	    	return SpiderUtil.parseTag(html,Div.class,"class","browtitle").toPlainTextString();
	    }
	/**
     * <div class="browtime"> 2014/8/27&nbsp;&nbsp;&nbsp;&nbsp;信息来源： 国际珍珠网  &nbsp;
     *                        &nbsp;&nbsp;&nbsp;作者：佚名&nbsp;&nbsp;&nbsp;&nbsp;点击：360
     * 抓取新闻的来源和作者
     * @param html 抓取到的新闻全部内容
     * @return     新闻来源和作者的集合
     */
	 private static Map<String,String> getNewFromAndAuthor(String html){
	    	Map<String,String> map=new HashMap<String, String>();
	    	String text=SpiderUtil.parseTag(html,Div.class,"class","browtime").toPlainTextString();
	    	String otherText=text.substring(text.indexOf("源"));
	    	String from=otherText.substring(3,text.indexOf("n")-1);
	    	String anothorText=text.substring(text.indexOf("作"));
	    	String author=anothorText.substring(anothorText.indexOf("者")+2,anothorText.indexOf("n")-1);
	    	map.put(from,author);
	    	return map;
	    }
   /**
     * <div class="brownr1">
     * 获取新闻的主要内容。
     * @param html 抓取到的内容
     * @return    新闻的主要内容
     * @throws ParserException 
     * @throws IOException 
     * @throws ClientProtocolException 
     */
	 private static String getNewsContent(String html) throws ParserException, ClientProtocolException, IOException{
	    	String contentHtml=SpiderUtil.parseTag(html,Div.class,"class","brownr1").toHtml();
	    	return contentHtml;
	    }
   /**
     * 抓取所有的各个类别的新闻的所有内容
     * @return 返回key是新闻的全部内容，value是新闻类别的map集合
     */
	 private static Map<String,Integer> getAllTypeNewsContent(){
	    	Map<String,Integer> linkMap=new HashMap<String,Integer>();
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/T0/list.html",1));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/t0/list_p2.html",1));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/t0/list_p3.html",1));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/t0/list_p4.html",1));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/T4799/list.html",1));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/t4799/list_p2.html",1));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/T4985/list.html",3));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/t4985/list_p2.html",3));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/T5503/list.html",3));
	    	linkMap.putAll(SpiderByzz31Util.getNewsLink("http://www.zz31.com/news/t4985/list_p3.html",3));
	    	Map<String,Integer> contentMap=new HashMap<String,Integer>();
	        for(Entry<String,Integer> set:linkMap.entrySet()){
	        	contentMap.put(SpiderByzz31Util.getAllContent(set.getKey()),set.getValue());
	        }
	        HttpClientFactory.closeHttpClient();
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
		 for(Entry<String,Integer> set:SpiderByzz31Util.getAllTypeNewsContent().entrySet()){
			 String html=set.getKey();
			 String title=SpiderByzz31Util.getTitle(html);
			 String from="";
			 String author="";
			for(Entry<String, String> fromAuthor:SpiderByzz31Util.getNewFromAndAuthor(html).entrySet()){
				from=fromAuthor.getKey();
				author=fromAuthor.getValue();
			}
			String content=SpiderByzz31Util.getNewsContent(html);
			NewsCategory category=new NewsCategory();
			category.setNewsCategoryId(set.getValue());
			NewsTemporary news=new NewsTemporary(title, from, author, content,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()) ,category);
			list.add(news);
		 }
		 return list;
	 }
}
