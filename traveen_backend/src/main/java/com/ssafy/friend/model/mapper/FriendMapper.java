package com.ssafy.friend.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.friend.model.Friend;

@Mapper
public interface FriendMapper {
	int registFriend(Friend friend) throws SQLException;
	void deleteFriend(Friend friend) throws SQLException;
}
