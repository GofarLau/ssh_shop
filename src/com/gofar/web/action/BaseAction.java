package com.gofar.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware,ModelDriven<T> {

	
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
		ParameterizedType type = (ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}

	
	
}
