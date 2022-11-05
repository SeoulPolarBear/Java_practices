package com.polarbear.sep303.trans;

public class Trans {
	private double num;
	private String change;
	

	public Trans() {
		// TODO Auto-generated constructor stub
	}


	public Trans(double num, String change) {
		super();
		this.num = num;
		this.change = change;
	}


	public double getNum() {
		return num;
	}


	public void setNum(double num) {
		this.num = num;
	}


	public String getChange() {
		return change;
	}


	public void setChange(String change) {
		this.change = change;
	}
	
	
}
