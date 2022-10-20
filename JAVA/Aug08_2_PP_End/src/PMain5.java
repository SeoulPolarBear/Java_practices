public class PMain5 {
	//면접 문제...!!
	//Call by Value, Call by Reference
	
	//어떻게 답이 도출되었는지 설명할 수 있어야...
	//Call by Value : 변수의 '값'을 복사해서 함수의 파라미터 값으로 사용하는 것
	//Call by Reference : 변수를 참조하는 주소값(번지값)을 파라미터를 값으로 사용하는 것
	public static void test(int a, int[] b, int[] c) {// 즉, int[] c = 기존 c의 번지 값(복사본); 이렇게 보면 된다.
		System.out.println("b(green)" + b);//asdgaSDG
		System.out.println("c(green)" + c);//ASGFDAWEGWE 즉, 여기서 c의 값은 복사본이다. 
		System.out.println("a(green)" + a);//10
		System.out.println(b[0]);//10
		System.out.println(c[0]);//10
		a = 100;
		b[0] = 100;//b는 test의 새로운 배열이지만 여기 b 역시 가리키는 주소가 main의 b와 같으므로 주소를 찾아가 값을 바꾸면 값이 바뀐다.
		//main쪽에 영향을 줌(참조형)
		//기본형과 참조형의 차이 !
		
		//new int[] : 말 그대로 새로운 수(new)
		//new int[] 꼭 써줘야 -> 약식을 못 쓰는 이유(정규식이 아니라서)
		
		
		
		c = new int[] {100, 200};//새로 참조를 시켰으므로 결국 다른 주소를 다시 갖게 된다. 즉, c의 값이 바뀌고 나서 날라간다. 
		//main 함수와 완전히 다른 c를 만들어 냈고 이는 결국 함수가 끝나면 c와 b는 없어진다.
		System.out.println(b);
		System.out.println(c);
		System.out.println(a);//100
		System.out.println(b[0]);//100
		System.out.println(c[0]);//100
		
	}
	public static void main(String[] args) {
		int a = 10;
		int[] b = {10, 20};
		int[] c = {10, 20};
		System.out.println("b(red)" + b);//ASDFAEG
		System.out.println("c(red)" + c);//ASDGAWEG
		System.out.println("-------------------------------");
		test(a,b,c);
		System.out.println(a);//10
		System.out.println(b[0]);//100
		System.out.println(c[0]);//10(100으로 해서 틀렸었다.)
		//값 변경에 영향을 받지 않았음
		//test 함수의 c와는 다르기 때문에
	}
}

