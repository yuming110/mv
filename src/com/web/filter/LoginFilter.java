package com.web.filter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bean.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelImpl;





public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("过滤器销毁了");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("执行过滤");
//		String methodName=req.getParameter("methodName");
//		System.out.println("这是一个方法"+methodName);
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
//		req.setCharacterEncoding("utf-8");
//		
//		User user = (User)request.getSession().getAttribute("loginUser");
//		System.out.println(user);
		
//		if("login".equals(methodName)||"reg".equals(methodName)||"ery".equals(methodName)){
			chain.doFilter(request, response);
//		}else{
//			if(user == null){
//				
//				request.getSession().setAttribute("loginError","请先注册！");
//				String path = request.getContextPath();
//				String basePath = request.getScheme()+"://"+
//					request.getServerName()+":"+request.getServerPort()+path+"/";
//				PrintWriter out = response.getWriter();
//				out.write("<script type = 'text/javascript'>window.top.location.href='"+basePath+"index.jsp'</script>");
//			}else{
//				String path=request.getServletPath();
//				String newPath=path.substring(1);
//				UserModel userModel=new UserModelImpl();
//				boolean b=userModel.goFilter(newPath,user.getUid());
//				//查询此用户是否有相应的菜单访问权限
//				if(b){
//					//b为true
//					chain.doFilter(request, response);
//				}else{
//					req.setAttribute("filterError", "对不起，你没有访问权限");
//					request.getRequestDispatcher("view/goFilter.jsp").forward(request, response);
//				}
//				
//			}
//		
//		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化了");
	}

}
