import java.util.Scanner;

public class OMain3 {
	public static void main(String[] args) {
		//키(cm), 나이를 입력받아서 출력
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("키와 나이를 입력하시오");
		double height = scanner.nextDouble();
		int age = scanner.nextInt();
		
		System.out.printf("키 : %.1f 나이 : %d\n",height, age);
		
		//나이가 10살이 넘는 사람만 탈 수 있음 판정을 해달라 논리 연산자
		
		
		
		System.out.printf("놀이기구를 탈 수 있습니까? : %b\n", age > 10);
		System.out.printf("어린이 놀이기구를 탈 수 있습니까? : %b\n", age < 5);
		System.out.printf("전용 놀이기구를 탈 수 있습니까? : %b\n", age == 20);
		System.out.printf("이 놀이기구를 탈 수 있습니까? : %b\n", age != 1);
		System.out.printf("이 놀이기구를 탈 수 있습니까? : %b\n", age%2 == 1);
		
		//업그레이드
		// ~고(and) &&
		// ~또는(or) ||
		// xor      ^	(exclusive OR) => 두 입력이 서로 다를 때  (Abar and B) or (A and Bbar)
		//              1 1 0      1 0 1
		//				0 0 0      0 1 1
		//not 		! 결과를 뒤집는 연산자
		
		
		
		
		
		System.out.printf("이 놀이기구를 탈 수 있습니까? : %b\n", age%2 == 1);
		//내가 작성한 것 
		System.out.printf("나이가 3살이 넘고, 키가 2m 넘어야 탈 수 있음 이 놀이기구를 탈 수 있습니까? : %b\n", age > 3 && height>200);
		//하지만 최적화를 시키기 위해서는 A, B 중 충족하기 힘든 것을 앞에다 적어주는 것이 좋다. 왜냐하면 &&앞에 있는 것부터 검사를 하기 때문이다.
		//따라서 다음과 같이 적는 것이 바람직하다. and, or 등 모두 고려할 필요가 있다.
		//즉, 확률이 낮은 조건을 앞으로 배치 해야한다. 즉, 95% && 5% 보다 5% && 95%가 더 깔끔한 코드이다.
		System.out.printf("나이가 3살이 넘고, 키가 2m 넘어야 탈 수 있음 이 놀이기구를 탈 수 있습니까? : %b\n",height>200 && age > 3);
		
		//키가 1.9m가 넘거나 나이가 50살 미만이면 탈 수 있는 놀이기구 								or 앞(age)이 1이 되는게 효율적(앞이 높은 확률)
		System.out.printf("키가 1.9m가 넘거나 나이가 50살 미만이면 탈 수 있는 놀이기구 가능? : %b\n",age< 50 || height >190);
		//10 < 나이 < 40이면 탈 수 있음
		System.out.printf("나이 10살 초과 40 미만 입니까? : %b\n", age < 40 && age > 10);
		//나이가 10살 이상이던지, 키가 1.5m이상이던지 하나만 조건을 만족할 경우만 탑승이 가능하다.
		boolean ride9 = (age >= 10) ^ (height >= 150);
		System.out.printf("나이 10살 이상 이거나 1.5m 둘중에 하나만 만족해야 한다. 그렇습니까? : %b\n", ride9);
		
		//나이가 10살 이상이던지, 키가 1.5m이상이던지 하나만 조건을 만족할 경우만 탑승이 가능하다. 이거 가능한 사람은 못 타고 이거 불가능한 사람만 탈 수 있다.
		System.out.printf("나이 10살 이상 이거나 1.5m 둘중에 하나만 만족해야 한다. 그렇습니까? " + 
		"이거 가능한 사람은 못 타고 이거 불가능한 사람만 탈 수 있다." + " : %b\n", !ride9);
		
	}
}
