package com.student.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.mapper.StInfoMapper;
import com.student.pojo.StInfo;
import com.student.pojo.StInfoExample;
import com.student.pojo.StInfoExample.Criteria;
import com.student.pojo.StUser;
import com.student.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StInfoMapper infoMapper;
	
	public void AddInfo(StInfo info) {
		
		info.setCreated(new Date());
		infoMapper.insert(info);
	}

	public StInfo selectInfoByNumber(String username) {
		
		StInfoExample example=new StInfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andNumberEqualTo(username);
		List<StInfo> infoList=infoMapper.selectByExample(example);
		if(infoList.size()==0) {
			return null;
		}
		StInfo info=infoList.get(0);
		return info;
	}

	public com.student.pojo.PageInfo selectInfoList(StInfo info, Integer pageNum) {
		
		if(pageNum==null) {
			pageNum=1;
		}
		StInfoExample example=new StInfoExample();
		PageHelper.startPage(pageNum, 10);
		Criteria criteria=example.createCriteria();
		if(!info.getName().isEmpty()) {
			criteria.andNameLike("%"+info.getName()+"%");
		}
		if(!info.getSex().isEmpty()) {
			criteria.andSexEqualTo(info.getSex().equals("男")?"1":"0");
		}
		if(!info.getMajor().isEmpty()) {
			criteria.andMajorLike("%"+info.getMajor()+"%");
		}
		if(!info.getGraduated().isEmpty()) {
			criteria.andGraduatedEqualTo(info.getGraduated().equals("是")?"1":"0");
		}
		List<StInfo> infoList=infoMapper.selectByExample(example);
		PageInfo<StInfo> pageInfo=new PageInfo<StInfo>(infoList);
		long total=pageInfo.getTotal();
		com.student.pojo.PageInfo page =new com.student.pojo.PageInfo();
		page.setObjectList(infoList);
		page.setTotolNum((int)total);
		page.setPageNo(pageNum);
		
		return page;
	}

	public boolean deleteInfo(long id) {
		
		try {
			infoMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public StInfo selectInfoById(long id) {
		
		StInfo info=infoMapper.selectByPrimaryKey(id);
		return info;
	}

	public boolean updateinfo(StInfo info) {
		
		try {
			infoMapper.updateByPrimaryKey(info);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
