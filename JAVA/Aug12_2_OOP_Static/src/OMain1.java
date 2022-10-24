
public class OMain1 {
//게임 캐릭터 하나 생성!
//속성 : 닉네임/레벨/직업/무기
//출력하는 기능까지!
//Main에서 객체를 만들고 닉네임 값만 넣어서
//출력
public static void main(String[] args) {
	System.out.println("케릭터 생성!");
	Player player = new Player("백곰선생");
	player.setNickname("백곰선생");
	player.printInfo();
}
}
