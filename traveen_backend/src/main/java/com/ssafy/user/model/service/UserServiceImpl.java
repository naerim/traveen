package com.ssafy.user.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.User;
import com.ssafy.user.model.mapper.UserMapper;
import com.ssafy.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	private UserUtil userUtil = new UserUtil();
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public User login(Map<String, String> map) throws Exception {
//		User user = userMapper.getUser(map.get("userId"));
//		if (user == null) {
//			return null;
//		}
//		
//		String salt = user.getSalt();
//		if (salt == null) {
//			System.out.println("login 실패");
//		}
//		
//		String userPwd = map.get("userPwd");
//		userPwd = userUtil.getEncrypt(userPwd, salt);
//		map.put("userPwd", userPwd);
//		System.out.println(userPwd);
		return userMapper.login(map);
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return userMapper.idCheck(userId);
	}

	@Override
	public void join(Map<String, String> map) throws Exception {
		String salt = userUtil.getSalt();
		userMapper.join(map);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userMapper.getUser(userId);
	}
}
