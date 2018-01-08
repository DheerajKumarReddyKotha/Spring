package com.asura.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // It is inherited from @Component
public class HomeController {

	@RequestMapping("/")
	//This is a controller method
	public String showMyPage() {
		return "main-menu";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "index";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "Output";
	}
	
	//This is using HttpServlerRequest
	/*@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		String result = theName.toUpperCase();
		
		model.addAttribute("message",result);
		return "Output";
	}*/
	
	//This is using @RequestParam
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
		String result = theName.toUpperCase();
		
		model.addAttribute("message",result);
		return "Output";
	}
}
