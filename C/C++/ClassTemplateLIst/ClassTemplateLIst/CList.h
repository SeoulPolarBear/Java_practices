#pragma once
#include "CArr.h"
#include <list>

template<typename T>
struct tListNode//많은 기능이 필요하지 않은 data에 사용할 때만 쓰자
{
	T data;
	tListNode<T>* pPrev;//내부에 있기 때문에 <T> 생략이 가능하지만 여기서는 적어주자
	tListNode* pNext;

	tListNode()//멤버 변수의 초기화를 이화 같이 하겠다.
		//생성자
		:data()
		, pPrev(nullptr)
		, pNext(nullptr)
	{
	}

	tListNode(const T& _data, tListNode<T>* _pPrev, tListNode<T>* _pNext)
		//생성자 오버로딩
		//멤버 변수의 초기화를 받아서 하겠다. 즉, 노드가 만들어 졌을 때 활용
		: data(_data)
		, pPrev(_pPrev)
		, pNext(_pNext)
	{
	}

};

template<typename T>
class CList {//구조체와 클래스의 차이점은 이거 하나 private를 붙힐 수 있을 때만이 다르다
private:
	tListNode<T>* m_pHead;//node 자체가 템플릿이므로 이렇게 적어줘야한다.
	tListNode<T>* m_pTail;
	int		   m_iCount;

public:
	void push_back(const T& _data);
	void push_front(const T& _data);
	int size() { return m_iCount; }

public:
	class iterator;
	iterator begin();
	iterator end();
	iterator erase(iterator& _iter);
	iterator insert(const iterator& _iter, const T& _data);

public:
	CList();
	~CList();

	class iterator {

	private:
		Clist<T>* m_pList;//인덱스를 이용하기에는 용량이 너무 클 수도 있으므로 direct로 노드의 주소를 가리키는게 좋다.
		tListNode<T>* m_pNode;
		bool m_bValid;

	public:
		T& operator *()
		{
			return m_pNode->data;
		}

		bool operator ==(const iterator& _otheriter) {

			if (m_pList == m_otheriter.m_pList && m_pNode == _otheriter.m_pNode)
				return true;
			else
				return false;
		}

		bool operator !=(const iterator& _otheriter) {
			return !(*this == _otheriter);
		}

		iterator& operator ++() {
			//end에서 ++ 한 경우
			if (nullptr == m_pNode || !m_bValid) {
				assert(nullptr);
			}

			m_pNode = m_pNode->pNext;

			return *this;

		}

		iterator& operator ++(int) {
			iterator copyiter(*this);//???? 왜 되는지 모르겠다
			++(*this);

			return copyiter;
		}


		iterator& operator --()
		{
			if (nullptr == m_pNode->pPrev || !m_bValid)
			{
				assert(nullptr);
			}
			m_pNode = m_pNode->pPrev;

			return *this;

		}


		iterator& operator --(int) {
			iterator copyiter(*this);//???? 왜 되는지 모르겠다
			--(*this);

			return copyiter;
		}

	public:
		iterator()
			:m_pList(nullptr)
			, m_pNode(nullptr)
			, m_bValid(false)

			iterator(Clist<T>* _pList, tListNode<T>* _pNode)
			: m_pList(_pList)
			, m_pNode(_pNode)
			, m_bValid(false)

		{//iterator가 가리키는 객체의 유효성을 체크하는 부분이다.
			if (nullptr != _pList && nullptr != _pNode) {
				m_bValid = true;
			}
		}

		~iterator()
		{

		}

		friend class CList;
	};

};

template<typename T>
void CList<T>::push_back(const T& _data)
{
	//입력된 데이터를 저장할 노드를 동적할당 함
	tListNode<T>* pNewNode = new tListNode<T>(_data, nullptr, nullptr);
	//처음 입력된 데이터라면
	if (nullptr == m_pHead) {
		m_pHead = pNewNode;
		m_pTail = pNewNode;
	}
	else {
		//데이터가 1개 이상에서 입력된 경우
		//현재 가장 마지막 데이터(tail)를 저장하고 있는 노드와
		//새로 생성된 노드가 서로 가리키게 한다.
		m_pTail->pNext = pNewNode;
		pNewNode->pPrev = m_pTail;
		//List가 마지막 노드의 주소값을 새로 입력된 노드로 갱신한다.
		this->m_pTail = pNewNode;
		pNewNode->pNext = nullptr;
		++m_iCount;

	}
}

