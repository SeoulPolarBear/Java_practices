//이름이 Kim Andrew, 남자, 핸드폰 번호가 010-1234-5678인 사람
		//출력
public class Human {
private String name;
private String gender;
private String phoneNumber;

public Human(String name, String gender, String phoneNumber) {
	super();
	this.name = name;
	this.gender = gender;
	this.phoneNumber = phoneNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public void HumanInfo() {
	System.out.println(name);
	System.out.println(gender);
	System.out.println(phoneNumber);
}
}
