package com.gofar.web.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gofar.domain.Category;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{

	public String queryJoinAccount() throws Exception {
		System.out.println("进来了");
		//用来储存分页的数据
		pageMap = new HashMap<String, Object>();
		
		String type = model.getType();
		if(type == null){
			type="";
		}
		//根据关键词获得中总记录数
		Long total = categoryService.getCount(type);
		//将总记录数 传到map里去
		pageMap.put("total", total);
		
		//获得分页数据
		List<Category> list = categoryService.queryJoinAccount(type, page, rows);
		//将分页的数据传到map内去
		pageMap.put("rows", list);

		System.out.println(pageMap);
		return "jsonMap";
	}
}
