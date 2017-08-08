package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.common.utils.JsonUtils;
import com.student.pojo.CourseGrade;
import com.student.pojo.GradeListToString;
import com.student.pojo.StCourse;
import com.student.pojo.StGrade;
import com.student.pojo.StInfo;
import com.student.pojo.StOption;
import com.student.service.CourseService;
import com.student.service.GradeService;
import com.student.service.OptionService;
import com.student.service.StudentService;

@Controller
public class PageController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private OptionService optionService;
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping("/")
	public String toPage() {
		return  "login";
	}
	@RequestMapping("/info-add")
	public String toAddInfo() {
		return "student";
	}
	@RequestMapping("/course-add")
	public String toAddCourse() {
		return "course";
	}
	@RequestMapping("*")
	     public String test3(){
	         return "error";
	     }
	@RequestMapping("/main")
	public String toMain() {
		return  "main";
	}
	@RequestMapping("/passwordEdit")
	public String toPassword() {
		return  "password-edit";
	}
	@RequestMapping("/student-course")
	public String toCourse(HttpServletRequest request,Model model) {
		HttpSession session=request .getSession();
		String major=(String) session.getAttribute("major");
		List<StCourse> list=courseService.getCourse(major);
		model.addAttribute("clist", list);
		return  "student-course";
	}
	@RequestMapping("/studentinfo")
	public String toStudentInfo(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String number=(String) session.getAttribute("number");
		StInfo info=studentService.selectInfoByNumber(number);
		model.addAttribute("info", info);
		model.addAttribute("infoToString", info.toString());
		return  "student-info";
	}
	@RequestMapping("/studentEdit")
	public String toEditPage(long id,Model model) {
		
		StInfo info=studentService.selectInfoById(id);
		model.addAttribute("student", info);
		return "student-edit";
	}
	@RequestMapping("/score")
	public String toScorePage(long courseId,Model model) {
		
		List<StInfo> infoList=new ArrayList<StInfo>();
		List<StGrade> gradeList=new ArrayList<StGrade>();
		StCourse course=courseService.selectCourseById(courseId);
		List<String> numberList=optionService.getNumberByCourse(courseId);
		for (String number : numberList) {
			infoList.add(studentService.selectInfoByNumber(number));
			List<StGrade> list=gradeService.getGradeList(number, courseId);
			if(list.size()!=0) {
				gradeList.add(list.get(0));
			}
		}
		model.addAttribute("students",infoList);
		model.addAttribute("grades",gradeList);
		model.addAttribute("courseName", course.getName());
		model.addAttribute("courseId", courseId);
		return "course-score";
	}
	@RequestMapping("/grade")
	public String toGrade(Model model,HttpServletRequest request) {
		
		List<CourseGrade> courseGrades=new ArrayList<CourseGrade>();
		HttpSession session=request.getSession();
		String number=(String) session.getAttribute("number");
		StInfo info=studentService.selectInfoByNumber(number);
		List<StGrade> list=gradeService.getGradeByNumber(number);
		if(list.size()!=0) {
			for (StGrade stGrade : list) {
				CourseGrade courseGrade=new CourseGrade();
				courseGrade.setCourseId(stGrade.getCourseid());
				courseGrade.setName(courseService.selectCourseById(stGrade.getCourseid()).getName());
				courseGrade.setGrade(stGrade.getGrade());
				courseGrades.add(courseGrade);
			}
		 	GradeListToString toString=new GradeListToString();
			model.addAttribute("json",toString.gradeListToString(courseGrades));
			model.addAttribute("gradeList", courseGrades);
			model.addAttribute("infoz", info);
		} 
		return  "grade";
	}
}
