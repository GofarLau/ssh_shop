package com.gofar.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Commit;

import com.gofar.service.AccountService;
import com.gofar.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware,ModelDriven<T> {
	
	
	//page 和rows 分页相关数据  page  当前页  ;rows 每页的大小 pageMap  存储 查询的数据 然后打包成json格式发送给前台
	//page 和rows  需要实现setter 和getter 方法  从前台获得数据  pageMap只需要实现getter方法  让struts 获得
	protected Integer page;
	protected Integer rows;
	protected Map<String, Object> pageMap = null;
	
	
	
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}


	@Resource(name = "categoryService")
	protected CategoryService categoryService;
		
	@Resource(name = "accountService")
	protected AccountService accountService;
	
	
	
	
	//域对象
	//通过实现 *Aware 接口  注入 相应的map
	protected Map<String, Object> application;
	protected Map<String, Object> session;
	protected Map<String, Object> request;
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	
	//modeldriven
	protected T model;
	//对象需要实例化  才能放在栈顶
	@Override
	public T getModel() {
		//通过传进来的T  new 一个instance  实例化model  
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class)type.getActualTypeArguments()[0];
		try {
			model = (T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
		
		return model;
	}

	
	
}
