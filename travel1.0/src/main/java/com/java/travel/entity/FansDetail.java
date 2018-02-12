package com.java.travel.entity;

public class FansDetail extends Fans {
	private String HEADADDRESS;

	public String getHEADADDRESS() {
		return HEADADDRESS;
	}

	public void setHEADADDRESS(String hEADADDRESS) {
		HEADADDRESS = hEADADDRESS;
	}

	@Override
	public String toString() {
		return "FansDetail [HEADADDRESS=" + HEADADDRESS + "]";
	}

	public FansDetail(Integer fANSID, String mYNAME, String mYFANSNAME, String hEADADDRESS) {
		super(fANSID, mYNAME, mYFANSNAME);
		HEADADDRESS = hEADADDRESS;
	}
	
	public FansDetail() {
		// TODO Auto-generated constructor stub
	}
}
