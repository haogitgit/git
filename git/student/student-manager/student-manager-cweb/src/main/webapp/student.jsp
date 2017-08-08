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
    
    <title>学生信息管理</title>
    <jsp:include page="navigate.jsp" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/ycl.css" media="all">
  </head>
  
  <body >
 <div class="layui-body admin-body">
        <div class="layui-main">
         <div class="layui-tab layui-tab-brief">
                  <ul class="layui-tab-title">
                       <li class="layui-this">学生信息列表</li>
                       <li>添加学生信息</li>
                  </ul>
                  <div class="layui-tab-content">
                     <div class="layui-tab-item layui-show">
                   <form method="post" action="${pageContext.request.contextPath}/student/select" class="layui-form">
                <div class="layui-form-item">
      
                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="name" name="name" placeholder="学生名称" >
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="sex" name="sex" placeholder="性别" >
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="major" name="major" placeholder="专业" >
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" type="text" id="graduated" name="graduated" placeholder="是否毕业" >
                    </div>
                
                    <div class="layui-input-inline">
                        <button id="selectInfo" class="layui-btn" lay-submit="" lay-filter="userFilter">筛选</button>
                        <button class="layui-btn" onclick="deleSeltedRecords()">
							  <i class="layui-icon">&#xe640;</i> 
							</button>
                    </div>
                 
                </div>
                
            </form>
            <table class="layui-table" lay-even="" lay-skin="row">
                <thead>
                    <tr>
                        <th style="text-align: center">学号</th>
                        <th style="text-align: center">姓名</th>
                        <th style="text-align: center">性别</th>
                        <th style="text-align: center">民族</th>
                        <th style="text-align: center">身份证号</th>
                        <th style="text-align: center">届</th>
                        <th style="text-align: center">专业</th>
                        <th style="text-align: center">班级</th>
                        <th style="text-align: center">是否毕业</th>
                        <th style="text-align: center">更新</th>
                        <th style="text-align: center">注销</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="list" items="${list}">
                       <tr>
                        <td style="text-align: center;">${list.number}</td>
                        <td style="text-align: center;">${list.name}</td>
                        <td style="text-align: center;">${list.sex=="0"?"女":"男"}</td>
                        <td style="text-align: center;">${list.nation}</td>
                        <td style="text-align: center;">${list.identity}</td>
                        <td style="text-align: center;">${list.session}</td>
                        <td style="text-align: center;">${list.major}</td>
                        <td style="text-align: center;">${list.classes}</td>
                        <td style="text-align: center;">${list.graduated=="0"?"否":"是"}</td>

                        <td>
                            <button class="layui-btn layui-btn-mini" edit-uid="1" onclick="studentEdit('${list.id}');">更新</button>
                        </td>
                        <td> 	
             				<button class="layui-btn layui-btn-mini" edit-uid="1" onclick="studentDel('${list.id}');"><i class="layui-icon">&#xe640;</i></button>
                        </td>
                    </tr>
                   </c:forEach>
                 </tbody>
            </table>
              <div id="page" style="float:right"></div>
        
  </div>
