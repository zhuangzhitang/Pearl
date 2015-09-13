package cn.jk.pearl.listener;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitDataServletContextListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event) {
		InputStream in=this.getClass().getResourceAsStream("/public.properties");
		OutputStream out=null;
		String basePath=event.getServletContext().getRealPath("/");
		try {
		   out=new FileOutputStream(this.getClass().getResource("/public.properties").getPath());
		   Properties pro=new Properties();
		   pro.load(in);
		   pro.setProperty("basePath",basePath);
		   pro.setProperty("FilePath","image");
		   pro.store(out,"我就是注释，咋的了");
		} catch (Exception e){
			throw new RuntimeException(e);
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("应用销毁");
	}
 }
