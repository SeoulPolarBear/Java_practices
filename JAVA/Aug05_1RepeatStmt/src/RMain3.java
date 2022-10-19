
public class RMain3 {
	public static void main(String[] args) throws InterruptedException {
		// 초시계
		// 일자 시 분 초 => 각각에 for문 이용
		// 1초마다 초 값이 증가

		System.out.println("실행 시작");
		for (int day = 0; day < 30; day++) {
			for (int hour = 0; hour < 24; hour++) {
				for (int min = 0; min < 60; min++) {
					for (int sec = 0; sec < 60; sec++) {
						System.out.printf("[Day%02d] %02d:%02d:%02d\n", day, hour, min, sec);
						Thread.sleep(1000);
					}
				}
			}
		}
	}
}
