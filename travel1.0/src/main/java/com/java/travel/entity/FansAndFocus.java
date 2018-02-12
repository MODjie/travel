package com.java.travel.entity;

import java.util.List;

public class FansAndFocus {
	private List<FocusDetail> focusList;
	private List<FansDetail> fansList;
	@Override
	public String toString() {
		return "FansAndFocus [focusList=" + focusList + ", fansList=" + fansList + "]";
	}
	public List<FocusDetail> getFocusList() {
		return focusList;
	}
	public void setFocusList(List<FocusDetail> focusList) {
		this.focusList = focusList;
	}
	public List<FansDetail> getFansList() {
		return fansList;
	}
	public void setFansList(List<FansDetail> fansList) {
		this.fansList = fansList;
	}
	public FansAndFocus(List<FocusDetail> focusList, List<FansDetail> fansList) {
		super();
		this.focusList = focusList;
		this.fansList = fansList;
	}
	public FansAndFocus() {
		// TODO Auto-generated constructor stub
	}
	
}
