package com.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bean.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelImpl;
import com.web.util.DBUtil;





public class ShowUserServlet extends HttpServlet{
	
	UserModel userModel = new UserModelImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		List<User> list=userModel.loadAllData();
		this.getServletContext().setAttribute("userList", list);
		req.getRequestDispatcher("view/showUsers.jsp").forward(req, resp);
		
		
	}	

}
