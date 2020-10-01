package com.backend.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.backend.entity.Gamer;
import com.backend.service.GamerService;

@Controller
public class GamerController {

	@Autowired
	private GamerService gamerService; 
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		Gamer theGamer=new Gamer();
		
		theModel.addAttribute("gamer",theGamer);
		
		
		return "signup";
	}
	

	@PostMapping("/processData")
	public String processForm(@Valid @ModelAttribute("gamer") Gamer aGamer,BindingResult theBindingResult) {
		
		System.out.println("the binding result :::: "+ theBindingResult);
		if(theBindingResult.hasErrors()) {
			return "signup";
		}
		else {
			
			gamerService.saveGamer(aGamer);
			return "reg-confirmation";
		}
							
	}
	
	
	@InitBinder
	public void initEmptyBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		//interesting:::new StringTrimmerEditor(charsToDelete,true);
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}
	
	
	
	
}