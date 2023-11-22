package com.ssafy.friend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.friend.model.Friend;
import com.ssafy.friend.model.service.FriendService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/friend")
@Api(tags = "친구 API", value="Traveen")
public class FriendController {
	private final Logger logger = LoggerFactory.getLogger(FriendController.class);
	
	private FriendService friendService;

	public FriendController(FriendService friendService) {
		super();
		this.friendService = friendService;
	}
	
	@PostMapping("/regist")
	@ApiOperation(value = "코스 등록 API", notes = "코스를 등록하는 역할을 합니다. /course/regist")
	public ResponseEntity<?> regist(@RequestBody Friend friend) throws Exception {
		logger.debug("regist friend : {}", friend);
		System.out.println(friend);
		friendService.followUser(friend);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
