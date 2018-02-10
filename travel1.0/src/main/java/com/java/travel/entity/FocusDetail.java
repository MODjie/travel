package com.java.travel.entity;

public class FocusDetail extends Focus {
	private String HEADADDRESS;

	
	
	public String getHEADADDRESS() {
		return HEADADDRESS;
	}

	public void setHEADADDRESS(String hEADADDRESS) {
		HEADADDRESS = hEADADDRESS;
	}

	@Override
	public String toString() {
		return "FocusDetail [HEADADDRESS=" + HEADADDRESS + "]";
	}

	public FocusDetail(Integer fOCUSID, String mYFFOCUS, String mYNAME, String hEADADDRESS) {
		super(fOCUSID, mYFFOCUS, mYNAME);
		HEADADDRESS = hEADADDRESS;
	}
	public FocusDetail() {
		// TODO Auto-generated constructor stub
	}
}
