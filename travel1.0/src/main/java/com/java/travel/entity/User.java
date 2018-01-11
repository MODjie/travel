package com.java.travel.entity;

public class User {
    private Short USERID;

    private Short GROWTHLEVELID;

    private Short HOMEADDRESSID;

    private Short ROLEID;

    private Short REGISTERID;

    private Short AGE;

    private String HEADADDRESS;

    private String NICKNAME;

    private String MOOD;

    public Short getUSERID() {
        return USERID;
    }

    public void setUSERID(Short USERID) {
        this.USERID = USERID;
    }

    public Short getGROWTHLEVELID() {
        return GROWTHLEVELID;
    }

    public void setGROWTHLEVELID(Short GROWTHLEVELID) {
        this.GROWTHLEVELID = GROWTHLEVELID;
    }

    public Short getHOMEADDRESSID() {
        return HOMEADDRESSID;
    }

    public void setHOMEADDRESSID(Short HOMEADDRESSID) {
        this.HOMEADDRESSID = HOMEADDRESSID;
    }

    public Short getROLEID() {
        return ROLEID;
    }

    public void setROLEID(Short ROLEID) {
        this.ROLEID = ROLEID;
    }

    public Short getREGISTERID() {
        return REGISTERID;
    }

    public void setREGISTERID(Short REGISTERID) {
        this.REGISTERID = REGISTERID;
    }

    public Short getAGE() {
        return AGE;
    }

    public void setAGE(Short AGE) {
        this.AGE = AGE;
    }

    public String getHEADADDRESS() {
        return HEADADDRESS;
    }

    public void setHEADADDRESS(String HEADADDRESS) {
        this.HEADADDRESS = HEADADDRESS == null ? null : HEADADDRESS.trim();
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME == null ? null : NICKNAME.trim();
    }

    public String getMOOD() {
        return MOOD;
    }

    public void setMOOD(String MOOD) {
        this.MOOD = MOOD == null ? null : MOOD.trim();
    }
    
    public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Short uSERID, Short gROWTHLEVELID, Short hOMEADDRESSID, Short rOLEID, Short rEGISTERID, Short aGE,
			String hEADADDRESS, String nICKNAME, String mOOD) {
		super();
		USERID = uSERID;
		GROWTHLEVELID = gROWTHLEVELID;
		HOMEADDRESSID = hOMEADDRESSID;
		ROLEID = rOLEID;
		REGISTERID = rEGISTERID;
		AGE = aGE;
		HEADADDRESS = hEADADDRESS;
		NICKNAME = nICKNAME;
		MOOD = mOOD;
	}
    
    
}