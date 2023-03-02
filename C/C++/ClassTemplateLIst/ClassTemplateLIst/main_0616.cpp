#include<iostream>
#include "CBST.h"


using std::cout;
using std::endl;
using std::sin;

class CParent
{
protected://상속 받은 클래스에서도 접근 가능하게 하는 기능을 한다.
	int  m_i;

public:
	void SetInt(int _a)
	{
		m_i = _a;
	}

	virtual void Output()
	{
		cout << "Parent" << endl;
	}

public:
	CParent()
		:m_i(0)
	{
		cout << "부모 생성자" << endl;
	}

	CParent(int _a)
		:m_i(_a)
	{}
	~CParent()
	{
		cout << "부모 소멸자" << endl;
	}
};

class CChild : public CParent//: public CParent이게 상속 받았다는 표현
	//반복적인 자주 구현되는 것을 기능으로 가져가고 
{
private:
	float m_f;

public:
	void SetFloat(float _f)
	{
		m_f = _f;
		m_i = 100;
	}

	//상속받은 부모클래스의 함수를 재정의(오버라이딩) 함
	void Output()
	{
		cout << "child" << endl;
	}

public:
	CChild()
		//CParent() //기본생성자 생략되어 있다.
		:CParent(10)//다음과 같이 사용자 지정 생성자는 반드시 오버로딩 해줘야 한다.
		,m_f(0.f)
		//,m_i(0)오류가 되는 이유가 초기화는 각자 부모, 자식에서 해줘야한다.
		//즉, 메모리 할당에서 부모 자식은 각자 멤버 변수를 책임지게 되는 것이다.
		
		//결론은 호출은 자식이 먼저 되고 실행은 부모쪽을 호출해서 실행한 다음 자식쪽 초기화를 시작한다.
		//호출은 자식이 실행(초기화)은 부모가 먼저 되는 것이다.
	
	{
		//m_i = 0;
		cout << "자식 생성자" << endl;
	}

	~CChild()
		//소멸자는 자식 소멸자부터 호출되고 호출된 자식 소멸자의 기능을 전부 수행한 후
		//부모 소멸자를 호출하고 수행한다.
	{
		cout << "자식 소멸자" << endl;
	}

};

class CChildChild : public CChild
{
private:
	long long m_ll;
};

//생성자 수행 방법 설명 함수들
void FuncA()
{
	cout << "Function A" << endl;
}

void FuncB()
{
	FuncA();
	cout << "Function B" << endl;
}

//소멸자 수행 방법 설명 함수들

void FuncAA()
{
	cout << "Function A" << endl;
}

void FuncBB()
{
	cout << "Function B" << endl;
	FuncAA();
}



int main()
{
	//객체지향 언어 특징
	//1. 캡슐화
	//2. 상속
	//3. 다형성
	//4. 추상화

	CParent parent;
	parent.Output();
	CChild child;
	child.Output();
	child.CParent::Output();//자식 객체에서 오버라이딩된 부모클래스의 함수를 부모쪽에서 호출하고 싶을경우

	//상속
	//자식 or 부모 클래스는 상속관계에서 다른 클래스의 멤버를 초기화 할 수 없다.
	//생성자 호출 순서 자식->부모
	//생성자 실행 순서, 초기화 순서 부모 ->자식
	
	// 소멸자 실행 및 호출 순서, 자식 -> 부모
	//자식 소멸자 역시 부모의 소멸자를 생략하고 있는 상태이다
	 
	//오버라이딩
	//부모 클래스의 멤버함수를 자식쪽에서 재정의 함으로써, 자식 클래스에 구현된 기능이 호출되도록 한다.
	
	//상속 And 포인터
	

	/*
	CParent parent;
	CChild child;
	CParent* pParent = &parent; --(1)
	CChild* pChild = &child;    --(2)

	CParent* pParent = &child;  --(1)
	//메모리 할당을 보면 [parent | child ]이렇게 되어있는데 
	처음 주소가 parent이므로 뒷부분을 알 필요가 없기 때문에 문제가 되지 않는다.

	CChild* pChild = &parent;   --(2)//문제가 있다. 
	//메모리 할당을 보면 &parent; 이 부분은 [parent]이렇게 되어있는데 child는 뒷부분까지 알아야하는데 알 수 없기 때문에
	자칫 다른 메모리 부분을 침해할 수 있다. 시작주소도 없을 뿐더러
	
	*/

	//자동차(부모)를 가지고 기차, 자동차, 트럭(자식들)을 만들수 있게 된다가 다형성

	CParent* pParent = nullptr;
	
	parent.Output();
	pParent = &parent;
	pParent->Output();

	child.Output();
	pParent = &child;
	pParent->Output();


	pParent = &parent;

	((CChild*)pParent)->NewFunc();//NewFunc() CChild내에 존재하는 자식만 가지고 있는 함수

	CChild* pChild = dynamic_cast<CChild*>(pParent);
	if (nullptr != pChild)
	{
		pChild->NewFunc();
	}





	//다형성, 가상함수(virtual)
	//부모 포인터 타입으로, 부모 클래스로부터 파생되는 자식클래스 객체들의 주소를 가리킬 수 있다.
	//모든 객체를 부모 클래스 타입으로 인식하게 되기 때문에, 실제 객체가 무엇인지 알 수 없다.
	//virtual 키워드를 통해서, 각 클래스는 자신만의 고유한 가상함수 테이블을 가지게 된다.
	//각 클래스의 객체들은 가상함수 테이블 포인터에서 해당 클래스에 맞는 테이블을 가리키게 된다.
	//그 테이블에는 해당 클래스의 가상함수들이 등록된다.

	//다운 케스팅
	//부모 클래스에서 선언되지 않은, 오직 자식쪽에서만 추가된 함수를 호출 하고 싶을 때
	//자식 포인터 타입으로 일시적으로 캐스팅 해서 호출한다.
	//문제가 발생 할 수 있기 때문에 dynamic_cast로 안전하게 확인해 볼 수 있다.
	//RTTI(Run Time Type Identification or Information)

	//추상화
	//실제 객체를 생성할 목적의 클래스가 아닌, 상속을 통해서 구현해야할 내용을 전달하는 상속 목적으로 만들어진 클래스
	//virtual, =0(1 개 이상의 순수 가상함수를 포함하면 추상클래스가 된다.)






	parent.SetInt(10);
	child.SetInt(10);

	return 0;
}