package com.myhome.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myhome.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;

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
}