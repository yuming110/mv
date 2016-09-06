package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.util.DBUtil;


public class AddStudentServlet extends HttpServlet{

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
		String sid = req.getParameter("sid");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String sex = req.getParameter("sex");
		String cid = req.getParameter("cid");
		String times = req.getParameter("times");
		
		String sql = "select*from student where sid = ? ";
		System.out.println(sid);
		HttpSession session = req.getSession();
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{sid});
		if(list.size()>0){
			session.setAttribute("studentError", "此学生已存在！请重新添加！");
			resp.sendRedirect("view/addStudent.jsp");
		}else{
		   String sql1 = "insert into student() values(?,?,?,?,?,?)";
					
			 DBUtil.executeDML(sql1, new Object[]{sid,name,age,sex,cid,times});
			 //resp.sendRedirect("class");
			 req.getRequestDispatcher("student").forward(req, resp);
		}
	}	
		
}
		


