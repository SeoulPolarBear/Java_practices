package Person;

public class Person {
	private String name;
	private int age;
	private String affiliation;


	public Person(String name, int age, String affiliation) {
		super();
		this.name = name;
		this.age = age;
		this.affiliation = affiliation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(affiliation);
	}
}
