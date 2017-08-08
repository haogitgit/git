package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.service.ExportService;

@Controller
public class ExportController {
	
	@Autowired
	private ExportService exportService;
	
	@RequestMapping("/export")
	@ResponseBody
	public String export(String json) {
		boolean flag=exportService.export(json);
		return flag==true?"success":"error";
	}
	@RequestMapping("/exportInfo")
	@ResponseBody
	public String exportInfo(String json) {
		boolean flag=exportService.exportInfo(json);
		return flag==true?"success":"error";
	}
}