<div class="layui-tab-item">
        <form id="studentInfo" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/student/addinfo" method="post">
        
      
        <div class="layui-form-item" >
                 <label class="layui-form-label">届</label>
                  <div class="layui-input-inline">
                   <select name="session" lay-filter="session" lay-verify="session">
                   <option value="">入学年份</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option> 
                        <option value="2015">2015</option> 
                        <option value="2016">2016</option> 
                        <option value="2017" >2017</option>  
                  </select>
               </div>
           </div>
         <div class="layui-form-item">
                 <label class="layui-form-label">专业</label>
                  <div class="layui-input-inline">
                   <select name="major" lay-filter="major" lay-verify="major">
                   		<option value="">专业</option>
                         <option value="计算机科学与技术">计算机科学与技术</option>
                         <option value="软件工程">软件工程</option>
                         <option value="数字媒体">数字媒体</option>
                         <option value="网络工程"> 网络工程</option>
                         <option value="物联网"> 物联网</option>
                  </select>
               </div>
           
           </div>
           
        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
                 <div class="layui-input-inline">
                  <input id="classes" type="text" name="classes" lay-verify="classes" autocomplete="off" placeholder="请输入班级" class="layui-input" >
                    </div>
           </div>
          <div class="layui-form-item">
                 <label class="layui-form-label">学号</label>
                     <div class="layui-input-inline">
                       <input type="text" name="number" id="number" lay-verify="number" autocomplete="off" placeholder="请输入学号" class="layui-input" value="">
                           <font style="float: right;color: red">(学号一旦生成不能修改)</font>
                       <input type="hidden" name="id" lay-verify="id" autocomplete="off" placeholder="" class="layui-input" value="">
                    </div>
           </div>
           <div class="layui-form-item">
                 <label class="layui-form-label">登录密码</label>
                     <div class="layui-input-inline">
                       <input type="text" name="password" id="password" lay-verify="password" autocomplete="off" placeholder="请输入密码" class="layui-input" value="123456">
                       <font style="float: right;color: red">(默认密码123456)</font>
                    </div>
           </div>
           <div class="layui-form-item">
                 <label class="layui-form-label">姓名</label>
                     <div class="layui-input-inline">
                       <input type="text" name="name" id="name" lay-verify="name" autocomplete="off" placeholder="请输入姓名" class="layui-input" value="">
                    </div>
           </div>
           <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                  <input name="sex" value="1" title="男" type="radio" checked>
                  <input name="sex" value="0" title="女" type="radio" >
                 </div>
           </div>
           <div class="layui-form-item">
            <label class="layui-form-label">民族</label>
                 <div class="layui-input-inline">
                  <input type="text" id="nation" name="nation" lay-verify="nation" autocomplete="off" placeholder="请输入民族" class="layui-input" value="汉族">
                    </div>
           </div>
             <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
                 <div class="layui-input-inline">
                  <input type="text" name="identity" id="identity" lay-verify="identity" autocomplete="off" placeholder="请输入身份证号" class="layui-input" ">
                    </div>
           </div>
            <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
                 <div class="layui-input-inline">
                  <input type="text" name="phone" id="phone" lay-verify="phone" autocomplete="off" placeholder="请输入联系电话" class="layui-input" ">
                    </div>
           </div>
           
            <div class="layui-form-item">
                <label class="layui-form-label">是否毕业</label>
                <div class="layui-input-block">
                  <input name="graduated" value="1" title="是" type="radio" >
                  <input name="graduated" value="0" title="否" type="radio" checked>
                 </div>
           </div>
           
           <div class="layui-form-item">
            <div class="layui-input-block">
               <button class="layui-btn" lay-submit="" lay-filter="sumbitBtn">提交</button>
               <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
    layui.use(['laypage','layer','element','form'], function(){
    	
        var $ = layui.jquery;
        var laypage = layui.laypage;
        var layer = layui.layer;
        var form = layui.form();
        form.verify({
        	number: function(value){
              if(value.length < 8){
                return '学号为12个字符';
              }
            },
            password: function(value){
                if(value.length < 6){
                  return '密码至少得6个字符';
                }
            },   
            identity: function(value){
                if(value.length !=18){
                  return '身份证号必须为18位';
                }
              },
           name: function(value){
                if(value.length < 2){
                  return '姓名至少得2个字符';
                }
            },
            major: function(value){
                if(value==''){
                  return '专业没有选择';
                }
              },
              session: function(value){
                  if(value==''){
                    return '届没有选择';
                  }
                }
          
          });  
        

       
        $(".layui-nav-item").each(function(){
        	if($(this).find("a").attr("href")=='student/select'){
        		$(this).addClass("layui-this");
        	}else{
        		$(this).removeClass("layui-this");
        	}
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
                    location.href = 'student/select?pageNo='+curr;                }
            }
        })

        $("#page").prepend('<span>共 ' + c_pages + ' 条&nbsp;&nbsp;</span>');
        //监听提交
         $("#infoButton").click(function(){
	
                	 layer.msg('添加成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
       
         });
         
    });


    function studentEdit(uid){
    	  window.location.href='studentEdit?id=' + uid;
    }
    
    function studentDel(uid){
        layui.use(['layer'],function(){
            var $ = layui.jquery;
            var layer = layui.layer;

            layer.confirm('确定删除此学生?', {icon: 3, title:'学生删除',offset: '200px'}, function(index){
                $.ajax({    
                    type: "post",   
                    url: 'student/delete?id=' + uid,
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
</body>
</html>
