#include<iostream>
#include"CArr.h"
#include "CList.h"
#include<vector>
#include<list>


namespace MYSPACE {
	int g_int;//전역변수가 된다. 함수 안에 선언 한것이 아니므로
}
namespace OTHERSPACE {
	int g_int;
}

void MyEndL()//endl의 함수
{
	wprintf(L"\n");
}

//using namespace std;//이렇게 선언하면 namespace의 MYSPACE::이 부분을 쓸 필요가 없어진다.
//하지만 이렇게 되면 namespace의 존재이유를 상실해 버린다. 중복에 대응을 못하므로

using std::cout;//다음과 같이 특정 기능만 std::cout 이렇게 쓸 필요 없이 cout를 바로 쓸 수 있게 해준다.
using std::endl;//즉 중첩되지 않을 선에서 사용하면 유용하다.
using std::vector;
using std::list;

class CTest {
public:
	int m_i;

public://자동으로 만들어 지는 것
	CTest& operator =(const CTest& _other)
	{
		m_i = _other.m_i;
		return *this;
	}
public:
	CTest()
		:m_i(0)
	{

	}


	//자동으로 만들어 지는 것, 근데 내가 만들었다 생성자 오버로딩
	//=> 그렇게 되면 컴파일러는 자동으로 기본 생성자를 만들어주지 않는다.
	//시험에 자주 나오는 질문!~!!!!!!!!!!!!!!!
	CTest(const CTest& _other)
		:m_i(_other.m_i)
	{

	}
	//객체 없이 호출 가능
	static void MemberFunc() {

	}
};

class CMyOStream {
public:
	CMyOStream& operator << (int _data) //extern ostream cout; 즉 외부 cout는 객체이다. 
	{// cout << "안녕" << (10 << endl 이부분이 this여야지 다음에 대입할 때도 사용) 
	//이기 떄문에 반환 타입을 자기 자신으로 해야한다.
		wprintf(L"%d", _data);

		return *this;
	}

	CMyOStream& operator << (const wchar_t* _pString) {
		wprintf(L"%s", _pString);
		return *this;
	}

	CMyOStream& operator >> (int& _idata) {//수정되여야 하므로 주소 제공 및 const x
		scanf_s("%d", &_idata);// 이 기능은 실제로는 istream의 클래스에 만들어 져있다.
		return *this;
	}

