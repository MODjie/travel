package com.java.travel.token;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationToken;

public class TelphoneToken implements Serializable,  AuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4812793519945855483L;
	
	//ÊÖ»úºÅÂë
	private String telphoneNum;
	
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return telphoneNum;
	}

	public Object getCredentials() {
		// TODO Auto-generated method stub
		return "xx";
	}
	
	public TelphoneToken() {
		// TODO Auto-generated constructor stub
	}
	
	public TelphoneToken(String telphoneNum) {
		// TODO Auto-generated constructor stub
		this.telphoneNum = telphoneNum;
	}
}
