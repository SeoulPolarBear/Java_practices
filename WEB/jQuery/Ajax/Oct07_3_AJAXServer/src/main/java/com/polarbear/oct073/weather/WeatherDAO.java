package com.polarbear.oct073.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	
	//기상청 XML 다운 받아와서 => String 한 덩어리로 뭉쳐서 그대로 리턴
	//"http://www.kma.go.kr/wid/queryDFSRSS.jsp",
	//{"zone":1165065100},
	
	public String getKoreaWeather(HttpServletRequest req) {
		try {
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165065100");
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			//나오는 하나하나를 한 덩어리로 뭉치기
			
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line.replace("\r\n", ""));
			}
			
			//다운 받아온 데이터를 한 덩어리로 뭉쳤고, 엔터키를 없앰
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
