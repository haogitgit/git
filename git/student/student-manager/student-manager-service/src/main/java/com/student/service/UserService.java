package com.student.service;

import com.student.pojo.StUser;

public interface UserService {
	
	void createUser(StUser user);
	
	void editPassword(String username,String password);
	
	StUser selectUserByUsername(String username);
	
	void deleteUserByUsername(String username);
}
