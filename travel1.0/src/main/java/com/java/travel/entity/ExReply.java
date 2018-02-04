package com.java.travel.entity;

public class ExReply {
    private Integer REPLYID;

    private Integer COMMENTID;

    private String REPLYUSERANAME;

    private String REPLYCONTENT;

    private String REPLYTIME;

    private String REPLYUSERBNAME;

    public Integer getREPLYID() {
        return REPLYID;
    }

    public void setREPLYID(Integer REPLYID) {
        this.REPLYID = REPLYID;
    }

    public Integer getCOMMENTID() {
        return COMMENTID;
    }

    public void setCOMMENTID(Integer COMMENTID) {
        this.COMMENTID = COMMENTID;
    }

    public String getREPLYUSERANAME() {
        return REPLYUSERANAME;
    }

    public void setREPLYUSERANAME(String REPLYUSERANAME) {
        this.REPLYUSERANAME = REPLYUSERANAME == null ? null : REPLYUSERANAME.trim();
    }

    public String getREPLYCONTENT() {
        return REPLYCONTENT;
    }

    public void setREPLYCONTENT(String REPLYCONTENT) {
        this.REPLYCONTENT = REPLYCONTENT == null ? null : REPLYCONTENT.trim();
    }

    public String getREPLYTIME() {
        return REPLYTIME;
    }

    public void setREPLYTIME(String REPLYTIME) {
        this.REPLYTIME = REPLYTIME == null ? null : REPLYTIME.trim();
    }

    public String getREPLYUSERBNAME() {
        return REPLYUSERBNAME;
    }

    public void setREPLYUSERBNAME(String REPLYUSERBNAME) {
        this.REPLYUSERBNAME = REPLYUSERBNAME == null ? null : REPLYUSERBNAME.trim();
    }

	@Override
	public String toString() {
		return "ExReply [REPLYID=" + REPLYID + ", COMMENTID=" + COMMENTID + ", REPLYUSERANAME=" + REPLYUSERANAME
				+ ", REPLYCONTENT=" + REPLYCONTENT + ", REPLYTIME=" + REPLYTIME + ", REPLYUSERBNAME=" + REPLYUSERBNAME
				+ "]";
	}

	public ExReply(Integer rEPLYID, Integer cOMMENTID, String rEPLYUSERANAME, String rEPLYCONTENT, String rEPLYTIME,
			String rEPLYUSERBNAME) {
		super();
		REPLYID = rEPLYID;
		COMMENTID = cOMMENTID;
		REPLYUSERANAME = rEPLYUSERANAME;
		REPLYCONTENT = rEPLYCONTENT;
		REPLYTIME = rEPLYTIME;
		REPLYUSERBNAME = rEPLYUSERBNAME;
	}
    public ExReply() {
		// TODO Auto-generated constructor stub
	}
}