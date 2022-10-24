//Candy has a Company : 제조사 (v) -> 청포도 사탕(주체)을 롯데에서 만들었다.  => 즉, 제조사의 정보를 알고 싶은 것이다. 
//Company has a candy : 제품
//즉, 홈페이지의 물건이 삼성 브랜드면 제품/ 물건 위주면 제조사로 가면 된다.
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
		System.out.printf("이름 : %s, 맛 : %s인 사탕\n", name, tasty);
	}

}
