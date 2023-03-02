#pragma once
#include <assert.h>
#include<iostream>

template<typename T>
//Ŭ���� ���ø� �� ��� �Լ�(���� �κ�)�� ������ ������Ͽ� �־�� �Ѵ�.
//���� Ŭ���� ���ø��� cpp������ ���� �ʿ䰡 ����.
class CArr
{
private:
	T* m_pData;//m_pInt���� ���� ���� data�� ���������� �ؾ��ϱ� ������ �̰͸� T�� ����
	int  m_iCount;
	int  m_iMaxCount;

public:
	void push_back(const T& _Data);// ���� ���������� ���� �޾ƿ��� ���� ũ�⿡���� ��� ������ 
	//�����ϴµ� ��ȿ�� ���̱� ������ ���������� �������� �ּҸ� ���� �� �ִ� ��, ������ �޴� ���۷����� ����ϴ°� ����.(54.���۷��� �ΰ����� ����)
	//���������� ������ ȸ�� �ϸ� �� �Ǳ� ������ const
	void resize(int _iResizeCount);//���� �迭 ����

	//vector���� ����ϴ� �Լ� �Ȱ��� �����
	T* data() { return m_pData; }
	int size() { return m_iCount; }
	int capacity() { return m_iMaxCount; }
	class iterator;//Ŭ������ ���漱�� �ʿ�
	iterator begin();
	iterator end();
	iterator erase(iterator& _iter);

	void clear() {
		m_iCount = 0;// ������ �ִ� data ������ 0�̵Ǹ� ó������ �ٽ� ����� �ϹǷ�
		//�ٸ� �����ϰ� �ִ� ������ �������� ���ư��� �ʰ� �þ ���·� �����Ѵ�.
		//�ٸ� �����ϰ� �ִ� ������ �������� ���ư��� �ʰ� �þ ���·� �����Ѵ�.
	}

public:
	T& operator[](int idx);//[]�̶� operator
public://header���� �̹Ƿ� �Լ��� �������� �ʴ´�. 
	CArr();
	~CArr();


	//inner Ŭ������ �����ϰ� �ִ� Ŭ������ private ����� ���� ����

	class iterator

