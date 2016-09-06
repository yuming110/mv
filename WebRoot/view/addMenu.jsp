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
    
    <title>My JSP 'addMenu.jsp' starting page</title>
    
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
  	<h2>添加菜单</h2>
  	<form action="addMenu.do?methodName=addMenu" method="post">
  		<table>
			<tr>
				<td><label>菜单名称</label></td>  
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td><label>连接地址</label></td>  
				<td><input type="text" name="url"/></td>
			</tr>
			<tr>
				<td><label>是否展示</label></td>  
				<td>
					<input type="radio" name="isshow" value="1"/>展示
					<input type="radio" name="isshow" value="0"/>不展示
				</td>
			</tr>
			<tr>
				<td><label>上级菜单</label></td>  
				<td>
					<select name="parentid" id="parentid">
						 <c:forEach items="${menu12List}" var="m">
  	              	  	  	  <option value="${m.mid }">
  	              	  	  	  	  <c:if test="${m.level==1}">一级-${m.name}</c:if>
  	              	  	  	  	  <c:if test="${m.level==2}">二级-${m.name}</c:if>
  	              	  	  	  	   <c:if test="${m.level==3}">三级-${m.name}</c:if>
  	              	  	  	  </option>
  	              	  	  </c:forEach>
					</select>
				</td>
			</tr>
			 <tr>
  	              <td >
  	              	  <input type="submit" value="提交" />
  	              </td>
  		      </tr>		
  		</table>
  	</form>
  </body>
</html>
