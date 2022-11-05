package com.polarbear.sep303.trans;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransController {
	
	@Autowired
	private TransDAO transDao;

	
	
	//여기서 핵심은 Trans의 모든 필드를 충족하지 않는다 하더라도
	// parameter의 name 중에 하나라도 필드의 변수 값과 같은면 받아올 수 있게 된다.
	//따라서 여러 필드를 만들고 겹치는 것 몇개만 만들어도 값을 받아올 수 있다.
	@RequestMapping(value = "/trans.do", method=RequestMethod.GET)
	public String result(Trans tr, HttpServletRequest req) {
		System.out.println("절반 성공");
		transDao.transdao(tr, req);
		return "result";
	}
	
}
