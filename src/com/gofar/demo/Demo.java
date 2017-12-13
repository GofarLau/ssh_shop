package com.gofar.demo;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gofar.domain.Category;
import com.gofar.service.CategoryService;
import com.gofar.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	
/*	@Test
	public void func1(){
		
		CategoryService cs = new CategoryServiceImpl();
		Category c = new Category();
		c.setType("洗洁");
		c.setHot(true);
		cs.save(c);
	}*/
	
	@Resource(name="categoryService")
	private CategoryService cs ;

	@Test
	public void fun2(){
		
		Category c = new Category();
		c.setType("厨房用品");
		c.setHot(true);
		cs.update(c);
	}
	
}
