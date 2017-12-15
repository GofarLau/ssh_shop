<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@include  file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({    
			    url:'categoryAction_queryJoinAccount.action',  
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
                    {field:'id',title:'编号',width:200}                   
                ]],  
                //配置datagrid的列字段
                //field 列字段的名称  与 json的key 绑定
                //title 列标题 显示给人看的
			    columns:[[    
			        {field:'type',title:'类别名称',width:100,
			        	//用来格式化当前列的值 返回的是最终数据
			        	formatter:function(value,row,index){
			        		 return "<span title=" +　value + ">" + value + "</span>";  
			        	}
			        },
			        {field:'hot',title:'热卖',width:100,
			        	formatter:function(value,row,index){
			        		if(value==1){
			        			return "<input type='checkbox' checked='checked' disabled='true'";
			        		}else{
			        			return "<input type='checkbox' disabled='true'";
			        		}
			        	}
			        },{field:'account.login',title:'所属管理员',width:200,
			        	formatter: function(value,row,index){  
                            if(row.account != null && row.account.login != null) {  
                                return row.account.login; //如果登录名不为空，显示登录名  
                            } else {  
                                return "此类别没有管理员";  
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
