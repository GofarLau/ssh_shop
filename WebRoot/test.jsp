<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@include  file="/public/head.jspf"%>
	<script type="text/javascript">
	
	$('#cc').combobox({    
	    url:'combobox_data.json',    
	    valueField:'id',    
	    textField:'text'   
	});  
	</script>
	
  </head>
  
  <body>
	<input id="cc" name="dept" value="aa"> 
  </body>
</html>
