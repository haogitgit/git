package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.student.common.utils.IDUtils;
import com.student.mapper.StCourseMapper;
import com.student.pojo.PageInfo;
import com.student.pojo.StCourse;
import com.student.pojo.StCourseExample;
import com.student.pojo.StCourseExample.Criteria;
import com.student.pojo.StInfo;
import com.student.pojo.StInfoExample;
import com.student.service.CourseService;
import com.student.service.OptionService;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private StCourseMapper courseMapper;
	@Autowired
	private OptionService optionService;
	
	public boolean addCourse(StCourse course) {
			
		try {
			course.setId(IDUtils.genCourseId());
			course.setRealnum(0);
			if("1".equals(course.getIspublic())) {
				course.setMajor(null);
			}			
			courseMapper.insert(course);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public PageInfo selectCourse(String name, String min, String max, Integer pageNum) {
		if(pageNum==null) {
			pageNum=1;
		}
		StCourseExample example=new StCourseExample();
		PageHelper.startPage(pageNum, 10);
		Criteria criteria=example.createCriteria();
		if(!name.isEmpty()) {
			criteria.andNameLike("%"+name+"%");
		}
		if(!min.isEmpty()&&!max.isEmpty()) {
			criteria.andRealnumBetween(Integer.parseInt(min), Integer.parseInt(max));
		}
		List<StCourse> courseList=courseMapper.selectByExample(example);
		com.github.pagehelper.PageInfo<StCourse> pageInfo=new com.github.pagehelper.PageInfo<StCourse>(courseList);
		long total=pageInfo.getTotal();
		com.student.pojo.PageInfo page =new com.student.pojo.PageInfo();
		page.setObjectList(courseList);
		page.setTotolNum((int)total);
		page.setPageNo(pageNum);
		
		return page;
	}

	public boolean deleteCourse(long id) {
		try {
			courseMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public StCourse selectCourseById(long id) {
		
		StCourse course=courseMapper.selectByPrimaryKey(id);
		return course;
	}

	public List<StCourse> getCourse(String major) {
		
		try {
			StCourseExample example=new StCourseExample();
			Criteria criteria=example.createCriteria();
			criteria.andIspublicEqualTo("1");
			List<StCourse> courselist=courseMapper.selectByExample(example);
			
			StCourseExample example1=new StCourseExample();
			Criteria criteria1=example1.createCriteria();
			criteria1.andIspublicEqualTo("0");
			List<StCourse> courselist1=courseMapper.selectByExample(example1);
			for (StCourse course : courselist1) {
				String []majorlist=course.getMajor().split(",");
				for (String maj : majorlist) {
					if(major.equals(maj)) {
						courselist.add(course);
					}
				}
			}		
			return courselist;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	public String operateCourse(String number,long id, String operation) {
		
		StCourse course=courseMapper.selectByPrimaryKey(id);
		int num=course.getRealnum();
		if("add".equals(operation)) {
			if(course.getRealnum()>=course.getStudentnum())
				return "error";
			course.setRealnum(num+1);
			boolean flag=optionService.addOption(number, id);
			if(!flag) {return "notAdd";}
		}
		if("delete".equals(operation)) {
			if(course.getRealnum()==0)
				return "error";
			course.setRealnum(num-1);
			optionService.deleteOption(number, id);
		}
		courseMapper.updateByPrimaryKey(course);
		return "success";
	}
}
