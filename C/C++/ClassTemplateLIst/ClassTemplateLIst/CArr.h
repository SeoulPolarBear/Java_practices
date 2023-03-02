#pragma once
#include <assert.h>
#include<iostream>

template<typename T>
//클래스 템플릿 및 멤버 함수(구현 부분)는 무조건 헤더파일에 있어야 한다.
//따라서 클래스 템플릿은 cpp파일이 있을 필요가 없다.
class CArr
{
private:
	T* m_pData;//m_pInt역할 지금 넣을 data만 유동적으로 해야하기 때문에 이것만 T로 변경
	int  m_iCount;
	int  m_iMaxCount;

public:
	void push_back(const T& _Data);// 만약 지역변수로 값을 받아오면 값의 크기에따라 어떻게 받을지 
	//결정하는데 비효율 적이기 때문에 직접적으로 변수값의 주소를 받을 수 있는 즉, 원본을 받는 레퍼런스를 사용하는게 좋다.(54.레퍼런스 부과설명 참고)
	//마찬가지로 원본을 회손 하면 안 되기 때문에 const
	void resize(int _iResizeCount);//가변 배열 개수

	//vector에서 사용하는 함수 똑같이 만들기
	T* data() { return m_pData; }
	int size() { return m_iCount; }
	int capacity() { return m_iMaxCount; }
	class iterator;//클래스도 전방선언 필요
	iterator begin();
	iterator end();
	iterator erase(iterator& _iter);

	void clear() {
		m_iCount = 0;// 기존에 있는 data 개수가 0이되면 처음부터 다시 덮어쓰기 하므로
		//다만 관리하고 있는 공간이 예전으로 돌아가지 않고 늘어난 상태로 존재한다.
		//다만 관리하고 있는 공간이 예전으로 돌아가지 않고 늘어난 상태로 존재한다.
	}

public:
	T& operator[](int idx);//[]이란 operator
public://header파일 이므로 함수를 구현하지 않는다. 
	CArr();
	~CArr();


	//inner 클래스를 포함하고 있는 클래스의 private 멤버에 접근 가능

	class iterator

		//CArr 클래스와는 별개라고 생각해야한다. 그저 내부에 있을 뿐이다.
		//내부에 있기 때문에 vector<int>::iterator veciter = vecInt.begin(); 이렇게 쓰일 뿐.
	{	//CArr내부에 있기 때문에 iterator또한 자동적으로 template로 구현해야 한다.
	private:
		//재할당 받는 것을 고려해서 배역 자체를 알고 있으면 재할당 받을 때의 문제를 해결할 수 있다.
		CArr* m_pArr;// iterator가 가리킬 테이터를 관리하는 가변배열 주소
		T* m_pData;//데이터들의 시작 주소
		int m_iIdx;//가리키는 데이터의 인덱스
		bool m_bValid; // iterator 유효성 체크

	public:
		T& operator* () //*이란 계산자(operator) 역참조
		{	//iterator가 알고 있는 주소와, 가변배열이 알고 있는 주소가
			//달라진 경우(공간 확장으로 주소가 달라진 경우)
		//end iterator일 경우에는 가리키는 부분의 값이 없기 때문에 역참조 할 수 없다. 따라서 예외 처리
			//유효성이 거짓인 것은 역참조가 불가능 하게 한다.
			if (m_pArr->m_pData != m_pData || -1 == m_iIdx || !m_bValid)//!false는 true
				assert(nullptr);

			return m_pData[m_iIdx];
		}
		//전위
		iterator& operator ++()//++(++k)와 같이 가능하다. 즉 본인 스스로를 반환해야 한다.
		{
			//iterator가 알고 있는 주소와, 가변배열이 알고 있는 주소가
			//달라진 경우(공간 확장으로 주소가 달라진 경우)
			//end iterator일 경우에는 가리키는 부분의 값이 없기 때문에 역참조 할 수 없다. 따라서 예외 처리
			if (m_pArr->m_pData != m_pData || -1 == m_iIdx)
				assert(nullptr);

			// iterator가 마지막 데이터를 가리키고 있는 경우
			if (m_pArr->size() - 1 == m_iIdx) {
				m_iIdx = -1;
			}
			else {
				++m_iIdx;
			}

			return *this;//iterator 클래스 자체를 받는 것이다.
		}




		// 후위++
		iterator operator ++(int)//(k++)++와 같이 가능하다. 복사본을 가져온다.
		//++(int): 아무 의미 없는 int를 가져와서  ++(int)를 컴파일러가 후위 연산자라고 인식하게 해준다.
		{
			iterator copy_iter = *this;//후위 연산자 
			++(*this);
			//fake를 준다. 즉, 반환 값은 전에 있던 객체 값을 반환 해주고(복사 값이므로 원본에 영향을 주지 않는다.)
			// 그대신 함수내에서 객체 원본에 영향을 줘서 값을 증가 시킨다.

			return copy_iter;//iterator 클래스 자체를 받는 것이다.
			//반환 타입이 또다른 복사본이므로 반환시 없어진다.

		}

		//--전위
		iterator& operator --()
		{
			//iterator가 알고 있는 주소와, 가변배열이 알고 있는 주소가
			//달라진 경우(공간 확장으로 주소가 달라진 경우)
			//end iterator일 경우에는 가리키는 부분의 값이 없기 때문에 역참조 할 수 없다. 따라서 예외 처리
			if (m_pArr->m_pData != m_pData || -1 == m_iIdx)
				assert(nullptr);

			if (m_pArr->size() == 0) {
				assert(nullptr);
			}
			else {
				--m_iIdx;
			}

			return *this;//iterator 클래스 자체를 받는 것이다.
		}

		//--후위
		iterator operator --(int)
		{
			iterator copy_iter = *this;//후위 연산자 
			--(*this);

			return copy_iter;//iterator 클래스 자체를 받는 것이다.
		}



		//-- 전,후위 만들어 보기

		//비교 연산자 ==, !=
		bool operator == (const iterator& _otheriter)
		{//this는 내가 넣었는데 맞지 않을까라는 생각에 넣었다.
			if (this->m_pData == _otheriter.m_pData && this->m_iIdx == _other.m_iIdx)
				return true;
			else return false;
		}

		bool operator != (const iterator& _otheriter)
		{
			return !(*this == _otheriter);
			//호출 시킨 객체가 *this 그리고 bool operator == (const iterator& _otheriter) 호출시켜서 반대로 반환하면 된다.
		}


	public:
		iterator() {//템플릿이니까 헤더에서 바로 구현
			:m_pArr(nullptr)
				, m_pData(nullptr)
				, m_iIdx(-1)
				, m_bValid(false);//기본생성자에서는 false
		}
		iterator(CArr* _pArr, T* _pData, int _iIdx)
			:m_pArr(_pArr)
			, m_pData(_pData)
			, m_iIdx(_iIdx)
			, m_bValid(false);
		{//유효성 생성 가변배열에 내용이 있고 인덱스 값이 -1이 아닌 iterator는 유효성이 참이다.
			if (nullptr != _pArr && 0 <= m_iIdx) {
				m_bValid = true;
			}

		}


		~iterator()
		{

		}

		friend class CArr;// CArr클래스에서 iterator 클래스에 private 시 접근 불가(역은 가능하지만)
		//따라서 friend를 선언하면 둘 클래스는 서로 private까지 접근 가능하게 된다.
		//즉, CArr에서 iterator의 멤버 변수에 접근 할 수 있게 허용 보통은 멤버함수로 접근
	};




