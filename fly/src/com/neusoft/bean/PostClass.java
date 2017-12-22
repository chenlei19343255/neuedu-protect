package com.neusoft.bean;

public class PostClass {

	private int id;
	private String pname;

	public PostClass() {

	}

	public PostClass(int id, String pname) {
		super();
		this.id = id;
		this.pname = pname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
