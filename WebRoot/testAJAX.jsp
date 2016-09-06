<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testAJAX.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		$(function(){
			$(".bt").click(function(){
				/*$.ajax({
					type : 'post',
					url : 'testAJAX.do',
					data :　{methodName:'testAJAX'},
					
					success : function(data){
						alert(data);
					}
				});*/
				/*$.get('testAJAX.do',{methodName:'testAJAX'},function(data){
					alert(data);
				},"text");*/
				
				/*$.getJSON('testAJAX.do',{methodName:'testAJAX'},function(data){
					alert(data.name);
				});*/
				$.post('testAJAX.do',{methodName:'testAJAX'},function(data){
					//var o = eval("("+data+")");//将json格式的字符串转换为json对象
					alert(data.name);
				},"json");
			});	
		});		
				
	</script>

  </head>
  
  <body>
  	 <div id="d">
		<span class="bt">测试</span>
	</div>
  </body>
</html>
