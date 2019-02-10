package com.srivastava.actions;

public class MyAction {
	private String userid;
	private String pwd;
	private String message;

	public String doLogin(){
		if(this.getUserid().equals(this.getPwd())){
			this.setMessage("Welcome "+this.getUserid());
		}
		else{
			this.setMessage("Invalid Userid or Password");
		}
		return "welcome";
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMessage() {
		return message;
	}
	
	public String execute(){
		setMessage("Hello Struts 2");
		return "success";
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
