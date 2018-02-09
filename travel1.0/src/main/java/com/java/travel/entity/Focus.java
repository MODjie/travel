package com.java.travel.entity;

public class Focus {
    private Integer FOCUSID;

    private String MYFFOCUS;

    private String MYNAME;

    public Integer getFOCUSID() {
        return FOCUSID;
    }

    public void setFOCUSID(Integer FOCUSID) {
        this.FOCUSID = FOCUSID;
    }

    public String getMYFFOCUS() {
        return MYFFOCUS;
    }

    public void setMYFFOCUS(String MYFFOCUS) {
        this.MYFFOCUS = MYFFOCUS == null ? null : MYFFOCUS.trim();
    }

    public String getMYNAME() {
        return MYNAME;
    }

    public void setMYNAME(String MYNAME) {
        this.MYNAME = MYNAME == null ? null : MYNAME.trim();
    }

	@Override
	public String toString() {
		return "Focus [FOCUSID=" + FOCUSID + ", MYFFOCUS=" + MYFFOCUS + ", MYNAME=" + MYNAME + "]";
	}

	public Focus(Integer fOCUSID, String mYFFOCUS, String mYNAME) {
		super();
		FOCUSID = fOCUSID;
		MYFFOCUS = mYFFOCUS;
		MYNAME = mYNAME;
	}
    public Focus() {
		// TODO Auto-generated constructor stub
	}
}