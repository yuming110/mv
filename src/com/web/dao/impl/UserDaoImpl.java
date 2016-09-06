package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;



import com.web.bean.ClassUser;
import com.web.bean.Menu;
import com.web.bean.Page;
import com.web.bean.Role;
import com.web.bean.StudentUser;
import com.web.bean.User;
import com.web.dao.UserDao;
import com.web.ov.VoMenu;
import com.web.util.DBUtil;

public class UserDaoImpl implements UserDao {
	/**
	 * 通过用户名加载一个对象
	 * userName 用户输入的账号
	 * 返回null表示
	 */
	@Override
	public User loadUserByName(String userName) {
		String sql = "select*from user where userName=?";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{userName});
		User user = null;
		if(list.size()>0&&list!=null){
			Object[] os = list.get(0);
			user = new User((Integer)os[0], userName, String.valueOf(os[2]), (Integer)os[3], (String)os[4], (Integer)os[5], (String)os[6], (String)os[7]);
		}
		
		
		return user;
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> loadAllData() {
		
		String sql = "select*from user ";
		List<Object[]> list = DBUtil.executeQurry(sql, null);
		List<User> userList = new ArrayList<User>();
		User user = null;
		if(list!=null&&list.size()>0){
			for(Object[] os : list){
				user = new User((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (String)os[4], (Integer)os[5], (String)os[6], (String)os[7]); 
				userList.add(user);
			}
		}
		
		return userList;
	}

	/**
	 * 删除数据
	 */
	@Override
	public void loaddeleteData(int uid) {
		
		String sql = "delete from user where uid=? ";
		DBUtil.executeDML(sql, new Object[]{uid});
		sql="select *from user";
		List<Object[]> o=DBUtil.executeQurry(sql, null);
		
		
	}
	/**
	 * 查看个人用户
	 */
	@Override
	public List<User> loadsShowUser(String uid) {
		String sql = "select*from user where uid=? ";
		System.out.println(uid);
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{uid});
		List<User> userList = new ArrayList<User>();
		User user = null;
		if(list!=null&&list.size()>0){
			Object[] os = list.get(0);
			user = new User((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (String)os[4], (Integer)os[5], (String)os[6], (String)os[7]);
			userList.add(user);
		}
		return userList;
	}
	/**
	 * 注册
	 */
	@Override
	public boolean regData(String userName,String userPass,String sex,
			String email,String education,String[] hobbys,String introduction) {
		String hobby = "";
		if(hobbys != null && hobbys.length>0){
			for(String s : hobbys){
				hobby += s+",";
			}
		}
		if(hobby.endsWith(",")) 
			hobby = hobby.substring(0, hobby.length()-1);
		
		
		boolean b =true;
		String sql = "select*from user where userName=?";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{userName});
		System.out.println(userName);
		if(list.size()>0){
			b=false;
		}else{
			String sql1 = "insert into user(userName,userPass,email,sex,hobby,education,introduction) values(?,?,?,?,?,?,?)";
		    DBUtil.executeDML(sql1,new Object[]{userName,userPass,email,sex,hobby,education,introduction} );
		}
		return b;
		
	}
    /**
     * 用户权限管理
     */
	@Override
	public List<Menu> loadUserByUid(int uid) {
		
		String sql = "select  m.* from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and m.isshow=1 and ur.uid=? " ;
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{uid});
		
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		
		if(list.size() > 0 && list != null){
			
			for(Object[] os : list){
				menu = new Menu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (Integer)os[5]); 
				
				menuList.add(menu);
			}
		}
		return 	menuList;
	}
	
	/**
	 * 班级列表
	 */
	@Override
	public List<ClassUser> showClass() {
		String sql = "select*from class order by times desc";
		List<Object[]> list = DBUtil.executeQurry(sql, null);
		List<ClassUser> classList = new ArrayList<ClassUser>();
		ClassUser cu = null;
		if(list.size()>0&&list!=null){
			for(Object[] os : list){
				cu = new ClassUser((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[1])); 
				classList.add(cu);
			}
		}
		
		return classList;
	}
	/**
	 * 学生列表
	 */
	@Override
	public List<StudentUser> showStudent() {
		String sql = "select * from student order by times desc";
		List<Object[]> list = DBUtil.executeQurry(sql, null);
		List<StudentUser> studentList = new ArrayList<StudentUser >();
		StudentUser st = null;
		if(list.size()>0&&list!=null){
			for(Object[] os : list){
				st = new StudentUser((Integer)os[0], String.valueOf(os[1]), (Integer)os[2],(Integer)os[3],(Integer)os[4],String.valueOf(os[5])); 
				studentList.add(st);
			}
		}
		
		return studentList;
	}
	/**
	 * 添加班级
	 */
	public List<ClassUser> addClass(String name){
		String sql = "select * from ClassUser where name=?";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{name});
		List<ClassUser> addList = new ArrayList<ClassUser>();
		ClassUser c= null;
		if( null != list && list.size()>0){
			for(Object[] o : list){
				c = new ClassUser((Integer)o[0],String.valueOf(o[1]), String.valueOf(o[2]));
				addList.add(c);
			}
		}	
		return addList;
		
	}
	
	/**
	 * 菜单列表
	 */
	public Page<VoMenu> loadShowVoMenu(int pageNo,int pageSize) {
		
		String sql = "select m.mid,m.name,m.url,m.isshow,m.level,(select m2.name from menu m2 where m.parentid=m2.mid) from menu m  limit ?,?";
		List<Object[]> list = DBUtil.executeQurry(sql, new Object[]{(pageNo-1)*pageSize,pageSize});
		List<VoMenu> voMenuList = new ArrayList<VoMenu>();
		VoMenu voMenu = null;
		if(list!=null&&list.size()>0){
			for(Object[] os : list){
				voMenu = new VoMenu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3],(Integer)os[4],String.valueOf(os[5])); 
				voMenuList.add(voMenu);
			}
		} 
		sql="select count(*) from menu";
		list = DBUtil.executeQurry(sql,null);
		long total=(Long)list.get(0)[0];
		return new Page<VoMenu>(pageNo,pageSize,voMenuList,total);
	}
	/**
	 * 查询1.2级菜单
	 */
	@Override
	public List<Menu> loadAdd12JMenu() {
		String sql = "select * from menu where level in(1,2)";
		List<Object[]> list = DBUtil.executeQurry(sql, null);
		List<Menu> menu12List = new ArrayList<Menu>();
		Menu menu = null;
		if(list!=null&&list.size()>0){
			for(Object[] os : list){
				menu = new Menu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (Integer)os[5]);
				menu12List.add(menu);
			}
		}
		return menu12List;
	}
	/**
	 * 添加
	 */
	@Override
	public void loadAddMenu(String name,String url,int isshow,int parentid) {
		
		String sql = "select level from menu where mid=?";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{parentid});
		Object[] o = list.get(0);
		
		sql = "insert into menu(name,url,isshow,level,parentid) values(?,?,?,?,?)";
		
		DBUtil.executeDML(sql,new Object[]{name,url,isshow,(Integer)o[0]+1,parentid} );
		}
		
	/**
	 * 权限管理角色列表
	 * @return
	 */
	public List<Role> loadShowRole(){
		String sql = "select * from role ";
		List<Object[]> list = DBUtil.executeQurry(sql, null);
		List<Role> roleList = new ArrayList<Role>();
		Role role = null;
		if(list!=null&&list.size()>0){
			for(Object[] os : list){
				role = new Role((Integer)os[0], String.valueOf(os[1])); 
				roleList.add(role);
			}
		}
		
		return roleList;
	}

	/**
	 * 根据rid查询角色信息
	 * @return
	 */
	public Role loadShowRoleRid(int rid){
		String sql = "select*from role where rid=? ";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{rid});
		Role role = null;
		if(list.size()>0&&list!=null){
			Object[] os = list.get(0);
			role = new Role(rid,String.valueOf(os[1]));
		}
		return role;
	}

	/**
	 * 查询角色用户
	 */
	public List<Object[]> showRoleUser(int rid){
		String sql = "select u.uid,u.userName,(select 1 from userrole ur where ur.uid=u.uid and ur.rid=?) from user u";
		List<Object[]> uList = DBUtil.executeQurry(sql,new Object[]{rid});
		return uList;
	}
	
	/**
	 * 修改角色用户
	 * @param rid
	 * @param userName
	 */
	public void loadAlterRole(int rid,String[] urid){
		String sql = "delete from userrole where rid=?";
		DBUtil.executeDML(sql, new Object[]{rid});
		
		sql = "insert into userrole(uid,rid) values(?,?)";
		for(String urids:urid){
			DBUtil.executeDML(sql, new Object[]{urids,rid});
		}
		
	}
	
	/**
	 * 查询菜单
	 */
	public List<Object[]> showMenuName(int rid){
		String sql = "select m.mid,m.name,(select 1 from rolemenu rm where rm.mid=m.mid and rm.rid=?) from menu m";
		
		return DBUtil.executeQurry(sql, new Object[]{rid});
		
	}
	
	/**
	 * 修改角色权限
	 * @param rid
	 * @param s
	 */		
	public void loadAlterMenu(int rid,String[] mName){
		String sql = "delete from rolemenu where rid=?";
		DBUtil.executeDML(sql, new Object[]{rid});
		
		sql = "insert into rolemenu(rid,mid) values(?,?)";
		for(String mNames:mName){
			DBUtil.executeDML(sql, new Object[]{rid,mNames});
		}
	}
	
	/**
	 * 过滤
	 * @param newPath
	 * @param uid
	 * @return
	 */
	public boolean goFilter(String newPath,int uid){
		//查询数据库，此用户是否拥有相应菜单的访问权限
		String sql="select m.* from userrole u,rolemenu r,menu m where u.rid=r.rid and r.mid=m.mid and u.uid=? and m.url like ?";
		List<Object[]> list=DBUtil.executeQurry(sql,new Object[]{uid,"%"+newPath+"%"});
		System.out.println("这是权限过滤的长度"+list.size());
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	
}
