
public class Company {
	// 이름 롯데, 위치가 잠실, 직원수가 100명인 회사
	// 정보출력
	private String name;
	private String position;
	private int personnel;

	public Company(String name, String position, int personnel) {
		super();
		this.name = name;
		this.position = position;
		this.personnel = personnel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPersonnel() {
		return personnel;// employee
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public void CompanyInfo() {
		System.out.printf("회사 정보 : (이름 : %s, 위치 : %s , 직원수 : %d만인 회사)\n", name, position, personnel / 1000);
	}
}
