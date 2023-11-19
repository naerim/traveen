package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.User;

@Mapper
public interface UserMapper {
	int idCheck(String userId) throws SQLException;
	User login(User user) throws SQLException;
	void join(User user) throws SQLException;
	void deleteUser(String userId) throws SQLException;

	User getUserById(String userId) throws SQLException;
	User getUserByEmail(Map<String, String> map) throws SQLException;
	void updateUser(User user) throws SQLException;
	void updatePwd(User user, String newPwd) throws SQLException;
	int pwdCheck(String userId, String userPwd) throws SQLException;
	
	void saveRefreshToken(Map<String, String> map) throws SQLException;
	Object getRefreshToken(String userid) throws SQLException;
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
