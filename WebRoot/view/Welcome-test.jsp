<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List<Object[]> list =(List<Object[]>)request.getAttribute("useLise");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#up{
			
			height:20%;
			
		}
		#left{
			width: 20%;
			height: 80%;
			float:left;
			background-color:blue;	
			
				
		}
		#right{
			width:80%;
			height: 80%;
			float:left;
			
		}
		#left a{
			text-decoration: none;
			color: white;
			font-size: 18px;
			font-family: serif;
			font-weight: bold;
			
			display: block;
			margin-top: 10px;	
	        padding-left: 10px;
			
		}
		 #lefta a:hover{
	        text-decoration:underline;
	        background-color: maroon;
	        color: #ffffff;
	    }
		
	
	</style>

  </head>	
  <body>
  	<div id="up">
  		<p>欢迎,${loginUser.userName}</p>
  	</div>
  	<div id="left">
  		<ul>
  			<c:forEach items="${menuList}" var="m2">
  				<c:if test="${m2.level==2}">
  					<li>
  						<span>${m2.name}</span>
  						<ul>
  							<c:forEach items="${menuList}" var="m3">
  								<c:if test="${m3.parentid==m2.mid}">
  									<li><a href="${m3.url}" target="center">${m3.name}</a></li>
  								</c:if>
  							</c:forEach>
  						</ul>
  					</li>
  				</c:if>
  			</c:forEach>
  		</ul>
  		
  	</div>
  	<div id="right">
  		<iframe name="center" frameborder="2" scrolling="auto" width="100%" height="100%"></iframe>
  	</div>
  </body>
</html>




<!-- <a href="showUsers.do?methodName=showUser" target="center">用户列表</a>
  		<a href="class.do?methodName=showClass" target="center">班级列表</a>
  		<a href="view/addClass.jsp" target="center">添加班级</a>
  		<a href="student.do?methodName=showStudent" target="center">学生列表</a>
  		<a href="view/addStudent.jsp" target="center">添加学生</a> -->
