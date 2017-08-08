package com.student.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.pojo.PageInfo;
import com.student.pojo.StInfo;
import com.student.pojo.StUser;
import com.student.service.GradeService;
import com.student.service.OptionService;
import com.student.service.StudentService;
import com.student.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private OptionService optionService;
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping("/addinfo")
	public String addInfo(StInfo info,String password) {
		
		StUser user=new StUser();
		user.setUsername(info.getNumber());
		user.setPassword(DigestUtils.md5Hex(password));
		user.setIsteacher("0");
		userService.createUser(user);
		studentService.AddInfo(info);
		optionService.createOption(info.getNumber());
		return "student";
	}
	@RequestMapping("/select")
	public String selectInfoList(StInfo info, Integer pageNo,Model model){
		
		PageInfo pageInfo=studentService.selectInfoList(info, pageNo);
		model.addAttribute("page", pageInfo);
		model.addAttribute("list", pageInfo.getObjectList());
		return "student";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String infoDelete(long id){
		
		StInfo info=studentService.selectInfoById(id);
		boolean flag=studentService.deleteInfo(id);
		userService.deleteUserByUsername(info.getNumber());
		
		return flag==true?"success":"error";
	}
	@RequestMapping("/editInfo")
	@ResponseBody
	public String editInfo(StInfo info) {
		
		boolean flag=studentService.updateinfo(info);
		return flag==true?"success":"error";
	}
}
