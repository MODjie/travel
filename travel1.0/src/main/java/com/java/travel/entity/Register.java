package com.java.travel.entity;

public class Register {
    private Short REGISTERID;

    private String NICKNAME;

    private String PASSWORD;

    public Short getREGISTERID() {
        return REGISTERID;
    }

    public void setREGISTERID(Short REGISTERID) {
        this.REGISTERID = REGISTERID;
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME == null ? null : NICKNAME.trim();
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD == null ? null : PASSWORD.trim();
    }
    
    public Register() {
		// TODO Auto-generated constructor stub
	}

	public Register(Short rEGISTERID, String nICKNAME, String pASSWORD) {
		super();
		REGISTERID = rEGISTERID;
		NICKNAME = nICKNAME;
		PASSWORD = pASSWORD;
	}
    
    
}