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
    
    <title>课程管理</title>
    <jsp:include page="navigate.jsp" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/ycl.css" media="all">
  </head>
  
  <body style="text-align: center;">
 <div class="layui-body admin-body">
        <div class="layui-main">
        <br><br><br><br>
             <font size="10" style="margin-top: 500px">个人信息</font>
           <table class="layui-table" lay-even lay-skin="nob" style="margin-top: 60px" > 
  <colgroup>
    <col width="800">
    <col width="500">
    <col width="500">
    <col width="830">
  </colgroup>
  
  <thead>
    <tr>
      <th style="text-align: right;">学号:</th>
      <th style="text-align: left;">${info.number }</th>
      <th style="text-align: right;">姓名</th>
      <th style="text-align: left;">${info.name }</th>
    </tr> 
    <tr>
      <th style="text-align: right;">性别:</th>
      <th style="text-align: left;">${info.sex=="1"?"男":"女" }</th>
      <th style="text-align: right;">民族:</th>
      <th style="text-align: left;">${info.nation }</th>
    </tr> 
    <tr>
      <th style="text-align: right;">身份证号:</th>
      <th style="text-align: left;">${info.identity }</th>
      <th style="text-align: right;">入学时间:</th>
      <th style="text-align: left;">${info.session }</th>
    </tr> 
    <tr>
      <th style="text-align: right;">专业:</th>
      <th style="text-align: left;">${info.major }</th>
      <th style="text-align: right;">班级:</th>
      <th style="text-align: left;">${info.classes }</th>
    </tr> 
    <tr>
      <th style="text-align: right;">毕业:</th>
      <th style="text-align: left;">${info.graduated=="1"?"是":"否" }</th>
      <th style="text-align: right;"></th>
      <th style="text-align: left;"></th>
      
    </tr> 
  </thead>
  
</table>
          <div class="layui-form-item">
                     <div class="layui-input-block">
                        <input id="exportButton" type="button" class="layui-btn" value="导出"/>
                    </div>
             </div>    
      </div>            
</div>
<script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
	<script>
layui.use(['laypage', 'layer','element','form'], function(){    	
    var $ = layui.jquery;
    var element = layui.element(); 
    var form = layui.form();
    });  
	$("#exportButton").click(function(){
		var json=JSON.stringify("${infoToString}");
		 $.ajax({
	            cache: true,
	            type: "POST",
	            url:"${pageContext.request.contextPath}/exportInfo",
	            data:{"json":json},
	            async: false,
	            success: function(data) {
	            	if(data=="success") {
	            		layer.msg("导出成功！", {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
	            	}else {
	            		layer.msg("导出失败！", {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){});
	            	}
	            }
	        });
	});
</script>
</body>
</html>
