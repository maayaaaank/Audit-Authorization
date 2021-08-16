package com.cognizant.auditauthentication.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class JwtResponse implements Serializable {

	@ApiModelProperty(name = "serialVersionUID", notes = "Serial Version UID")
	private static final long serialVersionUID = -8091879091924046844L;

	@ApiModelProperty(notes = "JWT Token", name = "jwttoken")
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}