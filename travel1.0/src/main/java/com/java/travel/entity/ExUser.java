package com.java.travel.entity;

public class ExUser {
    private Integer USERID;

    private Integer ROLEID;

    private Integer AGE;

    private String HEADADDRESS;

    private String NICKNAME;

    private String MOOD;

    private String TEL;

    private String EMAIL;

    private Integer GROWTHVALUE;

    private Integer TODAYVALUE;

    private Integer NORMALLEVEL;

    private Integer DAYVALLIMIT;

    private String PROVINCE;

    private String CITY;

    private String COUNTY;

    private String PASSWORD;

    private String REGISTERTIME;

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public Integer getROLEID() {
        return ROLEID;
    }

    public void setROLEID(Integer ROLEID) {
        this.ROLEID = ROLEID;
    }

    public Integer getAGE() {
        return AGE;
    }

    public void setAGE(Integer AGE) {
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

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL == null ? null : TEL.trim();
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    public Integer getGROWTHVALUE() {
        return GROWTHVALUE;
    }

    public void setGROWTHVALUE(Integer GROWTHVALUE) {
        this.GROWTHVALUE = GROWTHVALUE;
    }

    public Integer getTODAYVALUE() {
        return TODAYVALUE;
    }

    public void setTODAYVALUE(Integer TODAYVALUE) {
        this.TODAYVALUE = TODAYVALUE;
    }

    public Integer getNORMALLEVEL() {
        return NORMALLEVEL;
    }

    public void setNORMALLEVEL(Integer NORMALLEVEL) {
        this.NORMALLEVEL = NORMALLEVEL;
    }

    public Integer getDAYVALLIMIT() {
        return DAYVALLIMIT;
    }

    public void setDAYVALLIMIT(Integer DAYVALLIMIT) {
        this.DAYVALLIMIT = DAYVALLIMIT;
    }

    public String getPROVINCE() {
        return PROVINCE;
    }

    public void setPROVINCE(String PROVINCE) {
        this.PROVINCE = PROVINCE == null ? null : PROVINCE.trim();
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY == null ? null : CITY.trim();
    }

    public String getCOUNTY() {
        return COUNTY;
    }

    public void setCOUNTY(String COUNTY) {
        this.COUNTY = COUNTY == null ? null : COUNTY.trim();
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD == null ? null : PASSWORD.trim();
    }

    public String getREGISTERTIME() {
        return REGISTERTIME;
    }

    public void setREGISTERTIME(String REGISTERTIME) {
        this.REGISTERTIME = REGISTERTIME == null ? null : REGISTERTIME.trim();
    }

	public ExUser(Integer uSERID, Integer rOLEID, Integer aGE, String hEADADDRESS, String nICKNAME, String mOOD,
			String tEL, String eMAIL, Integer gROWTHVALUE, Integer tODAYVALUE, Integer nORMALLEVEL, Integer dAYVALLIMIT,
			String pROVINCE, String cITY, String cOUNTY, String pASSWORD, String rEGISTERTIME) {
		super();
		USERID = uSERID;
		ROLEID = rOLEID;
		AGE = aGE;
		HEADADDRESS = hEADADDRESS;
		NICKNAME = nICKNAME;
		MOOD = mOOD;
		TEL = tEL;
		EMAIL = eMAIL;
		GROWTHVALUE = gROWTHVALUE;
		TODAYVALUE = tODAYVALUE;
		NORMALLEVEL = nORMALLEVEL;
		DAYVALLIMIT = dAYVALLIMIT;
		PROVINCE = pROVINCE;
		CITY = cITY;
		COUNTY = cOUNTY;
		PASSWORD = pASSWORD;
		REGISTERTIME = rEGISTERTIME;
	}

	@Override
	public String toString() {
		return "ExUser [USERID=" + USERID + ", ROLEID=" + ROLEID + ", AGE=" + AGE + ", HEADADDRESS=" + HEADADDRESS
				+ ", NICKNAME=" + NICKNAME + ", MOOD=" + MOOD + ", TEL=" + TEL + ", EMAIL=" + EMAIL + ", GROWTHVALUE="
				+ GROWTHVALUE + ", TODAYVALUE=" + TODAYVALUE + ", NORMALLEVEL=" + NORMALLEVEL + ", DAYVALLIMIT="
				+ DAYVALLIMIT + ", PROVINCE=" + PROVINCE + ", CITY=" + CITY + ", COUNTY=" + COUNTY + ", PASSWORD="
				+ PASSWORD + ", REGISTERTIME=" + REGISTERTIME + "]";
	}
    public ExUser() {
		// TODO Auto-generated constructor stub
	}
}