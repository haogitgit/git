package com.student.pojo;

import java.util.List;

public class GradeListToString {
	
	public String gradeListToString(List<CourseGrade> list) {
		
		StringBuilder sb=new StringBuilder();
		for (CourseGrade courseGrade : list) {
			sb.append("{课程编号：");
			sb.append(courseGrade.getCourseId());
			sb.append(",课程名：");
			sb.append(courseGrade.getName());
			sb.append(",成绩：");
			sb.append(courseGrade.getGrade());
			sb.append("};");
		}
		return sb.toString();
	}
}
