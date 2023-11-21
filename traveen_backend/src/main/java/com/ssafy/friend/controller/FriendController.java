package com.ssafy.friend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.friend.model.service.FriendService;

import io.swagger.annotations.Api;

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
	
//	@GetMapping("/following/{userIdx}")
//	@ApiOperation(value = "팔로잉 목록 API", notes = "팔로잉 목록을 조회하는 역할을 합니다. /following/{userIdx}")
//	public ResponseEntity<?> list(@PathVariable("userIdx") int userIdx) throws Exception {
//		logger.debug("following list user Idx : {}", userIdx);
//		List<User> followingList = friendService.listFollowing(userIdx);
//		HttpHeaders header = new HttpHeaders();
//		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//		return ResponseEntity.ok().headers(header).body(followingList);
//	}
}
