package com.neusoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.bean.Post;
import com.neusoft.bean.PostClass;
import com.neusoft.bean.User;
import com.neusoft.service.PostService;
import com.neusoft.service.UserService;

/**
 * Servlet implementation class PostServlet
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if ("check".equals(flag)) {
			checkPower(request, response);
		} else if ("success".equals(flag)) {
			sendPost(request, response);
		} else if ("postInfo".equals(flag)) {
			selPostInfo(request, response);
		}

	}

	private void selPostInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pid = request.getParameter("pid");
		System.out.println(pid);
		PostService ps = new PostService();
		// 将帖子点击数+1
		ps.addClick(Integer.valueOf(pid));
		Post p = ps.selById(Integer.valueOf(pid));
		request.getSession().setAttribute("postInfo", p);
		response.sendRedirect("html/jie/detail.jsp");
	}

	private void checkPower(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("userinfo") != null) {

			response.sendRedirect("html/jie/add.jsp");
		} else {
			response.sendRedirect("html/user/login.jsp");
		}
	}

	private void sendPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("userinfo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pclass = request.getParameter("class");
		String kiss = request.getParameter("kiss");
		Post p = new Post();

		PostClass pc = new PostClass();
		// User user = new User();
		p.setTitle(title);
		p.setContent(content);
		pc.setId(Integer.valueOf(pclass));
		p.setPcid(pc);
		p.setNickName(user.getNickName());
		// user.setKissNum(Integer.valueOf(kiss));
		UserService us = new UserService();
		System.out.println(title);
		boolean flag = us.usersPost(p);
		if (flag) {
			// 减少相应的飞吻数
			// System.out.println("发布成功");
			us.deleteKiss();
		}
		response.sendRedirect(request.getContextPath() + "/indexServlet");
	}

}
