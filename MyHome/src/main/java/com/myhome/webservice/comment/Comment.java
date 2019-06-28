package com.myhome.webservice.comment;

public class Comment {
	private int c_number;
	private String c_writer;
	private String c_content;
	private String c_wdate;
	private int c_bnumber;
	public int getC_number() {
		return c_number;
	}
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	public String getC_writer() {
		return c_writer;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_wdate() {
		return c_wdate;
	}
	public void setC_wdate(String c_wdate) {
		this.c_wdate = c_wdate;
	}
	public int getC_bnumber() {
		return c_bnumber;
	}
	public void setC_bnumber(int c_bnumber) {
		this.c_bnumber = c_bnumber;
	}
	@Override
	public String toString() {
		return "Comment [c_number=" + c_number + ", c_writer=" + c_writer + ", c_content=" + c_content + ", c_wdate="
				+ c_wdate + ", c_bnumber=" + c_bnumber + "]";
	}
	
}
