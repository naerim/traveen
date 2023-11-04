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
		User user = userMapper.getUser(map.get("userId"));
		if (user == null) {
			return null;
		}
		
		String salt = user.getSalt();
		if (salt == null) {
			return null;
		}
		
		String userPwd = map.get("userPwd");
		userPwd = userUtil.getEncrypt(userPwd, salt);
		map.put("userPwd", userPwd);
		return userMapper.login(map);
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return userMapper.idCheck(userId);
	}

	@Override
	public void join(Map<String, String> map) throws Exception {
		String salt = userUtil.getSalt();
		String userPwd = userUtil.getEncrypt(map.get("userPwd"), salt);
		map.put("userPwd", userPwd);
		map.put("salt", salt);
		userMapper.join(map);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userMapper.getUser(userId);
	}

	@Override
	public void updateUser(Map<String, String> map) throws Exception {
		userMapper.updateUser(map);
	}

	@Override
	public void updatePwd(Map<String, String> map) throws Exception {
		String salt = userUtil.getSalt();
		System.out.println("salt : " + salt);
		System.out.println("map newPwd : " + map.get("newPwd"));
		String newPwd = userUtil.getEncrypt(map.get("newPwd"), salt);
		System.out.println("newPwd: " + newPwd);
		map.put("userPwd", newPwd);
		map.put("salt", salt);
		userMapper.updatePwd(map);
	}

	@Override
	public int pwdCheck(Map<String, String> map) throws Exception {
		String userPwd = map.get("userPwd");
		String salt = map.get("salt");
		userPwd = userUtil.getEncrypt(userPwd, salt);
		map.put("userPwd", userPwd);
		return userMapper.pwdCheck(map);
	}
}