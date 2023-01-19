import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("5명의 학생의 점수를 입력하세요.");
		int count=0;
		int sum=0;
		for(int i=0;i<5;i++) {
			int n=scanner.nextInt();//정수를 입력하십시오
			if(n<=60)
				continue; //양수가 아닌 경우 다음 반복으로 진행
			else
			    count++;
				sum+=n; // 양수인 경우 덧셈
		}
		System.out.println("60점 이상인 학생들의 점수의 평균은 "+(double)sum/count);

		scanner.close();
	}


	

}
