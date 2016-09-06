package com.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.util.DBUtil;


public class AddClassServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String times = req.getParameter("times");
		String sql = "select*from class where name = ? ";
		System.out.println(name);
		HttpSession session = req.getSession();
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{name});
		if(list.size()>0){
			session.setAttribute("classError", "此班级已存在！请重新添加！");
			resp.sendRedirect("view/addClass.jsp");
		}else{
			req.setAttribute("date", new Date());
		   String sql1 = "insert into class(name,times) values(?,?)";
					
			 DBUtil.executeDML(sql1, new Object[]{name,times});
			 //resp.sendRedirect("class");
			 req.getRequestDispatcher("class").forward(req, resp);
		}
	}	
		
}
		


