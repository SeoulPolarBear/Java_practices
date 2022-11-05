package com.polarbear.oct042.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDAO {

	@Autowired
	private SqlSession ss;

	public void reqTest(Test t, HttpServletRequest req) {
		try {
			// View파라미터 3개 (t_y, t_m, t_d -> t_date) 합쳐줄리없죠 -> DAO
			String t_y = req.getParameter("t_y");
			int t_m = Integer.parseInt(req.getParameter("t_m"));
			int t_d = Integer.parseInt(req.getParameter("t_d"));
			
			//2022 1 1 -> SimpleDateFormat
			
			// 202211 -> 2022년 11월 ? / 2022년 1월 1일?
			// 따라서 정수로 받아서 20220101이렇게 받을 필요가 있다.
			
			String t_date2 = String.format("%s%02d%02d", t_y,t_m,t_d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date t_date = sdf.parse(t_date2);
			t.setT_date(t_date);
			
			TestMapper tm = ss.getMapper(TestMapper.class);
			if (tm.reqTest(t) == 1) {
				req.setAttribute("r", "test 등록 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "test 등록 실패");
		}
	}
	
	public void getAllTest(HttpServletRequest req) {
		try {
			TestMapper tm = ss.getMapper(TestMapper.class);
			List<Test> tests = tm.getAllTest();
			
			req.setAttribute("tests", tests);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//cos.jar
	//1. req.getParameter() -> mr.getParameter()를 써야!
	//2. 실행되는 서버상에서 파일이 업로드되는 폴더 경로 
	//		String path = req.getServletContext().getRealPath("img"); => (X)
	//		String path = req.getSession().getServletContext().getRealPath("resources/img"); => (O)	
}
