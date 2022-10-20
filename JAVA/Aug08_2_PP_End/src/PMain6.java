import java.util.ArrayList;
import java.util.Scanner;

// Bubble Sort : 인접한 두 항목의 값을 비교해서 기준에 만족하면 서로의 값을 교환하는 정렬 방법
public class PMain6 {

	public static int[] BubbleSort() {
		Scanner scanner = new Scanner(System.in);
		//숫자를 입력 받아서 배열에 담을 것(숫자는 5개)
		System.out.println("숫자 5개를 입력하시오. : ");
		
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		//정렬 전의 값을 출력
		for (int i : array) {
			System.out.print(i + " ");
		}System.out.println();
		//정렬
		int k = array.length;
		while(k != 0) {
			for(int i = 0; i < k -1 ; i++) {
				if (array[i]>array[i + 1]) {
					int a = array[i + 1];
					array[i + 1] = array[i];
					array[i] = a;
				}
			}
			k--;
		}
		return array;
	}
	
	public static ArrayList<Integer> BubbleSort(int k, ArrayList<Integer> Array){//k는 어느 인덱스까지 할 것인가, Array는 정렬 시켜야 하는 배열
		if (k == 0) {
			return Array;
		}
		else {
			for (int i = 0; i < k; i++) {
				if (Array.get(i) > Array.get(i + 1)) {
					int temp = Array.get(i);
					Array.set(i,Array.get(i+1));
					Array.set(i+1,temp);
				}
			}
			return BubbleSort(k - 1,Array);
		}
		
	}
	
	public static int[] getResult(int[] num) {
		int b = 0;
		for (int turn = 1; turn < num.length; turn++) {
			for (int i = 0; i < num.length-1; i++) {
				if(num[i] > num[i + 1]) {
					b = num[i + 1];
					num[i + 1] = num[i];
					num[i] = b; 
				}
			System.out.print(num[i] + " ");
			}
			System.out.println(num[4]);	
		}
		return num;
	}
	
	public static void main(String[] args) {
		for (int num : BubbleSort()) {
			System.out.print(num + " ");
		}System.out.println();
		
		ArrayList<Integer> Array = new ArrayList<>();
		
		Array.add(10);
		Array.add(16);
		Array.add(80);
		Array.add(1);
		Array.add(13);
		for (Integer integer : BubbleSort(Array.size() - 1, Array)) {
			System.out.print(integer + " ");
		}System.out.println();
		int[] array = {10,5,4,101,54};
		getResult(array);
		
		
		
		
		
		//정렬 후의 값을 출력
	}
}
