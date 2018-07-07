package com.neocom.mobilerefueling.bean;

public class TimeBean {
	private String date;
	private String text;

	public TimeBean() {

	}

	public TimeBean(String date, String text) {
		super();
		this.date = date;
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
