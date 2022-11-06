package com.polarbear.oct06.fruit;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//용도는 배열처럼 한번 감싸줄게 필요해서 사용했다.
@XmlRootElement
public class Fruits {
	private List<Fruit> fruit;
	
	public Fruits() {
		// TODO Auto-generated constructor stub
	}

	public Fruits(List<Fruit> fruit) {
		super();
		this.fruit = fruit;
	}

	public List<Fruit> getFruit() {
		return fruit;
	}
	@XmlElement
	public void setFruit(List<Fruit> fruit) {
		this.fruit = fruit;
	}
	
	
	
}
