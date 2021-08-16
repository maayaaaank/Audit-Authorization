package com.cognizant.auditauthentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "User ID", name = "id")
	private int id;

	@ApiModelProperty(notes = "Username", name = "userName")
	private String userName;

	@ApiModelProperty(notes = "Password", name = "password")
	private String password;

}
