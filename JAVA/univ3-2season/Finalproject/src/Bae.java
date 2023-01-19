
import java.util.Scanner;
import java.util.InputMismatchException;

public class gamesimulation {
	public static void main(String args[]) {
		System.out.println("** 게임 강화 및 확률형 아이템 뽑기 기댓값 계산 시뮬레이션 프로그램입니다.\n"
				+ "강화 기댓값 시뮬레이션은 1, 아이템 뽑기 기댓값 시뮬레이션은 2를 입력해 주세요.\n"
				+ " 그 외의 숫자 또는 문자 입력 시 프로그램 사용 주의사항이 출력됩니다. **");
		Scanner scanner = new Scanner(System.in);
		int answer = 0;
		try {
		answer = scanner.nextInt(); // 0 또는 1 또는 2 입력
		}
		catch(InputMismatchException e) {
			System.out.println("프로그램 사용 주의사항 >> 데이터 값 입력 시 %, $ 등 별도의 단위를 입력할 필요 없으며,"
					+ "확률 입력 시 반드시 1~100 사이의 정수를 입력해 주시길 바랍니다.");
			System.out.println("모든 데이터는 적절한 범위의 정수 값을 입력해 주시고,"
					+ "범위 밖을 벗어난 값은 모두 최솟값으로 자동 설정됩니다.");
		}
		if(answer == 1) { // 강화 기댓값 시뮬레이션
			System.out.println("강화 기댓값 시뮬레이션 >> 강화 최대 레벨을 입력해 주세요. (최소 1 이상)");
			int level = 1;
			try {
			level = scanner.nextInt(); // 강화 최대 레벨 설정
			}
			catch(InputMismatchException e) {
				level = 1;
			}
			if(level < 1) {
				level = 1;
			}
			System.out.println("강화 레벨별 성공 확률과 소모 재화를 설정해 주세요. (확률 최소 1 이상, 재화 최소 0 이상)");
			int count = 0, sumcount = 0, money = 0, summoney = 0;
			for(int i=1; i<level; i++) {
				System.out.print(i + "->" + (i+1) + " 레벨 강화 시 확률 >> ");
				int levelprob = 1;
				try {
				levelprob = scanner.nextInt(); // 사용자가 강화 레벨별 확률을 직접 입력
				}
				catch(InputMismatchException e) {
					levelprob = 1;
					scanner.next();
					i--;
					continue;
				}
				if(levelprob < 1 || levelprob > 100) {
					levelprob = 1;
				}
				System.out.print(i + "->" + (i+1) + " 레벨 강화 시 소모 재화 >> ");
				try {
				money = scanner.nextInt(); // 사용자가 강화 레벨별 소모 재화를 직접 입력
				}
				catch(InputMismatchException e) {
					money = 0;
					scanner.next();
					i--;
					continue;
				}
				if(money < 0) {
					money = 0;
				}
				count = 100 / levelprob;
				summoney = money * count + summoney;
				sumcount = count + sumcount;
			}
			System.out.print("결과 >> 최대 " + level + "레벨까지의 강화 시도 예상 횟수는 " + sumcount
					+ "회이며, 예상되는 총 소모 재화는 " + summoney + "입니다.");
		}
		
		else if(answer == 2) { // 아이템 뽑기 기댓값 시뮬레이션
			int money = 0, count = 0;
			System.out.println("아이템 뽑기 기댓값 시뮬레이션 >> 획득하고자 하는 아이템의 확률을 설정해 주세요. (최소 1 이상)");
			int itemprob = 1;
			try {
			itemprob = scanner.nextInt(); // 사용자가 강화 레벨별 확률을 직접 입력
			}
			catch(InputMismatchException e) {
				itemprob = 1;
				scanner.next();
			}
		if(itemprob < 1 || itemprob > 100) {
			itemprob = 1;
		}
		System.out.println("1회 뽑기 시 소모 재화를 입력해 주세요. (최소 0 이상)");
		try {
			money = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			money = 0;
			scanner.next();
		}
		if(money < 0) {
			money = 0;
		}		
		System.out.println("뽑기 횟수를 설정해 주세요. (최소 1 이상)");
		try {
			count = scanner.nextInt(); // 사용자가 뽑기 횟수를 직접 입력
		}
		catch(InputMismatchException e) {
			count = 1;
			scanner.next();
		}
		if(count < 1) {
			count = 1;
		}
		int getitem = count * itemprob / 100;
		int firstget = 100 / itemprob;
		System.out.print("결과 >> " + firstget + " 번째 뽑기에서 아이템을 획득할 것으로 예상되며,\n"
		+ "총 " + count * money + "만큼의 재화 소비 시 " + count + " 회 뽑기 중 " + getitem + " 개의 아이템을 획득할 것으로 예상됩니다.");
	}
		
		else {
			System.out.println("프로그램 사용 주의사항 >> 데이터 값 입력 시 %, $ 등 별도의 단위를 입력할 필요 없으며,"
					+ "확률 입력 시 반드시 0~100 사이의 정수를 입력해 주시길 바랍니다.");
			System.out.println("모든 데이터는 적절한 범위의 정수 값을 입력해 주시고,"
					+ "범위 밖을 벗어난 값은 모두 최솟값으로 자동 설정됩니다.");
		}
		scanner.close(); // scanner 닫기
	}