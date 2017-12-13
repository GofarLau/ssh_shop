package com.gofar.web.action;

import com.gofar.domain.Category;
import com.gofar.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author gofar
 *
 */
public class CategoryAction extends ActionSupport {
		
	private CategoryService cs;
	
	private Category c;
	
	
	
	public Category getC() {
		return c;
	}

	public void setC(Category c) {
		this.c = c;
	}

	public void setCs(CategoryService cs) {
		this.cs = cs;
	}

	
	public String index(){
		return "index";
	}
	
	public String update(){
		System.out.println("update");
		cs.update(c);
		System.out.println("保存成功");
		return SUCCESS;
	}
	
	
}
