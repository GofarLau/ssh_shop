package com.gofar.web.action;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.Date;
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
	
	
	public String deleteByIds(){
		
		productService.deleteByIds(ids);
		
		inputStream = new ByteArrayInputStream("true".getBytes());
		
		return "stream";
	}
	
	public void save(){
		
		String pic = fileUpload.uploadFile(fileImage);
		//获得文件名  并设置产品的文件名

		// 设置时间
		model.setDate(new Timestamp(new Date().getTime()));
		productService.save(model);
		
	}
	public void update(){
		
		//获得文件名 并设置产品的文件名
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		
		model.setDate(new Timestamp(new Date().getTime()));
		productService.save(model);
		
	}
}


















