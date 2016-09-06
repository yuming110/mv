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
  	<h3>学生列表</h3>
  	<table border="1" width="100%" bordercolor="blue" cellpadding="0">
  		<tr> 
  			<td>编号</td>
  			<td>姓名</td>
  			<td>年龄</td>
  			<td>性别</td>
  			<td>班级</td>
  			<td>时间</td>
  			
  		</tr>
  		
  		<c:forEach items="${studentList}" var="u">
  			<tr>
  				<td>${u.sid} </td>
  				<td>${u.name} </td>
  				<td>${u.age} </td>
  				
  				
  				<td>
  					<c:if test="${u.sex==1}">男</c:if>
  					<c:if test="${u.sex==2}">女</c:if>
  				</td>
  				<td>
  					<c:if test="${u.cid==1}">一班</c:if>
  					<c:if test="${u.cid==2}">二班</c:if>
  					<c:if test="${u.cid==3}">三班</c:if>
  				
  				</td>
  				<td>${u.times}</td>
  				
  			</tr>
  			
  		
  		</c:forEach>
  		
  		
  		
  		
  				
  		
  	 </table>
  </body>
</html>
