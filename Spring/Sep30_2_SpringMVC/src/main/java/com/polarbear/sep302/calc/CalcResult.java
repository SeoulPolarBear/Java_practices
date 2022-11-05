package com.polarbear.sep302.calc;

//요청파라미터 JavaBean멤버변수명을 같게 + DB 컬럼명
//자동으로 요청파라미터의 값을 Javabean객체에 ...!(getparameter로 안 받아도 된다.)
public class CalcResult {
	private String name;
	private int x;
	private int y;
	
	public CalcResult() {
		// TODO Auto-generated constructor stub
	}

	public CalcResult(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
