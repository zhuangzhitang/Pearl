package cn.jk.pearl.util;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.jk.pearl.service.DataCollectionService;

@Component("checkDataTimeTask")
public class CheckDataTimeTask extends TimerTask{
    private ServletContext servletContext;
    private DataCollectionService dataService;
    public ServletContext getServletContext() {
		return servletContext;
	}
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
    public void run() {
    	ApplicationContext ac=(ApplicationContext)WebApplicationContextUtils.getWebApplicationContext(servletContext);
    	dataService=(DataCollectionService)ac.getBean("dataCollectionService");
    	dataService.checkData();
		
	}
	

}
