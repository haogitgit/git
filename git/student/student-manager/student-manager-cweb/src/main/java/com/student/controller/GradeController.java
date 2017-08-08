package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.pojo.StGrade;
import com.student.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping("/add")
	public ModelAndView addGrade(String  grades,String numbers,long courseId) {
		
		boolean falg=gradeService.addGrade(numbers, grades, courseId);
		return new ModelAndView("redirect:/score?courseId="+courseId);
	}
}
