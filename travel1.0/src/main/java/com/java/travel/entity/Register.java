package com.java.travel.entity;

public class Register {
    private Integer REGISTERID;

    private String NICKNAME;

    private String PASSWORD;

    public Integer getREGISTERID() {
        return REGISTERID;
    }

    public void setREGISTERID(Integer REGISTERID) {
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

	@Override
	public String toString() {
		return "Register [REGISTERID=" + REGISTERID + ", NICKNAME=" + NICKNAME + ", PASSWORD=" + PASSWORD + "]";
	}

	public Register(Integer rEGISTERID, String nICKNAME, String pASSWORD) {
		super();
		REGISTERID = rEGISTERID;
		NICKNAME = nICKNAME;
		PASSWORD = pASSWORD;
	}
	
	public Register() {
		// TODO Auto-generated constructor stub
	}
    
}