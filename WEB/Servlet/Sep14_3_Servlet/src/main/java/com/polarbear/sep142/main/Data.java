package com.polarbear.sep142.main;

import java.util.ArrayList;

public class Data {
	private String Id;
	private String PW;
	private String gender;
	private String location;
	private ArrayList<String> hobby = new ArrayList<>();
	private String Introduce;

	public Data(String id, String pW, String gender, String location, ArrayList<String> hobby, String introduce) {
		super();
		Id = id;
		PW = pW;
		this.gender = gender;
		this.location = location;
		for (String string : hobby) {
			this.hobby.add(string);
		}
		Introduce = introduce;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<String> getHobby() {
		return hobby;
	}

	public void setHobby(ArrayList<String> hobby) {
		this.hobby.clear();
		for (String string : hobby) {
			this.hobby.add(string);
		}
	}

	public String getIntroduce() {
		return Introduce;
	}

	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}

}
