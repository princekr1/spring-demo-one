package com.prince.example.springmvcradiofield;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String ShowForm(Model theModel) {
		
		//create a new Student object
		Student theStudent=new Student();
	
		//add the object to model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
		
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		//log the input data
	    System.out.println("theStudent :"+theStudent.getFirstName()+" "+theStudent.getLastName()
	    +" "+theStudent.getCountry()+" "+theStudent.getFavoriteLanguage());
	    return "student-confirmation";
	}
	
}
