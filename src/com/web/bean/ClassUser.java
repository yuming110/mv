package com.web.bean;


import java.io.Serializable;

public class ClassUser implements Serializable{
	//id 主键
	private int cid;
	//班级
	private String name;
	
	private String times;
	
	
	
	public ClassUser() {}
	
	public ClassUser(int cid, String name,String times) {
		super();
		this.cid = cid;
		this.name = name;
		this.times=times;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	

	
	
	
}
