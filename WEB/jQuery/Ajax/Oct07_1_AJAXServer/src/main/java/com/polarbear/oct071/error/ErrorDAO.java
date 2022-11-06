package com.polarbear.oct071.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorDAO {

	@Autowired
	private SqlSession ss;
	
	public Errors getJSON(HttpServletRequest req) {
		return new Errors(ss.getMapper(ErrorMapper.class).getAllError());
	}
	
	public Errors getSearchJSON(Error e,HttpServletRequest req) {
		return new Errors(ss.getMapper(ErrorMapper.class).getSearchError(e));
	}
}
