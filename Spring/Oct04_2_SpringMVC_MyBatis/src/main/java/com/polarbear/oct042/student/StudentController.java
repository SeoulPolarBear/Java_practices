package com.polarbear.oct042.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polarbear.oct042.test.Test;
import com.polarbear.oct042.test.TestDAO;

@Controller
public class StudentController {
	
	@Autowired
	private TestDAO tDAO;
	
	@Autowired
	private StudentDAO sDAO;
	
	
	@RequestMapping(value="/student.req", method = RequestMethod.GET)
	public String reqStudent(Student s, HttpServletRequest req) {
		sDAO.reqStudent(s, req);
		sDAO.getAllStudent(req);
		tDAO.getAllTest(req);
		return "index";
	}

}
