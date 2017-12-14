<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include  file="/public/head.jspf"%>
   <script type="text/javascript">
   		
   </script>
   
   <style type="text/css">
   		#menu {
   			width: 200px;
   			
   		}
   		#menu ul {
   			list-style: none;
   			padding: 0px;
   			margin: 0px;
   		}
   		
   		#menu ul li {
   			border-bottom: 1px solid #fff;
   		}
   		
   		#meun ul li a {
   			/* 先将a元素设置为快元素 才能设置宽高 */
   			display: block;
   			background-color: #00a6ac;
   			color: #fff;
   			padding: 5px;
   			text-decoration: none;
   		}
   		a:HOVER {
			background-color: #008792
		}
   </style>
  </head>
  <body>
	<div id="menu">
		<ul>
			<li><a href="">类别管理</a></li>
			<li><a href="">商品管理</a></li>
		</ul>
	</div>
  </body>
</html>
