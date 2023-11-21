package com.ssafy.friend.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.friend.model.Friend;
import com.ssafy.friend.model.mapper.FriendMapper;
import com.ssafy.user.model.User;

@Service
public class FriendServiceImpl implements FriendService {
	private FriendMapper friendMapper;

	public FriendServiceImpl(FriendMapper friendMapper) {
		super();
		this.friendMapper = friendMapper;
	}

	@Override
	public int registFriend(Friend friend) throws Exception {
		return friendMapper.registFriend(friend);
	}

	@Override
	public void deleteFriend(Friend friend) throws Exception {
		friendMapper.deleteFriend(friend);
	}

	@Override
	public List<User> listFollowing(int fromIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<User> listFollowing(int fromIdx) throws Exception {
//		return friendMapper.listFollowing(fromIdx);
//	}
	
	
}
