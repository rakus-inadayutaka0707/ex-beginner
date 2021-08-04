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
<<<<<<< HEAD
			itemList.add(new Item("手帳ノート", 1000));
			itemList.add(new Item("文房具セット", 1500));
			itemList.add(new Item("ファイル", 2000));
=======
			Item item1 = new Item();
			item1.setName("手帳ノート");
			item1.setPrice(1000);
			itemList.add(item1);

			Item item2 = new Item();
			item2.setName("文房具セット");
			item2.setPrice(1500);
			itemList.add(item2);

			Item item3 = new Item();
			item3.setName("ファイル");
			item3.setPrice(2000);
			itemList.add(item3);
>>>>>>> 17fe445e7d2cc63ae7dd197a9ce8869c21ad7c90

			application.setAttribute("itemList", itemList);
		}
		int totalPrice = 0;
<<<<<<< HEAD
		if(session.getAttribute("cartItemList") != null) {
			@SuppressWarnings("unchecked")
			List<Item> cartItem = (List<Item>) session.getAttribute("cartItemList");
			for (Item item : cartItem) {
=======
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
		if (cartItemList == null) {

		} else {
			for (Item item : cartItemList) {
>>>>>>> 17fe445e7d2cc63ae7dd197a9ce8869c21ad7c90
				totalPrice += item.getPrice();
			}
		}
		model.addAttribute("totalPrice", totalPrice);
<<<<<<< HEAD
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
=======
		return "exam6/item-and-cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/in-cart")
	public String inCart(int indexNum) {
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		List<Item> cartItemList = new LinkedList<>();
		if (session.getAttribute("cartItemList") != null) {
			cartItemList = (List<Item>) session.getAttribute("cartItemList");
>>>>>>> 17fe445e7d2cc63ae7dd197a9ce8869c21ad7c90
		}
		cartItemList.add(itemList.get(indexNum));
		session.setAttribute("cartItemList", cartItemList);
		return "redirect:/exam6/redirect";
	}
<<<<<<< HEAD
	
	@RequestMapping("/delete")
	public String delete(int indexNum) {
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>)session.getAttribute("cartItemList");
=======

	@RequestMapping("/out-cart")
	public String outCart(int indexNum) {
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
>>>>>>> 17fe445e7d2cc63ae7dd197a9ce8869c21ad7c90
		cartItemList.remove(indexNum);
		session.setAttribute("cartItemList", cartItemList);
		return "redirect:/exam6/redirect";
	}
<<<<<<< HEAD
	
=======

>>>>>>> 17fe445e7d2cc63ae7dd197a9ce8869c21ad7c90
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		return index(model);
	}
}
