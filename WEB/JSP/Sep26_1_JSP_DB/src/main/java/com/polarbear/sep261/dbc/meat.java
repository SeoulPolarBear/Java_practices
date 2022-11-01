package com.polarbear.sep261.dbc;

public class meat {
	private int m_id;
	private int rn;
	private String m_kind;
	private String m_from;
	private long m_price;
	private String m_introduce;
	
	public meat() {
		// TODO Auto-generated constructor stub
	}

	public meat(int m_id, int rn, String m_kind, String m_from, long m_price, String m_introduce) {
		super();
		this.m_id = m_id;
		this.rn = rn;
		this.m_kind = m_kind;
		this.m_from = m_from;
		this.m_price = m_price;
		this.m_introduce = m_introduce;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_kind() {
		return m_kind;
	}

	public void setM_kind(String m_kind) {
		this.m_kind = m_kind;
	}

	public String getM_from() {
		return m_from;
	}

	public void setM_from(String m_from) {
		this.m_from = m_from;
	}

	public long getM_price() {
		return m_price;
	}

	public void setM_price(long m_price) {
		this.m_price = m_price;
	}

	public String getM_introduce() {
		return m_introduce;
	}

	public void setM_introduce(String m_introduce) {
		this.m_introduce = m_introduce;
	}
	
	
	
	
}
