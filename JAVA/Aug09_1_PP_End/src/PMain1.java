import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PMain1 {
public static void main(String[] args) {
	//10���� ���ڸ� �������� �̾Ƽ� (1~100)
	//�迭�� ��� -> ���!
	
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	int[] array = new int[10];
	
	for (int i = 0; i < array.length; i++) {
		array[i] = random.nextInt(100) + 1;
		System.out.print(array[i] + " ");
	}System.out.println();
	
	int Max = array[0];
	int Min = array[0];
	
	for (int i = 0; i < array.length; i++) {
		if(Min > array[i]) Min = array[i];
		else if(Max < array[i]) Max = array[i];//�Ƹ� Min���� array[i]�̸� Max�� �翬�� array[i]���� ũ�ϱ� else if ����� �� ����.
	}System.out.println(Max);System.out.println(Min);
	
	for (int i : array) {
		System.out.print(i + " ");
	}
	int max_or = Arrays.stream(array).max().getAsInt();
	int min_or = Arrays.stream(array).min().getAsInt();
	
	System.out.printf("�ִ� : %d �ּڰ� : %d",max_or,min_or);
	System.out.println();
	
	
	
//	for (int i = 0; i < array.length; i++) {
//		System.out.printf("%d ��° �� : \n", i + 1);
//		array[i] = scan.nextInt();
//	}Arrays.sort(array);
//	
//	
//	for (int i : array) {
//		System.out.print(i + " ");
//		
//	}System.out.print(" ");
//	int max = Arrays.stream(array).max().getAsInt();
//	int min = Arrays.stream(array).min().getAsInt();
//	System.out.printf("�ִ� : %d �ּڰ� : %d",max,min);
}
}
