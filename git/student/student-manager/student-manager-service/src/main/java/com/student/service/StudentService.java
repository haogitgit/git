package com.student.service;

import java.util.List;

import com.student.pojo.PageInfo;
import com.student.pojo.StInfo;
import com.student.pojo.StUser;

public interface StudentService {
	
	void AddInfo(StInfo info);
	
	StInfo selectInfoByNumber(String username);
	
	PageInfo selectInfoList(StInfo info, Integer pageNum);
	
	boolean deleteInfo(long id);
	
	StInfo selectInfoById(long id);
	
	boolean updateinfo(StInfo info);
}
