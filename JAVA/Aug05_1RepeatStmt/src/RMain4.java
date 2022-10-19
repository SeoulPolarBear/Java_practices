//for(변수 초기화; 조건식; 값의 증감)
public class RMain4 {
	public static void main(String[] args) {
		// 1~100까지의 정수 중에서 6의 배수만 더한 값을 출력
		int sum = 0;
		for (int i = 1; i * 6 < 100; i++) {
			sum += i * 6;
		}
		System.out.println(sum);

		// 4x + 5y = 60이 되는 해(정수)를 모두 구해서
		// (x,y)의 형태로 출력
		// x,y는 둘 다 10이하의 정수(1~10)
		int x = 0;
		for (int j = 1; j <= 10; j++) {
			for (int i = 1; i * 4 + j * 5 <= 60; i++) {
				if (i * 4 + 5 * j == 60) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}

	}
}
