/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-06-03 12:57:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class info_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/input.css\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/js/jquery-3.1.1.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"top\" style=\"background-color: red;width: 100%;height:50px\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div style=\";margin-left: 1100px; width: 120px;height: 31px\">欢迎你，老师</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"left\" style=\"background-color: green;width: 15%;height:643px;float: left\" >\r\n");
      out.write("\t\t<div style=\"margin-top: 20%\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t<span>学生档案信息管理</span>\r\n");
      out.write("\t\t\t<li><span><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/info-add\">信息注册</a></span></li>\r\n");
      out.write("\t\t\t<li><span><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/info-edit\">信息更新</a></span></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<ul><span>选修课管理</span>\r\n");
      out.write("\t\t\t<li><span><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/course-add\">选修课发布</a></span></li>\r\n");
      out.write("\t\t\t<li><span><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/course-edit\">选修课更新</a></span></li>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<ul><span>学生成绩管理</span>\r\n");
      out.write("\t\t\t<li><span><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/grade-add\">成绩录入</a></span></li>\r\n");
      out.write("\t\t\t<li><span><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/grade-edit\">成绩更新</a></span></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"main\" style=\"width: 85%;height:643px;float: left\">\r\n");
      out.write("\t\t<div style=\"margin-top: 60px;margin-left: 200px\">\r\n");
      out.write("\t\t\t<form>\r\n");
      out.write("\t\t\t\t<div style=\"margin-left: 250px;margin-top: 60px\"><h1>学生档案添加</h1></div>\r\n");
      out.write("\t\t\t\t<form class=\"jqtransform jqtransformdone\" action=\"#\" method=\"post\">\r\n");
      out.write("\t\t<p><label style=\"cursor: pointer;\">用户名：</label><div class=\"jqTransformInputWrapper jqTransformSafari\" style=\"width: 210px;\"><div class=\"jqTransformInputInner\"><div><input type=\"text\" class=\"jqtranformdone jqTransformInput\" style=\"width: 226px;\"></div></div></div></p>\r\n");
      out.write("\t\t<p><label style=\"cursor: pointer;\">密码：</label><div class=\"jqTransformInputWrapper jqTransformSafari\" style=\"width: 210px;\"><div class=\"jqTransformInputInner\"><div><input type=\"password\" class=\"jqtranformdone jqTransformInput\" style=\"width: 226px;\"></div></div></div></p>\r\n");
      out.write("\t\t<p><label>性别：</label><span class=\"jqTransformRadioWrapper\"><a href=\"#\" class=\"jqTransformRadio\" rel=\"sex\"></a><input type=\"radio\" name=\"sex\" class=\"jqTransformHidden\"></span> <label style=\"width: auto; cursor: pointer;\">男</label> <span class=\"jqTransformRadioWrapper\"><a href=\"#\" class=\"jqTransformRadio\" rel=\"sex\"></a><input type=\"radio\" name=\"sex\" class=\"jqTransformHidden\"></span> <label style=\"width: auto; cursor: pointer;\">女</label> </p>\r\n");
      out.write("\t\t<p><label>&nbsp;</label><button id=\"\" name=\"\" type=\"submit\" class=\" jqTransformButton\"><span><span>提交</span></span></button> <button id=\"\" name=\"\" type=\"reset\" class=\" jqTransformButton\"><span><span>重置</span></span></button></p>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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