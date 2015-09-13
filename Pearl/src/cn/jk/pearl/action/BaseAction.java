package cn.jk.pearl.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.jk.pearl.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller(value="baseAction")
@Scope(value="prototype")
  //这里没必要加入懒加载，因为使用多例的时候Spring默认就是懒加载，需要的时候再实例化。
@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{
	private static final long serialVersionUID = 1L;
	protected T model;
    protected Map<String,Object> requestMap;
    protected Map<String,Object> sessionMap;
    protected Map<String,Object> applicationMap;
    
	@Resource
	protected UserService userService = null;
	
    public BaseAction(){
    	try {
    		Type type=this.getClass().getGenericSuperclass();
        	ParameterizedType pt=(ParameterizedType) type;
    		Class<T> clazz=(Class<T>)pt.getActualTypeArguments()[0];
			model=(T) clazz.newInstance();
		}catch(Exception e) {
			 throw new RuntimeException(e);
        }
    }
	public T getModel() {
		return model;
	}

	public void setApplication(Map<String, Object> applicationMap) {
		this.applicationMap=applicationMap;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

	public void setRequest(Map<String, Object> requestMap) {
	   this.requestMap=requestMap;
	}

}
