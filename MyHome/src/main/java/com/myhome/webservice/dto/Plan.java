package com.myhome.webservice.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Plan{
    private int p_number;
    private String p_title;
    private String p_sdate;
    private String p_edate;
    private String p_content;
    private int p_color;
    
    @Builder
	public Plan(int p_number, String p_title, String p_sdate, String p_edate, String p_content, int p_color) {
		super();
		this.p_number = p_number;
		this.p_title = p_title;
		this.p_sdate = p_sdate;
		this.p_edate = p_edate;
		this.p_content = p_content;
		this.p_color = p_color;
		
	}
}