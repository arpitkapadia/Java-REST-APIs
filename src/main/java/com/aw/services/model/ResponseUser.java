package com.aw.services.model;

public class ResponseUser {
	
	User user;
	String message;
	boolean success;
	
	
	public ResponseUser(User u, boolean s, String m) {
		user = u;
		message = m;
		success = s;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
