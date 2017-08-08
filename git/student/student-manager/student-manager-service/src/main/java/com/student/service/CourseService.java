package com.student.service;

import java.util.List;

import com.student.pojo.PageInfo;
import com.student.pojo.StCourse;

public interface CourseService {
	
	boolean addCourse(StCourse course);
	
	PageInfo selectCourse(String name,String min,String max, Integer pageNo);
	
	boolean deleteCourse(long id);
	
	StCourse selectCourseById(long id);
	
	List<StCourse> getCourse(String major);
	
	String operateCourse(String number,long id,String operation);
}
