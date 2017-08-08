
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
    
    <title>学生成绩管理</title>
    <jsp:include page="navigate.jsp" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/ycl.css" media="all">
  </head>
   <style>
  .layui-form-label{width:30px}
  </style>
  <body>
 <div class="layui-body admin-body">
        <div class="layui-main">
         <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
              
         </fieldset>
         <div class="layui-tab layui-tab-brief" style="min-height:500px">
                  
				<table class="layui-table">
				 <thead>
				    <tr>
				        <th style="text-align: center;">学号</th>
						<th style="text-align: center;">姓名</th>
						<th style="text-align: center;">届</th>
						<th style="text-align: center">专业</th>
						<th style="text-align: center">班级</th>
						<th style="text-align: center">课程</th>
						<th style="text-align: center">成绩</th>
				    </tr>
				</thead>
                <tbody>
                   <c:forEach var="list" items="${gradeList}" varStatus="loop">
                       <tr>
                        <td style="text-align: center;">${infoz.number}</td>
                        <td style="text-align: center;">${infoz.name}</td>
                        <td style="text-align: center;">${infoz.session}</td>
                        <td style="text-align: center;">${infoz.major}</td>                     
                        <td style="text-align: center;">${infoz.classes}</td>
                        <td style="text-align: center;">${list.name}</td>
                        <td style="text-align: center;">${list.grade}</td>        
                    </tr>
                   </c:forEach>
              
                 </tbody>
            </table>
             <div class="layui-form-item">
                     <div class="layui-input-block">
                        <input id="exportButton" type="button" class="layui-btn" value="导出"/>
                    </div>
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
		var json=JSON.stringify("${json}");
		 $.ajax({
	            cache: true,
	            type: "POST",
	            url:"${pageContext.request.contextPath}/export",
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
