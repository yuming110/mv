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
  	<input type="hidden" name="methodName" value="showClass" />
  	<table border="1" width="100%" bordercolor="blue" cellpadding="0">
  		<tr> 
  			<td>编号</td>
  			<td>班级</td>
  			<td>时间</td>
  			
  		</tr>
  		
  		<c:forEach items="${classList}" var="u" >
  			<tr>
  				<td>${u[0]} </td>
  				<td>${u[1]} </td>
  				<td>${u[2]} </td>
  				
  			</tr>
  			
  		
  		</c:forEach>
  		
  	
  	 </table>
  	 </form>
  </body>
</html>
