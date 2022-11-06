package com.polarbear.oct06.fruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllFruit(HttpServletRequest req) {
		try {
			FruitMapper fm = ss.getMapper(FruitMapper.class);
			List<Fruit> fruits = fm.getAllFruit();
			
			req.setAttribute("fruits", fruits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Fruits getPriceFruitXML(Fruit f, HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getPriceFruit(f);
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
	}
	
	
	//Spring에서 XML 끌어오는 시스템 : XML AJAX Server
	//		현재] DB에 있는 과일데이터 하나를 표현할 JavaBean(Fruit.java)를 가지고 있는 상태
	//			우리가 필요한 것]
	//			1. DB에 있는 '과일테이블'을 표현할 또 하나의 JavaBean이 필요
	//			2. Spring이 XML로 바꿀 수 있도록
	//			각각의 JavaBean에(Class명 위에) @XmlRootElement annotation 달기
	//			3. Setter 위에 @XmlElement annotation 달기
	//			특정 데이터 -> XML형태로 바꾸는 것 : 마샬링(Mashalling)
	
	
	
	public Fruits getXML(HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
