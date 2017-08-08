<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    <jsp:include page="navigate.jsp" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/ycl.css" media="all">
  </head>
  
  <body>
         
     <div class="layui-body admin-body">
        <div class="layui-main" style="font-size:20px;margin:50px 200px"> 
        </div>
        </div>
  </body>
</html>
<script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>
<script>
$(".layui-nav-item").each(function(){
	if($(this).find("a").attr("href")=='login!index.action'){
		$(this).addClass("layui-this");
	}else{
		$(this).removeClass("layui-this");
	}
});
</script>