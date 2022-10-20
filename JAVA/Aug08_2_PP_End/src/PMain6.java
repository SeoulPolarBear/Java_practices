import java.util.ArrayList;
import java.util.Scanner;

// Bubble Sort : ������ �� �׸��� ���� ���ؼ� ���ؿ� �����ϸ� ������ ���� ��ȯ�ϴ� ���� ���
public class PMain6 {

	public static int[] BubbleSort() {
		Scanner scanner = new Scanner(System.in);
		//���ڸ� �Է� �޾Ƽ� �迭�� ���� ��(���ڴ� 5��)
		System.out.println("���� 5���� �Է��Ͻÿ�. : ");
		
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		//���� ���� ���� ���
		for (int i : array) {
			System.out.print(i + " ");
		}System.out.println();
		//����
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
	
	public static ArrayList<Integer> BubbleSort(int k, ArrayList<Integer> Array){//k�� ��� �ε������� �� ���ΰ�, Array�� ���� ���Ѿ� �ϴ� �迭
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
		
		
		
		
		
		//���� ���� ���� ���
	}
}
