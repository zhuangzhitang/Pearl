package cn.jk.pearl.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.jk.pearl.util.DrawImage;
@Controller
public class CheckCodeAction {
	/**
	 * 验证码
	 */
	@Resource
	DrawImage drawImage = null;
	public void checkcode() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String random = drawImage.getRandcode(request, response);	
	}
}
