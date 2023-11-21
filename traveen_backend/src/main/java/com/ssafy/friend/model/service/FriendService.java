package com.ssafy.friend.model.service;

import com.ssafy.friend.model.Friend;

public interface FriendService {
	int registFriend(Friend friend) throws Exception;
	void deleteFriend(Friend friend) throws Exception;
//	List<User> listFollowing(int fromIdx) throws Exception;
}
