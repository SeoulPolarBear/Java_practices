//Candy has a Company : ������ (v) -> û���� ����(��ü)�� �Ե����� �������.  => ��, �������� ������ �˰� ���� ���̴�. 
//Company has a candy : ��ǰ
//��, Ȩ�������� ������ �Ｚ �귣��� ��ǰ/ ���� ���ָ� ������� ���� �ȴ�.
public class Candy {
	private String name;
	private String tasty;
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Candy() {
		// TODO Auto-generated constructor stub
	}

	public Candy(String name, String tasty) {
		super();
		this.name = name;
		this.tasty = tasty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTasty() {
		return tasty;
	}

	public void setTasty(String tasty) {
		this.tasty = tasty;
	}

	public void printInfo() {
		System.out.printf("�̸� : %s, �� : %s�� ����\n", name, tasty);
	}

}
