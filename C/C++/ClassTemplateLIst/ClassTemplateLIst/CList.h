#pragma once
#include "CArr.h"
#include <list>

template<typename T>
struct tListNode//���� ����� �ʿ����� ���� data�� ����� ���� ����
{
	T data;
	tListNode<T>* pPrev;//���ο� �ֱ� ������ <T> ������ ���������� ���⼭�� ��������
	tListNode* pNext;

	tListNode()//��� ������ �ʱ�ȭ�� ��ȭ ���� �ϰڴ�.
		//������
		:data()
		, pPrev(nullptr)
		, pNext(nullptr)
	{
	}

	tListNode(const T& _data, tListNode<T>* _pPrev, tListNode<T>* _pNext)
		//������ �����ε�
		//��� ������ �ʱ�ȭ�� �޾Ƽ� �ϰڴ�. ��, ��尡 ����� ���� �� Ȱ��
		: data(_data)
		, pPrev(_pPrev)
		, pNext(_pNext)
	{
	}

};

template<typename T>
class CList {//����ü�� Ŭ������ �������� �̰� �ϳ� private�� ���� �� ���� ������ �ٸ���
private:
	tListNode<T>* m_pHead;//node ��ü�� ���ø��̹Ƿ� �̷��� ��������Ѵ�.
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
		Clist<T>* m_pList;//�ε����� �̿��ϱ⿡�� �뷮�� �ʹ� Ŭ ���� �����Ƿ� direct�� ����� �ּҸ� ����Ű�°� ����.
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
			//end���� ++ �� ���
			if (nullptr == m_pNode || !m_bValid) {
				assert(nullptr);
			}

			m_pNode = m_pNode->pNext;

			return *this;

		}

		iterator& operator ++(int) {
			iterator copyiter(*this);//???? �� �Ǵ��� �𸣰ڴ�
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
			iterator copyiter(*this);//???? �� �Ǵ��� �𸣰ڴ�
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

		{//iterator�� ����Ű�� ��ü�� ��ȿ���� üũ�ϴ� �κ��̴�.
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
	//�Էµ� �����͸� ������ ��带 �����Ҵ� ��
	tListNode<T>* pNewNode = new tListNode<T>(_data, nullptr, nullptr);
	//ó�� �Էµ� �����Ͷ��
	if (nullptr == m_pHead) {
		m_pHead = pNewNode;
		m_pTail = pNewNode;
	}
	else {
		//�����Ͱ� 1�� �̻󿡼� �Էµ� ���
		//���� ���� ������ ������(tail)�� �����ϰ� �ִ� ����
		//���� ������ ��尡 ���� ����Ű�� �Ѵ�.
		m_pTail->pNext = pNewNode;
		pNewNode->pPrev = m_pTail;
		//List�� ������ ����� �ּҰ��� ���� �Էµ� ���� �����Ѵ�.
		this->m_pTail = pNewNode;
		pNewNode->pNext = nullptr;
		++m_iCount;

	}
}

template<typename T>
void CList<T>::push_front(const T& _data)
{//���� ���������� ��尡 �ϳ��� ���� ���� push_back�Լ��θ� �����ϴ� �� ����.
	//push_front�� ����Ʈ�� �ִ� ���¿��� �տ� �߰��ϴ� ��ɸ� ������ �ִ� �� ����.
	tListNode<T>* pNewNode = new tListNode<T>/***/(_data, nullptr, m_pHead);// �����ڿ� * �־��µ� �̰Ŵ� ������ �״�� ����Ѵ�. ���� �Ǽ�
	//���� ��� ����� ���� ��� �ּҰ��� ���� ������ ����� �ּҷ� ä��
	m_pHead->pPrev = pNewNode;
	//����Ʈ�� ���� ������ ����� �ּҸ� ���ο� �ص� �ּҷ� �����Ѵ�.
	m_pHead = pNewNode;
	//������ ���� ����
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
	return iterator(this, nullptr);//������ ��尡 ����Ű�°� nullptr�̸� ������ ����� ������ nullptr�� �ϰڴ�.
}

template<typename T>
inline typename CList<T>::iterator CList<T>::erase(iterator& _iter)
//m_pList(nullptr) , m_pNode(nullptr)
{
	//1. iterator�� �ٸ� Arr�� ��Ҹ� ����Ű�� ���
	//2. end iterator�� ��쿡�� ������ �ȴ� ��, ������ ������
	//3. ���� ����ִ� data�� �������� �ε����� �� Ŭ���
	if (this != _iter.m_pList || end() == iter)//erase�� CList�Լ��̴�.

		//iterator�� ����Ű�� ��带 �����Ѵ�.
		_iter.m_pNode->pPrev->pNext = _iter.m_pNode->pNext;
	_iter.m_pNode->pNext->pPrev = _iter.m_pNode->pPrev;
	iterator iter = new iterator(this, _iter.m_pNode->pNext);

	delete _iter.m_pNode;
	// parameter�� �޾ƿ� iterator�� ��ȿ���� false�� �߱� ������
	//������ �ִ� ��ü�� �ٽ� ���� �ʴ� �̻� ��ȿ���� false�� ���� �ְ� �ȴ�.

//ī���� ����
	--m_iCount;
	//������ ���ƴ� iterator��� ���� Ȯ�� ���� ����Ѵ�. ��, ������ �ִ� iterator
	return iter;
}

template<typename T>
inline typename CList<T>::iterator CList<T>::insert(const iterator& _iter, const T& _data)
{
	if (end() == _iter)//100 ���⿡ �ִ� �ŹǷ� 300 end == 300�̶�� ���̴�.
	{
		assert(nullptr);
	}
	//����Ʈ�� �߰��Ǵ� �����͸� ���� �� Node ����
	tListNode<T>* pNode = new tListNode<T>(_data, nullptr, nullptr);
	if (_iter.m_pNode == m_pHead) {
		_iter.m_pNode->pPrev = pNode;
		pNode->pNext = _iter.m_pNode;//_iter.m_pNode == m_pHead

		m_pHead = pNode;
	}
	else {//iterator�� ����Ű�� �ִ� ����� �������� ���� ���� ��� �ּ� ��Ʈ�� ���� ������ ���� ����
			//���ο� ����� pNext�� iterator�� ����Ű�� �ִ� ���� ����
		_iter.m_pNode->pPrev->pNext = pNode;
		pNode->pPrev = _iter.m_pNode->pPrev;
		_iter.m_pNode->pPrev = pNode;
		pNode->pNext = _iter.m_pNode;
	}

	return iterator(this, pNode);//��� �߰��� iterator�� �����Ѿ��Ѵ�.
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
