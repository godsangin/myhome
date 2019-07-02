package com.myhome.webservice.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class User{
    private String u_mail;
    private String u_name;
    private String u_tel;
    private String u_birth;
    private String u_pw;
    
    @Builder
	public User(String u_mail, String u_name, String u_tel, String u_birth, String u_pw) {
		this.u_mail = u_mail;
		this.u_name = u_name;
		this.u_tel = u_tel;
		this.u_birth = u_birth;
		this.u_pw = u_pw;
	}
}