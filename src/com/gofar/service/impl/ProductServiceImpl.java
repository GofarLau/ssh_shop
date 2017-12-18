package com.gofar.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.gofar.domain.Product;
import com.gofar.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "from Product p left join fetch p.category where p.name like :name";  
        return getSession().createQuery(hql)  
                .setString("name", "%" + name + "%")  
                .setFirstResult((page-1) * size) //从第几个开始显示  
                .setMaxResults(size) //显示几个  
                .list();  
		/*String sql = "select * from product p left join p.category where p.name like ? ";
		List<Product> list = getSession().createSQLQuery(sql).setString(0, "%"+name+"%").list();
		return list;*/
	}

	@Override
	public Long getCount(String name) {
		String hql = "select count(p) from Product p where p.name like :name";  
        return (Long) getSession().createQuery(hql)  
            .setString("name", "%" + name + "%")  
            .uniqueResult();
		/*String sql = "select count(*) from product p where p.name like ? ";
		return (Long) getSession().createSQLQuery(sql).setString(0, "%"+name+"%").uniqueResult();*/
		
	}

	@Override
	public void deleteByIds(String ids) {
		String hql = "delete from Product p where p.id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
	}
	
	
}
