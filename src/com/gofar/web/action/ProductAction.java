package com.gofar.web.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gofar.domain.Product;



@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory(){
		System.out.println("name:" + model.getName());  
        System.out.println("page：" + page);  
        System.out.println("rows：" + rows);  
          
        //用来存储分页的数据  
        pageMap = new HashMap<String, Object>(); 
        
         String name = model.getName();
        if(name == null){
			name="";
		}
        
        //根据关键字和分页的参数查询相应的数据  
        List<Product> productList = productService.queryJoinCategory(name, page, rows);  
        System.out.println(productList);
        pageMap.put("rows", productList); //存储为JSON格式  
        //根据关键字查询总记录数  
        Long total = productService.getCount(name);  
//      System.out.println(total);  
        pageMap.put("total", total); //存储为JSON格式  
        return "jsonMap";  
	}
}
