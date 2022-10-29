package com.polarbear.sep142.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Output() {
        super();
       
    }
    //사용자가 입력한 데이터가 주소에
    //인터넷 주소에 한글 - X
    //	ㅋ-> %2B%AC(URL 인코딩)
    
    //사용자가 입력한 ㅋ(EUC-KR) - URLEncoding -> %2B%AC
    //사용자로부터 받아온 %2B%AC - URLEncoding -> ㅋ
    
    // Get방식 요청파라미터 한글처리
    //		EUC-KR로 맞추자!
    //		Tomcat server.xml 63번줄 설정을 건드렸음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client에 보내줄 때도 한글은 지원이 안 되기 때문에 다음과 같이 encoding 해줘야 한다.
		response.setCharacterEncoding("EUC-KR");
		String a = request.getParameter("a");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		out.print("<h2>Output-GET</h2>");		
		out.printf("<h2>%s</h2>", a);		
		out.print("</body>");
		out.print("</html>");
	}
	//GET방식 요청 VS POST 방식요청
	//GET : 요청파라미터가 주소에 있음
	//		대부분 GET방식을 사용함
	//POST : 요청파라미터가 주소에 없음, 내부적으로 전달
	//		보안성 높음 - 로그인, 회원가입,...
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");// 이거 안하면 한글 깨져서 나옴 post는 주소에 param 없기 때문
		
		response.setCharacterEncoding("EUC-KR");
		String a = request.getParameter("a");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		out.print("<h2>Output-POST</h2>");		
		out.printf("<h2>%s</h2>", a);		
		out.print("</body>");
		out.print("</html>");
	}

}















