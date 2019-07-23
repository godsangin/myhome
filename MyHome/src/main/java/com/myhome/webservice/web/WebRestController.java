package com.myhome.webservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.webservice.domain.post.PostsRepository;
import com.myhome.webservice.domain.post.PostsSaveRequestDto;
import com.myhome.webservice.dto.Attachment;
import com.myhome.webservice.dto.Board;
import com.myhome.webservice.dto.Plan;
import com.myhome.webservice.dto.User;
import com.myhome.webservice.service.PlanService;
import com.myhome.webservice.service.PostsService;
import com.myhome.webservice.service.UserService;
import com.myhome.webservice.service.BoardService;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor//의존성 주입(Autowired생략 가능하게 해줌)
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class WebRestController {
	
	private PostsService postsService;
	private UserService userService;
	private PlanService planService;
	private BoardService boardService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    /**
     * user data action
     */
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
    public User login(@RequestBody User user) {
    	User resultUser = userService.getUserByMail(user.getU_mail());
    	if(resultUser == null) {
    		return null;
    	}
    	if(resultUser.getU_pw().equals(user.getU_pw())) {
    		resultUser.setU_pw("");
    		return resultUser;
    	}
    	return null;
    }
    
    @PutMapping("/updateUserInfo")
    public boolean updateUserInfo(User user) {
    	return userService.updateUserInfo(user);
    }
    
    @PutMapping("/updateUserPW")
    public boolean updateUserPW(User user) {
    	return userService.updateUserPW(user);
    }

    /**
     * plan data action
     */
    @PostMapping("/insertPlan")
    public boolean insertPlan(@RequestBody Plan plan) {
    	return planService.insertPlan(plan);
    }
    
    @GetMapping("/getPlan")
    public Plan getPlan(@RequestParam int p_number) {
    	return planService.getPlanByNum(p_number);
    }
    
    @GetMapping("/getMonthPlan")
    public List<Plan> getMonthPlan(@RequestParam String m_start){
    	return planService.getPlansByMonth(m_start);
    }
    
    @PutMapping("/updatePlan")
    public boolean updatePlan(@RequestBody Plan plan) {
    	return planService.updatePlan(plan);
    }
    
    @PostMapping("/deletePlan")
    public boolean deletePlan(@RequestBody int p_number) {
    	return planService.deletePlanByNum(p_number);
    }
    
    /**
     * board data action
     */
    @PostMapping("/insertBoard")
    public boolean insertBoard(@RequestBody Board board) {
    	return boardService.insertBoard(board, null);
    }
    
    @GetMapping("/getBoard")
    public Board getBoard(@RequestParam int b_number) {
    	return boardService.getBoardByNum(b_number);
    }
    
    @GetMapping("/getBoardListByPage")
    public List<Board> getBoardListByPage(@RequestParam int page_num){
    	return boardService.getBoardsByPageNum(page_num);
    }
    
    @PutMapping("/updateBoard")
    public boolean updateBoard(@RequestBody Board board, List<Attachment> attachments) {
    	return boardService.updateBoard(board, attachments);
    }
    
    //like need
    @DeleteMapping("/deleteBoardByNum")
    public boolean deleteBoardByNum(@RequestBody int b_number) {
    	return boardService.deleteBoardByNum(b_number);
    }
    
    @GetMapping("/getAttachmentListByBoardNumber")
    public List<Attachment> getAttachmentListByBoardNumber(@RequestParam int b_number){
    	return boardService.getAttachmentListByBoardNum(b_number);
    }
}
