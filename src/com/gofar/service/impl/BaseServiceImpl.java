package com.gofar.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gofar.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private SessionFactory sf;
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	private Class clazz;//储存当前操作的类型  即泛型
	
	public BaseServiceImpl() {
		//下面三个方法给自己看的
		
		System.out.println("this 当前调用构造方法的对象 "+this);
		System.out.println("获得this对象的父类信息"+this.getClass().getSuperclass());
		System.out.println("获得this对象的父类信息 包括泛型信息"+this.getClass().getGenericSuperclass());
		
		
		//拿到泛型的参数
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	
	protected Session getSession(){
		return sf.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void delete(Serializable id) {
		
		T t = findById(id);
		getSession().delete(t);
		
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public T findById(Serializable id) {
		System.out.println(clazz.getSimpleName());
		return (T) getSession().get(clazz, id);
		
	}

	@Override
	public List<T> findAll() {
		String hql = "from "+clazz.getSimpleName();
		Query query = getSession().createQuery(hql);
		return query.list();
		 
	}

}
