package com.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.pojo.StInfo;
import com.student.pojo.StUser;
import com.student.service.LoginService;
import com.student.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/login")
	@ResponseBody
	public String checkLogin(StUser user,HttpServletRequest request,HttpServletResponse response,Model model) {
		
		boolean isLogin=loginService.checkLogin(user);
		HttpSession session=request.getSession();
		if(!isLogin) {
			return "error";
		}
		
		if("1".equals(user.getIsteacher())) {
			session.setAttribute("name", "管理员");
		}else {
			StInfo info=studentService.selectInfoByNumber(user.getUsername());
			session.setAttribute("name", info.getName());
			session.setAttribute("major", info.getMajor());
		}	
		session.setAttribute("number", user.getUsername());
		session.setAttribute("role", user.getIsteacher());
		return "success";
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.setAttribute("name", null);
		session.setAttribute("role", null);
		session.setAttribute("number", null);
		return new ModelAndView("redirect:/");
	}
}