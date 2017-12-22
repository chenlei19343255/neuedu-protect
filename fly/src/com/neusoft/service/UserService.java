package com.neusoft.service;

import com.neusoft.bean.Post;
import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;

public class UserService {

	UserDao dao = new UserDao();

	public void addReg(User user) {
		dao.userReg(user);
	}

	public User loginService(String email) {
		User user = dao.userLogin(email);
		return user;
	}

	public boolean usersPost(Post p) {
		boolean flag = dao.userPost(p);
		// System.out.println(flag);
		return flag;
	}

	public void deleteKiss() {

	}

}
