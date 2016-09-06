package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.util.DBUtil;


public class RegServlet extends HttpServlet{

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
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		String email = req.getParameter("email");
		String sex = req.getParameter("sex");
		String education = req.getParameter("education");
		String introduction = req.getParameter("introduction");
		String[] hobbys = req.getParameterValues("hobby");
		String hobby = "";
		if(hobbys != null && hobbys.length>0){
			for(String s : hobbys){
				hobby += s+",";
			}
		}
		if(hobby.endsWith(",")) 
			hobby = hobby.substring(0, hobby.length()-1);
		
		String sql = "select*from user where userName=?";
		HttpSession session = req.getSession();
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{userName});
		if(list.size()>0){
			session.setAttribute("regError", "此账号已存在！请重新注册！");
			resp.sendRedirect("view/reg.jsp");
		}else{
			sql = "insert into user(userName,userPass,email,sex,hobby,education,introduction) values(?,?,?,?,?,?,?)";
					
			 DBUtil.executeDML(sql, new Object[]{userName,userPass,email,sex,hobby,education,introduction});
			resp.sendRedirect("index.jsp");
		}
		
		
		
		
	}
		

}
