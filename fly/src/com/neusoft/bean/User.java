package com.neusoft.bean;

public class User {

	private int id;//用户id
	private String email;//邮箱
	private String nickName;//昵称
	private String city;//所在城市
	private int sex;//性别  默认男
	private String headUrl;//头像
	private String password;//密码
	private String signName;//签名
	private int kissNum;//飞吻数  默认100
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public int getKissNum() {
		return kissNum;
	}
	public void setKissNum(int kissNum) {
		this.kissNum = kissNum;
	}
	
	
	
}
