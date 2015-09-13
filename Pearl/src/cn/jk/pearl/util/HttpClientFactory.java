package cn.jk.pearl.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientFactory {
    private static HttpClient httpClient=new DefaultHttpClient();
    public static HttpClient getHttpclient() {
		return httpClient;
	}
    public static void closeHttpClient(){
    	httpClient.getConnectionManager().shutdown();
    }
}
