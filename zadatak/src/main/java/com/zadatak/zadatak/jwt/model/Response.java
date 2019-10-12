package com.zadatak.zadatak.jwt.model;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = -4089270921629971763L;
	private final String token;
	public Response(String token) {
		super();
		this.token = token;
	}
	public String getToken() {
		return token;
	}

}
