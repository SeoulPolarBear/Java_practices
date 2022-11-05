package com.polarbear.sep301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polarbear.sep301.fruit.Fruit;
import com.polarbear.sep301.member.MemberDAO;

@Controller
public class HomeController {

	//Fruit 클래스 -> 이름 / 가격
	//자동으로 연결하는 방식으로 이를 통해 servlet-context.xml에 들어있는 fruit1을 바로 가져올 수 있다.
	@Autowired
	private Fruit fruit1;
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		System.out.println(fruit1.getName());
		System.out.println(fruit1.getPrice());
		
		mDAO.test();
		
		return "home";
	}
	
}
