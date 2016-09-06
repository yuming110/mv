<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
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
  	<form action="reg.do?methodName=reg" method="post">
  		<table>
  			<tr>
  				<td><label>用户名</label></td>
  				<td><input type="text" name="userName"/></td>
  			</tr>
  			 <tr>
          	  <td><label>密码：</label></td>
              <td><input type="password" name="userPass"/></td>
          </tr>
          <tr>
          	  <td><label>邮箱：</label></td>
              <td><input type="text" name="email"/></td>
          </tr>
          <tr>
          	  <td><label>性别：</label></td>
              <td>
              	<input type="radio" name="sex" value="1"/>男
              	<input type="radio" name="sex" value="2"/>女
              </td>
          </tr>
          <tr>
          	  <td><label>兴趣爱好</label></td>
              <td>
              	<input type="checkbox" name="hobby" value="1"/>篮球
              	<input type="checkbox" name="hobby" value="2"/>上网
              	<input type="checkbox" name="hobby" value="3"/>游戏
              	<input type="checkbox" name="hobby" value="4"/>电影
              </td>
          </tr>
          
          
          <tr>
          	  <td><label>学历选择</label></td>
          	  <td>
          	  	<select name="education">
          	  	  <option value="1">学历选择</option>
          	  	  <option value="2">大学本科</option>
          	  	  <option value="3">大专毕业</option>
          	  	  <option value="4">高中毕业</option>
          	  	</select>
          	  </td>
          </tr>
          <tr>
          	<td><label>个人简介</label></td>
          	<td>
          		<textarea name="introduction" rows="5" cols="20" columns="45" ></textarea>
          	</td>
          </tr>
          <tr>
          	  <td colspan="2" style="text-align: center;">
          	  	  <input type="submit" value="注册"/> 
          	  	  <span><a href="index.jsp">登录</a></span>
          	  
          	  </td>
          </tr>
  		</table>
  	</form>
  	<script src="../assets/js/jquery-1.8.2.min.js"></script>
       
  </body>
</html>
