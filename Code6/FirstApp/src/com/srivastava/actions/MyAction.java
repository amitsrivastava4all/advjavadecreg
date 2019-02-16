package com.srivastava.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MyAction extends ActionSupport implements ModelDriven<UserModel>, SessionAware, ServletRequestAware{ //implements Action {
//	private String userid;
//	private String pwd;
//	private String message;
	private UserModel user = new UserModel();
	
	private Map<String,Object> sessionMap;
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public void validate(){
		System.out.println("::::::::User is :::::: "+user.getUserid());
		if(user.getUserid().trim().length()==0){
			addFieldError("userid", getText("userid.error"));
		}
		if(user.getPwd().trim().length()==0){
			addFieldError("pwd", getText("password.error"));
		}
		else
		if(user.getPwd().trim().length()<8){
			addFieldError("pwd", getText("password.lenerror"));
		}
	}

	public String loadLogin(){
		return SUCCESS;
	}
	
	public String doLogin(){
		if(user.getUserid().equals(user.getPwd())){
			user.setMessage("Welcome "+user.getUserid());
			sessionMap.put("userid", user.getUserid());
		}
		else{
			user.setMessage("Invalid Userid or Password");
		}
		return "welcome";
	}
//	public String getUserid() {
//		return userid;
//	}
//
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}

//	public String getMessage() {
//		return message;
//	}
	@Override
	public String execute(){
		user.setMessage("Hello Struts 2");
		return SUCCESS;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}

	@Override
	public UserModel getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap = session;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
}
