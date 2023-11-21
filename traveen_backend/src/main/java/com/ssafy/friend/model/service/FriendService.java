package com.ssafy.friend.model.service;

import com.ssafy.friend.model.Friend;

public interface FriendService {
	int followUser(Friend friend) throws Exception;
	void deleteFriend(Friend friend) throws Exception;
}
