package com.java.travel.entity;

public class Extype {
    private Integer EXTYPEID;

    private String TYPENAME;

    public Integer getEXTYPEID() {
        return EXTYPEID;
    }

    public void setEXTYPEID(Integer EXTYPEID) {
        this.EXTYPEID = EXTYPEID;
    }

    public String getTYPENAME() {
        return TYPENAME;
    }

    public void setTYPENAME(String TYPENAME) {
        this.TYPENAME = TYPENAME == null ? null : TYPENAME.trim();
    }

	public Extype(Integer eXTYPEID, String tYPENAME) {
		super();
		EXTYPEID = eXTYPEID;
		TYPENAME = tYPENAME;
	}

	@Override
	public String toString() {
		return "Extype [EXTYPEID=" + EXTYPEID + ", TYPENAME=" + TYPENAME + "]";
	}
    
	public Extype() {
		// TODO Auto-generated constructor stub
	}
    
}