package com.student.service;

import java.util.List;

import com.student.pojo.StOption;

public interface OptionService {
	
	void createOption(String number);
	
	boolean addOption(String number, long courseId);
	
	void deleteOption(String number, long courseId);
	
	StOption getOption(String number);
	
	List<String> getNumberByCourse(long courseId);
}
