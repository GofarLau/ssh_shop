package com.gofar.web.action;


public class CategoryAction extends BaseAction{


	public String test(){
		request.put("yi", "一");
		session.put("er", "二");
		application.put("san", "三");
		return "test";
	}
	
	
}
