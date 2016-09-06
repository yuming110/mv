package com.web.model;

import java.util.List;

import com.web.bean.ClassUser;
import com.web.bean.Menu;
import com.web.bean.Page;
import com.web.bean.Role;
import com.web.bean.StudentUser;
import com.web.bean.User;
import com.web.ov.VoMenu;

public interface UserModel {

	/**
	 * 登录
	 * @param userName
	 * @return
	 */
	public User loadUserByName(String userName);
	
	/**
	 * 查看所有数据
	 * @return
	 */
	public List<User> loadAllData();
	
	
	/**
	 * 删除数据
	 */
	public void loaddeleteData(int uid);
	
	/**
	 * dandu查看
	 */
	public List<User> loadsShowUser(String uid);
	
	/**
	 * 注册
	 * @return
	 */
	public boolean regData(String userName,String userPass,String sex,
			String email,String education,String[] hobbys,String introduction);
	
	/**
	 * 班级列表
	 * 
	 * @return
	 */
	public List<ClassUser> showClass();
	/**
	 * 学生列表
	 * @return
	 */
	public List<StudentUser> showStudent();
	/**
	 * 添加班级ram name
	 * @return
	 */
	public List<ClassUser> addClass(String name);
	
	
	public List<Menu> loadUserByUid(int uid);
	
	/**
	 * 权限管理菜单列表
	 * @return
	 */
	public Page<VoMenu> loadShowVoMenu(int pageNo,int pageSize);
	/**
	 * 查出1，2级菜单
	 * @return
	 */
	public List<Menu> loadAdd12JMenu();
	
	
	/**
	 * 增加菜单
	 * @return
	 */
	public void loadAddMenu(String name,String url,int isshow,int parentid);
	
	/**
	 * 权限管理角色列表
	 * @return
	 */
	public List<Role> loadShowRole();
	
	/**
	 * 根据rid查询角色信息
	 * @return
	 */
	public Role loadShowRoleRid(int rid);
	
	/**
	 * 查询角色用户
	 */
	public List<Object[]> showRoleUser(int rid);
	
	/**
	 * 修改角色用户
	 * @param rid
	 * @param userName
	 */
	public void loadAlterRole(int rid,String[] urid);
	
	/**
	 * 查询角色用户
	 */
	public List<Object[]> showMenuName(int rid);
	
	/**
	 * 修改角色权限
	 * @param rid
	 * @param s
	 */
	public void loadAlterMenu(int rid,String[] mName);
	
	/**
	 * 过滤
	 * @param newPath
	 * @param uid
	 * @return
	 */
	public boolean goFilter(String newPath,int uid);

}
