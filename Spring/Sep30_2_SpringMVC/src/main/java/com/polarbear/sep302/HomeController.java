package com.polarbear.sep302;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//JSP Model 2------------------------------------------------
// http://IP:port/프로젝트명/컨트롤러파일명
//	C:Servlet
//		상황판단 -> 흐름의 제어
//		doGet(), doPost()를 활용
//		주소에 컨트롤러파일명, 컨트롤러 하나당 GET하나, POST하나 
//			=> 컨트롤러의 수가 많아짐

// Spring MVC-------------------------------------------------
// http://IP:Port/top-level-package의 마지막자리/임의대로 지정한 값
//	C : 일반 클래스
//		일반 메소드
//		컨트롤러 하나에 여러개의 요청 처리가 가능
//			=> 컨트롤러 수가 많이 필요없어짐

@Controller
public class HomeController {
	
	// hehehe.test라는 주소로 GET방식의 요청이 들어오면
	// index.jsp로 포워딩(이동)해주는 메소드
	
	@RequestMapping(value="/hehehe.test", method = RequestMethod.GET)
	public String testhehehe() {
		return "index";
	}
	
	//lalala.test라는 주소로 GET방식의 요청이 들어오면 '랄랄라~'라는 내용이
	//콘솔에 출력되는 메소드
	
	@RequestMapping(value= "/lalala.test",method= RequestMethod.GET)
	public void testlalala() {
		System.out.println("우효");
	}
	
	// 사이트 첫 접속시 method : GET
	// value에는 아무것도 쓰지 않은 상태
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome() { //String 자료형이 기본
		
		
		
		return "index";//index.jsp로 포워딩
	}
	
}
