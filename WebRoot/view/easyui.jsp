<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'easyui.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>

  </head>
  
   <body class="easyui-layout">   
      <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
      <div data-options="region:'west',title:'West',split:true" style="width:100px;">
          <div id="aa" class="easyui-accordion" style="width:300px;" data-options="fit:true">   
		      <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
		          <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
		          <p>Accordion is a part of easyui framework for jQuery</p>   
		      </div>   
		      <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
		          <ul id="tt" class="easyui-tree">   
				      <li>   
		                  <span>Sub Folder 1</span>   
		                  <ul>   
		                      <li>   
		                          <span><a href="#">File 11</a></span>   
		                      </li>   
		                      <li>   
		                          <span>File 12</span>   
		                      </li>   
		                      <li>   
		                          <span>File 13</span>   
		                      </li>   
		                  </ul>   
				     </li>   
				</ul>    
		    </div>   
		    <div title="Title3">   
		        content3    
		    </div>   
	  </div>  

   
      <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
      	  <div id="test" class="easyui-tabs" style="width:500px;"data-options="fit:true">   
		    <div title="欢迎使用！" style="padding:20px;display:none;">   
		        tab1   
		    </div>     
	    </div> 
		 
      </div>   
   </body>
</html>
