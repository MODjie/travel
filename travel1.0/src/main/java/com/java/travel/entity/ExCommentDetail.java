package com.java.travel.entity;


public class ExCommentDetail extends ExComment {
	private String HEADADDRESS;

	public String getHEADADDRESS() {
		return HEADADDRESS;
	}

	public void setHEADADDRESS(String HEADADDRESS) {
		this.HEADADDRESS = HEADADDRESS;
	}

	@Override
	public String toString() {
		return "ExCommentDetail [HEADADDRESS=" + HEADADDRESS + "]";
	}

	public ExCommentDetail(Integer cOMMENTID, Integer eXPRIENCEID, String uSERANAME, String cOMMENTCONTENRT,
			String cOMMENTTIME, String HEADADDRESS) {
		super(cOMMENTID, eXPRIENCEID, uSERANAME, cOMMENTCONTENRT, cOMMENTTIME);
		this.HEADADDRESS = HEADADDRESS;
	}
	
	public ExCommentDetail() {
		// TODO Auto-generated constructor stub
	}
}
