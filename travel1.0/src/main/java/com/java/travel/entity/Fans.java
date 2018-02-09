package com.java.travel.entity;

public class Fans {
    private Integer FANSID;

    private String MYNAME;

    private String MYFANSNAME;

    public Integer getFANSID() {
        return FANSID;
    }

    public void setFANSID(Integer FANSID) {
        this.FANSID = FANSID;
    }

    public String getMYNAME() {
        return MYNAME;
    }

    public void setMYNAME(String MYNAME) {
        this.MYNAME = MYNAME == null ? null : MYNAME.trim();
    }

    public String getMYFANSNAME() {
        return MYFANSNAME;
    }

    public void setMYFANSNAME(String MYFANSNAME) {
        this.MYFANSNAME = MYFANSNAME == null ? null : MYFANSNAME.trim();
    }

	@Override
	public String toString() {
		return "Fans [FANSID=" + FANSID + ", MYNAME=" + MYNAME + ", MYFANSNAME=" + MYFANSNAME + "]";
	}

	public Fans(Integer fANSID, String mYNAME, String mYFANSNAME) {
		super();
		FANSID = fANSID;
		MYNAME = mYNAME;
		MYFANSNAME = mYFANSNAME;
	}
    public Fans() {
		// TODO Auto-generated constructor stub
	}
}