		//CArr Ŭ�����ʹ� ������� �����ؾ��Ѵ�. ���� ���ο� ���� ���̴�.
		//���ο� �ֱ� ������ vector<int>::iterator veciter = vecInt.begin(); �̷��� ���� ��.
	{	//CArr���ο� �ֱ� ������ iterator���� �ڵ������� template�� �����ؾ� �Ѵ�.
	private:
		//���Ҵ� �޴� ���� ����ؼ� �迪 ��ü�� �˰� ������ ���Ҵ� ���� ���� ������ �ذ��� �� �ִ�.
		CArr* m_pArr;// iterator�� ����ų �����͸� �����ϴ� �����迭 �ּ�
		T* m_pData;//�����͵��� ���� �ּ�
		int m_iIdx;//����Ű�� �������� �ε���
		bool m_bValid; // iterator ��ȿ�� üũ

	public:
		T& operator* () //*�̶� �����(operator) ������
		{	//iterator�� �˰� �ִ� �ּҿ�, �����迭�� �˰� �ִ� �ּҰ�
			//�޶��� ���(���� Ȯ������ �ּҰ� �޶��� ���)
		//end iterator�� ��쿡�� ����Ű�� �κ��� ���� ���� ������ ������ �� �� ����. ���� ���� ó��
			//��ȿ���� ������ ���� �������� �Ұ��� �ϰ� �Ѵ�.
			if (m_pArr->m_pData != m_pData || -1 == m_iIdx || !m_bValid)//!false�� true
				assert(nullptr);

			return m_pData[m_iIdx];
		}
		//����
		iterator& operator ++()//++(++k)�� ���� �����ϴ�. �� ���� �����θ� ��ȯ�ؾ� �Ѵ�.
		{
			//iterator�� �˰� �ִ� �ּҿ�, �����迭�� �˰� �ִ� �ּҰ�
			//�޶��� ���(���� Ȯ������ �ּҰ� �޶��� ���)
			//end iterator�� ��쿡�� ����Ű�� �κ��� ���� ���� ������ ������ �� �� ����. ���� ���� ó��
			if (m_pArr->m_pData != m_pData || -1 == m_iIdx)
				assert(nullptr);

			// iterator�� ������ �����͸� ����Ű�� �ִ� ���
			if (m_pArr->size() - 1 == m_iIdx) {
				m_iIdx = -1;
			}
			else {
				++m_iIdx;
			}

			return *this;//iterator Ŭ���� ��ü�� �޴� ���̴�.
		}




		// ����++
		iterator operator ++(int)//(k++)++�� ���� �����ϴ�. ���纻�� �����´�.
		//++(int): �ƹ� �ǹ� ���� int�� �����ͼ�  ++(int)�� �����Ϸ��� ���� �����ڶ�� �ν��ϰ� ���ش�.
		{
			iterator copy_iter = *this;//���� ������ 
			++(*this);
			//fake�� �ش�. ��, ��ȯ ���� ���� �ִ� ��ü ���� ��ȯ ���ְ�(���� ���̹Ƿ� ������ ������ ���� �ʴ´�.)
			// �״�� �Լ������� ��ü ������ ������ �༭ ���� ���� ��Ų��.

			return copy_iter;//iterator Ŭ���� ��ü�� �޴� ���̴�.
			//��ȯ Ÿ���� �Ǵٸ� ���纻�̹Ƿ� ��ȯ�� ��������.

		}

		//--����
		iterator& operator --()
		{
			//iterator�� �˰� �ִ� �ּҿ�, �����迭�� �˰� �ִ� �ּҰ�
			//�޶��� ���(���� Ȯ������ �ּҰ� �޶��� ���)
			//end iterator�� ��쿡�� ����Ű�� �κ��� ���� ���� ������ ������ �� �� ����. ���� ���� ó��
			if (m_pArr->m_pData != m_pData || -1 == m_iIdx)
				assert(nullptr);

			if (m_pArr->size() == 0) {
				assert(nullptr);
			}
			else {
				--m_iIdx;
			}

			return *this;//iterator Ŭ���� ��ü�� �޴� ���̴�.
		}

		//--����
		iterator operator --(int)
		{
			iterator copy_iter = *this;//���� ������ 
			--(*this);

			return copy_iter;//iterator Ŭ���� ��ü�� �޴� ���̴�.
		}



		//-- ��,���� ����� ����

		//�� ������ ==, !=
		bool operator == (const iterator& _otheriter)
		{//this�� ���� �־��µ� ���� �������� ������ �־���.
			if (this->m_pData == _otheriter.m_pData && this->m_iIdx == _other.m_iIdx)
				return true;
			else return false;
		}

		bool operator != (const iterator& _otheriter)
		{
			return !(*this == _otheriter);
			//ȣ�� ��Ų ��ü�� *this �׸��� bool operator == (const iterator& _otheriter) ȣ����Ѽ� �ݴ�� ��ȯ�ϸ� �ȴ�.
		}


	public:
		iterator() {//���ø��̴ϱ� ������� �ٷ� ����
			:m_pArr(nullptr)
				, m_pData(nullptr)
				, m_iIdx(-1)
				, m_bValid(false);//�⺻�����ڿ����� false
		}
		iterator(CArr* _pArr, T* _pData, int _iIdx)
			:m_pArr(_pArr)
			, m_pData(_pData)
			, m_iIdx(_iIdx)
			, m_bValid(false);
		{//��ȿ�� ���� �����迭�� ������ �ְ� �ε��� ���� -1�� �ƴ� iterator�� ��ȿ���� ���̴�.
			if (nullptr != _pArr && 0 <= m_iIdx) {
				m_bValid = true;
			}

		}


		~iterator()
		{

		}

		friend class CArr;// CArrŬ�������� iterator Ŭ������ private �� ���� �Ұ�(���� ����������)
		//���� friend�� �����ϸ� �� Ŭ������ ���� private���� ���� �����ϰ� �ȴ�.
		//��, CArr���� iterator�� ��� ������ ���� �� �� �ְ� ��� ������ ����Լ��� ����
	};




