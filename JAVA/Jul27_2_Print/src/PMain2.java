
public class PMain2 {

	public static void main(String[] args) {
		/**Escape Sequence(이스케이프 문자)
		 * 특수한 문자나 특수한 기능을 표현할 때
		 * \특수문자 : \앞의 특수문자를 일반 문자로 사용 -> 경로를 설정할 때 사용한다. ex)"C:\\Users\\user\\Desktop"
		 * \n : New Line(줄만 맞추는 용도로 사용한다.)
		 * \t : tab키(줄 맞추는 용도)
		 * \b : Backspace키 -> 하지만 Java에서는 사용 X Java는 Unicode를 사용하는데 backspace는 ASCII 코드와 같이 1byte만 지우므로 폰트가 깨지게 된다.
		 * \r : Carriage Return (커서를 맨 앞으로 보내준다.)
		 * \r\n : enter와 같은 역할을 한다. 
		 * \0 : 빈칸(Space키)
		 * 
		 */ 
		
	
		 /** 
		 * 현재 : 가볍게 확인용도로 사용하는 콘솔창이라서 \r 이나 \n 둘 중에 하나만 있어도 enter키 처리가 가능함
		 * 파일 처리 / 통신 " \n이나 \r 하나만 쓰게 되면... 다 뒤집어질 수도 있음
		 * ->이클립스 안에서는 \r과 \n을 구분하기는 어렵다.
		 * -> \n으로 엔터처리를 하고, 이후에 파일처리에서 \r,\n을 보자
		 * 
		 * 
		 * \n*/
		
		System.out.println("New Line\n                           " + "\rclass\0"+ " " + "good" + "\t" + "get" + "\b" + "name" );

		
		//\(^_^)/ 출력
		System.out.println("\\(^_^)/");
		//\(".")/ 출력
		System.out.println("\\(\".\")/");
		
	}

}
