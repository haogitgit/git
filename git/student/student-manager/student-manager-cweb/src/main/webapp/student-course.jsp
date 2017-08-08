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
    
    <title>选课管理</title>
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
        <div class="layui-main">
              <div class="layui-tab layui-tab-brief">
                  <ul class="layui-tab-title">
                       <li class="layui-this">选课列表</li>  
                  </ul>
      
            <table class="layui-table" lay-even="" lay-skin="row" id="course">
                <thead >
                    <tr>
                        <th style="text-align: center;width:80px;">编号</th>
                        <th style="text-align: center;width:130px;">课程名称</th>
                        <th style="text-align: center;width:110px;">公选课</th>
                         <th style="text-align: center;width:100px;">教师</th>
                          <th style="text-align: center;width:100px;">时间</th>
                          <th style="text-align: center;width:80px;">地点</th>
                          <th style="text-align: center;width:80px;">应选人数</th>
                            <th style="text-align: center;width:80px;">实选人数</th>
                        <th style="text-align: center;width:130px;">操作</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="list" items="${clist}" varStatus="status">
                       <tr id="${list.id}" >
                        <td style="text-align: center;">${list.id}</td>
                         <td style="text-align: center;">${list.name}</td>
                        <td style="text-align: center;">${list.ispublic=="1"?"是":"否"}</td>
                        <td style="text-align: center;">${list.teacher}</td>
                        <td style="text-align: center;">${list.start}-${list.end}周</td>
                        <td style="text-align: center;">${list.place}</td>
                        <td style="text-align: center;">${list.studentnum}</td>
                        <td class="num" style="text-align: center;">${list.realnum}</td>
                        <td style="text-align: center;">
                                     
                    
                        	 <c:if test="${list.studentnum==list.realnum}">
	                            <input name="${list.id}" type="button"  class="layui-btn layui-btn-mini" edit-uid="1"  value="人数已满" style="background-color:#c2c2c2 ">
	                      	 </c:if>
                        	 <c:if test="${list.studentnum!=list.realnum}">
	                            <input name="${list.id}" type="button"  class="layui-btn layui-btn-mini" edit-uid="1" onclick="check(this)" value="选择" style="background-color:#009688 ">
	                      	 </c:if>	 
                        
							</td>
	                    </tr>
	                   </c:forEach>
	     
                 </tbody>
            </table>
              <div id="page" style="float:right"></div>
        
             <input id="iframe_status" value="" hidden="hidden"/>
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
 	function check(e) {

 			var id=e.name;
			if(e.value=="选择") {
				 $.ajax({
	                 cache: true,
	                 type: "POST",
	                 url:"${pageContext.request.contextPath}/course/selectcourse",
	                 data:{"courseId":id,"operation":"add"},
	                 async: false,
	                 success: function(data) {
	                	 if(data=="success") {
	                		 var tr = $(e).parent("td").parent("tr");
	         				$("#course").find("tr").first().after(tr); 
	                		 e.value="退选";
	                		 e.style.backgroundColor="#FF5722";
	                		 layer.msg('选课成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
	                	 }	 
	                 	 else if(data=="error"){
	                 		layer.msg('选课人数已满！', {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){}); 
	                 		e.value="人数已满";
	                 		e.style.backgroundColor="#c2c2c2";
	                 		e.disable="true";
	                 	 } 
	                 	 else {
	                 		 var tr = $(e).parent("td").parent("tr");
		         			$("#course").find("tr").first().after(tr); 
	                 		 e.value="退选";
	                		 e.style.backgroundColor="#FF5722";
	                		 layer.msg('你已经选过该课程了！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
	                 	 } 		
	                 }
	             });
				 				 
			}
			else if(e.value=="退选") {
							
				var tr = $(e).parent("td").parent("tr");
				$("#course").find("tr").last().after(tr);  
				
				 $.ajax({
	                 cache: true,
	                 type: "POST",
	                 url:"${pageContext.request.contextPath}/course/selectcourse",
	                 data:{"courseId":id,"operation":"delete"},
	                 async: false,
	                 success: function(data) {
	                	 if(data=="success") {
	                 	 	layer.msg('退选成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
	                 	 	e.value="选择";
	                 	 	e.style.backgroundColor="#009688";
	                	 }
	                 	 else
	                 		layer.msg('退选失败！', {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){}); 
	                 }
	             });
			}	
			else {}
 	}
</script>
</body>
</html>
