<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>学生修改</title>
   <jsp:include page="navigate.jsp" />
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <link rel="stylesheet" href="layui/css/ycl.css" media="all">  
</head>
<body>
 <div class="layui-body admin-body">
 <div class="layui-main">    
  <fieldset class="layui-elem-field layui-field-title">
             <legend><strong>&nbsp &nbsp&nbsp&nbsp 学生修改</strong></legend>
      </fieldset>   
        <form id="studentInfo" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/student/addinfo" method="post">
        
        <div class="layui-form-item" >
                 <label class="layui-form-label">届</label>
                  <div class="layui-input-inline">
                   <select name="session" lay-filter="session" lay-verify="session">
                        <option value="">请选择</option>
                        <option value="2013" <c:if test='${2013==student.session}'>selected</c:if>>2013</option>
                        <option value="2014" <c:if test='${2014==student.session}'>selected</c:if>>2014</option> 
                        <option value="2015" <c:if test='${2015==student.session}'>selected</c:if>>2015</option> 
                        <option value="2016" <c:if test='${2016==student.session}'>selected</c:if>>2016</option> 
                        <option value="2017" <c:if test='${2017==student.session}'>selected</c:if>>2017</option>  
                  </select>
               </div>
           </div>
         <div class="layui-form-item">
                 <label class="layui-form-label">专业</label>
                  <div class="layui-input-inline">
                   <select name="major" lay-filter="major" lay-verify="major">
                        <option value="">请选择</option>
                         <option value="计算机科学与技术" <c:if test='${"计算机科学与技术"==student.major}'>selected</c:if>>计算机科学与技术</option>
                         <option value="软件工程" <c:if test='${"软件工程"==student.major}'>selected</c:if>>软件工程</option>
                         <option value="数字媒体" <c:if test='${"数字媒体"==student.major}'>selected</c:if>>数字媒体</option>
                         <option value="网络工程" <c:if test='${"网络工程"==student.major}'>selected</c:if>> 网络工程</option>
                         <option value="物联网" <c:if test='${"物联网"==student.major}'>selected</c:if>> 物联网</option>
                  </select>
               </div>
           </div>
           
        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
                 <div class="layui-input-inline">
                  <input type="text" name="classes" lay-verify="classes" autocomplete="off" value="${student.classes }" class="layui-input" required="required">
                    </div>
           </div>
          <div class="layui-form-item">
                 <label class="layui-form-label">学号</label>
                     <div class="layui-input-inline">
                       <input type="text" name="number" lay-verify="number" autocomplete="off" value="${student.number }" class="layui-input" disabled>
                       <input type="hidden" name="id" lay-verify="id" autocomplete="off" value="${student.id }" class="layui-input" >
                       <input type="hidden" name="number" lay-verify="number" autocomplete="off" value="${student.number }" class="layui-input" >
                       <input type="hidden" name="created" lay-verify="created" autocomplete="off" value="${student.created }" class="layui-input" >
                    </div>
           </div>
           <div class="layui-form-item">
                 <label class="layui-form-label">姓名</label>
                     <div class="layui-input-inline">
                       <input type="text" name="name" lay-verify="name" autocomplete="off" value="${student.name }" class="layui-input" value="" required="required">
                    </div>
           </div>
           <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                  <input name="sex" value="1" title="男" type="radio" <c:if test="${'1'==student.sex}">checked</c:if>>
                  <input name="sex" value="0" title="女" type="radio" <c:if test="${'0'==student.sex}">checked</c:if>>
                 </div>
           </div>
           <div class="layui-form-item">
            <label class="layui-form-label">民族</label>
                 <div class="layui-input-inline">
                  <input type="text" name="nation" lay-verify="nation" autocomplete="off" value="${student.nation }" class="layui-input" value="汉族" required="required">
                    </div>
           </div>
             <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
                 <div class="layui-input-inline">
                  <input type="text" name="identity" lay-verify="identity" autocomplete="off" value="${student.identity }" class="layui-input" required="required">
                    </div>
           </div>
            <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
                 <div class="layui-input-inline">
                  <input type="text" name="phone" lay-verify="phone" autocomplete="off" value="${student.phone }" class="layui-input" ">
                    </div>
           </div>
           
            <div class="layui-form-item">
                <label class="layui-form-label">是否毕业</label>
                <div class="layui-input-block">
                  <input name="graduated" value="1" title="是" type="radio" <c:if test="${'1'==student.graduated}">checked</c:if>>
                  <input name="graduated" value="0" title="否" type="radio" <c:if test="${'0'==student.graduated}">checked</c:if>>
                 </div>
           </div>
           
           <div class="layui-form-item">
            <div class="layui-input-block">
               <input type="button" id="infoButton" class="layui-btn" value="修改"/>
               <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
  
         </div>
        </form>
  </div>  </div>
  <script src="layui/jquery-2.0.0.min.js" charset="utf-8"></script>   
<script src="layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['form'], function(){
  var form = layui.form()
  ,layer = layui.layer;
 
  form.verify({
  	studentId: function(value){
        if(value.length < 8){
          return '学号至少得8个字符';
        }
      },
      password: function(value){
          if(value.length < 6){
            return '密码至少得6个字符';
          }
      },
      studentName: function(value){
          if(value.length < 2){
            return '姓名至少得2个字符';
          }
      },
      sex: function(value){
          if(value==''){
            return '性别没有选择';
          }
        },
      majorId: function(value){
          if(value==''){
            return '专业没有选择';
          }
        },
        period: function(value){
            if(value==''){
              return '届没有选择';
            }
          }
    });  
  //监听提交
  $("#infoButton").click(function(){
        	 $.ajax({
                 cache: true,
                 type: "POST",
                 url:"${pageContext.request.contextPath}/student/editInfo",
                 data:$('#studentInfo').serialize(),// 你的formid
                 async: false,
                 success: function(data) {
                	 if(data=="success")
                	 	layer.msg('修改成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});
                	 else
                		layer.msg('修改失败！', {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){}); 
                 }
             });
         });
  $(".layui-nav-item").each(function(){
	  	if($(this).find("a").attr("href").indexOf('student')!=-1){
	  		$(this).addClass("layui-this");
	  	}else{
	  		$(this).removeClass("layui-this");
	  	}
	  });
  
});
</script>

</body>
</html>