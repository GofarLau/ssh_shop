package com.gofar.service;

import java.io.Serializable;
import java.util.List;


public interface BaseService<T> {
	//增加
	public void save(T t);
	//删除
	public void delete(Serializable id);
	//修改
	public void update(T t);
	//根据id查找
	public T findById(Serializable id);
	//查找所有
	public List<T> findAll();
}	
