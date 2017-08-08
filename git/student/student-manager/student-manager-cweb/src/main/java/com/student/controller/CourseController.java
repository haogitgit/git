package com.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.pojo.PageInfo;
import com.student.pojo.StCourse;
import com.student.pojo.StInfo;
import com.student.service.CourseService;
import com.student.service.OptionService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private OptionService optionService;
	
	@RequestMapping("/addCourse")
	@ResponseBody
	public String addCourse(StCourse course){
		
		boolean flag=courseService.addCourse(course);
		return flag==true?"success":"error";
	}
	@RequestMapping("/select")
	public String selectInfoList(String name,String min,String max, Integer pageNo,Model model){
		
		PageInfo pageInfo=courseService.selectCourse(name, min, max, pageNo);
		model.addAttribute("page", pageInfo);
		model.addAttribute("courselist", pageInfo.getObjectList());
		return "course";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String infoDelete(long id){
		
		boolean flag=courseService.deleteCourse(id);
		return flag==true?"success":"error";
	}
	
	@RequestMapping("/selectcourse")
	@ResponseBody
	public String selectCourse( long courseId,String operation,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String number=(String) session.getAttribute("number");
		String flag=courseService.operateCourse(number,courseId, operation);
		return flag;
	}
	
	
}
