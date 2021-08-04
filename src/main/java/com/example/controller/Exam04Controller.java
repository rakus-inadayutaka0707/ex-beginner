package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam4")
public class Exam04Controller {

	@ModelAttribute
	private UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String index() {
		return "exam4/exam04";
	}

	@RequestMapping("/form")
	public String form(@Validated UserForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index();
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		model.addAttribute(user);
		return "exam4/exam04-result";
	}
}
