//객체간의 관계
//		A is a B : Dog is a Animal 상속관계
public class IMain1 {
	public static void main(String[] args) {
		//동물(Animal) 객체 => sort, age
		
		Dog cat = new Dog("달마시안", 10, "밤마다 집을 나간다.");
		cat.printInfo();
	}
}
