package com.polarbear.sep271.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondC")
public class SecondC extends HttpServlet {

    public SecondC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 M.makeSecondData(request, response);
	 M.printSecondData(request);
	 M.printSecondDataNew(request);
	 request.getRequestDispatcher("View/secondV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

}
