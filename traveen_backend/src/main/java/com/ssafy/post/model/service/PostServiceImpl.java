package com.ssafy.post.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.post.model.Post;
import com.ssafy.post.model.PostItem;
import com.ssafy.post.model.PostList;
import com.ssafy.post.model.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {
	private PostMapper postMapper;

	public PostServiceImpl(PostMapper postMapper) {
		super();
		this.postMapper = postMapper;
	}

	@Override
	public PostList listPost(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "10" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);

		String key = map.get("key");
		param.put("key", key == null ? "" : "p.title");

		param.put("userIdx", map.get("userIdx") == null ? "" : map.get("userIdx"));
		
		System.out.println("사용자아이디 : " + param.get("userIdx"));

		List<Post> list = postMapper.listPost(param);

		param.put("key", key == null ? "" : "title");
		int totalPostCount = postMapper.getTotalPostCount(param);
		int totalPageCount = (totalPostCount - 1) / sizePerPage + 1;

		PostList postList = new PostList();
		postList.setPosts(list);
		postList.setCurrentPage(currentPage);
		postList.setTotalPageCount(totalPageCount);
		return postList;
	}

	@Override
	public void registPost(Map<String, Object> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("post", map.get("post") == null ? "" : map.get("post"));
		param.put("courseIdx", map.get("courseIdx") == null ? "" : map.get("courseIdx"));
		param.put("list", map.get("list") == null ? "" : map.get("list"));

		// Post객체로 cast
		Post post =  new ObjectMapper().convertValue(param.get("post"), Post.class);
		postMapper.registPost(post);

		// 생성된 글의 고유 아이디
		int idx = post.getIdx();
		param.put("postIdx", idx);
		postMapper.registPostItem(param);

		// 여행 완료
		postMapper.updateCourseFlag((String) param.get("courseIdx"));
	}

	@Override
	public void modifyPost(Post post) throws Exception {
		postMapper.modifyPost(post);
	}

	@Override
	public void deletePost(int idx) throws Exception {
		postMapper.deletePost(idx);
	}

	@Override
	public Post viewPost(int idx) throws Exception {
		return postMapper.viewPost(idx);
	}
	
	@Override
	public List<PostItem> viewPostItem(int idx) throws Exception {
		return postMapper.viewPostItem(idx);
	}

	@Override
	public Post getPost(int idx) throws Exception {
		return postMapper.getPost(idx);
	}

	@Override
	public void updateHit(int idx) throws Exception {
		postMapper.updateHit(idx);
	}
}
