package com.ssafy.friend.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.friend.model.Friend;
import com.ssafy.user.model.User;

@Mapper
public interface FriendMapper {
	int followUser(Friend friend) throws SQLException;
	void deleteFriend(Friend friend) throws SQLException;
}