	template<typename T>
	CArr<T>::CArr()//생성자 함수
	//Header 파일에서는 함수를 만들 수 없으므로 Header에서 선언한 함수 여기서 cpp에서 만들어 줘야한다.
	//CArr클래스 안에 있는 CArr()함수라는 정확한 명시를  해줘야 한다.
		:m_pData(nullptr)
		, m_iCount(0)
		, m_iMaxCount(2)
	{
		//이니셜라이즈, 메모리 초기화 할때는 순차적으로 멤버 변수를 초기화 해주는게 좋다.
		m_pData = new T[2];//malloc(sizeof(int)*2)와 같은 뜻이다.

	}
	template<typename T>
	CArr<T>::~CArr()//소멸자 함수
	{
		delete[] m_pData;//여러 자료형묶음(배열)같은 것은 이렇게 지워준다.
		//int* p =new int[10];일 경우에는 delete[] p;
		//int* p = new int;일 경우에는 delete p;로 해제한다.
	}
	//이 함수 활용할 때는 s1.push_back;
	template<typename T>
	void CArr<T>::push_back(const T& _Data)//this는 전부 생략이 가능, this를 생략힌 것과
	//생략하지 안은 부분을 보면서 고민해보자
	{
		if (this->m_iMaxCount <= this->m_iCount) {
			//재할당
			resize(m_iMaxCount * 2);// 배열이 꽉 찾을 경우에는 2배만 확장
		}
		//데이터 추가
		m_pData[m_iCount++] = _Data;
	}
	//언제든지 공간 확장가능, 
	//이를 통해서 내가 미리 크기를 조정해서 push_back에서 함수를 여러번 불러오는 일이 없게(시간낭비 때문에) 하기 위한 멤버함수이다.
	template<typename T>
	void CArr<T>::resize(/*여기도 this 생략*/int _iResizeCount)
	{
		// 현재 최대 수용량 보다 더 적은 수치로 확장하려는 경우
		//즉 _iDataCount가 5, m_iMaxCount 10일 경우 기존에 있던 data가 7개를 였을 경우
		// 2개의 data 손실이 발생 할 수 있으므로 문제가 발생할 수 있다.
		//이렇게 되면 데이터 손실이 발생하므로 nullptr을 통해서 공간이 없다는걸 경고해준다.
		if (this->m_iMaxCount >= _iResizeCount) {
			assert(nullptr);
		}

		//1.리사이즈
		T* pNew = new int[_iResizeCount];//malloc(_iResizeCount)대신해서 사용
		//2. 기존 공간에 있던 데이터들을 새로 할당한 공간으로 복사시킨다.
		for (int i = 0; i < m_iCount; ++i) {
			pNew[i] = this->m_pData[i];//여기서도 this 생략 가능
		}
		//3. 기존 공간은 메모리 해제
		delete[] m_pData;
		//4. 배열이 새로 할당된 공간을 가리키게 한다.
		m_pData = pNew;
		//5. MaxCount 변경점 적용
		this->m_iMaxCount = _iResizeCount;
	}

