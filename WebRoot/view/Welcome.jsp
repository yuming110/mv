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
    
    <title>My JSP 'easyui2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function add(title,url){
			$('#s').tabs('add',{
				title: title,
				selected: true,
				closable: true,
				content : "<iframe width='100%' height='100%'  frameborder='0' scrolling='auto' src='"+url+"'></iframe>"
			});
			
		}
	</script>
	<style type="text/css">
		h1{
			font-size: 100px;
			text-align:center;	
			padding-top: 100px;
		}
	</style>

  </head>
  
  <body class="easyui-layout">
      <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
      	  <div id="up">
		      <p>欢迎,${loginUser.userName}</p>
		  </div>
      </div>   
      <div data-options="region:'west',title:'菜单',split:true" style="width:300px;">
      	 
      	  <%--<div id="aa" class="easyui-accordion" style="width:300px;" data-options="fit:true">   
		      <div title="菜单一" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
		          <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
		          <p>Accordion is a part of easyui framework for jQuery</p>   
		      </div> 
		      <div title="菜单二" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
		          
		             
		       </div>   
		      <div title="菜单三">   
		          content3    
		      </div>  
		  </div> --%>
		  <ul id="tt" class="easyui-tree">   
					   <c:forEach items="${menuList}" var="m2">
		  				<c:if test="${m2.level==2}">
		  					<li>
		  						<span>${m2.name}</span>
		  						<ul>
		  							<c:forEach items="${menuList}" var="m3">
		  								<c:if test="${m3.parentid==m2.mid}">
		  									<li><a href="javascript:void(0);" onclick="add('${m3.name}','${m3.url}');" >${m3.name}</a></li>
		  								</c:if>
		  							</c:forEach>
		  						</ul>
		  					</li>
		  				</c:if>
		  			</c:forEach>   
				</ul>
      </div>   
      <div data-options="region:'center'" style="padding:5px;background:#eee;">
      	  <div id="s" class="easyui-tabs" style="width:500px;" data-options="fit:true" >   
		      <div title="欢迎访问" style="padding:20px;" >   
		        	<h1>欢迎访问!</h1>      
		      </div>   
		  </div> 
      </div>   
  </body>
</html>
