package com.java.travel.entity;

public class ExReplyDetail extends ExReply {
	private String HEADADDRESS;

	public String getHEADADDRESS() {
		return HEADADDRESS;
	}

	public void setHEADADDRESS(String hEADADDRESS) {
		HEADADDRESS = hEADADDRESS;
	}

	@Override
	public String toString() {
		return "ExReplyDetail [HEADADDRESS=" + HEADADDRESS + "]";
	}

	public ExReplyDetail(String hEADADDRESS) {
		super();
		HEADADDRESS = hEADADDRESS;
	}

	public ExReplyDetail() {

	}
}
