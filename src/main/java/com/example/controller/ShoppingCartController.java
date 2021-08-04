package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/exam6")
public class ShoppingCartController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index(Model model) {
		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		if (itemList == null) {
			itemList = new LinkedList<>();
			itemList.add(new Item("手帳ノート", 1000));
			itemList.add(new Item("文房具セット", 1500));
			itemList.add(new Item("ファイル", 2000));

			application.setAttribute("itemList", itemList);
		}
		int totalPrice = 0;
		if(session.getAttribute("cartItemList") != null) {
			@SuppressWarnings("unchecked")
			List<Item> cartItem = (List<Item>) session.getAttribute("cartItemList");
			for (Item item : cartItem) {
				totalPrice += item.getPrice();
			}
		}
		model.addAttribute("totalPrice", totalPrice);
		return "item-and-cart";
	}
	
	@RequestMapping("/in-cart")
	public String inCart(int indexNum) {
		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>)application.getAttribute("itemList");
		List<Item> cartItemList = new LinkedList<>();
		if(session.getAttribute("cartItemList") != null) {
			@SuppressWarnings("unchecked")
			List<Item> cartItem = (List<Item>)session.getAttribute("cartItemList");
			for(Item item:cartItem) {
				cartItemList.add(item);
			}
		}
		cartItemList.add(itemList.get(indexNum));
		session.setAttribute("cartItemList", cartItemList);
		return "redirect:/exam6/redirect";
	}
	
	@RequestMapping("/delete")
	public String delete(int indexNum) {
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>)session.getAttribute("cartItemList");
		cartItemList.remove(indexNum);
		session.setAttribute("cartItemList", cartItemList);
		return "redirect:/exam6/redirect";
	}

	@RequestMapping("/redirect")
	public String redirect(Model model) {
		return index(model);
	}
}
