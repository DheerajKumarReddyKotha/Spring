package com.asura.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // It is inherited from @Component
public class HomeController {

//	@RequestMapping("/")
//	//This is a controller method
//	public String showMyPage() {
//		return "main-menu";
//	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "index";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "Output";
	}
}
