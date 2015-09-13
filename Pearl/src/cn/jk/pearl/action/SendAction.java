package cn.jk.pearl.action;

import org.springframework.stereotype.Controller;

@Controller("sendAction")
public class SendAction {
	public String execute(){
		System.out.println("----execute()----");
		return "send";
	}
}
