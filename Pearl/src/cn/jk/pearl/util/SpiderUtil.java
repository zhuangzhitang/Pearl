package cn.jk.pearl.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;


public class SpiderUtil {
  /**
   * 基于get请求的抓取
   * @param httpClient
   * @param 链接
   * @return  获取的网页字符串
   */
   public static String getHtml(HttpClient httpClient,String url,String begin,String end){
	   HttpGet get=new HttpGet(url);
	   try {
		    HttpResponse response=httpClient.execute(get);
		    HttpEntity entity=response.getEntity();
		    if(entity!=null){
		    	String charset=EntityUtils.getContentCharSet(entity);
		    	if(charset==null){
		    		charset="GBK";
		    	}
		    	InputStream is=entity.getContent();
		    	String html=IOUtils.toString(is,charset);
		    	if(begin!=null&end!=null){
		    	  return StringUtils.substringBetween(html, begin, end);
		    	}else{
		    		return html;
		    	}
		    }
	} catch (ClientProtocolException e) {
        throw new RuntimeException(e);
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
	   return null;
   }
   @SuppressWarnings("unchecked")
   /**
    * 根据标签类型，属性名，属性值筛选复合肥标准的标签（Node）
    * @param html      抓取的页面
    * @param tagType   标签的类型
    * @param attributeName   属性名
    * @param attributeValue  属性值
    * @return
    */
   public static <T extends TagNode> List<T> parseTags(String html,final Class<T> tagType,final String attributeName,final String attributeValue){
	   Parser parser=new Parser();
	   List<T> list=new ArrayList<T>();
	    try {
		    parser.setInputHTML(html);
		    NodeList tagList=parser.parse(new NodeFilter(){
			private static final long serialVersionUID = 1L;
		    public boolean accept(Node node){
				if(node.getClass()==tagType){
					if(attributeName==null&&attributeValue==null){
						return true;
					}
					T tn=(T)node;
					String value=tn.getAttribute(attributeName);
					if(value!=null && attributeValue.equals(value)){
						return true;
					}
				}
				return false;
			}
		});
		  for(int i=0;i<tagList.size();i++){
			  T t=(T)tagList.elementAt(i);
			  list.add(t);
		  }
	} catch (ParserException e) {
		throw new RuntimeException(e);
	}
	  return list;
   }
   /**
    * 获取标签集合中的<a>标签中的路径。
    * @param nodeList Node集合
    * @param parentUrl  父路径
    * @return 路径集合
    */
    public static <T extends TagNode> List<String> getLink(List<T> nodeList,String parentUrl){
    	String htmls="";
    	for(T t:nodeList){
    		htmls=htmls+t.toHtml();
    	}
    	Parser parser=new Parser();
    	List<String> listURL=new ArrayList<String>();
    	try {
			parser.setInputHTML(htmls);
			NodeList nodes=parser.parse(new NodeClassFilter(LinkTag.class));
			for(int i=0;i<nodes.size();i++){
				 LinkTag t=(LinkTag)nodes.elementAt(i);
				 String url=parentUrl+t.getLink();
				 listURL.add(url);
			}
		} catch (ParserException e) {
			throw new RuntimeException(e);
		}
    	  return listURL;	
    }
    public static <T extends TagNode> T parseTag(String html,final Class<T> tagType,final String attributeName,final String attributeValue){
      return  SpiderUtil.parseTags(html, tagType, attributeName, attributeValue).get(0);
    }
    /**
     * 下载图片到指定的路径
     * @param httpClient
     * @param url    下载的链接
     * @param path       存放图片的路径
     * @throws ClientProtocolException
     * @throws IOException
     * return 图片新的文件名（uuid）
     */
    public static String downloadImage(HttpClient httpClient,String url,String path) throws ClientProtocolException, IOException{
    	HttpGet get=new HttpGet(url);
    	HttpResponse response=httpClient.execute(get);
    	HttpEntity entity=response.getEntity();
    	if(entity!=null){
    		InputStream in=entity.getContent();
    		String oldName=FilenameUtils.getName(url);
    		String ext=FilenameUtils.getExtension(oldName);
    		//生成新的名字
    		String newName=UUID.randomUUID().toString()+"."+ext;
    		IOUtils.write(IOUtils.toByteArray(in),new FileOutputStream(path+newName));
    		return newName;
    	}
    	return null;
    }
}
