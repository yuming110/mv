<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  	<form action="addStudent" method="post">
  		<table>
  			<tr>
  				<td><label>学号：</label></td>
  				<td><input type="text" name="sid"/></td>
  			</tr>
  			<tr>
  				<td><label>姓名：</label></td>
  				<td><input type="text" name="name"/></td>
  			</tr>
  			<tr>
  				<td><label>年龄：</label></td>
  				<td><input type="text" name="age"/></td>
  			</tr>
  			<tr>
          	  <td><label>性别：</label></td>
              <td>
              	<input type="radio" name="sex" value="1"/>男
              	<input type="radio" name="sex" value="2"/>女
              </td>
             </tr> 
             <tr>
  				<td><label>班级：</label></td>
  				<td><input type="text" name="cid"/></td>
  			 </tr>
             <tr>
  				<td><label>时间：</label></td>
  				<td><input type="text" name="times"/></td>
  			 </tr> 
         
          <tr>
          	  <td colspan="2" style="text-align: center;">
          	  <p>{studentError}</p>
          	  	  <input type="submit" value="添加"/> 
          	  	  
          	  
          	  </td>
          </tr>
  		</table>
  	</form>
       
  </body>
</html>
