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
public class Attachment {
	private int a_number;
	private int a_bnumber;
	private String a_file;
	
	@Builder
	public Attachment(int a_number, int a_bnumber, String a_file) {
		super();
		this.a_number = a_number;
		this.a_bnumber = a_bnumber;
		this.a_file = a_file;
	}
}
