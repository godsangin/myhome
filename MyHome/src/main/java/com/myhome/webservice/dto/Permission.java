package com.myhome.webservice.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Permission{
    private @NonNull String p_mail;
    private int p_grade;

    @Builder
    public Permission(String p_mail, int p_grade) {
    	this.p_mail = p_mail;
    	this.p_grade = p_grade;
    }
}