package com.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.pojo.StUser;
import com.student.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/editpassword")
	@ResponseBody
	public String editPassword(String password,String checkpassword,HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		if(!password.equals(checkpassword)) {
			return "error";
		}
		String username=(String) session.getAttribute("number");
		userService.editPassword(username, password);
		return "success";
	}
}
