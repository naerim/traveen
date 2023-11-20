package com.ssafy.friend.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.friend.model.Friend;

public interface FriendService {
	int registFriend(Friend friend) throws Exception;
	void deleteFriend(Friend friend) throws Exception;
	List<Friend> listFollowing(int fromIdx) throws Exception;
}
