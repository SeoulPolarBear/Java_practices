import java.util.Scanner; 
public class NumberOfWordSegment {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		while(true) {
			System.out.print(">>");
			String string = scanner.nextLine();//어절의 개수를 알고 싶은 문장 입력
	
			if(string.equals("그만")) {
				System.out.println("프로그램을 종료합니다!");
				break;//사용자가 "그만" 입력할 시 프로그램 종료
		} 
	String StringArray[] = string.split(" ");//공백을 기준으로 배열
System.out.println("어절의 개수는 " + StringArray.length + "개입니다.");//어절 개수 출력
		}
		scanner.close();
	}
}
