package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/exam5")
public class Exam05Controller {

	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {
		return "exam5/exam05";
	}

	@RequestMapping("/form")
	public String form(String name, Model model) {
		List<Member> memberList = repository.findLike(name);
		model.addAttribute("memberList", memberList);
		return "exam5/exam05-result";
	}
}
