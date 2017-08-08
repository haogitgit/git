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
  
  <body>
 <div class="layui-body admin-body">
        <div class="layui-main">
              <div class="layui-tab layui-tab-brief">
                  <ul class="layui-tab-title">
                       <li class="layui-this">课程列表</li>
                       <li>添加课程</li>
                  </ul>
                  <div class="layui-tab-content">
                     <div class="layui-tab-item layui-show">
                <form method="post" action="${pageContext.request.contextPath}/course/select" class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="name" name="name"  placeholder="课程名称" >
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="min" name="min"  placeholder="最小实选人数" >
                    </div>

                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="max" name="max"  placeholder="最大实选人数" >
                    </div>
                    <div class="layui-input-inline">
                        <button class="layui-btn" lay-submit="" lay-filter="userFilter">筛选</button>
                    </div>
                </div>
            </form>
            <table class="layui-table" lay-even="" lay-skin="row">
                <thead>
                    <tr>
   
                        <th style="text-align: center;width:80px;">编号</th>
                        <th style="text-align: center;width:130px;">课程名称</th>
                        <th style="text-align: center;width:110px;">公选课</th>
                         <th style="text-align: center;width:80px;">教师</th>
                          <th style="text-align: center;width:80px;">时间</th>
                          <th style="text-align: center;width:80px;">地点</th>
                          <th style="text-align: center;width:80px;">应选人数</th>
                            <th style="text-align: center;width:80px;">实选人数</th>
                        <th style="text-align: center;width:130px;">操作</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="list" items="${courselist}">
                       <tr>
                        <td style="text-align: center;">${list.id}</td>
                        <td style="text-align: center;">${list.name}</td>
                        <td style="text-align: center;">${list.ispublic=="1"?"是":"否"}</td>
                        <td style="text-align: center;">${list.teacher}</td>
                        <td style="text-align: center;">${list.start}-${list.end}周</td>
                        <td style="text-align: center;">${list.place}</td>
                        <td style="text-align: center;">${list.studentnum}</td>
                        <td style="text-align: center;">${list.realnum}</td>
                        <td>
                            <button class="layui-btn layui-btn-mini layui-btn-warm" edit-uid="1" onclick="forAddScore('${list.id}');">录入/修改成绩</button>
                            <button class="layui-btn layui-btn-mini" edit-uid="1" onclick="courseEdit('${list.id}');">修改</button>
                            <button class="layui-btn layui-btn-danger layui-btn-mini" del-uid="1" onclick="courseDel('${list.id}');">删除</button>
                        </td>
                    </tr>
                   </c:forEach>
                 </tbody>
            </table>
              <div id="page" style="float:right"></div>
        
             <input id="iframe_status" value="" hidden="hidden"/>
            </div>
             <div class="layui-tab-item"  style="min-height:350px">
           <form class="layui-form" id="courseform">
    <div class="layui-form-item">
    <label class="layui-form-label">课程名称</label>
    <div class="layui-input-inline">
      <input type="text" name="name" lay-verify="name" autocomplete="off" placeholder="请输入课程名称" class="layui-input" value="">
      <input type="hidden" name="id" lay-verify="id" autocomplete="off" placeholder="" class="layui-input" value="">
    </div>
   </div>
   
   <div class="layui-form-item">
    <label class="layui-form-label">公选课</label>
    <div class="layui-input-inline">
      	<input id="public" type="button" class="layui-btn" value="非公选课"/>
      	<input id="pubclass" type="hidden" value="0" name="ispublic">
    </div>
   </div>
   
   <div id="major" class="layui-form-item">
    <label class="layui-form-label">选修专业</label>
    <div class="layui-input-inline">
     <input type="checkbox" name="major" title="软件工程" value="软件工程">
     <input type="checkbox" name="major" title="数字媒体" value="数字媒体">
       <input type="checkbox" name="major" title="计算机科学与技术" value="计算机科学与技术">
    </div>
    <div class="layui-input-inline">
     <input type="checkbox" name="major" title="物联网" value="物联网">
     <input type="checkbox" name="major" title="网络工程" value="网络工程">
    </div>
   </div>
   
   <div class="layui-form-item" >
                 <label class="layui-form-label">学分</label>
                  <div class="layui-input-inline">
                   <select name="credit" lay-filter="session" lay-verify="session">
                        <option value="">学分</option>
                        <option value="0.5">0.5</option>
                        <option value="1">1</option> 
                        <option value="1.5">1.5</option> 
                        <option value="2">2</option> 
                  </select>
               </div>
           </div>
   
   <div class="layui-form-item">
    <label class="layui-form-label">上课老师</label>
    <div class="layui-input-inline">
      <input type="text" name="teacher" lay-verify="teacher" autocomplete="off" placeholder="请输入上课老师" class="layui-input" >
    </div>
   </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">上课时间</label>
    <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="start" placeholder="开始周" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid">-</div>
    <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="end" placeholder="结束周" autocomplete="off" class="layui-input">
    </div>
   </div>
 	
 	<div class="layui-form-item">
    <label class="layui-form-label">上课地点</label>
    <div class="layui-input-inline">
      <input type="text" name="place" lay-verify="place" autocomplete="off" placeholder="请输入上课地点" class="layui-input" >
    </div>
   </div>
   
   <div class="layui-form-item">
    <label class="layui-form-label">可选人数</label>
    <div class="layui-input-inline">
      <input type="text" name="studentnum" lay-verify="place" autocomplete="off" placeholder="请输入人数" class="layui-input" >
    </div>
   </div>
   
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="button" id="courseButton" class="layui-btn" value="提交"/>
      <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
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
        var laypage = layui.laypage;
        var layer = layui.layer;
        var form = layui.form();
        form.verify({
        	  name: function(value){
              if(value.length < 2){
                return '课程名称至少得2个字符';
              }
            },
            major: function(value){
                if(value==''){
                  return '专业没有选择';
                }
              }
          });  
        $(".layui-nav-item").each(function(){
        	if($(this).find("a").attr("href")=='course!list.action'){
        		$(this).addClass("layui-this");
        	}else{
        		$(this).removeClass("layui-this");
        	}
        });
        $("#courseButton").click(function(){
       	 $.ajax({
                cache: true,
                type: "POST",
                url:"${pageContext.request.contextPath}/course/addCourse",
                data:$('#courseform').serialize(),// 你的formid
                async: false,
                success: function(data) {
               	 if(data=="success")
               	 	layer.msg('添加成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
               	 else
               		layer.msg('添加失败！', {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){}); 
                }
            });
        });
        var pageinfo = {"pages":'${page.totolNum}',"curr":'${page.pageNo}',"limit":10};
        var c_pages = pageinfo.pages;
        var c_curr = pageinfo.curr;
        var c_limit = pageinfo.limit;
        //调用分页
        laypage({
            cont: 'page',
            pages: Math.ceil(c_pages/c_limit), //得到总页数
            groups: 5,
            curr: c_curr, //当前分页
            first: false,
            last: false,
            skip: true,
            jump: function(obj, first){
                var curr = obj.curr;
                if(!first){ //一定要加此判断，否则初始时会无限刷新
                    location.href = 'course!list.action?pageNo='+curr;                }
            }
        })
		$("#public").click(function(){
		 	$("#major").slideToggle("slow");
			var val=$("#public").val();
			if(val=="公选课") {
				$("#public").val("非公选课");
				$("#pubclass").val("0");
			}
			else {
				$("#public").val("公选课");
				$("#pubclass").val("1");
			}

		});
        $("#page").prepend('<span>共 ' + c_pages + ' 条&nbsp;&nbsp;</span>');
        //监听提交
        form.on('submit(sumbitBtn)', function(data){
        	  layer.msg('添加成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){
                
              });
        });
        
    });
    function courseEdit(uid){
    	  window.location.href='${pageContext.request.contextPath}/main';
    }
    function forAddScore(uid){
  	  window.location.href='score?courseId=' + uid;
  }
    function courseDel(uid){
        layui.use(['layer'],function(){
            var $ = layui.jquery;
            var layer = layui.layer;

            layer.confirm('确定删除此课程?', {icon: 3, title:'课程删除',offset: '200px'}, function(index){
                $.ajax({    
                    type: "post",   
                    url: 'course/delete?id=' + uid,
                    dataType: 'text',
                    success: function(data){
                    	layer.close(index);
                    	if(data=="success")
                    	 	layer.msg('删除成功！', {icon: 1,time: 1000,shade: 0.1,offset: '200px'}, function(){	  
                         });
                    	else
                    		layer.msg('删除失败！', {icon: 1,time: 1000,shade: 0.1,offset: '200px'}, function(){
     
                           });
                    }
                });
               
            });
        });
    }
</script>

</script>
</body>
</html>