	CMyOStream& operator << (void (*_pFunc)(void)) //endl을 구현
	{
		_pFunc();
		return *this;
	}

};
CMyOStream mycout;



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

	CList<int> list1;

	for (int i = 0; i < 4; ++i) {
		list1.push_back(i);
	}
	//printf("adwgasdg %d 10", 10)//""안에 있는 것은 문자 , %d를 통한건 숫자 10

		//c printf
		//cout << "안녕" << 10 << endl;//연산자 오버로딩
		//std::wcout << L"안녕" << 10 << endl;//2byte 문자열
		////c scanf
		//int input = 0;

	setlocale(LC_ALL, "korean");//한국어 언어 설정
	_wsetlocale(LC_ALL, L"korean");//이하 동문

	mycout << 10 << 20 << 30;// 출력되면 10, 20 ,30 이렇게 나온다.
	mycout << L"안녕";



	//std::cin >> input;//std가 namespace랑 구조가 똑같다.
	//std안에 cout와 cin이라는 변수가 전부 안에 들어있기 때문에 사용
	//왜 그럼 std안에 C++에서 지원하는 기능들이 들어있냐 하면
	//이렇게 namespace안에 있으면 내가 만약 cout라는 변수를 정의해서 쓰고 싶으면
	//중복 되지 않게 하려고 namespace안에 넣는 것이다.
	//즉, namespace(이름공간)이 다르면 같은 이름의 변수도 오류가 나오지 않는다.
	int a = 0;
	mycout >> a;


	//종합본
	int k = 0;

	mycout >> k << 100 << L" " << 20 << L" " << L"문자열" << MyEndL;


	MYSPACE::g_int = 0;//namespace안에 있기 때문에 MYSPACE:: 사용
	OTHERSPACE::g_int = 0;//namespace가 다르기 떄문에 변수이름 이 같아도 오류 x
	CTest::MemberFunc();//static정적함수이므로 객체 없이 호출 가능

	vector<int> vecInt;
	vecInt.push_back(10);
	vecInt.push_back(20);//push_front는 존재하지 않는다.
	vecInt.data();//벡터가가 소유한 요소들을 저장하는 데 내부적으로 사용하는 메모리 배열(가변 배열)에 대한 직접 포인터(direct pointer)를 반환합니다. 
	vecInt.size();//들어 있는 함수 개수
	vecInt.capacity();//앞으로 더 받을 수 있는 허용 용량

	for (size_t i = 0; i < vecInt.size(); ++i)//size_t인 이유는 vector의 반환 타입이 size_t이기 때문이다.
		//size_t는 __int64 와 같은데 unsigned long long와 같다.
	{
		cout << vecInt[i] << endl;
	}


	vecInt[0] = 100;
	vecInt.at(1);
	vecInt[1];//둘이 같은 뜻이다.

	list<int> listInt;
	listInt.push_back(10);
	listInt.push_front(100);
	listInt.size();//capacity는 필요가 없다.

	//리스트에는 없는 인덱스를 이용한 접근하는 방법을 위해 literator 사용

	// iterator(inner class)클래스 안에 구현된 클래스 list도 클래스
	//iterator도 클래스
	//iterator는 공통된 클래스 이므로 어떤 자료구조를 써도 반복자는 존재한다는 걸 알 수 있다.
	//즉, 내부동작은 다르더라도 인터페이스에서 쓰는 모양은 같다는 공통점이 존재한다. 즉, 통합 언어 같은 느낌
	vector<int>::iterator veciter = vecInt.begin();

	for (int i = 0; i < 10; ++i) {
		vecInt.push_back(i);
	}
	//이럴경우 가변배열을 재할당 받기 때문에 vecInt.begin();이 가리키는 주소는 전에 가리키고 있던 주소를 가리키게 된다


	*veciter = 100;//vector 내의 처음 주소의 값을 역참조
	++veciter;//다음 배열 값을 가리킨다.

	vecInt.erase(veciter);//iterator가 가리키는 부분을 삭제해 주세요라는 뜻




	list<int>::iterator iter = listInt.begin();//반복자(iterator) 
	//해당 자료구조안에 있는 data를 가리키고 지침하는 기능을 한다.
	//iterator 객체 생성 그리고 그 객체가 리스트의 처음 시작하는 노드를 가르켜라 라는 뜻이다.
	int iData = *iter;//마치 pointer같은 기능을 주려고 만들어 진것이다.
	//하지만 실제로는*iter하면 처음 노드 내의 값(data, 다음 주소값)중에서 data 값만
	//가져와서 보여주는 기능을 한다.
	++iter;//다음 노드를 가리킨다.

	for (iter = listInt.begin(); iter != listInt.end(); ++iter) {
		//end()는 마지막 다음 data를 지칭하는 iterator이다. 왜냐하면 기능이 그렇게 됐기 때문에 (편의성을 위해서)
		//end iterator라고 한다.
		cout << *iter << endl;
	}
	//vector<float>::iterator;//3개 전부다 다른 클래스 이다.
	//vector<short>::iterator;
	//vector<int>::iterator;

	CArr<int> myvector;
	myvector.push_back(1);
	myvector.push_back(2);
	myvector.push_back(3);

	CArr<int>::iterator myiter = myvector.begin();

	//*myiter;
	//++(전위, 후위),--,==,!=
	//

	for (; myiter != (myvector.end()); ++myiter) {
		cout << *myiter << endl;
	}


	int iData = *(++myiter);
	int iData = *(myiter++);//전위 연산자가 먼저 발동되지만 카피본을 줘서 후위연산자를 완성 시켰다.
	//따라서 for (; myiter != (myvector.end()); ++myiter) 이런 부분에서
	//전위를 쓰는 이유는 후위를 쓰면 쓸데 없이 객체 생성 삭제 비용이 발생하므로 카피본이 없어진다.
	//따라서 전위 연산자를 쓰는 게 좋다.

	//CTest t1, t2;//이렇게 코딩을 하면 기본생성자를 받아오는데
	//지금 오버로딩을 했기 때문에 기본 생성자가 없어서 오류가 발생 하는 것이다.
	//따라서 기본 생성자도 만들어야 한다.

	CTest t1;
	t1.m_i = 100;
	/*복사생성자 활용
	t2 = t1; 다음과 같은 기능은 다음 한줄로 끝난다.*/

	CTest t2(t1);//복사 생성자 호출

	CTest t3 = t1;// t3를 생성한 후에 t1을 대입하는 뜻 즉, 복사를 하겠다는 것이다.
	//즉, 이 것의 뜻은 복사 생성자를 호출한다는 거라고 알고 있어야 한다.
	//컴파일러가 CTest t3(t1);으로 변환해서 처리한다.



	//vector::erase
	//vector<int> vecInt;

	vecInt.push_back(100);
	vecInt.push_back(200);
	vecInt.push_back(300);
	vecInt.push_back(400);

	vector<int> vecInt2;
	vecInt2.push_back(1000);

	vector<int>::iterator veciter = vecInt.begin();//지금은 100이 들어 있는배열을 가리키고 있다.
	//vecInt.erase(veciter);//100이 들어있는 iterator를 삭제하고 삭제한 다음(200)을 떙긴 것을 반환 해준다.
	//따라서 반환타입이 다음 iterator이므로 veciter변수에 다시 넣어야지 접근할 수 있다.

	//int i = *veciter;//이렇게 되면 100d을 가리키고 있는 상태이므로(begin때문에) 컴파일오류가 발생한다.

	//따라서 
	veciter = vecInt.erase(veciter);//이렇게 받아줘야한다.

	//즉, erase(veciter)에서 veciter의 유효성은 false가되고 
	//veciter = vecInt.erase(veciter); 의 경우 return iterator(this, m_pData, _iter.m_iIdx); 
	//즉, 생성자를 이용하기때문에 생성자에서는 유효성이 true인 상태가 된다.기본 생성자 아님
	//따라서 erase를 통해서 기존에 있던 건 버리고 새로 생성자를 return해서 유효성을 true로 바꾼다.

	//만약 다음과 같이 iterator는 vecInt2를 가리키는데 
	//erase는 다음과 같이 vecInt에서 사용하는 경우가 발생할 수 있다.
	//vector<int>::iterator veciter = vecInt2.begin();
	//veciter= vecInt.erase(veciter);

	vecInt.clear();//vector에 있는 모든 data를 제거한다.

	//1~10을 벡터에 입력
	for (int i = 0; i < 11; ++i) {
		vecInt.push_back(i + 1);
	}

	//짝수만 제거
	veciter = vecInt.begin();
	for (; veciter != vecInt.end(); ++veciter) {//i < 10일때 erase에 오류가 뜬 이유는 vecInt
		//erase를 한 후에 다음을 가리키는데 10을 erase하면 veciter는 end()를 가리키게되고 그렇게 되고
		//for문이 종료되서 ++veciter가 되서 end()의 다음 메모리를 가리키기 때문에 오류가 발생한다.
		if (*veciter % 2 == 0) {
			//짝수만 제거 하지만 홀수를 검사하지 않았다. 왜? erase는 지운 요소의 다음 값을 가리키기 때문이다.
			veciter = vecInt.erase(veciter);
		}
	}

	for (; veciter != vecInt.end();) {//여기서 만약 ++veciter;를 for의 증감문에 적으면
		//1~5사이에서 erase가 일어나자 마자 다음을 가리키고 그다음으로 증가 되므로
		//1제거 2가리키고 바로 3가리켜서 for 시작 후 3제거 4가리키고 바로 5넘어가서 for시작
		//이렇게 되기때문에 2와 4는 제거가 되지 않고 넘어가게된다.
		//따라서 다음과 같이 따로 빼서 증감을 시키지 않으면 반복문에서 피해를 볼 수 있다.
		//심심치 않게 면접에서 나온다
		if (1 <= *veciter && *veciter <= 5) {
			//제거
			veciter = vecInt.erase(veciter);
		}
		else
		{
			++veciter;
		}
	}

	for (int i = 0; i < vecInt.size(); ++i) {
		cout << vecInt[i] << endl;
	}

	list<int> intlist;
	intlist.push_back(100);
	intlist.push_back(300);
	intlist.push_back(400);

	list<int>::iterator it = intlist.begin();
	it = intlist.insert(++it, 200);
	//insert반환값은 iterator로 넣고 싶은 값 즉, 200을 가지고 있는 노드를 가리킨다.
	//insert(++(넣고 싶은부분의 전의 값 즉, 100이 있는곳), 넣고 싶은 값)



	//====================================
	//			list iterator
	//====================================

	CList<int> mylist;

	mylist.push_back(100);
	mylist.push_back(200);
	mylist.push_back(300);

	CList<int>::iterator listiter = mylist.begin();
	int l = *listiter;
	*listiter = 150;

	//++,--, ==

	cout << "===================" << endl;
	cout << "list iterator test" << endl;
	cout << "===================" << endl;

	for (listiter = mylist.begin(); listiter != mylist.end(); ++listiter)
	{
		cout << *listiter << endl;
	}

	return 0;
}