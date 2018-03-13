package com.example.faithhopelove.bean;
/*
 成员的bean类
 */
public class Person {
	
	public Person(){
	}
	
	private String id;
	private String name;
	private String phone;
	private String sex;
	private String birth;
	private String job;
	private String address;
	private boolean ismarried;
	private boolean baptism;
	private int groupid;
	private String groupname;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public boolean isIsmarried() {
		return ismarried;
	}
	
	public void setIsmarried(Integer ismarried) {
	    if(ismarried.equals(1))
	    	this.ismarried = true;
	    else 
	    	this.ismarried  = false;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getBaptism() {
		return baptism;
	}
	public void setBaptism(Boolean baptism) {
		this.baptism = baptism;
	}
	
	public int getGroup() {
		return groupid;
	}

	public void setGroup(int group) {
		this.groupid = group;
	}
	
	

	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Override
	public String toString() {
		return "id:" +id + "name"+ name + "phone" + phone + "sex" + sex +"birth" + birth+"job"+ job+"ismarried:"+ismarried+"address"+address+"baptism" + baptism+" groupid: " + groupid +" groupname:" + groupname;
	}
	
	
	
}
