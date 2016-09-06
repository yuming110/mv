<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="addClass.do" method="post">
  		<input type="hidden" name="methodName" value="addClass" />
  		<table>
  			<tr>
  				<td><label>添加班级</label></td>
  				<td><input type="text" name="name"/></td>
  			</tr>
  			<tr>
  				<td><label>添加时间</label></td>
  				<td><input type="text" name="times" <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>/></td>
  			</tr>
          <tr>
          	  <td colspan="2" style="text-align: center;">
          	  <p>{classError}</p>
          	  	  <input type="submit" value="添加"/> 
          	  	  
          	  
          	  </td>
          </tr>
  		</table>
  	</form>
       
  </body>
</html>
