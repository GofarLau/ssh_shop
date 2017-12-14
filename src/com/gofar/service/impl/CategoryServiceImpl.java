package com.gofar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.gofar.domain.Category;
import com.gofar.service.CategoryService;
import com.gofar.utils.HibernateSessionFactory;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		
		String sql = "from Category c left join fetch c.account where c.type like :type";
		Query query = getSession().createQuery(sql);
		query.setString("type", "%"+type+"%");
		query.setFirstResult((page-1)*size);
		query.setMaxResults(size);
		List<Category> list = query.list();
		return list;
	}

}
