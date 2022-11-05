package com.polarbear.sep303.trans;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class TransDAO {
	public void transdao(Trans tr, HttpServletRequest req) {
		
		if(tr.getChange().equals("inch")) {
			req.setAttribute("o", "cm");
			req.setAttribute("result",String.format("%.4f", tr.getNum() * 0.393701));
		}
		else if(tr.getChange().equals("area")) {
			req.setAttribute("o", "m2");
			req.setAttribute("result",String.format("%.4f", tr.getNum() * 0.3025));
		}
		else if(tr.getChange().equals("F")) {
			req.setAttribute("o", "C");
			req.setAttribute("result", String.format("%.4f",tr.getNum() * 1.8 + 32));
		}
		else{
			req.setAttribute("o", "mi_per_h");
			req.setAttribute("result",String.format("%.4f", tr.getNum() * 1.60934));
		}
		
			req.setAttribute("origin", tr.getNum());
			req.setAttribute("r", tr.getChange());
		}
	}

