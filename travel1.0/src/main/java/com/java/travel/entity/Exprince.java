package com.java.travel.entity;

import java.util.Date;

public class Exprince {
    private Short EXPRIENCEID;

    private Short EXTYPEID;

    private String EXTITLE;

    private String EXAUTHORNAME;

    private String EXCONTENT;

    private Date EXPUBLISHTIME;

    private String TRAVELADDRES;

    private String EXCOVER;

    public Short getEXPRIENCEID() {
        return EXPRIENCEID;
    }

    public void setEXPRIENCEID(Short EXPRIENCEID) {
        this.EXPRIENCEID = EXPRIENCEID;
    }

    public Short getEXTYPEID() {
        return EXTYPEID;
    }

    public void setEXTYPEID(Short EXTYPEID) {
        this.EXTYPEID = EXTYPEID;
    }

    public String getEXTITLE() {
        return EXTITLE;
    }

    public void setEXTITLE(String EXTITLE) {
        this.EXTITLE = EXTITLE == null ? null : EXTITLE.trim();
    }

    public String getEXAUTHORNAME() {
        return EXAUTHORNAME;
    }

    public void setEXAUTHORNAME(String EXAUTHORNAME) {
        this.EXAUTHORNAME = EXAUTHORNAME == null ? null : EXAUTHORNAME.trim();
    }

    public String getEXCONTENT() {
        return EXCONTENT;
    }

    public void setEXCONTENT(String EXCONTENT) {
        this.EXCONTENT = EXCONTENT == null ? null : EXCONTENT.trim();
    }

    public Date getEXPUBLISHTIME() {
        return EXPUBLISHTIME;
    }

    public void setEXPUBLISHTIME(Date EXPUBLISHTIME) {
        this.EXPUBLISHTIME = EXPUBLISHTIME;
    }

    public String getTRAVELADDRES() {
        return TRAVELADDRES;
    }

    public void setTRAVELADDRES(String TRAVELADDRES) {
        this.TRAVELADDRES = TRAVELADDRES == null ? null : TRAVELADDRES.trim();
    }

    public String getEXCOVER() {
        return EXCOVER;
    }

    public void setEXCOVER(String EXCOVER) {
        this.EXCOVER = EXCOVER == null ? null : EXCOVER.trim();
    }
    
    public Exprince() {
		// TODO Auto-generated constructor stub
	}

	public Exprince(Short eXPRIENCEID, Short eXTYPEID, String eXTITLE, String eXAUTHORNAME, String eXCONTENT,
			Date eXPUBLISHTIME, String tRAVELADDRES, String eXCOVER) {
		super();
		EXPRIENCEID = eXPRIENCEID;
		EXTYPEID = eXTYPEID;
		EXTITLE = eXTITLE;
		EXAUTHORNAME = eXAUTHORNAME;
		EXCONTENT = eXCONTENT;
		EXPUBLISHTIME = eXPUBLISHTIME;
		TRAVELADDRES = tRAVELADDRES;
		EXCOVER = eXCOVER;
	}
    
    
}