package com.asura.spring;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asura.spring.models.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}") 
	private LinkedHashMap<String,String> countryOptions;
	
	@RequestMapping("/enrollment")
	public String showStudentEnrollmentForm(Model model) {
		
		Student student = new Student();
		model.addAttribute("student", student);
		
		// add the country options to the model 
	    model.addAttribute("countryOptions", countryOptions); 
		return "student-enrollment";
	}
	
	@RequestMapping("/processEnrollment")
	public String letsShoutDude(@ModelAttribute("student") Student student) {
		System.out.println("Student Data is: "+student.getFirstName());
		return "student-confirmation";
	}
}
