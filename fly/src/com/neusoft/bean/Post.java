package com.neusoft.bean;

import java.util.Date;

public class Post {

	// id 标题 发帖时间 回复数 点击数
	private int pid;
	private String title;
	private Date startime;
	private int revert;
	private int click;
	private PostClass pcid;
	private String content;
	private String nickName;

	public Post() {

	}

	public Post(int pid, String title, Date startime, int revert, int click, PostClass pcid, String contetn,
			String nickName) {
		super();
		this.pid = pid;
		this.title = title;
		this.startime = startime;
		this.revert = revert;
		this.click = click;
		this.pcid = pcid;
		this.content = contetn;
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PostClass getPcid() {
		return pcid;
	}

	public void setPcid(PostClass pcid) {
		this.pcid = pcid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartime() {
		return startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public int getRevert() {
		return revert;
	}

	public void setRevert(int revert) {
		this.revert = revert;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

}
