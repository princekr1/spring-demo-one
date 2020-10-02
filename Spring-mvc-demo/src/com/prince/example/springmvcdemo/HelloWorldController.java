package com.prince.example.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	
	//need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the Html From
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new Controller method to read form data and
	//add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//Read the request parameter from the HTMl Form
		String theName=request.getParameter("studentName");
		
		//Convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Yo! "+theName;
		
		//Add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}

	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
				
		//Convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Hey From V3! "+theName;
		
		//Add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
}
