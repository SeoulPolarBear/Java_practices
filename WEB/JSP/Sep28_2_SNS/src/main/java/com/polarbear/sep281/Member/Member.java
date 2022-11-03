package com.polarbear.sep281.Member;

public class Member {
	private String m_id;
	private String m_passwd;
	private String m_name;
	private String m_phoneNum;
	private String m_birthday;
	private String m_photo;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_passwd, String m_name, String m_phoneNum, String m_birthday, String m_photo) {
		super();
		this.m_id = m_id;
		this.m_passwd = m_passwd;
		this.m_name = m_name;
		this.m_phoneNum = m_phoneNum;
		this.m_birthday = m_birthday;
		this.m_photo = m_photo;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_passwd() {
		return m_passwd;
	}

	public void setM_passwd(String m_passwd) {
		this.m_passwd = m_passwd;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_phoneNum() {
		return m_phoneNum;
	}

	public void setM_phoneNum(String m_phoneNum) {
		this.m_phoneNum = m_phoneNum;
	}


	public String getM_birthday() {
		return m_birthday;
	}

	public void setM_birthday(String m_birthday) {
		this.m_birthday = m_birthday;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	
}