	template<typename T>
	CArr<T>::CArr()//������ �Լ�
	//Header ���Ͽ����� �Լ��� ���� �� �����Ƿ� Header���� ������ �Լ� ���⼭ cpp���� ����� ����Ѵ�.
	//CArrŬ���� �ȿ� �ִ� CArr()�Լ���� ��Ȯ�� ��ø�  ����� �Ѵ�.
		:m_pData(nullptr)
		, m_iCount(0)
		, m_iMaxCount(2)
	{
		//�̴ϼȶ�����, �޸� �ʱ�ȭ �Ҷ��� ���������� ��� ������ �ʱ�ȭ ���ִ°� ����.
		m_pData = new T[2];//malloc(sizeof(int)*2)�� ���� ���̴�.

	}
	template<typename T>
	CArr<T>::~CArr()//�Ҹ��� �Լ�
	{
		delete[] m_pData;//���� �ڷ�������(�迭)���� ���� �̷��� �����ش�.
		//int* p =new int[10];�� ��쿡�� delete[] p;
		//int* p = new int;�� ��쿡�� delete p;�� �����Ѵ�.
	}
	//�� �Լ� Ȱ���� ���� s1.push_back;
	template<typename T>
	void CArr<T>::push_back(const T& _Data)//this�� ���� ������ ����, this�� ������ �Ͱ�
	//�������� ���� �κ��� ���鼭 ����غ���
	{
		if (this->m_iMaxCount <= this->m_iCount) {
			//���Ҵ�
			resize(m_iMaxCount * 2);// �迭�� �� ã�� ��쿡�� 2�踸 Ȯ��
		}
		//������ �߰�
		m_pData[m_iCount++] = _Data;
	}
	//�������� ���� Ȯ�尡��, 
	//�̸� ���ؼ� ���� �̸� ũ�⸦ �����ؼ� push_back���� �Լ��� ������ �ҷ����� ���� ����(�ð����� ������) �ϱ� ���� ����Լ��̴�.
	template<typename T>
	void CArr<T>::resize(/*���⵵ this ����*/int _iResizeCount)
	{
		// ���� �ִ� ���뷮 ���� �� ���� ��ġ�� Ȯ���Ϸ��� ���
		//�� _iDataCount�� 5, m_iMaxCount 10�� ��� ������ �ִ� data�� 7���� ���� ���
		// 2���� data �ս��� �߻� �� �� �����Ƿ� ������ �߻��� �� �ִ�.
		//�̷��� �Ǹ� ������ �ս��� �߻��ϹǷ� nullptr�� ���ؼ� ������ ���ٴ°� ������ش�.
		if (this->m_iMaxCount >= _iResizeCount) {
			assert(nullptr);
		}

		//1.��������
		T* pNew = new int[_iResizeCount];//malloc(_iResizeCount)����ؼ� ���
		//2. ���� ������ �ִ� �����͵��� ���� �Ҵ��� �������� �����Ų��.
		for (int i = 0; i < m_iCount; ++i) {
			pNew[i] = this->m_pData[i];//���⼭�� this ���� ����
		}
		//3. ���� ������ �޸� ����
		delete[] m_pData;
		//4. �迭�� ���� �Ҵ�� ������ ����Ű�� �Ѵ�.
		m_pData = pNew;
		//5. MaxCount ������ ����
		this->m_iMaxCount = _iResizeCount;
	}

	template<typename T>
	T& CArr<T>::operator[](int idx)
	{
		return m_pData[idx];
	}

