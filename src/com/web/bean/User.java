package com.web.bean;


import java.io.Serializable;

public class User implements Serializable{
	//id 主键
	private int uid;
	//账号
	private String userName;
	//密码
	private String userPass;
	//性别
	private int sex;
	//邮箱
	private String email;
	//学历
	private int education;
	//爱好
	private String hobby;
	//简介
	private String introduction;

	
	
	public User() {}
	
	public User(int uid, String userName, String userPass, int sex,
			String email, int education, String hobby, String introduction) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userPass = userPass;
		this.sex = sex;
		this.email = email;
		this.education = education;
		this.hobby = hobby;
		this.introduction = introduction;
	}



	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
	
	
	
	
}
