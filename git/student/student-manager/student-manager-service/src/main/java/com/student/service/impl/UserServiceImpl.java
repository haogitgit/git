package com.student.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mapper.StUserMapper;
import com.student.pojo.StUser;
import com.student.pojo.StUserExample;
import com.student.pojo.StUserExample.Criteria;
import com.student.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private StUserMapper userMapper;
	
	public void createUser(StUser user) {
		
		userMapper.insert(user);
	}

	public void editPassword(String username, String password) {
		
		StUser user=selectUserByUsername(username);
		user.setPassword(DigestUtils.md5Hex(password));
		userMapper.updateByPrimaryKey(user);
	}

	public StUser selectUserByUsername(String username) {
		
		StUserExample example=new StUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<StUser> userList=userMapper.selectByExample(example);
		if(userList.size()!=0) {
			return userList.get(0);
		}
		return null;
	}

	public void deleteUserByUsername(String username) {
		
		StUserExample example=new StUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		userMapper.deleteByExample(example);
	}


}
