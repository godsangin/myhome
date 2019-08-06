package com.myhome.webservice.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Board {
	private int b_number;
	private String b_title;
	private String b_content;
	private String b_writer;
	private String b_wdate;
	private int b_category;
	private int b_views;
	private int b_like;
	private int b_comments;
	
	@Builder
	public Board(int b_number, String b_title, String b_content, String b_writer, String b_wdate, int b_category,
			int b_views, int b_like, int b_comments) {
		super();
		this.b_number = b_number;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_wdate = b_wdate;
		this.b_category = b_category;
		this.b_views = b_views;
		this.b_like = b_like;
		this.b_comments = b_comments;
	}
	
}
