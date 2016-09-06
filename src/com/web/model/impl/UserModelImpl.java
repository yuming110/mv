package com.web.model.impl;

import java.util.List;

import com.web.bean.ClassUser;
import com.web.bean.Menu;
import com.web.bean.Page;
import com.web.bean.Role;
import com.web.bean.StudentUser;
import com.web.bean.User;
import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;

import com.web.model.UserModel;
import com.web.ov.VoMenu;

public class UserModelImpl implements UserModel {
	
	 private UserDao userDao = new UserDaoImpl();
	 /**
	  * 登录
	  */
	@Override
	public User loadUserByName(String userName) {
		
		return userDao.loadUserByName(userName);
	
	 
	}
	/**
	 * 查询数据
	 */
	@Override
	public List<User> loadAllData() {
		return userDao.loadAllData();
	}
	/**
	 * 删除数据
	 */
	@Override
	public void loaddeleteData(int uid) {
		userDao.loaddeleteData(uid);
	}
	
	/**
	 * 查看数据
	 */
	@Override
	public List<User> loadsShowUser(String uid) {
		return userDao.loadsShowUser(uid);
	}
	/**
	 * 注册
	 * @return
	 */
	public boolean regData(String userName,String userPass,String sex,
			String email,String education,String[] hobbys,String introduction){
		return userDao.regData(userName, userPass, sex, email, education, hobbys, introduction) ;
	}
	
	/**
	 * 班级列表
	 */
	@Override
	public List<ClassUser> showClass() {
		return userDao.showClass();
	}
	/**
	 * 学生列表
	 */
	@Override
	public List<StudentUser> showStudent() {
		return userDao.showStudent();
	}
	
	/**
	 * 添加班级
	 */
	@Override
	public List<ClassUser> addClass(String name) {
		return null;
	}
	 
	
	@Override
	public List<Menu> loadUserByUid(int uid) {
		return userDao.loadUserByUid(uid);
	}
	@Override
	public Page<VoMenu> loadShowVoMenu(int pageNo,int pageSize) {
		return userDao.loadShowVoMenu(pageNo,pageSize);
	}
	
	@Override
	public List<Menu> loadAdd12JMenu() {
		return userDao.loadAdd12JMenu();
	}
	@Override
	public void loadAddMenu(String name, String url, int isshow, int parentid) {
		userDao.loadAddMenu(name, url, isshow, parentid);
	}
	
	/**
	 * 权限管理角色列表
	 * @return
	 */
	public List<Role> loadShowRole(){
		return userDao.loadShowRole();
	}
	
	/**
	 * 根据rid查询角色信息
	 * @return
	 */
	public Role loadShowRoleRid(int rid){
		return userDao.loadShowRoleRid(rid);
	}
	
	/**
	 * 查询角色用户
	 */
	public List<Object[]> showRoleUser(int rid){
		return userDao.showRoleUser(rid);
	}
	
	/**
	 * 修改角色用户
	 * @param rid
	 * @param userName
	 */
	public void loadAlterRole(int rid,String[] urid){
		userDao.loadAlterRole(rid, urid);
	}
	
	/**
	 * 查询角色用户
	 */
	public List<Object[]> showMenuName(int rid){
		return userDao.showMenuName(rid);
	}
	
	/**
	 * 修改角色权限
	 * @param rid
	 * @param s
	 */
	public void loadAlterMenu(int rid,String[] mName){
		userDao.loadAlterMenu(rid, mName);
	}
	
	/**
	 * 过滤
	 * @param newPath
	 * @param uid
	 * @return
	 */
	public boolean goFilter(String newPath,int uid){
		return userDao.goFilter(newPath, uid);
	}
}
