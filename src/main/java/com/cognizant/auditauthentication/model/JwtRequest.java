package com.cognizant.auditauthentication.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest implements Serializable {
	@ApiModelProperty(notes = "serialVersionUID", name = "serialVersionUID")
	private static final long serialVersionUID = 5926468583005150707L;

	@ApiModelProperty(notes = "Username", name = "userName")
	private String userName;
	@ApiModelProperty(notes = "Password", name = "password")
	private String password;

	public JwtRequest() {

	}

	public JwtRequest(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}
}