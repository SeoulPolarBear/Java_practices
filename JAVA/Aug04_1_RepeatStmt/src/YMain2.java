import java.util.Scanner;

//평일 스케쥴을 출력해주는 프로그램

public class YMain2 {
	// 시간을 입력 받아서 -> 해당시간에 속하는 내용을 출력
	// (입력한 시간이) 시간 범위가 아니면 다시 입력
	public static int InputHour() {
		System.out.print("24시간 기준으로 시간을 입력해주세요. : ");
		int hour = new Scanner(System.in).nextInt();
		if (24 > hour && hour >= 0) {
			return hour;
		} else {
			System.out.println("응 다시 입력해");
			return InputHour();
		}
	}

	public static void Result(int hour) {
		// 오전 9시 ~ 오후 6시 : 학원에서 공부
		if (9 <= hour && hour < 18)
			System.out.println("학원에서 공부");
		// 오후 6시 넘어서 ~오후 8시 : 집에 가는 시간
		if (18 <= hour && hour < 20)
			System.out.println("집에 가는 시간");
		// 오전 9시 , 오후 2시 , 오후 6시 QR 찍기
		if (9 == hour || hour == 18 || hour == 14)
			System.out.println("QR 찍기");
		// 오후 12시 : 점심시간
		if (12 == hour)
			System.out.println("점심시간");

		// 오전 6시 ~ 오전 9시 전까지 : 기상 + 씻기 + 학원 가기
		if (6 <= hour && hour < 9)
			System.out.println("기상 + 씻기 + 학원 가기........");
		// 오후 8시 ~ 오전 6시 : 여가시간 취침
		if ((20 <= hour && hour <= 23) || (0 <= hour && hour < 6))
			System.out.println("여가시간 취침");
	}

	public static void main(String[] args) {

		Result(InputHour());
	}

}
