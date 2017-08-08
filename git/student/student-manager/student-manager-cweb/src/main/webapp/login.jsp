<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/ycl.css" media="all">
  </head>
  
<body style="background-image:url('img/bg1.jpg');"> 
<div style="color:#009688;font-family:微软雅黑;font-size:24px;margin-top:200px;text-align:center;">学生信息管理系统</div>         
<div style="padding:50px 430px;">   
<form id="loginForm" class="layui-form" action="" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label" style="color:#fff">账号</label>
    <div class="layui-input-inline">
      <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">  
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="color:#fff">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
   
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="color:#fff">角色</label>
    <div class="layui-input-inline" style="color:#fff">
      <input type="radio" name="isteacher" value="0" title="学生"  checked>
      <input type="radio" name="isteacher" value="1" title="教师" >
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input id="loginButton" type="button" class="layui-btn" value="登陆"/>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
</div>
<script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['laypage', 'layer','element','form'], function(){    	
        var $ = layui.jquery;
        var element = layui.element(); 
        var form = layui.form();
        });  
    $("#loginButton").click(function(){
   	 $.ajax({
            cache: true,
            type: "POST",
            url:"${pageContext.request.contextPath}/login",
            data:$('#loginForm').serialize(),// 你的formid
            async: false,
            success: function(data) {
            	if(data=="error") {
            		layer.msg("用户名或密码错误！", {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){});
            	}else {
            		window.location.href="${pageContext.request.contextPath}/main";	
            	}
            }
        });
    });
</script>
</body>
</html>