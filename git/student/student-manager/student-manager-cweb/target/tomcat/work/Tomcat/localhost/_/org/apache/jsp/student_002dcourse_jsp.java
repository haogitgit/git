/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-06-25 08:06:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class student_002dcourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>选课管理</title>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigate.jsp", out, false);
      out.write("\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"layui/css/layui.css\" media=\"all\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/ycl.css\" media=\"all\">\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write(" <div class=\"layui-body admin-body\">\r\n");
      out.write("        <div class=\"layui-main\">\r\n");
      out.write("              <div class=\"layui-tab layui-tab-brief\">\r\n");
      out.write("                  <ul class=\"layui-tab-title\">\r\n");
      out.write("                       <li class=\"layui-this\">选课列表</li>  \r\n");
      out.write("                  </ul>\r\n");
      out.write("      \r\n");
      out.write("            <table class=\"layui-table\" lay-even=\"\" lay-skin=\"row\" id=\"course\">\r\n");
      out.write("                <thead >\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th style=\"text-align: center;width:80px;\">编号</th>\r\n");
      out.write("                        <th style=\"text-align: center;width:130px;\">课程名称</th>\r\n");
      out.write("                        <th style=\"text-align: center;width:110px;\">公选课</th>\r\n");
      out.write("                         <th style=\"text-align: center;width:100px;\">教师</th>\r\n");
      out.write("                          <th style=\"text-align: center;width:100px;\">时间</th>\r\n");
      out.write("                          <th style=\"text-align: center;width:80px;\">地点</th>\r\n");
      out.write("                          <th style=\"text-align: center;width:80px;\">应选人数</th>\r\n");
      out.write("                            <th style=\"text-align: center;width:80px;\">实选人数</th>\r\n");
      out.write("                        <th style=\"text-align: center;width:130px;\">操作</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                   ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t     \r\n");
      out.write("                 </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("              <div id=\"page\" style=\"float:right\"></div>\r\n");
      out.write("        \r\n");
      out.write("             <input id=\"iframe_status\" value=\"\" hidden=\"hidden\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("                \r\n");
      out.write("                  </div>\r\n");
      out.write("             </div> \r\n");
      out.write("      </div>            \r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"layui/jquery-2.0.0.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("layui.use(['laypage', 'layer','element','form'], function(){    \t\r\n");
      out.write("    var $ = layui.jquery;\r\n");
      out.write("    var element = layui.element(); \r\n");
      out.write("    var form = layui.form();\r\n");
      out.write("    });  \r\n");
      out.write(" \tfunction check(e) {\r\n");
      out.write("\r\n");
      out.write(" \t\t\tvar id=e.name;\r\n");
      out.write("\t\t\tif(e.value==\"选择\") {\r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t                 cache: true,\r\n");
      out.write("\t                 type: \"POST\",\r\n");
      out.write("\t                 url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/course/selectcourse\",\r\n");
      out.write("\t                 data:{\"courseId\":id,\"operation\":\"add\"},\r\n");
      out.write("\t                 async: false,\r\n");
      out.write("\t                 success: function(data) {\r\n");
      out.write("\t                \t if(data==\"success\") {\r\n");
      out.write("\t                \t\t var tr = $(e).parent(\"td\").parent(\"tr\");\r\n");
      out.write("\t         \t\t\t\t$(\"#course\").find(\"tr\").first().after(tr); \r\n");
      out.write("\t                \t\t e.value=\"退选\";\r\n");
      out.write("\t                \t\t e.style.backgroundColor=\"#FF5722\";\r\n");
      out.write("\t                \t\t layer.msg('选课成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});\r\n");
      out.write("\t                \t }\t \r\n");
      out.write("\t                 \t else if(data==\"error\"){\r\n");
      out.write("\t                 \t\tlayer.msg('选课人数已满！', {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){}); \r\n");
      out.write("\t                 \t\te.value=\"人数已满\";\r\n");
      out.write("\t                 \t\te.style.backgroundColor=\"#c2c2c2\";\r\n");
      out.write("\t                 \t\te.disable=\"true\";\r\n");
      out.write("\t                 \t } \r\n");
      out.write("\t                 \t else {\r\n");
      out.write("\t                 \t\t var tr = $(e).parent(\"td\").parent(\"tr\");\r\n");
      out.write("\t\t         \t\t\t$(\"#course\").find(\"tr\").first().after(tr); \r\n");
      out.write("\t                 \t\t e.value=\"退选\";\r\n");
      out.write("\t                \t\t e.style.backgroundColor=\"#FF5722\";\r\n");
      out.write("\t                \t\t layer.msg('你已经选过该课程了！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});\r\n");
      out.write("\t                 \t } \t\t\r\n");
      out.write("\t                 }\r\n");
      out.write("\t             });\r\n");
      out.write("\t\t\t\t \t\t\t\t \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(e.value==\"退选\") {\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\tvar tr = $(e).parent(\"td\").parent(\"tr\");\r\n");
      out.write("\t\t\t\t$(\"#course\").find(\"tr\").last().after(tr);  \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t                 cache: true,\r\n");
      out.write("\t                 type: \"POST\",\r\n");
      out.write("\t                 url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/course/selectcourse\",\r\n");
      out.write("\t                 data:{\"courseId\":id,\"operation\":\"delete\"},\r\n");
      out.write("\t                 async: false,\r\n");
      out.write("\t                 success: function(data) {\r\n");
      out.write("\t                \t if(data==\"success\") {\r\n");
      out.write("\t                 \t \tlayer.msg('退选成功！', {icon: 1,time: 1000,shade: 0.1,offset:'200px'}, function(){});\r\n");
      out.write("\t                 \t \te.value=\"选择\";\r\n");
      out.write("\t                 \t \te.style.backgroundColor=\"#009688\";\r\n");
      out.write("\t                \t }\r\n");
      out.write("\t                 \t else\r\n");
      out.write("\t                 \t\tlayer.msg('退选失败！', {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){}); \r\n");
      out.write("\t                 }\r\n");
      out.write("\t             });\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\telse {}\r\n");
      out.write(" \t}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /student-course.jsp(46,19) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("list");
    // /student-course.jsp(46,19) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/student-course.jsp(46,19) '${clist}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${clist}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /student-course.jsp(46,19) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("status");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                       <tr id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" >\r\n");
          out.write("                        <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                         <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                        <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.ispublic==\"1\"?\"是\":\"否\"}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                        <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.teacher}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                        <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.start}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('-');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.end}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("周</td>\r\n");
          out.write("                        <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.place}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                        <td style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.studentnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                        <td class=\"num\" style=\"text-align: center;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.realnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                        <td style=\"text-align: center;\">\r\n");
          out.write("                                     \r\n");
          out.write("                    \r\n");
          out.write("                        \t ");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("                        \t ");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\t \r\n");
          out.write("                        \r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t                    </tr>\r\n");
          out.write("\t                   ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /student-course.jsp(59,26) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.studentnum==list.realnum}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                            <input name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"button\"  class=\"layui-btn layui-btn-mini\" edit-uid=\"1\"  value=\"人数已满\" style=\"background-color:#c2c2c2 \">\r\n");
        out.write("\t                      \t ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /student-course.jsp(62,26) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.studentnum!=list.realnum}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                            <input name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"button\"  class=\"layui-btn layui-btn-mini\" edit-uid=\"1\" onclick=\"check(this)\" value=\"选择\" style=\"background-color:#009688 \">\r\n");
        out.write("\t                      \t ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}