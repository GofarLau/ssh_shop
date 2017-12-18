<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@include  file="/public/head.jspf"%>
	 <style type="text/css">  
        form div {  
            margin:5px;  
        } 
     </style>
     
     <script type="text/javascript">
     
     $(function(){
    	 
 		//对下拉列表框 进行远程加载
    	 $('#cc').combobox({    
    		    url:'accountAction_query.action',    
    		    valueField:'id',    
    		    textField:'login', //显示给用户看下拉选项名称
    		    panelHeight:'auto', //自适应高度
			    panelWidth:120,//下拉列表是两个组件组成的
			    width:120, //要同时设置两个宽度才行
			    editable:false //下拉框不允许编辑
    		});  
    	 
    	 
    	 //获得表格对象
    	 var dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg")
    	 
    	 //获得选中的  需要更新的那一行
    	 var rows = dg.datagrid("getSelections");
    	 //将拿到的那一行  把相应的数据加载到表格中  实现数据的回显
    	 	$("#ff").form('load',{
				id:rows[0].id,
				type:rows[0].type,
				hot:rows[0].hot,
				'account.id':rows[0].account.id //EasyUI不支持account.id这种点操作，所以要加个引号
			});
    	 
    	 
    	 //用户名为空时候  提示为'请输入类别名称'
    	 $('#name').validatebox({    
    		    required: true,    
    		    missingMessage:'请输入类别名称'
    		});


    	//窗体弹出默认时禁用验证
			$("#ff").form("disableValidation");
    	
    	//注册button 事件
    		$("#btn").click(function(){
				//开启验证         !!!开启验证并没有用
				$("#ff").form("enableValidation");
				
				//判断  如果验证成功  则提交数据
				if($("#ff").form("validate")){
					
					$("#ff").form("submit",{
						url: 'categoryAction_update.action',
						success: function(data){
							//如果成功了 关闭当前窗口
							parent.$("#win").window("close");
							alert("成功更新")
							//刷新页面
							dg.datagrid("reload");
						}
					})
					
				}
    		});

     });

     
	</script>
  </head>
  
	<body>
		<form id="ff" method="post">
			<div>
			<label for="name">商品名称：</label><input type="text"  id="name"  name="type">
			</div>
			<div>
				<label>所属管理员：</label><input id="cc" name="account.id">
			</div>
			<div>
				<label for="hot">热点:</label>
				是<input type="radio" name="hot" value="true">
				否<input type="radio" name="hot" value="true">
			</div>
			<div>
				<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-update'">更新</a>
				<input type="hidden" name="id" />
			</div>
		</form>
	</body>
</html>
