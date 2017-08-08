package com.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.LongHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mapper.StOptionMapper;
import com.student.pojo.StOption;
import com.student.pojo.StOptionExample;
import com.student.pojo.StOptionExample.Criteria;
import com.student.service.OptionService;
@Service
public class OptionServiceImpl implements OptionService {
	
	@Autowired
	private StOptionMapper optionMapper;
	
	public void createOption(String number) {
		
		StOption option=new StOption();
		option.setNumber(number);
		option.setCourses(null);
		optionMapper.insert(option);
	}

	public boolean addOption(String number,long courseId) {
		
		StOptionExample example=new StOptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andNumberEqualTo(number);
		List<StOption> optionList=optionMapper.selectByExampleWithBLOBs(example);
		StOption option=optionList.get(0);
		String course=option.getCourses();
		if (course==null) {
			option.setCourses(courseId+"");
		} else {
			String []courseList=course.split(",");
			for (String string : courseList) {
				if(string.equals(courseId+""))
					return false;
			}
			option.setCourses(course+","+courseId);
		}
		optionMapper.updateByPrimaryKeyWithBLOBs(option);
		return true;
	}
	public void deleteOption(String number,long courseId) {
		
		String str=null;
		StOptionExample example=new StOptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andNumberEqualTo(number);
		List<StOption> optionList=optionMapper.selectByExampleWithBLOBs(example);
		StOption option=optionList.get(0);
		String courses=option.getCourses();
		String []courseList=courses.split(",");
		for (int i=0;i<courseList.length;i++) {
			if (!courseList[i].equals(courseId+"")) {
				if(str==null) {
					str=courseList[i];
				} else {
					str=str+","+courseList[i];
				}
			}
		}
		option.setCourses(str);
		optionMapper.updateByPrimaryKeyWithBLOBs(option);
	}

	public StOption getOption(String number) {
		
		StOptionExample example=new StOptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andNumberEqualTo(number);
		List<StOption> optionList=optionMapper.selectByExampleWithBLOBs(example);
		return optionList.get(0);
	}

	public List<String> getNumberByCourse(long courseId) {
		
		List<String> numberList=new ArrayList<String>();
		StOptionExample example=new StOptionExample();
		List<StOption> optionList=optionMapper.selectByExampleWithBLOBs(example);
		for (StOption option : optionList) {
			if(option.getCourses()!=null) {
				String []courseList=option.getCourses().split(",");
				for (String course : courseList) {
					if(course.equals(courseId+"")) {
						numberList.add(option.getNumber());
					}
				}
			}
		}
		return numberList;
	}
}
