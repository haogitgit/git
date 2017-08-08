<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<meta name="keywords" content="ChaoXCMS">
<meta name="description" content="">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<link rel="stylesheet" href="layui/css/ycl.css" media="all">
<script type="text/javascript">
</script>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header layui-bg-black header admin-header">
    <div class="layui-main">
        <a class="logo" href="${pageContext.request.contextPath}/main" style="font-size:24px;color:#fff">
                                     学生信息管理系统
        </a>
        <div class="nav-right">  
            <ul class="layui-nav">
                      <li  class="layui-nav-item" style="color:#F2889A">
                        <i class="layui-icon" style="font-size:16px; color: #F2889A;">&#xe612; 
                        </i>
                      </li>
                      <li  class="layui-nav-item">
                         <a href="javascript:void(0)">
                      
                        <cite>
                          ${sessionScope.name}
                        </cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a id="editPassword" href="javascript:void(0)">修改密码</a></dd>
      
                    </dl>
                </li>
                <li  class="layui-nav-item">
                    <a id="adminLogout" href="${pageContext.request.contextPath}/logout">登出</a>
                </li>
            </ul>
        </div>
        
    </div> 
</div>
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
   <ul class="layui-nav layui-nav-tree">
                
                 <c:if test="${sessionScope.role=='1'}">
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/info-add ">学生信息管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/course-add ">选课信息管理</a>
                </li>
    			</c:if>
    			 <c:if test="${sessionScope.role=='0'}">
    			 	<li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/studentinfo ">个人信息</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/grade">成绩查询</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/student-course ">选课</a>
                </li>
    			 </c:if>
            </ul>
      </div>
  </div> 
</div>
<script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>

	$("#editPassword").click(function(){
		//页面层
		layer.open({
			
		  title: '密码修改',
		  type: 2,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['300px', '300px'], //宽高
		  resize: false,
		  content: ['${pageContext.request.contextPath}/passwordEdit', 'no']
		});
	});
	
</script>
</body>
</html>