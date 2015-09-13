package cn.jk.pearl.util;

import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sendMessageUtil")
public class SendMessageUtil {
	@Value("#{public.url}")
	private String url;
	@Value("#{public.username}")
	private String username;
	@Value("#{public.key}")
	private String key;
    public int sendMessage(String mobilePhone,String text) {
    	HttpClient httpClient=HttpClientFactory.getHttpclient();
        HttpPost httpPost = new HttpPost(url);
    	  //设置Post请求参数NameValuePair
    	   List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    	   nvps.add(new BasicNameValuePair("Uid",username));
    	   nvps.add(new BasicNameValuePair("Key", key)); 
    	   nvps.add(new BasicNameValuePair("smsMob",mobilePhone));
    	   nvps.add(new BasicNameValuePair("smsText",text)); 
    	  //把请求参数按指定编码设置到httppost中，设置httppost请求头内容，可解决中文乱码问题.
    	   String charSet="UTF-8";
    	   try {
			   httpPost.setEntity(new UrlEncodedFormEntity(nvps, charSet));
			   // 解决中文乱码问题
	    	   httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
	    	   httpPost.addHeader("Accept-Language", "zh-cn");
	    	   httpPost.addHeader("Accept-Encoding", "gzip, deflate");
	    	  //执行post请求
	    	     HttpResponse res=httpClient.execute(httpPost);
	    	     HttpEntity responseEntity = res.getEntity();
	    	     int i=Integer.parseInt(getResponseContent(responseEntity));
	    	    System.out.println("+"+i);
	    	    return i;
		     } catch (Exception e) {
				 throw new RuntimeException(e);
		     } 
     }
    public String getResponseContent(HttpEntity responseEntity)
    		throws Exception {
    		byte[] bytes = EntityUtils.toByteArray(responseEntity);
    	    String sCharSet="utf-8";       //这里可以定义你指定的编码，中文网站编码一般为GB2312
    		return new String(bytes, sCharSet);
   }
}
