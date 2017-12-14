package com.gofar.service;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gofar.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {
	
	@Resource(name = "categoryService")
	private CategoryService categoryService;
	
	@org.junit.Test
	public void testQueryAccount(){
		for (Category c : categoryService.queryJoinAccount("",1,2)) {
			System.out.println(c);
			System.out.println(c.getAccount());
		}
		
	}
}