	template<typename T>
	typename CArr<T>::iterator CArr<T>::begin()
		//typename�� ������ ������ ��ȯŸ���� iterator�̴�. �̴� C++���� �����ϴ� �⺻
		//��ȯŸ���� �ƴϱ� ������ Ư�� ��ȯ Ÿ���̶� ���� typename�� �ٿ� ��� �Ѵ�.
		//��Ȯ���� CArr<T>::iterator �̰� Ư�� return ���̴� ��� �� �˷��ֱ� ���ؼ� ������.
	{
		//������ ����Ű�� iterator�� ���� ��ȯ����
		/*iterator iter(m_pData, 0);
		iter.m_pData = this->m_pData;
		iter.m_iIdx = 0;*///�� ��� ������ ����Ѱ� return�� �ִ� �κ�

		if (0 == m_iCount)
			return iterator(this, m_pData, -1);//�����Ͱ� ����  ���, begin() == end()
		else
			return iterator(this, m_pData, 0);//�ӽð�ü �̹Ƿ� ���� �Ұ� ��ȯ�� ����
			//��ü ��ü�� �޾ƾ� �ϱ� ������ this
	}

	template<typename T>
	typename CArr<T>::iterator CArr<T>::end()
		// �̰� ��ȯŸ��            �̰� �Լ� �̸�
	{	//���� ������ ����Ű�� iterator�� ���� ��ȯ����
		return iterator(this, m_pData, -1);//�����Ͱ� ���� ���, begin() == end()
	}

	template<typename T>
	typename CArr<T>::iterator CArr<T>::erase(iterator& _iter)//��ȿ�� �˻� ������ const X
	{
		//���� ������ ���� iterator�� vecInt2�� ����Ű�µ� 
		//erase�� ������ ���� vecInt���� ����ϴ� ��찡 �߻��� �� �ִ�.
		//vector<int>::iterator veciter = vecInt2.begin();
		//veciter= vecInt.erase(veciter);
		//�� ���� ���� ��Ȳ�� ��ü�� ���� �ּҰ��� iterator�� ����Ű�� �ּ� ���� ������ �ٸ� ��츦 ����� ���̴�.
		//1. iterator�� �ٸ� Arr�� ��Ҹ� ����Ű�� ���
		//2. end iterator�� ��쿡�� ������ �ȴ� ��, ������ ������
		//3. ���� ����ִ� data�� �������� �ε����� �� Ŭ���
		if (this != _iter.m_pArr || end() == _iter || m_iCount <= _iter.m_iIdx)
		{
			assert(nullptr);
		}

		//iterator�� ����Ű�� �����͸� �迭 ������ �����Ѵ�.
		int iLoopCount = m_iCount - (_iter.m_iIdx + 1);//10���߿� index 0�� ���� �� 10-(0+1)�� 9���� �����δ�.
		for (int i = 0; i < iLoopCount; ++i) {
			m_pData[i + _iter.m_iIdx] = m_pData[i + _iter.m_iIdx + 1];
		}

		_iter.m_bValid = false;// parameter�� �޾ƿ� iterator�� ��ȿ���� false�� �߱� ������
		//������ �ִ� ��ü�� �ٽ� ���� �ʴ� �̻� ��ȿ���� false�� ���� �ְ� �ȴ�.

			//ī���� ����
		--m_iCount;

		//������ ���ƴ� iterator��� ���� Ȯ�� ���� ����Ѵ�. ��, ������ �ִ� iterator

		return iterator(this, m_pData, _iter.m_iIdx);//������ �ִ� ���� ���� ������ ������ ���� �ε��� ���� �ָ� �ȴ�.
	}
};











//class CArr
//{
//private://�⺻������ �ƹ��͵� �Է����� ������ ��������� private�� �ν� �Ѵ�.
//	int* m_pInt;
//	int  m_iCount;
//	int  m_iMaxCount;
//
//public:
//	void push_back(int _Data);//tArr* _pArr�� ��ü�� ���� ���� ��, this
//	//�̹Ƿ� ������ ����� �ʿ䰡 ����.
//	void resize(int _iResizeCount);//public�̶� ���� Reallocate�� �޸� �������� 
//	//�ø� �� �ְ� ������ ���̴�.
//public:
//	int& operator[](int idx);//��, operator�� �ش� ��ü�� ��Ī�Ѵ�. carr[1]�� ���� �й�
//
//public://header���� �̹Ƿ� �Լ��� �������� �ʴ´�. 
//	CArr();
//	~CArr();
//};

