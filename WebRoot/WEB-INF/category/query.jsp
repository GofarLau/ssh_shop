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
			    singleSelect:false, //只允许选择一行
			    pagination:true,// 设置分页
			    pageSize:5,  
                //设置可选的每页记录数，供用户选择，默认是10,20,30,40...  
                pageList:[5,10,15,20],  
                idField:'id',//指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项  
                toolbar:[{
                	iconCls:'icon-add',
                	text:'添加类别',
                	handler:function(){
                		alert("add");
                	}
                },{
                	iconCls:'icon-edit',
                	text:'编辑类别',
					handler:function(){
						alert("edit");
					}                	
                },{
                	iconCls:'icon-remove',
                	text:'删除类别',
                	handler:function(){
                		//判断是否有选中行记录，使用getSelections获取选中的所有行  
                        var rows = $("#dg").datagrid("getSelections");  
                        //返回被选中的行，如果没有任何行被选中，则返回空数组  
                        if(rows.length == 0) {  
                            //弹出提示信息  
                            $.messager.show({ //语法类似于java中的静态方法，直接对象调用  
                                title:'错误提示',  
                                msg:'至少要选择一条记录',  
                                timeout:2000,  
                                showType:'slide',  
                            });  
                        }else{
                        	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
                        	    if (r){  
                        	    	//1.获得选中的id  进行拼接  将  1,2,3  传递给后台
                        	    	var ids = "";  
                                    for(var i = 0; i < rows.length; i ++) {  
                                        ids += rows[i].id + ",";  
                                    }  
                                    ids = ids.substr(0, ids.lastIndexOf(","));
                        	    } 
                        	    //2.发送ajax请求
                        	    $.post("categoryAction_deleteByIds.action",
                        	    		{ids:ids},
                        	    		function(result){
                        	    			console.log(result);
                        	    			if(result == "true"){
                        	    				//将刚刚选中的记录删除，要不然会影响后面更新的操作  
                                                $("#dg").datagrid("uncheckAll");  
                                                //刷新当前页，查询的时候我们用的是load，刷新第一页，reload是刷新当前页  
                                                $("#dg").datagrid("reload");//不带参数默认为上面的queryParams  
                        	    			}else{
                        	    				$.messager.show({
                        	    					 title:'删除异常',  
                                                     msg:'删除失败，请检查操作',  
                                                     timeout:2000,  
                                                     showType:'slide',  
                        	    				});
                        	    			}
                        	    		},
                        	    		"text");
                        	});  
                        } 
                	}
                },{
                	text:"<input id='ss' name='serach' />"
                }
         
                ],
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
			
			
			//把普通的文本框转化为查询搜索文本框  
            $('#ss').searchbox({   
                //触发查询事件  
                searcher:function(value,name){ //value表示输入的值  
                         alert(value+","+name);         //查询操作 
                         //获取当前查询的关键字，通过DataGrid加载相应的信息，使用load加载和显示第一页的所有行。  
                         //如果指定了参数，它将取代'queryParams'属性。通常可以通过传递一些参数执行一次查询，通过调用这个方法会向上面url指定的action去发送请求，从服务器加载新数据。  
                         $('#dg').datagrid('load',{  
                             type: value  
                         });  
                },   
                prompt:'请输入搜索关键字' //默认的显示  
            }); 
		});
	</script>
  </head>
  
  <body>
    <table id="dg"></table>
  </body>
</html>