template<typename T>
void CList<T>::push_front(const T& _data)
{//여기 수업에서는 노드가 하나도 없을 때는 push_back함수로만 시작하는 것 같다.
	//push_front는 리스트가 있는 상태에서 앞에 추가하는 기능만 가지고 있는 것 같다.
	tListNode<T>* pNewNode = new tListNode<T>/***/(_data, nullptr, m_pHead);// 생성자에 * 넣었는데 이거는 생성자 그대로 써야한다. 나의 실수
	//현재 헤드 노드의 이진 노드 주소값을 새로 생성된 노드의 주소로 채움
	m_pHead->pPrev = pNewNode;
	//리스트가 새로 생성된 노드의 주소를 새로운 해드 주소로 갱신한다.
	m_pHead = pNewNode;
	//데이터 개수 증가
	++m_iCount;
}

template<typename T>
inline typename CList<T>::iterator CList<T>::begin()
{
	return iterator(this, m_pHead);
}

template<typename T>
inline typename CList<T>::iterator CList<T>::end()
{
	return iterator(this, nullptr);//마지막 노드가 가리키는게 nullptr이면 마지막 노드의 다음을 nullptr로 하겠다.
}

template<typename T>
inline typename CList<T>::iterator CList<T>::erase(iterator& _iter)
//m_pList(nullptr) , m_pNode(nullptr)
{
	//1. iterator가 다른 Arr쪽 요소를 가리키는 경우
	//2. end iterator일 경우에는 문제가 된다 즉, 마지막 구분자
	//3. 지금 들어있는 data의 개수보다 인덱스가 더 클경우
	if (this != _iter.m_pList || end() == iter)//erase는 CList함수이다.

		//iterator가 가리키는 노드를 제거한다.
		_iter.m_pNode->pPrev->pNext = _iter.m_pNode->pNext;
	_iter.m_pNode->pNext->pPrev = _iter.m_pNode->pPrev;
	iterator iter = new iterator(this, _iter.m_pNode->pNext);

	delete _iter.m_pNode;
	// parameter로 받아온 iterator의 유효성을 false로 했기 때문에
	//기존에 있던 객체를 다시 받지 않는 이상 유효성이 false로 남아 있게 된다.

//카운터 감소
	--m_iCount;
	//예전에 사용됐던 iterator라는 것을 확인 시켜 줘야한다. 즉, 기존에 있던 iterator
	return iter;
}

template<typename T>
inline typename CList<T>::iterator CList<T>::insert(const iterator& _iter, const T& _data)
{
	if (end() == _iter)//100 여기에 넣는 거므로 300 end == 300이라는 뜻이다.
	{
		assert(nullptr);
	}
	//리스트에 추가되는 데이터를 저장 할 Node 생성
	tListNode<T>* pNode = new tListNode<T>(_data, nullptr, nullptr);
	if (_iter.m_pNode == m_pHead) {
		_iter.m_pNode->pPrev = pNode;
		pNode->pNext = _iter.m_pNode;//_iter.m_pNode == m_pHead

		m_pHead = pNode;
	}
	else {//iterator가 가리키고 있는 노드의 이전으로 가서 다음 노드 주소 파트를 새로 생성한 노드로 지정
			//새로운 노드의 pNext를 iterator가 가리키고 있는 노드로 지정
		_iter.m_pNode->pPrev->pNext = pNode;
		pNode->pPrev = _iter.m_pNode->pPrev;
		_iter.m_pNode->pPrev = pNode;
		pNode->pNext = _iter.m_pNode;
	}

	return iterator(this, pNode);//방금 추가된 iterator를 가리켜야한다.
}

template<typename T>
CList<T>::CList()
	:m_pHead(nullptr)
	, m_pTail(nullptr)
	, m_iCount(0)

{
}

template<typename T>
CList<T>::~CList()
{
	tListNode<T>* pDeleteNode = m_pHead;
	while (pDeleteNode) {
		tListNode<T>* pNext = pDeleteNode->pNext;
		delete(pDeleteNode);
		pDeleteNode = pNext;
	}
}
