//#include "CArr.h"
//#include <assert.h>
////이 함수 활용할 때는 s1.push_back;
//void CArr::push_back(int _Data)//this는 전부 생략이 가능, this를 생략힌 것과
////생략하지 안은 부분을 보면서 고민해보자
//{
//	if (this->m_iMaxCount <= this->m_iCount) {
//		//재할당
//		resize(m_iMaxCount*2);// 배열이 꽉 찾을 경우에는 2배만 확장
//	}
//	//데이터 추가
//	m_pData[m_iCount++] = _Data;
//}
////언제든지 공간 확장가능, 
////이를 통해서 내가 미리 크기를 조정해서 push_back에서 함수를 여러번 불러오는 일이 없게(시간낭비 때문에) 하기 위한 멤버함수이다.
//void CArr::resize(/*여기도 this 생략*/int _iResizeCount)
//{
//	// 현재 최대 수용량 보다 더 적은 수치로 확장하려는 경우
//	//즉 _iDataCount가 5, m_iMaxCount 10일 경우 기존에 있던 data가 7개를 였을 경우
//	// 2개의 data 손실이 발생 할 수 있으므로 문제가 발생할 수 있다.
//	//이렇게 되면 데이터 손실이 발생하므로 nullptr을 통해서 공간이 없다는걸 경고해준다.
//	if (this->m_iMaxCount >= _iResizeCount) {
//		assert(nullptr);
//	}
//
//	//1.리사이즈
//	int* pNew = new int[_iResizeCount];//malloc(_iResizeCount)대신해서 사용
//	//2. 기존 공간에 있던 데이터들을 새로 할당한 공간으로 복사시킨다.
//	for (int i = 0; i < m_iCount; ++i) {
//		pNew[i] = this->m_pData[i];//여기서도 this 생략 가능
//	}
//	//3. 기존 공간은 메모리 해제
//	delete[] m_pData;
//	//4. 배열이 새로 할당된 공간을 가리키게 한다.
//	m_pData = pNew;
//	//5. MaxCount 변경점 적용
//	this->m_iMaxCount = _iResizeCount;
//}
//
//int& CArr::operator[](int idx)
//{
//	return m_pData[idx];
//}
//
//CArr::CArr()//생성자 함수
////Header 파일에서는 함수를 만들 수 없으므로 Header에서 선언한 함수 여기서 cpp에서 만들어 줘야한다.
////CArr클래스 안에 있는 CArr()함수라는 정확한 명시를  해줘야 한다.
//:m_pData(nullptr)
//, m_iCount(0)
//, m_iMaxCount(2)
//{//이니셜라이즈, 메모리 초기화 할때는 순차적으로 멤버 변수를 초기화 해주는게 좋다.
//	m_pData = new int[2];//malloc(sizeof(int)*2)와 같은 뜻이다.
//
//}
//CArr::~CArr()//소멸자 함수
//{
//	delete[] m_pData;//여러 자료형묶음(배열)같은 것은 이렇게 지워준다.
//	//int* p =new int[10];일 경우에는 delete[] p;
//	//int* p = new int;일 경우에는 delete p;로 해제한다.
//}