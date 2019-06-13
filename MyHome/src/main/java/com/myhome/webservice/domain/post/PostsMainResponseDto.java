package com.myhome.webservice.domain.post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTimeByJava7(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
//    private String toStringDateTime(LocalDateTime localDateTime){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        return Optional.ofNullable(localDateTime)
//                .map(formatter::format)
//                .orElse("");
//    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}