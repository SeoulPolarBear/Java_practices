//part1 : 절차지향 프로그래밍(순서대로 잘 써서 결과를 잘 내자) - 이과스럽다.
//part2 : 객체지향 프로그래밍 - 문과스럽다...
//part3 : 기타 등등... 외부 라이브러리

/**
 * 조건문
 * 반복
 * 배열
 * ------------------------>정보올림피아드 문제
 * 
 * */
public class RMain7 {
	//누구 : 매니저 - 시스템관리, 학생관리, 수업관련 업무,
	//			강사 - 학생관리, 수업관련 업무
	//			학생 - 수업관련 업무를 반복하다가 "끝"이라고 입력하면 프로그램 종료!
	public static void main(String[] args) {
//		System.out.println("누군지 입력ㄱㄱ : ");
//		String comment = new Scanner(System.in).next();
//		a : while(!comment.equals("끝")) {// a는 반복문의 이름 -> 반복문 앞이 이름 : 
//			switch(comment) {
//			case "매니저":
//				System.out.println("시스템관리 ");
//			case "강사":
//				System.out.println("학생관리 ");
//			case "학생":
//				System.out.println("수업관련 업무");
//				break;
//			case "끝":
////				break;// 이렇게 할 경우 무조건 가까운 거(switch)를 종료 시킨다. => 즉, 중 가로 기준으로 종료를 시킨다.
//				break a;//따라서 이렇게 'break 반복문의 이름;' 이렇게 할 경우 반복문을 종료 시킬 수 있다.
//				default:
//					System.out.println("모르는 사람");
//					break;
//			}
//			comment = new Scanner(System.in).next();
//		}
		
		bb:for (int i = 0; i < 3; i++) {
			aa:for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					if(i == 1) {
						System.out.println("중단 !");
						
			//		break;// 1,0,0 -> 1,1,0 -> 1,2,0 -> 2,0,0 이렇게 됨
	//					break aa;// 출력이 1,0,0이고 나서 -> 2,0,0으로 넘어간다. 종료 출력 값이 없고 
				//		break bb;// 1,0,0에서 for문 자체를 종료
					}
					
				}
				
			}
			
		}
	}
}
