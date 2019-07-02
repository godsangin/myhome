package com.myhome.webservice.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myhome.webservice.service.CommentService;
import com.myhome.webservice.service.PermissionService;
import com.myhome.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;
	@Resource(name="commentservice")
	private CommentService commentService;
	@Resource
	private PermissionService permissionService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "home";
    }
    @GetMapping("/products")
    public String products(Model model) {
    	return "products";
    }
    @GetMapping("/calendar")
    public String calendar() {
    	return "calendar";
    }
    @GetMapping("/introduce")
    public String introduce() {
    	return "introduce";
    }
    
    @GetMapping("/boardlist")
    public String boardlist() {
    	return "boardlist";
    }
    
    @GetMapping("/comments")
    public String getCommets() {
    	System.out.println(commentService.getComment().toString());
    	return "home";
    }
    
    @GetMapping("/permission")
    public String getPermission() {
    	System.out.println(permissionService.getPermission().toString());
    	return "home";
    }
}