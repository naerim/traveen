package com.ssafy.post.model.service;

import java.util.Map;

import com.ssafy.post.model.Post;
import com.ssafy.post.model.PostList;

public interface PostService {
	PostList listPost(Map<String, String> map) throws Exception;
	void registPost(Post post) throws Exception;
	void modifyPost(Post post) throws Exception;
	void deletePost(int idx) throws Exception;
	Post viewPost(int idx) throws Exception;
	Post getPost(int idx) throws Exception;
	void updateHit(int idx) throws Exception;
}
