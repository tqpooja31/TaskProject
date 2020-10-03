package com.pr.pojo;

import java.util.Date;

public class task {
	
	private int tid;
	private String tname,desc,status;
	private int sid;
	private Date Tdate = new Date();
	private String email;
	
	public task() {
		
//		this.tid = tid;
//		this.tname = tname;
//		this.desc = desc;
//		this.status = status;
//		this.Tdate = Tdate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getTdate() {
		return Tdate;
	}
	public void setTdate(Date tdate) {
		Tdate = tdate;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "task [tid=" + tid + ", tname=" + tname + ", desc=" + desc + ", status=" + status + ", sid=" + sid
				+ ", Tdate=" + Tdate + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
}
