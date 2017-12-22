package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.Post;
import com.neusoft.dao.PostDao;

public class PostService {

	PostDao dao = new PostDao();

	public void addClick(int pid) {
		dao.addPostClick(pid);
	}

	public List<Post> selPost() {
		List<Post> list = dao.selAllPost();
		return list;
	}

	public Post selById(int pid) {
		Post post = dao.selById(pid);
		return post;
	}
}
