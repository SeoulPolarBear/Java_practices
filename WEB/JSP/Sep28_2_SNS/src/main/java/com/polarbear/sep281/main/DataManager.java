package com.polarbear.sep281.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

//�������⼭ ��¥�� ���� �ٷ� �� �ֱ� ������ home�ʿ� ��ġ��
public class DataManager {

	//<select> �⵵���� �ظ��� �ٲ��� ���� �޾ƿ���
	
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		req.setAttribute("curYear", curYear);
	}
}
