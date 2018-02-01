package com.java.travel.token;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

public class UserNamePasswordTelphoneToken extends UsernamePasswordToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4812793519945855483L;

	// �ֻ�����
	private String telphoneNum;

	/**
	 * ��дgetPrincipal����
	 */
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		// �����ȡ���û������򷵻��û��������򷵻ص绰����
		if (telphoneNum == null) {
			return getUsername();
		} else {
			return getTelphoneNum();
		}
	}

	/**
	 * ��дgetCredentials����
	 */
	public Object getCredentials() {
		// TODO Auto-generated method stub
		// �����ȡ�����룬�򷵻����룬���򷵻�null
		if (telphoneNum == null) {
			return getPassword();
		} else {
			return "ok";
		}
	}

	public UserNamePasswordTelphoneToken() {
		// TODO Auto-generated constructor stub
	}

	public UserNamePasswordTelphoneToken(final String telphoneNum) {
		// TODO Auto-generated constructor stub
		this.telphoneNum = telphoneNum;
	}

	public UserNamePasswordTelphoneToken(final String userName, final String password) {
		// TODO Auto-generated constructor stub
		super(userName, password);
	}

	public String getTelphoneNum() {
		return telphoneNum;
	}

	public void setTelphoneNum(String telphoneNum) {
		this.telphoneNum = telphoneNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TelphoneToken [telphoneNum=" + telphoneNum + "]";
	}

}
