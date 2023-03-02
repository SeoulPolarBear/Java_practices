#include<iostream>
#include"CArr.h"

template<typename T>//주형으로 본뜰 때 사용한다. T는 치환형이란 뜻이다.
T Add(T a, T b) {
	return a + b;
	}


int main() {
	//구조체-->클래스

	/*객체지향 언어 특징
		1.캡슐화
		기능을 수행하기 위해 필요한 멤버 선언, 묶음, 은닉성
		멤버 함수들
		
		2.상속
		
		3. 다형성
		
		4. 추상화
		구조체 버전 가변배열 -->클래스 버전
		c++ 동적할당 new, delete*/

		/* c언어에서의 역할
		tArr arr = {};
		InitArr(&arr);

		PushBack(&arr, 10);
		PushBack(&arr, 10);
		PushBack(&arr, 10);PushBack(&arr, 10);
		ReleaseArr(&arr);*/
		
		//C++에서 역할
		CArr<int> carr;
		//여기서 바로 CArr<float> carr; 하면 float단위 data 가능
		carr.push_back(10);
		carr.push_back(20);
		carr.push_back(30);
		/*carr.push_back(3.14f);
		carr.push_back(6.28f);
		carr.push_back(30.444f);
		float fData = carr[1];
		*/
		//release 부분은 소멸자에서 실행시키므로 적을 필요가 없다.

		carr[1] = 40;//이게 되게 하고 싶었다.
			//54. 레퍼런스 부가설명 그림 참조
			//결국 레퍼런스가 가리키는 것이 즉 본래 가지고 있는 변수값이랑 일치하므로
			// 이럴때 사용된다.
		//int p = carr[1];
		// int CArr::operator[](int idx)
		/*{
			return m_pInt[idx];
		}*/
		//*carr[1] = 100;//만약 이게 되려면 멤버함수는
		/*int* CArr::operator[](int idx)
		{
			return &m_pInt[idx] or m_pint+idx;
		}
		왜냐하면 기존 carr[1]의 리턴값은 결국 int형이기 때문에 레지던트에 임시로
		저장되어 있는 값이기 때문에 수정이 불가능 하다
		따라서 수정이 가능하게 하기위해서는 주소를 가져와야하기때문에 문제가 발생한다.
		*/

		int i = Add<int>(10, 20);//이렇게 하면 int 버전의 템플릿이 생긴다.
		//즉, 주형으로 만든 함수이다.
		int s = Add(10, 20);//1. 이럴 경우에도 템플릿이 int로 인식을 해서
		//(받는 변수도 int고 parameter 또한 int 타입이므로) 자동으로 함수를 사용한다.
		//2. 만약 Add함수를 만들지 않으면 함수가 없다고 생각하면 된다.
		//3. 그리고 Add 와 Add<int>와는 다른 것이다. 왜냐하면 함수 템플릿과 함수는 다르기때문
		






	///* c언어에서의 역할
	//tArr arr = {};
	//InitArr(&arr);

	//PushBack(&arr, 10);
	//PushBack(&arr, 10);
	//PushBack(&arr, 10);PushBack(&arr, 10);
	//ReleaseArr(&arr);*/
	//
	////C++에서 역할
	//CArr carr;
	//carr.push_back(10);
	//carr.push_back(20);
	//carr.push_back(30);
	////release 부분은 소멸자에서 실행시키므로 적을 필요가 없다.

	//carr[1] = 40;//이게 되게 하고 싶었다.
	//	//54. 레퍼런스 부가설명 그림 참조
	//	//결국 레퍼런스가 가리키는 것이 즉 본래 가지고 있는 변수값이랑 일치하므로
	//	// 이럴때 사용된다.
	////int p = carr[1];
	//// int CArr::operator[](int idx)
	///*{
	//	return m_pInt[idx];
	//}*/
	////*carr[1] = 100;//만약 이게 되려면 멤버함수는
	///*int* CArr::operator[](int idx)
	//{
	//	return &m_pInt[idx] or m_pint+idx;
	//}
	//왜냐하면 기존 carr[1]의 리턴값은 결국 int형이기 때문에 레지던트에 임시로
	//저장되어 있는 값이기 때문에 수정이 불가능 하다
	//따라서 수정이 가능하게 하기위해서는 주소를 가져와야하기때문에 문제가 발생한다.
	//*/

	//int i = Add<int>(10, 20);//이렇게 하면 int 버전의 템플릿이 생긴다.
	////즉, 주형으로 만든 함수이다.
	//int s = Add(10, 20);//1. 이럴 경우에도 템플릿이 int로 인식을 해서
	////(받는 변수도 int고 parameter 또한 int 타입이므로) 자동으로 함수를 사용한다.
	////2. 만약 Add함수를 만들지 않으면 함수가 없다고 생각하면 된다.
	////3. 그리고 Add 와 Add<int>와는 다른 것이다. 왜냐하면 함수 템플릿과 함수는 다르기때문
	//
	return 0;

}