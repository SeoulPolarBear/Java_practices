
public class Company {
	// �̸� �Ե�, ��ġ�� ���, �������� 100���� ȸ��
	// �������
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
		System.out.printf("ȸ�� ���� : (�̸� : %s, ��ġ : %s , ������ : %d���� ȸ��)\n", name, position, personnel / 1000);
	}
}
