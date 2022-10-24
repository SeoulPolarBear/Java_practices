package Person;

public class IMain3 {
	public static void main(String[] args) {
		//홍길동 17살 판교 고등학교 1학년
		//김길동 21살 성균과대 2학년
		//고길동 22살 육군 상병
		Student student1 = new Student("홍길동", 17, "판교 고등학교", 1);
		Student student2 = new Student("김길동", 21, "성균관대학교", 2);
		Soldier soldier = new Soldier("고길동", 22, "육군", "상병");
		student1.printInfo();
		student2.printInfo();
		soldier.printInfo();
	}
}
