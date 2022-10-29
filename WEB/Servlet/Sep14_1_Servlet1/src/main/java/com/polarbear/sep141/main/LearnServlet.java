package com.polarbear.sep141.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//main�� ����?!?!?!?!
//main�� tomcat�� ���ο� ����

//Servlet (Server + Application)
//@xxx : Annotation
//������ ���� �� �����ؾ� �ߴµ�... -> �ڵ� ó���� ����!

@WebServlet("/LearnServlet")	//LearnServelet�� Tomcat�� ���(*** ����� ������ �ȵ�!)
public class LearnServlet extends HttpServlet {
	//HttpServletŬ������ �ִ� ���(��û������ �����ϱ�)�� ��� ����
	//������ �� �߰� O
	
	
	//�۾��ϸ鼭 ���� ǥ���϶��... (������ ������)
	private static final long serialVersionUID = 1L;
 
	//������ - �� LearnServlet ��ü�� ����°� tomcat
	//���� �� �� ����(������ ������)
    public LearnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //Servlet�� �̿��� ���α׷����� event-driven-programming (�̺�Ʈ ��� ���α׷���)�̶� �Ѵ�.
    //Tomcat�� ���� �� -> LearnServlet�� ����
    //		-> Tomcat�� LearnServlet�̶�� ��ü�� ���� ���ѷ���
    //		-> � �̺�Ʈ�� �߻��ϸ� �װ��� ó���ϰ� ������ ����
    
    //** �ٽ� �κ� !!!
    //�������ٰ� Ŭ���̾�Ʈ�� �� Servlet���� GET��� ��û�ϸ�
    //Tomcat�� doGet�޼ҵ带 �ڵ����� ȣ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//�������ٰ� Ŭ���̾�Ʈ�� �� Servlet���� POST��� ��û�ϸ�
    //Tomcat�� doPOST�޼ҵ带 �ڵ����� ȣ��
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
