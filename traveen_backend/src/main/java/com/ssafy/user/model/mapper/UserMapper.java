package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.User;

@Mapper
public interface UserMapper {
	int idCheck(String userId) throws SQLException;
	User login(Map<String, String> map) throws SQLException;
	void join(Map<String, String> map) throws SQLException;
	User getUser(String userId) throws SQLException;
	void updateUser(Map<String, String> map) throws SQLException;
	void updatePwd(Map<String, String> map) throws SQLException;
	int pwdCheck(Map<String, String> map) throws SQLException;
}
