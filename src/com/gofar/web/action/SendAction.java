package com.gofar.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("sendAction")
public class SendAction extends ActionSupport {
	
	public String execute() throws Exception {
		
		return "send";
	}
}
