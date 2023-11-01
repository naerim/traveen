package com.ssafy.user.model.service;

import java.util.Map;

import com.ssafy.user.model.User;

public interface UserService {
	int idCheck(String userId) throws Exception;
	User login(Map<String, String> map) throws Exception;
	void join(Map<String, String> map) throws Exception;
}
