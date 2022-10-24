package Person;

public class Student extends Person {
	private int grade;

	public Student(String name, int age, String affiliation, int grade) {
		super(name, age,affiliation);
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(grade + "ÇÐ³â");
		System.out.println("=======================");
	}
}
