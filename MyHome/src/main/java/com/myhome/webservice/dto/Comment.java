package com.myhome.webservice.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Comment {
	private int c_number;
	private String c_writer;
	private String c_content;
	private String c_wdate;
	private int c_bnumber;
	
	@Builder
	public Comment(int c_number, String c_writer, String c_content, String c_wdate, int c_bnumber) {
		super();
		this.c_number = c_number;
		this.c_writer = c_writer;
		this.c_content = c_content;
		this.c_wdate = c_wdate;
		this.c_bnumber = c_bnumber;
	}
	
}
