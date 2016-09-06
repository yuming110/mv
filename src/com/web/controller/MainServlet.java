package com.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.web.bean.ClassUser;
import com.web.bean.Menu;
import com.web.bean.Page;
import com.web.bean.Role;
import com.web.bean.StudentUser;
import com.web.bean.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelImpl;
import com.web.ov.VoMenu;
import com.web.util.DBUtil;

public class MainServlet extends HttpServlet{
	
	private UserModel userModel=new UserModelImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接受信息
		req.setCharacterEncoding("utf-8");
		String methodName = req.getParameter("methodName");
		Class c = MainServlet.class;
		
		
		try {
			
			Method method = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,req, resp);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	/**
	 * 登录功能
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		User user = userModel.loadUserByName(userName);
		if(user != null){
			if(userPass.equals(user.getUserPass())){
				List<Menu> menuList = userModel.loadUserByUid(user.getUid());
				req.getSession().setAttribute("menuList",menuList );
				req.getSession().setAttribute("loginUser", user);
				resp.sendRedirect("view/Welcome.jsp");
			}else{
				req.setAttribute("loginError", "密码输入错误，请重新输入！");
				resp.sendRedirect("index.jsp");
			}
		}else{
			req.setAttribute("loginError", "账号输入错误，请重新输入！");
			resp.sendRedirect("index.jsp");
		}
		
		
	}
	/**
	 *注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void reg(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		String email = req.getParameter("email");
		String sex = req.getParameter("sex");
		String education = req.getParameter("education");
		String[] hobbys = req.getParameterValues("hobby");
		String introduction = req.getParameter("introduction");
		HttpSession session = req.getSession();
		boolean b = userModel.regData(userName, userPass, sex, email, education, hobbys, introduction);
		if(b==true){
			//注册成功
			resp.sendRedirect("index.jsp");
		}else{
			//注册失败
			session.setAttribute("regError", "此账号已存在！请重新注册！");
			resp.sendRedirect("view/reg.jsp");
		}
		//boolean b = userModel.regData(userName, userPass, sex, email, education, hobby, introduction);
	}
	
	/**
	 * 查看账户信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUser(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		List<User> userList=userModel.loadAllData();
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("view/showUsers.jsp").forward(req, resp);
	}
	/**
	 * 删除账户
	 * @param req
	 * @param resp
	 * @throws ServletExceptions
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	String uid = req.getParameter("uid");
	System.out.println(uid);
	this.userModel.loaddeleteData(Integer.valueOf(uid));
	resp.sendRedirect("view/ShowUsers.jsp");
	}
	
	/**
	 * 查看
	 * @param reqs
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void query(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	String uid = req.getParameter("uid");
	System.out.println(uid);
	List<User> user = userModel.loadsShowUser(uid);
	req.setAttribute("useLise", user);
	req.getRequestDispatcher("showUsers").forward(req, resp);
	}	
	/**
	 * 查看班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showClass(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
	
		List<ClassUser> classList = userModel.showClass();
	    req.setAttribute("classList", classList);
	    req.getRequestDispatcher("view/ShowClass.jsp").forward(req, resp);
	}
	/**
	 * 查看学生列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showStudent(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		List<StudentUser> studentList = userModel.showStudent();
	    req.setAttribute("studentList", studentList);
	    req.getRequestDispatcher("view/ShowStudent.jsp").forward(req, resp);
		
		
	}
	/**
	 * 添加班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addClass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String name = req.getParameter("name");
		String times = req.getParameter("times");
		HttpSession session = req.getSession();
	}
	/**
	 * 展示菜单列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showVoMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNo = Integer.valueOf(req.getParameter("pageNo"));
		int pageSize = Integer.valueOf(req.getParameter("pageSize"));
		
		Page<VoMenu> page=userModel.loadShowVoMenu(pageNo,pageSize);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", page.getDataList());//easyui要求返回的分页数据
		map.put("total", page.getTotal());
		
		String json = JSONObject.fromObject(map).toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
		
//		req.setAttribute("menuList", menuList);
//		req.getRequestDispatcher("view/showMenu.jsp").forward(req, resp);
	}
	/**
	 * 添加菜单前查出1,2级菜单，然后添加
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add12JMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println();
		List<Menu> menu12List=userModel.loadAdd12JMenu();
		System.out.println("控制层查询"+menu12List.size());
		req.setAttribute("menu12List", menu12List);
		req.getRequestDispatcher("view/addMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 添加菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String isshow = req.getParameter("isshow");
		String parentid = req.getParameter("parentid");
		userModel.loadAddMenu(name, url,Integer.valueOf(isshow),Integer.valueOf(parentid));
		this.showVoMenu(req, resp);
		
	}
	/**
	 * 角色列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRole(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		List<Role> roleList=userModel.loadShowRole();
		req.setAttribute("roleList", roleList);
		req.getRequestDispatcher("view/showRole.jsp").forward(req, resp);
		
	}	
	/**
	 * 根据rid查询rid对应的用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRoleRid(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String rid = req.getParameter("rid");
		
		Role role = userModel.loadShowRoleRid(Integer.valueOf(rid));
		req.setAttribute("role", role);
		
		List<Object[]> uList=userModel.showRoleUser(Integer.valueOf(rid));
		req.setAttribute("uList", uList);
		req.getRequestDispatcher("view/alterRole.jsp").forward(req, resp);
	}
	/**
	 * 修改用户
	 * @param req
	 * @param resp	
	 * @throws ServletException
	 * @throws IOException
	 */
	public void alterRole(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String rid = req.getParameter("rid");
		String[] urid = req.getParameterValues("urid");
		
		userModel.loadAlterRole(Integer.valueOf(rid), urid);
		this.showRole(req, resp);
	}
	
	/**
	 * 查询角色对应的菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenuRid(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String rid = req.getParameter("rid");
		
		Role role = userModel.loadShowRoleRid(Integer.valueOf(rid));
		req.setAttribute("role", role);
		
		List<Object[]> list=userModel.showMenuName(Integer.valueOf(rid));
		req.setAttribute("list", list);
		req.getRequestDispatcher("view/alterMenu.jsp").forward(req, resp);
	}
	
	
	/**
	 * 修改权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void alterMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		String[] mName = req.getParameterValues("mName");
		userModel.loadAlterMenu(Integer.valueOf(rid), mName);
		this.showRole(req, resp);
	}
	
	public void testAJAX(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		System.out.println("AJAX请求来了");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("{\"address\":\"重庆市渝中区\",\"name\":\"解放碑\"}");
		resp.getWriter().flush();
	}
}

	
