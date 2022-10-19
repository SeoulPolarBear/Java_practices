import java.util.Scanner;

public class CMain5 {
	//직업 : DBA(상위 데이터베이스 관리자) => 전원관리, 백업/복구, 명령어로 CRUD, 서비스 활용
	//DBP(데이터베이스 프로그래머) 명령어 CRUD, 서비스 활용, DBU(사용자) 서비스 활용
	public static String Career() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("직업이 뭐냐? : ");
		String Career = scanner.next();
		return Career;
	}
	
	public static void main(String[] args) {
		switch (Career()) {
		case "DBA":
			System.out.println("전원관리, 백업/복구, ");
			break;

		default:
			break;
		}
	}
	
}
