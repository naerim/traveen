package com.ssafy.friend.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.friend.model.Friend;
import com.ssafy.friend.model.mapper.FriendMapper;

@Service
public class FriendServiceImpl implements FriendService {
	private FriendMapper friendMapper;

	public FriendServiceImpl(FriendMapper friendMapper) {
		super();
		this.friendMapper = friendMapper;
	}

	@Override
	public int followUser(Friend friend) throws Exception {
		return friendMapper.followUser(friend);
	}

	@Override
	public void deleteFriend(Friend friend) throws Exception {
		friendMapper.deleteFriend(friend);
	}
}
