package com.student.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.common.utils.CookieUtils;
import com.student.mapper.StUserMapper;
import com.student.pojo.StUser;
import com.student.pojo.StUserExample;
import com.student.pojo.StUserExample.Criteria;
import com.student.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private StUserMapper userMapper;
	
	public boolean checkLogin(StUser user) {
		
		String username=user.getUsername();
		String password=DigestUtils.md5Hex(user.getPassword());
		String isTeacher=user.getIsteacher();
		
		StUserExample example=new StUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andIsteacherEqualTo(isTeacher);
		List<StUser> userList=userMapper.selectByExample(example);
		if(userList.size()==0) {
			return false;
		}
		StUser user1=userList.get(0);
		if(!password.equals(user1.getPassword())){
			return false;
		}
		return true;
	}
}
