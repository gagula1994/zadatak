package com.zadatak.zadatak.jwt.model;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = 3368344629160152357L;
	private String username;
	private String password;
	
	public Request(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Request() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
