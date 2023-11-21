package com.ssafy.user.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.user.model.User;

public interface UserService {
	int idCheck(String userId) throws Exception;
	User login(User user) throws Exception;
	void join(User user) throws Exception;
	void deleteUser(String userId) throws Exception;

	User getUserById(String userId) throws Exception;
	User getUserByEmail(String emailId, String emailDomain) throws Exception;
	void updateUser(User user) throws Exception;
	void updatePwd(Map<String, String> map) throws Exception;
	int pwdCheck(String userId, String userPwd) throws Exception;
	
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	void deleRefreshToken(String userId) throws Exception;
	
	List<User> listFollowing(int fromIdx) throws Exception;
	List<User> listFollower(int toIdx) throws Exception;
	void deleteFollowing(int fromIdx) throws Exception;
	void deleteFollower(int toIdx) throws Exception;
}
