import java.util.Scanner;

public class RMain6 {
	public static void main(String[] args) {
		//반복문 10번 -> 반복문 1번 돌때마다 안녕하세요 3번씩 출력
		//=> 값자기 숫자 3이 맘에 안들어서...
			for(int i = 0;i < 10; i++) {
				
				if(i == 3) {
					continue;
				}
				System.out.println(i);
				System.out.println("안녕하세요 1트");
				System.out.println("안녕하세요 2트");
				System.out.println("안녕하세요 3트");
		}
			
			for (int i = 0; i < 10; i++) {
				if(i%2==0) {
					System.out.println("와!");
				}else {
					/*
					 * continue;//다음 턴으로 넘어감 
					 * break;//(공식적으로) 반복문을 종료 
					 * return;//(비공식적), 함수가 끝, 반복문이
					 * 깨짐!
					 */				}
			}
				
				//코멘트 내용을 입력 받을 건데, 내용은 계속 받아올것
				//내용이 "ㅎㅇ"면 반복문 끝!
				String commentString = new Scanner(System.in).next();
				while(true) {
					System.out.println("멘트 ㄱㄱ : ");
					commentString = new Scanner(System.in).next();
					
					if(commentString.equals("ㅎㅇ")){
						System.out.println("인사를 이제 받아주네");
						break;
					}
				}
				
			
	}
}
