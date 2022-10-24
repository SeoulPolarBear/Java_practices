
public class Dog extends Animal{
	String inhabit;

	public Dog(String sort, int age, String inhabit) {
		super(sort, age);//기본생성자
		this.inhabit = inhabit;
	}


	//@XXX : Annotation -> 어떤 기능을 자동으로 연결해준다.
	@Override //상속받아온 method의 기능을 바꾸는 것
	public void printInfo() {
		//override를 사용하려면...
		//		상속받은 Class에서의 method명과 같아야!!
		super.printInfo();//super를 뜻하며 상위클래스.printInfo(); 사용하겠다.
		System.out.println(inhabit);
	}
	
	//VS
	//Overriding (//상속받아온 method의 기능을 바꾸는 것)
	//vs 
	//Overloading(메소드를 만들 때 같은 기능이라면 메소드명을 같게!
	//파라미터의 자료형이 다르거나, 파라미터의 개수가 달라야 함!
	
}
