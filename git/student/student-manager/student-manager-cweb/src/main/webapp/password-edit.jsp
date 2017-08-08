<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="keywords" content="ChaoXCMS">
<meta name="description" content="">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<link rel="stylesheet" href="layui/css/ycl.css" media="all">
<script type="text/javascript">
</script>
</head>
<body>
	 <form id="passwordInfo" class="layui-form">
		<div class="layui-form-item">
		<label class="layui-form-label">新密码：</label>
 		  <input type="password" name="password"  autocomplete="off" placeholder="请输入新密码" class="layui-input" >            
     </div>
     <div class="layui-form-item">
     <label class="layui-form-label">确认新密码:</label>
 		<input type="password" name="checkpassword"  autocomplete="off" placeholder="请输入确认新密码" class="layui-input" >           
      </div>
       <div class="layui-form-item">
            <div class="layui-input-block">
               <input type="button" id="passwordButton" class="layui-btn" value="修改"/>
            </div>
      </form>
      <script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>
	  <script src="layui/layui.js" charset="utf-8"></script>
	  <script type="text/javascript">
      $("#passwordButton").click(function(){
        	 $.ajax({
                 cache: true,
                 type: "POST",
                 url:"${pageContext.request.contextPath}/user/editpassword",
                 data:$('#passwordInfo').serialize(),// 你的formid
                 async: false,
                 success: function(data) {
                	 if(data=="success") {
                		alert ("修改密码成功！");
                	 } else {
                		 alert("两次输入的密码不一致！"); 
                	 }
                 }
             });
         });
      </script>
</body>
</html>