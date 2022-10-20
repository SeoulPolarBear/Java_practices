import java.util.Scanner;

public class YMain1 {
	// ATM기능을 하는 프로그램
	// 1을 고르면 예금 / 2를 고르면 출금/ 3을 고르면 잔고 확인 / 4를 고르면 프로그램을 종료
	public static int Deposit() {
		return new Scanner(System.in).nextInt();
	}
	public static int depositResult(int balance,int deposit) {
		return balance + deposit;
	}
	public static int Withdraw() {
		return new Scanner(System.in).nextInt();
	}
	
	public static int withdrawResult(int balance,int deposit) {
		return balance - deposit;
	}

	public static void Finish() {

	}

	// 돈 값은 입력을 받을 것(입금, 출금)
	// main 함수에!
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int button = 0;
		int balance = 0;
		while(button != 4) {
			System.out.println("1을 고르면 입금 / 2를 고르면 출금/ 3을 고르면 잔고 확인 / 4를 고르면 프로그램을 종료");
			 button = scan.nextInt();
			 
			 if(button == 1) {//예금
				 System.out.println("입금을 선택하셨군요. 넣을 금액을 입력해주세요");
				int deposit = Deposit();
				if(deposit >=0) {
					System.out.printf("%d원 입금합니다.\n", deposit);
					System.out.println();
					balance = depositResult(balance, deposit);
				}else {
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
					System.out.println();
					continue;
				}
			}
			 else if(button == 2) {//출금
				 System.out.println("출금을 선택하셨군요. 출금할 금액을 입력해주세요");
				int withdraw = Withdraw();
					if(withdraw >=0) {
						System.out.printf("%d원 출금 합니다.\n", withdraw);
						System.out.println();
						balance = withdrawResult(balance, withdraw);
					}else {
						System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
						System.out.println();
						continue;
					}
					
				 
			 }else if(button == 3) {//잔고 확인
				 System.out.println("잔고확인을 누르셨군요.");
					System.out.printf("잔고는 %d원 남았습니다.\n",balance);
					System.out.println();
				}
			 
			 else if(button == 4) {// 프로그램 종료
				 System.out.println("프로그램을 종료합니다.");
			 }
			 else{
				 System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				 System.out.println();
				 continue;
			 }
		}
		
		//switch문을 사용시 마지막 프로그램 종료할 경우에는 while에 이름 붙혀서 종료시키는 방법도 있다. a : while// break a;
	}
}
