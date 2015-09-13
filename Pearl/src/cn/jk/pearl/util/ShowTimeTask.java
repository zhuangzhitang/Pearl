package cn.jk.pearl.util;

import java.util.Map;
import java.util.TimerTask;

import javax.servlet.ServletContext;


import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.jk.pearl.dao.ExpertApplicationDao;
import cn.jk.pearl.service.NewsService;

@Component("showTimeTask")
public class ShowTimeTask extends TimerTask{
    
	private NewsService newsService;
	private ExpertApplicationDao expertDao;
	private ServletContext application;
	public ServletContext getApplication() {
		return application;
	}
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	@SuppressWarnings("unchecked")
	public void run() {
		ApplicationContext ac=(ApplicationContext)WebApplicationContextUtils.getWebApplicationContext(application);
	    Map<Integer,Integer> map=(Map<Integer, Integer>) application.getAttribute("newsClickNum");
	    newsService=(NewsService) ac.getBean("newsService");
	    expertDao=(ExpertApplicationDao)ac.getBean("expertApplicationDao");
	    expertDao.deleteExpertApplicationTiming();
	    if(map==null){
	    	application.setAttribute("newsClickNum",newsService.getAllNewsId());
	    }else{
	    	application.setAttribute("newsClickNum",newsService.updateClickNum(map));
	    }
		
	}

}
