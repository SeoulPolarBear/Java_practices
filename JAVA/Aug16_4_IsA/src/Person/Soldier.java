package Person;

public class Soldier extends Person {
	private String rank;

	public Soldier(String name, int age, String affiliation, String rank) {
		super(name, age,affiliation);
		this.rank = rank;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(rank);
		System.out.println("=======================");
	}
}
