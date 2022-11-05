package com.polarbear.oct042.test;

import java.math.BigDecimal;
import java.util.Date;

public class Test {

	private BigDecimal t_no;
	private String t_subject;
	private Date t_date;
	private BigDecimal t_s_no;
	
	public Test(BigDecimal t_no, String t_subject, Date t_date, BigDecimal t_s_no) {
		super();
		this.t_no = t_no;
		this.t_subject = t_subject;
		this.t_date = t_date;
		this.t_s_no = t_s_no;
	}
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getT_no() {
		return t_no;
	}

	public void setT_no(BigDecimal t_no) {
		this.t_no = t_no;
	}

	public String getT_subject() {
		return t_subject;
	}

	public void setT_subject(String t_subject) {
		this.t_subject = t_subject;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	public BigDecimal getT_s_no() {
		return t_s_no;
	}

	public void setT_s_no(BigDecimal t_s_no) {
		this.t_s_no = t_s_no;
	}
	
	
}
