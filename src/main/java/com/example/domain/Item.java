package com.example.domain;

public class Item {
	private String name;
	private Integer price;
<<<<<<< HEAD
	
	public Item() {
	}

	public Item(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
=======
>>>>>>> 17fe445e7d2cc63ae7dd197a9ce8869c21ad7c90

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}
}
