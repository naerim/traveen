package com.ssafy.users.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.users.model.Users;

public interface UsersService {
	int idCheck(String userId) throws Exception;
	void joiUsers(Users users) throws Exception;
	Users loginUsers(Map<String, String> map) throws Exception;
}
