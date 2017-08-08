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
                <legend>当前录入课程>>${courseName}</legend>
              
         </fieldset>
         <div class="layui-tab layui-tab-brief" style="min-height:500px">
                  
            <form method="post" action="${pageContext.request.contextPath }/grade/add" class="layui-form">
                <input type="hidden" name="courseId" value="${courseId}"/>
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
                   <c:forEach var="list" items="${students}" varStatus="loop">
                       <tr>
                        <td style="text-align: center;">${list.number}</td>
                        <td style="text-align: center;">${list.name}</td>
                        <td style="text-align: center;">${list.session}</td>
                        <td style="text-align: center;">${list.major}</td>                     
                        <td style="text-align: center;">${list.classes}</td>
                        <td style="text-align: center;">${courseName}</td>
                        <td>
                            <div class="layui-input-inline">
                            <c:if test="${!empty grades}">
                            	 <input name="grades" lay-verify="score" autocomplete="off" placeholder="请输入成绩" class="layui-input" type="text" value="${grades[loop.count-1].grade }">
                             </c:if>
                            <c:if test="${empty grades}">
                            	 <input name="grades" lay-verify="score" autocomplete="off" placeholder="请输入成绩" class="layui-input" type="text"">
                             </c:if>
                             <input value="${list.number}" type="hidden" name="numbers">
                            </div>
                        </td>
                    </tr>
                   </c:forEach>
                 </tbody>
            </table>
            <div class="layui-form-item">
                     <div class="layui-input-block">
                        <button  class="layui-btn" lay-submit="" lay-filter="sumbitBtn">提交</button>
                        <button  type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
             </div>
           </form>
            </div>
                  </div>
             </div> 
           

<script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['laypage','layer','element','form'], function(){
    	
        var $ = layui.jquery;
        var laypage = layui.laypage;
        var layer = layui.layer;
        var form = layui.form();
        form.verify({
                
                score: function(value){
                    if(value==''){
                      return '没有录入成绩';
                    }
                    var reg = new RegExp("^[0-9]*$"); 
                    if(!reg.test(value)){  
                    	  return '不是数字';
                    } 
                }
          });  
        $(".layui-nav-item").each(function(){
        	if($(this).find("a").attr("href").indexOf('course')!=-1){
        		$(this).addClass("layui-this");
        	}else{
        		$(this).removeClass("layui-this");
        	}
        });
       
    });
</script>
</body>
</html>
