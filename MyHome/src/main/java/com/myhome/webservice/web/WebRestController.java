package com.myhome.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.webservice.domain.PostsRepository;
import com.myhome.webservice.domain.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor//의존성 주입(Autowired생략 가능하게 해줌)
public class WebRestController {
	
	private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public void savaPosts(@RequestBody PostsSaveRequestDto dto) {
    	postsRepository.save(dto.toEntity());
    }
}