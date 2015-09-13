package cn.jk.pearl.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.jk.pearl.util.CheckDataTimeTask;
import cn.jk.pearl.util.ShowTimeTask;

public class ClickNumListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("应用销毁");
	}

	public void contextInitialized(ServletContextEvent event) {
		//启动定时器，并且允许该定时器可以加载一个守护线程
		Timer timer=new Timer(true);
	    ApplicationContext ac=(ApplicationContext)WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	    ShowTimeTask task=(ShowTimeTask)ac.getBean("showTimeTask");
	    task.setApplication(event.getServletContext());
	    timer.schedule(task, 0, 1000*60*60*24);
	    
	    Timer timer1=new Timer(true);
	    CheckDataTimeTask checkTask=(CheckDataTimeTask)ac.getBean("checkDataTimeTask");
	    checkTask.setServletContext(event.getServletContext());
	    timer1.schedule(checkTask,0,1000*60*60);
	    
	}

}
