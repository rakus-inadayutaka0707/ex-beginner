package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam3")
public class Exam03Controller {

	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam3/exam03";
	}
	
	@RequestMapping("/calc")
	public String calc(String item1, String item2, String item3) {
		int noTaxResult = (Integer.parseInt(item1)) + (Integer.parseInt(item2)) + (Integer.parseInt(item3));
		int taxResult = (int)(noTaxResult * 1.1);
		application.setAttribute("noTaxResult", noTaxResult);
		application.setAttribute("taxResult", taxResult);
		return "exam3/exam03-result";
	}
}
