package com.ssafy.user.model.service;

import com.ssafy.user.model.User;

public interface UserService {
	int idCheck(String userId) throws Exception;
	User login(String userId, String userPwd) throws Exception;
	void join(User user) throws Exception;
	void deleteUser(String userId) throws Exception;

	User getUser(String userId) throws Exception;
	void updateUser(User user) throws Exception;
	void updatePwd(User user, String newPwd) throws Exception;
	int pwdCheck(String userId, String userPwd) throws Exception;
}
