package com.polarbear.sep213.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Doctor {

	public static void calculate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("EUC-KR");
			String path = request.getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
			String myName = mr.getParameter("myName");
			String myHeight = mr.getParameter("myHeight");
			String myWeight = mr.getParameter("myWeight");
			String img = mr.getFilesystemName("myPhoto");

			//������ / Ű * Ű (m  ����)
			double weight = Double.parseDouble(myWeight);
			double height = Double.parseDouble(myHeight) / 100;

			double BMI = weight / Math.pow(height, 2);
			String result = "";
			if (BMI >= 25.00) {
				result = "��";
			} else if (BMI >= 23.00) {
				result = "��ü��";
			} else if (BMI >= 18.5) {
				result = "����";
			} else if (BMI >= 0) {
				result = "��ü��";
			} else {
				result = "?? �̻��ѵ�";
			}
			String bmi2 = String.format("%.2f", BMI);
			double bmi3 = Double.parseDouble(bmi2);

			img = URLEncoder.encode(img, "EUC-KR");
			img.replace("+", " ");
			Guest guest = new Guest(myName, height, weight, bmi3, img, result);
			
			request.setAttribute("guest", guest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
