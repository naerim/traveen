package com.ssafy.post.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.NoticeList;
import com.ssafy.post.model.Post;
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
		param.put("key", key == null ? "" : key);
		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "b.user_id");
		List<Post> list = postMapper.listPost(param);

		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "user_id");
		int totalPostCount = postMapper.getTotalPostCount(param);
		int totalPageCount = (totalPostCount - 1) / sizePerPage + 1;

		PostList postList = new PostList();
		postList.setPosts(list);
		postList.setCurrentPage(currentPage);
		postList.setTotalPageCount(totalPageCount);
		return postList;
	}

	@Override
	public void registPost(Post post) throws Exception {
		postMapper.registPost(post);
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
	public Post getPost(int idx) throws Exception {
		return postMapper.getPost(idx);
	}

	@Override
	public void updateHit(int idx) throws Exception {
		postMapper.updateHit(idx);
	}
}
