package com.ssafy.friend.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.friend.model.Friend;

@Mapper
public interface FriendMapper {
	int registFriend(Friend friend) throws SQLException;
	void deleteFriend(Friend friend) throws SQLException;
	List<Friend> listFollowing(int fromIdx) throws SQLException;
}
