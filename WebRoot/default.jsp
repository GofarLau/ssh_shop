<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>easyUI学习</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.2.6/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.2.6/themes/icon.css" />
    <script type="text/javascript">
          $(function(){
              //画面加载完成之后就调用layout()方法将body变成easy的layout
              $('#easyUILayoutBody').layout();   
          });
      </script>
  </head>
  <!--给body指定class属性指定easy的easyui-layout样式，这样就可以 使用body创建easyui的layout -->
  <body id="easyUILayoutBody">  
    <div data-options="region:'north',title:'North Title'" style="height:100px"></div>
    <!-- 布局中如果不需要west这个面板，那么可以删掉这个div -->  
    <div data-options="region:'west',title:'West'" style="width:100px;"></div>
    <div data-options="region:'center',title:'center'"></div>  
  </body>  
</html>
