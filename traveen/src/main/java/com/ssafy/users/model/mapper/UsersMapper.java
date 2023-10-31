package com.ssafy.users.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.users.model.Users;

@Mapper
public interface UsersMapper {
	int idCheck(String userId) throws SQLException;
	void joiUsers(Users users) throws SQLException;
	Users loginUsers(Map<String, String> map) throws SQLException;
}
