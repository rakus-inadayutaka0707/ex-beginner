package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam2")
public class Exam02Controller {

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String index() {
		return "exam2/exam02";
	}

	@RequestMapping("/add")
	public String add(String number1, String number2) {
		Integer num1 = Integer.parseInt(number1);
		Integer num2 = Integer.parseInt(number2);
		Integer result = num1 + num2;
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", result);
		return "exam2/exam02-result";
	}

	@RequestMapping("/result2")
	public String result2() {
		return "exam2/exam02-result2";
	}
}
