package com.ssafy.users.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.users.model.Users;
import com.ssafy.users.model.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;

	public UsersServiceImpl(UsersMapper usersMapper) {
		super();
		this.usersMapper = usersMapper;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return usersMapper.idCheck(userId);
	}

	@Override
	public void joiUsers(Users users) throws Exception {
		usersMapper.joiUsers(users);
		
	}

	@Override
	public Users loginUsers(Map<String, String> map) throws Exception {
		return usersMapper.loginUsers(map);
	}
}
