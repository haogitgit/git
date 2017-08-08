package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mapper.StGradeMapper;
import com.student.pojo.StGrade;
import com.student.pojo.StGradeExample;
import com.student.pojo.StGradeExample.Criteria;
import com.student.service.GradeService;
@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	private StGradeMapper gradeMapper;
	
	public boolean addGrade(String numbers,String grades,long courseId) {
		
		try {
			String []numberList=numbers.split(",");
			String []gradeList=grades.split(",");
			for(int i=0;i<numberList.length;i++) {
				StGrade grade=new StGrade();
				List<StGrade> list=getGradeList(numberList[i], courseId);
				if(list.size()==0) {
					grade.setCourseid(courseId);
					grade.setNumber(numberList[i]);
					grade.setGrade(Integer.parseInt(gradeList[i]));
					gradeMapper.insert(grade);
				}	
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<StGrade> getGradeList(String number, long courseId) {
		
		StGradeExample example=new StGradeExample();
		Criteria criteria=example.createCriteria();
		criteria.andCourseidEqualTo(courseId);
		criteria.andNumberEqualTo(number);
		List<StGrade> gradeList=gradeMapper.selectByExample(example);
		return gradeList;
	}

	public List<StGrade> getGradeByNumber(String number) {
		
		StGradeExample example=new StGradeExample();
		Criteria criteria=example.createCriteria();
		criteria.andNumberEqualTo(number);
		List<StGrade> list=gradeMapper.selectByExample(example);
		return list;
	}

	public void deleteGradeByNumber(String number) {
		StGradeExample example=new StGradeExample();
		Criteria criteria=example.createCriteria();
		criteria.andNumberEqualTo(number);
		gradeMapper.deleteByExample(example);
		
	}

}
