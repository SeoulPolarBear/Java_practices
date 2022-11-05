package com.polarbear.oct042.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polarbear.oct042.student.StudentDAO;

@Controller
public class testController {

	@Autowired
	private TestDAO tDAO;
	
	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(value="/test.req", method = RequestMethod.GET)
	public String reqTest(Test t, HttpServletRequest req) {
		sDAO.getAllStudent(req);
		tDAO.reqTest(t, req);
		tDAO.getAllTest(req);
		return "index";
	}
}
