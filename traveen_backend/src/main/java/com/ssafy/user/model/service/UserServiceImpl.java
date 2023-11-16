package com.ssafy.user.model.service;

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
	public User login(String userId, String userPwd) throws Exception {
		User user = userMapper.getUser(userId);
		if (user == null) {
			return null;
		}
		
		String salt = user.getSalt();
		if (salt == null) {
			return null;
		}
		
		userPwd = userUtil.getEncrypt(userPwd, salt);
		return userMapper.login(userId, userPwd);
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return userMapper.idCheck(userId);
	}

	@Override
	public void join(User user) throws Exception {
		String salt = userUtil.getSalt();
		user.setSalt(salt);
		user.setUserPwd(userUtil.getEncrypt(user.getUserPwd(), salt));
		userMapper.join(user);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		userMapper.deleteUser(userId);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userMapper.getUser(userId);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userMapper.updateUser(user);
	}

	@Override
	public void updatePwd(User user, String newPwd) throws Exception {
		String salt = userUtil.getSalt();
		newPwd = userUtil.getEncrypt(newPwd, salt);
		user.setUserPwd(newPwd);
		user.setSalt(salt);
		userMapper.updatePwd(user, newPwd);
	}

	@Override
	public int pwdCheck(String userId, String userPwd) throws Exception {
		User user = userMapper.getUser(userId);
		String salt = user.getSalt();
		userPwd = userUtil.getEncrypt(userPwd, salt);
		return userMapper.pwdCheck(userId, userPwd);
	}
}