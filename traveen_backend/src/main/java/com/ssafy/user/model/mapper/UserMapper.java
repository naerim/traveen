package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
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
	void updatePwd(Map<String, String> map) throws SQLException;
	int pwdCheck(String userId, String userPwd) throws SQLException;
	
	void saveRefreshToken(Map<String, String> map) throws SQLException;
	Object getRefreshToken(String userid) throws SQLException;
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	// 팔로잉, 팔로워
	List<User> listFollowing(int fromIdx) throws SQLException;
	List<User> listFollower(int toIdx) throws SQLException;
	void deleteFollowing(int fromIdx) throws SQLException;
	void deleteFollower(int toIdx) throws SQLException;
}
