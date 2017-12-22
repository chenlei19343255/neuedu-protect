package com.neusoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.bean.User;
import com.neusoft.service.UserService;
import com.neusoft.util.Md5Utils;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {

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

		String flag = request.getParameter("flag");
		// System.out.println(flag);
		if ("reg".equals(flag)) {
			forwardReg(request, response);
		} else if ("userReg".equals(flag)) {
			userReg(request, response);
		}
	}

	// 用户注册
	private void userReg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password1 = request.getParameter("pass");
		String password2 = request.getParameter("repass");
		HttpSession session = request.getSession();
		if (password1.equals(password2)) {

			User user = new User();
			user.setEmail(email);
			user.setNickName(username);
			user.setPassword(Md5Utils.md5(password1));
			UserService us = new UserService();
			us.addReg(user);
			session.setAttribute("userinfo", user);
			response.sendRedirect("html/user/login.jsp");
			return;
		}

		session.setAttribute("error", "密码不一致");
		response.sendRedirect("html/user/reg.jsp");

	}

	// 跳转到注册页面
	private void forwardReg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("html/user/reg.jsp");
	}

}
