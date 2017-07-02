package com.rsuser.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class UserRegDto {
	@NotEmpty(message = "*Please provide your username")
	@Length(min = 6, message = "too_little")
	private String accountid;
	
	@Length(min = 6, message = "*Your password must have at least 6 characters")
	@NotEmpty(message = "*Please provide your password")
	private String setpw;
	
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")	
	private String email;

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getSetpw() {
		return setpw;
	}

	public void setSetpw(String setpw) {
		this.setpw = setpw;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
