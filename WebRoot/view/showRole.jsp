<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showRole.jsp' starting page</title>
    
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
  			<td>角色名字</td>
  			<td>角色权限修改</td>
  		</tr>
  		
  		<c:forEach items="${roleList}" var="r">
  			<tr >
  				<td>${r.rid} </td>
  				<td>${r.rname} </td>
  				<td>
  					<a href="showRoleRid.do?rid=${r.rid}&methodName=showRoleRid">修改角色用户</a>	
	        		<a href="showMenuRid.do?rid=${r.rid}&methodName=showMenuRid">修改角色菜单</a>
	        	</td>
  			</tr>
  			
  		
  		</c:forEach>
  		
  	 </table>
  </body>
</html>
