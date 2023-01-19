import java.util.Scanner;

public class MoviePrice {

	public static void main(String[] args) {
		
System.out.println("자신의 만으로 나이(ex)20), \n"
		+ "영화 시간대(조조,일반,심야), \n"
		+ "통신사 번호(SKT는 1을,KT는 2를,LGU+는 3을 해당되는 통신사가 없으시면 4번을 입력해주세요.), \n"
		+ "오늘 날짜(ex)0406)를 입력하시오\n"
+" 그리고 블랙프라이 데이기간인 11월27일~12월04일도 확인하세요.(단 통신사 할인은 받지 않습니다.)\n");
		Scanner scanner=new Scanner(System.in);
	        
	System.out.print("만 나이 : ");
	int age= scanner.nextInt();
	System.out.print("영화 시간대(조조, 일반, 심야) : ");
	String time = scanner.next();
	System.out.print("통신사 : ");
	int telecom=scanner.nextInt();
	System.out.print("오늘 날짜 : ");
	int day = scanner.nextInt();
	int price=0;
if(telecom ==1) {
	if(age<=70&age>=19) {
					
		switch(time) {
		case "조조":
		price= 8000;
		break;
		case "일반":
		price=10000;
		break;
		case "심야":
		 price=7000;
		break;
			}
System.out.println("성인은 SKT 할인 혜택 시 10% 할인 돼서 "+price*90/100+"원 입니다.");
				
			}
				
	else if(age<= 14&age>= 8) {
		switch(time) {
		case "조조":
		price=6000;
						System.out.println("청소년은 SKT 할인 혜택 시 5% 할인 돼서 "+price*90/100+"원 입니다.");
		break;
		case "일반":
		price=8000;
							System.out.println("청소년은  SKT 할인 혜택 시 5% 할인 돼서"+price*90/100+"원 입니다.");
		break;
		case "심야":
  String x="청소년은 심야 영화 관람이 불가합니다.";
		System.out.println(x);	
		 break;			
		}
	}
	else {
		switch(time) {
		case "조조":
		price=4000;
		break;
		case "일반":
		price=6000;
		break;
		case "심야":
		price=3000;
		break;
					
	}
System.out.println("유아 혹은 노인은  SKT 할인 혜택 시 10% 할인 돼서  "+price*90/100+"원 입니다.");
		}
	}
else if(telecom ==2) {
	if(age<=70&age>=19) {
		switch(time) {
		case "조조":
		price= 8000;
		break;
		case "일반":
		price=10000;
		break;
		case "심야":
		price=7000;
		break;
	} 
System.out.println("성인은 KT 할인 혜택 시 15% 할인 돼서 "+price*85/100+"원 입니다.");
	}
	else if(age<= 14&age>= 8) {
		switch(time) {
		case "조조":
		price=6000;
						System.out.println("청소년은 KT 할인 혜택 시 5% 할인 돼서 "+price*85/100+"원 입니다.");
		break;
		case "일반":
		price=8000;
							System.out.println("청소년은 KT 할인 혜택 시 5% 할인 돼서"+price*85/100+"원 입니다.");
		break;
		case "심야":
String x="청소년은 심야 영화 관람이 불가합니다.";
	System.out.println(x);	
		break;				
	}
}
		else {
		switch(time) {
		case "조조":
		price=4000;
		break;
		case "일반":
		price=6000;
		break;
		case "심야":
		price=3000;
		break;
			}
System.out.println("유아 혹은 노인은  KT 할인 혜택 시 15% 할인 돼서 "+price*85/100+"원 입니다.");
			}
	}
else if(telecom ==3) {
	if(age<=70&age>=19) {
		switch(time) {
		case "조조":
		price= 8000;
		break;
		case "일반":
		price=10000;
		break;
		case "심야":
		price=7000;
		break;
	}
System.out.println("성인은 LGU+ 할인 혜택 시 5% 할인 돼서 "+price*95/100+"원 입니다.");
		}
	else if(age<= 14&age>= 8) {
		switch(time) {
		case "조조":
		price=6000;
						System.out.println("청소년은 LGU+ 할인 혜택 시 5% 할인 돼서 "+price*95/100+"원 입니다.");
		break;
		case "일반":
		price=8000;
							System.out.println("청소년은 LGU+ 할인 혜택 시 5% 할인 돼서"+price*95/100+"원 입니다.");
		break;
		case "심야":
String x="청소년은 심야 영화 관람이 불가합니다.";
System.out.println(x);	
		break;			
		}
	}
	else {
		switch(time) {
		case "조조":
		price=4000;
		break;
		case "일반":
		price=6000;
		break;
		case "심야":
		price=3000;
		break;
		}
System.out.println("유아 혹은 노인은   LGU+ 할인 혜택 시 5% 할인 돼서 "+price*95/100+"원 입니다.");
		}
}
	else{if(70>=age&age>=19) {
		switch(time) {
		case "조조":
		price= 8000;
		break;
		case "일반":
		price=10000;
		break;
		case "심야":
		price=7000;
		break;
	}
System.out.println("성인은 할인 혜택이 없으시면 "+price+"원 입니다.");
}
	else if(14>=age &age>= 8) {
		
		switch(time) {
		case "조조":
		price=6000;
System.out.println("청소년은 할인 혜택이 없으시면 "+price+"원 입니다.");
		break;
		case "일반":
		price=8000;
System.out.println("청소년은 할인 혜택이 없으시면 "+price+"원 입니다.");
		break;
		case "심야":
String x="청소년은 심야 영화 관람이 불가합니다.";
System.out.println(x);	
		 break;
	}
}
	else {
		switch(time) {
		case "조조":
		price=4000;
		break;
		case "일반":
		price=6000;
		break;
		case "심야":
		price=3000;
		break;
	}
System.out.println("유아 혹은 노인은 할인 혜택이 없으시면 "+price+"원 입니다.");
	}
}
if(day>=1127&1204>=day) 
System.out.println("블랙 프라이데이 기간 에는 모든 가격이 반값입니다. 따라서"+price*50/100+" 원 입니다.");

else 
System.out.println("오늘은 블랙 프라이데이 기간이 아닙니다.");
	        
scanner.close();
	       		
	}
}
