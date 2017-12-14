package com.gofar.service;

import java.util.List;

import com.gofar.domain.Category;

public interface CategoryService extends BaseService<Category>{
	
	public List<Category> queryJoinAccount(String type,int page,int size);
}
