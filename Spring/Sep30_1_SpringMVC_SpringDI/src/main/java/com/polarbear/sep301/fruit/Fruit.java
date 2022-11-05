package com.polarbear.sep301.fruit;

//객체를 여러개 등록해서 사용하려면...
//		-> src/main/resources에 xxxbeans.xml...
//singleton
//		root-context.xml		: 톰캣에 실려있는 '프로젝트 전체'에 영향
//		servlet-context.xml		: 이 프로젝트에만 영향(src.main.webapp.web-inf.spring.appservlet)
//			L 여기에 객체 등록
public class Fruit {

	private String name;
	private int price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
