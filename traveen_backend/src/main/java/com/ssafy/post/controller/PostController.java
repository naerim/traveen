package com.ssafy.post.controller;

import java.nio.charset.Charset;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.post.model.Post;
import com.ssafy.post.model.PostList;
import com.ssafy.post.model.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/post")
@Api(tags = "여행 후기 게시글 API", value="Traveen")
public class PostController {
	private final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "여행 후기 게시글 목록 조회 API", notes = "여행 후기 게시글 목록을 조회하는 역할을 합니다. /post/list")
	public ResponseEntity<?> list(@RequestParam @ApiParam(value = "여행 후기 게시글 목록을 얻기 위한 부가정보.", required = true) Map<String, String> map) throws Exception {
		logger.info("listPost map = {}", map);
		PostList postList = postService.listPost(map);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(postList);
	}
	
	@GetMapping("/view/{idx}")
	@ApiOperation(value = "여행 후기 게시글 상세 조회 API", notes = "Post의 idx를 RequestParam으로 받아 해당 여행 후기 게시글을 상세 조회하는 역할을 합니다. /post/view")
	public ResponseEntity<?> view(@PathVariable(value="idx") int idx) throws Exception {
		logger.debug("view post idx : {}", idx);
		Post post = postService.viewPost(idx);
		postService.updateHit(idx);
		return ResponseEntity.ok(post);
	}
	
	@PostMapping("/regist")
	@ApiOperation(value = "여행 후기 게시글 등록 API", notes = "여행 후기 게시글을 등록하는 역할을 합니다. /post/regist")
	public ResponseEntity<?> regist(@RequestBody Map<String, Object> map) throws Exception {
		logger.debug("write post : {}", map);
		postService.registPost(map);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/modify/{idx}")
	@ApiOperation(value = "여행 후기 게시글 수정 API", notes = "Post의 idx를 PathVariable으로 받아 해당 여행 후기 게시글을 수정하는 역할을 합니다. /post/modify")
	public ResponseEntity<?> modify(@PathVariable(value="idx") int idx) throws Exception {
		logger.debug("modify idx : {}", idx);
		Post post = postService.getPost(idx);
		return ResponseEntity.ok(post);
	}

	@PutMapping("/modify")
	@ApiOperation(value = "여행 후기 게시글 수정 API", notes = "여행 후기 게시글 수정하는 역할을 합니다. /post/modify")
	public ResponseEntity<?> modify(@RequestBody Post post) throws Exception {
		logger.debug("modify post : {}", post);
		postService.modifyPost(post);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{idx}")
	@ApiOperation(value = "여행 후기 게시글 삭제 API", notes = "Post의 idx를 PathVariable으로 받아 여행 후기 게시글을 삭제하는 역할을 합니다. /post/delete")
	public ResponseEntity<?> delete(@PathVariable("idx") int idx) throws Exception {
		logger.debug("delete post idx : {}", idx);
		postService.deletePost(idx);
		return ResponseEntity.ok().build();
	}
}