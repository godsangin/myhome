package com.myhome.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.webservice.domain.post.PostsRepository;
import com.myhome.webservice.domain.post.PostsSaveRequestDto;
import com.myhome.webservice.dto.Plan;
import com.myhome.webservice.dto.User;
import com.myhome.webservice.service.PlanService;
import com.myhome.webservice.service.PostsService;
import com.myhome.webservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor//의존성 주입(Autowired생략 가능하게 해줌)
public class WebRestController {
	
	private PostsService postsService;
	private UserService userService;
	private PlanService planService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public Long savaPosts(@RequestBody PostsSaveRequestDto dto) {
    	return postsService.save(dto);
    }
    
    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User user) {
    	userService.addUser(user);
    	return "true";
    }
    
    @GetMapping("/getUser")
    public String getUser(@RequestParam String u_mail) {
    	User user = userService.getUserByMail(u_mail);
    	return user.getU_tel();
    }
    
    @PostMapping("/login")
    public User login(@RequestBody String u_mail, @RequestBody String u_PW) {
    	User resultUser = userService.getUserByMail(u_mail);
    	if(resultUser == null) {
    		return null;
    	}
    	if(resultUser.getU_pw().equals(u_PW)) {
    		resultUser.setU_pw("");
    		return resultUser;
    	}
    	return null;
    }
    
    @PostMapping("/updateUserInfo")
    public boolean updateUserInfo(User user) {
    	return userService.updateUserInfo(user);
    }
    
    @PostMapping("/updateUserPW")
    public boolean updateUserPW(User user) {
    	return userService.updateUserPW(user);
    }
    
    @PostMapping("/insertPlan")
    public boolean insertPlan(@RequestBody Plan plan) {
    	return planService.insertPlan(plan);
    }
    
    @GetMapping("/getPlan")
    public Plan getPlan(@RequestParam int p_number) {
    	return planService.getPlanByNum(p_number);
    }
    
}