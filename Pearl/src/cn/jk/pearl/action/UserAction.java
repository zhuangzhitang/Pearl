package cn.jk.pearl.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jk.pearl.pojo.User;

@Controller
@Scope(value="prototype")
public class UserAction extends BaseAction<User> {
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String checkname() throws Exception{
		boolean flag=userService.isExistUsername(model.getUserName());
		String json = null;
		if(flag){
			json = "{tip:'该用户名已经被注册!'}";
		}else{
			json="{tip:'该用户可以注册'}";
		}
		inputStream = new ByteArrayInputStream(json.getBytes("UTF-8"));
		return "login";
	}
	public String checkemail() throws Exception{
		boolean flag=userService.isExistEmail(model.getUserEmail());
		String json = null;
		if(flag){
			json = "{tip:'该邮箱已经被注册!'}";
		}else{
			json="{tip:'该邮箱可以注册'}";
		}
		inputStream = new ByteArrayInputStream(json.getBytes("UTF-8"));
		return "login";
	}
}
