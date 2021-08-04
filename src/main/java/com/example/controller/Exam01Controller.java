package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam1")
public class Exam01Controller {

	@RequestMapping("")
	public String index() {
		return "exam1/exam01";
	}

	@RequestMapping("/form")
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "exam1/exam01-result";
	}
}
