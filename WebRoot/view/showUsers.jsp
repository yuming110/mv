<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List<Object[]> list =(List<Object[]>)request.getAttribute("useLise");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<h3>用户列表</h3>
  	<table border="1" width="100%" bordercolor="blue" cellpadding="0">
  	
  		<tr> 
  			<td>编号</td>
  			<td>用户名</td>
  			<td>邮箱号</td>
  			<td>性别</td>
  			<td>爱好</td>
  			<td>学历</td>
  			<td>个人简介</td>
  			<td>操作</td>
  			
  		</tr>
  		
  		<c:forEach items="${userList}" var="u">
  			<tr >
  				<td>${u.uid} </td>
  				<td>${u.userName} </td>
  				<td>${u.sex} </td>
  				<td>${u.email} </td>
  				<td>${u.education} </td>
  				<td>${u.hobby} </td>
  				<td>${u.introduction} </td>
  				<td><a href="query.do?methodName=query&uid=${u.uid}">查看</a><a href="delete.do?methodName=delete&uid=${u.uid}">删除</a></td>
  			</tr>
  			
  		
  		</c:forEach>
  		
  	 </table>
  </body>
</html>