	template<typename T>
	T& CArr<T>::operator[](int idx)
	{
		return m_pData[idx];
	}

	template<typename T>
	typename CArr<T>::iterator CArr<T>::begin()
		//typename을 적어준 이유는 반환타입이 iterator이다. 이는 C++에서 제공하는 기본
		//반환타입이 아니기 때문에 특정 반환 타입이란 뜻의 typename을 붙여 줘야 한다.
		//적확히는 CArr<T>::iterator 이게 특정 return 값이다 라는 걸 알려주기 위해서 붙힌다.
	{
		//시작을 가리키는 iterator를 만들어서 반환해줌
		/*iterator iter(m_pData, 0);
		iter.m_pData = this->m_pData;
		iter.m_iIdx = 0;*///이 모든 과정을 축약한게 return에 있느 부분

		if (0 == m_iCount)
			return iterator(this, m_pData, -1);//데이터가 없는  경우, begin() == end()
		else
			return iterator(this, m_pData, 0);//임시객체 이므로 접근 불가 반환만 가능
			//객체 자체를 받아야 하기 때문에 this
	}

	template<typename T>
	typename CArr<T>::iterator CArr<T>::end()
		// 이게 반환타입            이게 함수 이름
	{	//끝의 다음을 가리키는 iterator를 만들어서 반환해줌
		return iterator(this, m_pData, -1);//데이터가 없는 경우, begin() == end()
	}

	template<typename T>
	typename CArr<T>::iterator CArr<T>::erase(iterator& _iter)//유효성 검사 때문에 const X
	{
		//만약 다음과 같이 iterator는 vecInt2를 가리키는데 
		//erase는 다음과 같이 vecInt에서 사용하는 경우가 발생할 수 있다.
		//vector<int>::iterator veciter = vecInt2.begin();
		//veciter= vecInt.erase(veciter);
		//즉 지금 같은 상황은 객체의 시작 주소값과 iterator가 가리키는 주소 값이 완전히 다를 경우를 고려한 것이다.
		//1. iterator가 다른 Arr쪽 요소를 가리키는 경우
		//2. end iterator일 경우에는 문제가 된다 즉, 마지막 구분자
		//3. 지금 들어있는 data의 개수보다 인덱스가 더 클경우
		if (this != _iter.m_pArr || end() == _iter || m_iCount <= _iter.m_iIdx)
		{
			assert(nullptr);
		}

		//iterator가 가리키는 데이터를 배열 내에서 제거한다.
		int iLoopCount = m_iCount - (_iter.m_iIdx + 1);//10개중에 index 0을 지울 시 10-(0+1)총 9번을 움직인다.
		for (int i = 0; i < iLoopCount; ++i) {
			m_pData[i + _iter.m_iIdx] = m_pData[i + _iter.m_iIdx + 1];
		}

		_iter.m_bValid = false;// parameter로 받아온 iterator의 유효성을 false로 했기 때문에
		//기존에 있던 객체를 다시 받지 않는 이상 유효성이 false로 남아 있게 된다.

			//카운터 감소
		--m_iCount;

		//예전에 사용됐던 iterator라는 것을 확인 시켜 줘야한다. 즉, 기존에 있던 iterator

		return iterator(this, m_pData, _iter.m_iIdx);//기존에 있던 곳에 덮어 씌웠기 때문에 기존 인덱스 값을 주면 된다.
	}
};











//class CArr
//{
//private://기본적으로 아무것도 입력하지 않으면 멤버변수는 private로 인식 한다.
//	int* m_pInt;
//	int  m_iCount;
//	int  m_iMaxCount;
//
//public:
//	void push_back(int _Data);//tArr* _pArr는 객체와 같은 역할 즉, this
//	//이므로 이제는 사용할 필요가 없다.
//	void resize(int _iResizeCount);//public이란 뜻은 Reallocate랑 달리 언제든지 
//	//늘릴 수 있게 조정한 것이다.
//public:
//	int& operator[](int idx);//즉, operator는 해당 객체를 지칭한다. carr[1]와 같은 분법
//
//public://header파일 이므로 함수를 구현하지 않는다. 
//	CArr();
//	~CArr();
//};

