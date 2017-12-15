<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@include  file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({    
			    url:'datagrid_data1.json',  
			    loadMsg: 'loading....',
			    queryParams: {
			    			type:'' //请求远程数据时发生的额外的参数
			    	},
			    fitColumns:true,//水平自动展开,设置该属性的时候不会有滚动条
			    striped:true,//设置是否有斑马线效果
			    nowrap:true,//当数据多的时候 不换行
			    singleSelect:true, //只允许选择一行
			    pagination:true,// 设置分页
			    rowStyler: function(index,row){  
                    console.info("index" + index + "," + row)  
                    if(index % 2 == 0) {  
                        return 'background-color:#fff;';  
                    } else {  
                        return 'background-color:#ff0;';  
                    }  
                      
                },  
                frozenColumns:[[  //同列属性  但是这些列会被冻结在左侧
                    {field:'checkbox',checkbox:true},  
                    {field:'productid',title:'编号',width:200}                   
                ]],  
                //配置datagrid的列字段
                //field 列字段的名称  与 json的key 绑定
                //title 列标题 显示给人看的
			    columns:[[    
			        {field:'productname',title:'类别名称',width:100,
			        	//用来格式化当前列的值 返回的是最终数据
			        	formatter:function(value,row,index){
			        		 return "<span title=" +　value + ">" + value + "</span>";  
			        	}
			        },
			        {field:'listprice',title:'价格',width:100,
			        	styler:function(value,row,index){
			        		if(value<20){
			        			return 'color:red;';
			        		}
			        	}
			        }
			    ]]    
			});  
		});
	</script>
  </head>
  
  <body>
    <table id="dg"></table>
  </body>
</html>
