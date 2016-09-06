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
	<script type="text/javascript">
		$('#dg').datagrid({
				url:'showVoMenu.do?methodName=showVoMenu&pageNo=1&pageSize=10',
				forzenColumns:[[{field:'fd',chevkbox:true}]],
				rownumbers:true,
	     		striped:true,
	            pagination:true,
	            columns:[[
		            {field:'mid',hidden:true},
		            {field:'name',title:'菜单名字',width:100,alige:'center'},
		            {field:'url',title:'地址',width:300,alige:'center'},
		            {field:'isshow',title:'是否展示',width:100,alige:'center'},
		            {field:'level',title:'菜单级别',width:100,alige:'center'},
		            {field:'parentid',title:'上级菜单',width:100,alige:'center'},
	      	    ]],
	      		toolbar: [{
	      			text   :'添加',
					iconCls: 'icon-add',
					handler: function(){
						
					}
				},'-',{
					iconCls: 'icon-help',
					handler: function(){alert('帮助按钮')}
				}]
	      		
	            
		});
		var pager = $('#dg').datagrid("getPager");
		pager.pagination({
			onSelectPage:function(pageNumber,pageSize){
				$('#dg').datagrid('loading');
				$.post("showVoMenu.do",{
					methodName:'showVoMenu',
					pageNo:pageNumber,
					pageSize:pageSize
					
				},function(date){
					$('#dg').datagrid("loadData",{
						rows:data.rows,
						total:data.total
					});	
				},"json");
				$('#dg').datagrid('loaded');
			}
			
		});
	
	</script>
	
  </head>
  
  <body>
  	<table id="dg""></table>
  
  	<!--<h3>用户列表</h3>http://mo.tenpay.com/project/legua/pc/?ADTAG=MSG.CUIFEI.LEGUA.TX_OK_PIC
  	<table border="1" width="100%" bordercolor="blue" cellpadding="0">
  	
  		<tr> 
  			<td>编号</td>
  			<td>菜单名字</td>
  			<td>地址</td>
  			<td>是否展示</td>
  			<td>菜单级别</td>
  			<td>上级菜单</td>
  			
  			
  			
  		</tr>
  		
  		<c:forEach items="${menuList}" var="m">
  			<tr >
  				<td>${m.mid} </td>
  				<td>${m.name} </td>
  				<td>${m.url} </td>
  				<td> 
  					<c:if test="${m.isshow==1}">展示</c:if>
  					<c:if test="${m.isshow==0}">不展示</c:if>
  				</td>
  				<td>
  					<c:if test="${m.level==1}">一级菜单</c:if>
  					<c:if test="${m.level==2}">二级菜单</c:if>
  					<c:if test="${m.level==3}">三级菜单</c:if>
  				</td> 
  				<td>${m.parentid} </td>
  			</tr>
  			
  		
  		</c:forEach>
  		
  	 </table>
  --></body>
</html>
