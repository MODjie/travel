package com.java.travel.entity;

import java.util.Date;

public class Exprience {
    private Integer EXPRIENCEID;

    private Integer EXTYPEID;

    private String EXTITLE;

    private String EXAUTHORNAME;

    private Date EXPUBLISHTIME;

    private String EXCOVER;

    private String ISPUBLISH;

    private String EXCONTENT;

    public Integer getEXPRIENCEID() {
        return EXPRIENCEID;
    }

    public void setEXPRIENCEID(Integer EXPRIENCEID) {
        this.EXPRIENCEID = EXPRIENCEID;
    }

    public Integer getEXTYPEID() {
        return EXTYPEID;
    }

    public void setEXTYPEID(Integer EXTYPEID) {
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

    public Date getEXPUBLISHTIME() {
        return EXPUBLISHTIME;
    }

    public void setEXPUBLISHTIME(Date EXPUBLISHTIME) {
        this.EXPUBLISHTIME = EXPUBLISHTIME;
    }

    public String getEXCOVER() {
        return EXCOVER;
    }

    public void setEXCOVER(String EXCOVER) {
        this.EXCOVER = EXCOVER == null ? null : EXCOVER.trim();
    }

    public String getISPUBLISH() {
        return ISPUBLISH;
    }

    public void setISPUBLISH(String ISPUBLISH) {
        this.ISPUBLISH = ISPUBLISH == null ? null : ISPUBLISH.trim();
    }

    public String getEXCONTENT() {
        return EXCONTENT;
    }

    public void setEXCONTENT(String EXCONTENT) {
        this.EXCONTENT = EXCONTENT == null ? null : EXCONTENT.trim();
    }
}