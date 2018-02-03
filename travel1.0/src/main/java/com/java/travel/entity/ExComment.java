package com.java.travel.entity;

public class ExComment {
    private Integer COMMENTID;

    private Integer EXPRIENCEID;

    private String USERANAME;

    private String COMMENTCONTENRT;

    private String COMMENTTIME;

    public Integer getCOMMENTID() {
        return COMMENTID;
    }

    public void setCOMMENTID(Integer COMMENTID) {
        this.COMMENTID = COMMENTID;
    }

    public Integer getEXPRIENCEID() {
        return EXPRIENCEID;
    }

    public void setEXPRIENCEID(Integer EXPRIENCEID) {
        this.EXPRIENCEID = EXPRIENCEID;
    }

    public String getUSERANAME() {
        return USERANAME;
    }

    public void setUSERANAME(String USERANAME) {
        this.USERANAME = USERANAME == null ? null : USERANAME.trim();
    }

    public String getCOMMENTCONTENRT() {
        return COMMENTCONTENRT;
    }

    public void setCOMMENTCONTENRT(String COMMENTCONTENRT) {
        this.COMMENTCONTENRT = COMMENTCONTENRT == null ? null : COMMENTCONTENRT.trim();
    }

    public String getCOMMENTTIME() {
        return COMMENTTIME;
    }

    public void setCOMMENTTIME(String COMMENTTIME) {
        this.COMMENTTIME = COMMENTTIME == null ? null : COMMENTTIME.trim();
    }

	@Override
	public String toString() {
		return "ExComment [COMMENTID=" + COMMENTID + ", EXPRIENCEID=" + EXPRIENCEID + ", USERANAME=" + USERANAME
				+ ", COMMENTCONTENRT=" + COMMENTCONTENRT + ", COMMENTTIME=" + COMMENTTIME + "]";
	}

	public ExComment(Integer cOMMENTID, Integer eXPRIENCEID, String uSERANAME, String cOMMENTCONTENRT,
			String cOMMENTTIME) {
		super();
		COMMENTID = cOMMENTID;
		EXPRIENCEID = eXPRIENCEID;
		USERANAME = uSERANAME;
		COMMENTCONTENRT = cOMMENTCONTENRT;
		COMMENTTIME = cOMMENTTIME;
	}
    
    public ExComment() {
		// TODO Auto-generated constructor stub
	}
}