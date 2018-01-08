package com.asura.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

	@RequestMapping("/getKitchenItems")
	public String getKitchenItems() {
		return "index";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
		String result = theName.toUpperCase();
		
		model.addAttribute("message",result);
		return "Output";
	}
}
