package com.gofar.service;

import java.util.List;

import com.gofar.domain.Product;


public interface ProductService extends BaseService<Product> {
	
	public List<Product> queryJoinCategory(String type, int page, int size);
	public Long getCount(String type);
	public void deleteByIds(String ids);
}
