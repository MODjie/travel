package com.java.travel.entity;

public class ClobTest {
    private Integer ID;

    private String CLOBCONTENT;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCLOBCONTENT() {
        return CLOBCONTENT;
    }

    public void setCLOBCONTENT(String CLOBCONTENT) {
        this.CLOBCONTENT = CLOBCONTENT == null ? null : CLOBCONTENT.trim();
    }

	public ClobTest(Integer iD, String cLOBCONTENT) {
		super();
		ID = iD;
		CLOBCONTENT = cLOBCONTENT;
	}
    
    public ClobTest() {
		// TODO Auto-generated constructor stub
	}
}