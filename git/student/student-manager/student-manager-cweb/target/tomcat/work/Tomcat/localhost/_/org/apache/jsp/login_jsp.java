/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-06-10 00:46:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>学生信息管理系统</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"layui/css/layui.css\" media=\"all\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/ycl.css\" media=\"all\">\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("<body style=\"background-image:url('img/bg1.jpg');\"> \r\n");
      out.write("<div style=\"color:#009688;font-family:微软雅黑;font-size:24px;margin-top:200px;text-align:center;\">学生信息管理系统</div>         \r\n");
      out.write("<div style=\"padding:50px 430px;\">   \r\n");
      out.write("<form id=\"loginForm\" class=\"layui-form\" action=\"\" method=\"post\">\r\n");
      out.write("  <div class=\"layui-form-item\">\r\n");
      out.write("    <label class=\"layui-form-label\" style=\"color:#fff\">账号</label>\r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("      <input type=\"text\" name=\"username\" required  lay-verify=\"required\" placeholder=\"请输入用户名\" autocomplete=\"off\" class=\"layui-input\">  \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"layui-form-item\">\r\n");
      out.write("    <label class=\"layui-form-label\" style=\"color:#fff\">密码</label>\r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("      <input type=\"password\" name=\"password\" required lay-verify=\"required\" placeholder=\"请输入密码\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"layui-form-item\">\r\n");
      out.write("    <label class=\"layui-form-label\" style=\"color:#fff\">角色</label>\r\n");
      out.write("    <div class=\"layui-input-inline\" style=\"color:#fff\">\r\n");
      out.write("      <input type=\"radio\" name=\"isteacher\" value=\"0\" title=\"学生\"  checked>\r\n");
      out.write("      <input type=\"radio\" name=\"isteacher\" value=\"1\" title=\"教师\" >\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"layui-form-item\">\r\n");
      out.write("    <div class=\"layui-input-block\">\r\n");
      out.write("      <input id=\"loginButton\" type=\"button\" class=\"layui-btn\" value=\"登陆\"/>\r\n");
      out.write("      <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"layui/jquery-2.0.0.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    layui.use(['laypage', 'layer','element','form'], function(){    \t\r\n");
      out.write("        var $ = layui.jquery;\r\n");
      out.write("        var element = layui.element(); \r\n");
      out.write("        var form = layui.form();\r\n");
      out.write("        });  \r\n");
      out.write("    $(\"#loginButton\").click(function(){\r\n");
      out.write("   \t $.ajax({\r\n");
      out.write("            cache: true,\r\n");
      out.write("            type: \"POST\",\r\n");
      out.write("            url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login\",\r\n");
      out.write("            data:$('#loginForm').serialize(),// 你的formid\r\n");
      out.write("            async: false,\r\n");
      out.write("            success: function(data) {\r\n");
      out.write("            \tif(data==\"error\") {\r\n");
      out.write("            \t\tlayer.msg(\"用户名或密码错误！\", {icon: 2,time: 1000,shade: 0.1,offset:'200px'}, function(){});\r\n");
      out.write("            \t}else {\r\n");
      out.write("            \t\twindow.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/main\";\t\r\n");
      out.write("            \t}\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}