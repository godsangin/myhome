package com.myhome.webservice.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myhome.webservice.domain.PostsMainResponseDto;
import com.myhome.webservice.domain.PostsRepository;
import com.myhome.webservice.domain.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {//controller와 service의 역할 분리, 비지니스 로직&트랜잭션 관리 담당, Controller에서는 view와 연동되는 부분 담당
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
    
    @Transactional(readOnly = true)//조회를 목적으로만 사용할 경우(수정,삭제,등록 등이 아닐경우) 속도 개선됨.
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)//.map(posts -> new PostsMainResponseDto(posts))
                .collect(Collectors.toList());
    }
}