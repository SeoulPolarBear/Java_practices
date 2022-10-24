//oop
//static
//생성자
//객체간의 관계
//	A has a B : 사람 has a 핸드폰
//	A is a B : 개 is a 동물
public class HMain1 {
	public static void main(String[] args) {
		// 이름이 청포도, 맛이 청포도맛인 사탕
		// 정보를 출력

		Candy candy = new Candy("청포도", "청포도맛");
		candy.printInfo();

		// 이름 롯데, 위치가 잠실, 직원수가 100명인 회사
		// 정보출력
		Company company = new Company("롯데", "잠실", 100000);
		company.CompanyInfo();

		// 청포도 사탕을 롯데에서 만들었다.

		Computer computer = new Computer("i7-1234", 32, 500, new Company("삼성전자", "수원", 3000000));
		computer.printInfo();
	}
}
