package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.bean.User;
import com.neusoft.service.UserService;

public class LoginServlet extends HttpServlet {
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		UserService us=new UserService();
		User user=us.loginService(email);
		System.out.println(user.getNickName());
		HttpSession session=request.getSession();
		if("".equals(email)||user==null){
			session.setAttribute("error1", "用户名或密码有误");
			session.setAttribute("error2", "");
			response.sendRedirect("html/user/login.jsp");
			return;
		}
		if ("".equals(password)||!password.equals(user.getPassword())) {
			session.setAttribute("error1", "");
			session.setAttribute("error2", "用户名或密码有误");
			response.sendRedirect("html/user/login.jsp");
			return;
		}
		session.setAttribute("userinfo", user);
		response.sendRedirect("html/index.jsp");
	}

}
