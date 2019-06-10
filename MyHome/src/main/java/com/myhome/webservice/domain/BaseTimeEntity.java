package com.myhome.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass//jpa entity클래스들이 BaseTimeEntity를 상속할 경우 필드들도 컬럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class)//auditing기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate//entity생성시 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate//entity변경시 시간 자동저장
    private LocalDateTime modifiedDate;

}
