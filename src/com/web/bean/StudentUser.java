package com.web.bean;


import java.io.Serializable;

public class StudentUser implements Serializable{
	//id 主键
	private int sid;
	//学生名字
	private String name;
	//年龄
	private int age;
	//性别
	private int sex;
	//班级
	private int cid;
	
	private String times;
	
	public StudentUser() {}

	public StudentUser(int sid, String name, int age, int sex, int cid,String times) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.cid = cid;
		this.times = times;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	
	
	
	
	

	
	
	
}
