package com.student.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.pojo.StUser;

public interface LoginService {
	
	boolean checkLogin(StUser user);
}
